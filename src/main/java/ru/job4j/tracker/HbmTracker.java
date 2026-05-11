package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.persist(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(Integer id, Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            int result = session.createMutationQuery(
                            "UPDATE Item SET name = :fName, created = :fCreated WHERE id = :fId")
                    .setParameter("fLogin", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", item.getId())
                    .executeUpdate();
            session.getTransaction().commit();
            return result > 0;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createMutationQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            List<Item> result = session.createSelectionQuery("from Item", Item.class)
                    .getResultList();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Item> findByName(String key) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            List<Item> result = session.createSelectionQuery("from Item where name = :fName",
                            Item.class)
                    .setParameter("fName", key)
                    .getResultList();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public Item findById(Integer id) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Item result = session.createSelectionQuery("From Item i where i.id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}