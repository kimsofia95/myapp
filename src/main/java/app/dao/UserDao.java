package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {
    void createDatabase();
    void addUser(User user);
    void deleteUser(User user);
    void changeUser(User user);
    List<User> getAllUsers();
}
