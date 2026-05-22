package ru.job4j.toone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            var role = new Role();
            role.setName("ADMIN");
            role = create(role, sf);
            var user = new User();
            user.setName("Admin Admin");
            user.setMessengers(List.of(
                    new UserMessenger(null, "tg", "@tg"),
                    new UserMessenger(null, "wu", "@wu")
            ));
            user.setRole(role);
            user = create(user, sf);
            var stored = sf.openSession()
                    .createQuery("FROM User WHERE id = :fId", User.class)
                    .setParameter("fId", user.getId())
                    .getSingleResult();
            stored.getMessengers().forEach(System.out::println);
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static <T> T create(T model, SessionFactory sf) {
        T result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.merge(model);
            session.getTransaction().commit();
        }
        return result;
    }

    public static <T> List<T> findAll(Class<T> cl, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<T> list = session.createQuery("FROM " + cl.getName(), cl).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}