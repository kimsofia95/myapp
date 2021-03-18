package app.service;

import app.model.User;

import java.util.List;

public interface UserService {

    void createDatabase();
    void addUsers();
    void addUser(User user);
    void deleteUser(User user);
    void changeUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
}
