package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private Item makeItem(ResultSet set) throws SQLException {
        return new Item(
                set.getInt("id"),
                set.getString("name"),
                set.getTimestamp("created").toLocalDateTime()
        );
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        executePrepared(
                String.format("update items set name = '%s' where id = %s;",
                        item.getName(), id)
        );
        return findById(id).getName().equals(item.getName());
    }

    @Override
    public void delete(int id) {
        executePrepared(String.format("delete from items where id = %s;", id));
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try {
            PreparedStatement statement = cn.prepareStatement("select * from items;");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(makeItem(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try {
            PreparedStatement statement
                    = cn.prepareStatement(
                            String.format("select * from items where name = '%s';", key)
            );
            try (ResultSet resultSet
                         = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getString("name").equals(key)) {
                        list.add(makeItem(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        try {
            PreparedStatement statement
                    = cn.prepareStatement("select * from items where id = ?;");
            statement.setInt(1, id);
            try (ResultSet resultSet
                         = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getInt("id") == id) {
                        rsl = makeItem(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public void executePrepared(String sql) {
        try {
            PreparedStatement statement
                    = cn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
