package app.service;

import app.dao.UserDao;
import app.dao.UserDaoImp;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    boolean usersAdded = false;

    @Transactional
    public void addUsers() {
        User user = new User("Masha", "Petrova");
        addUser(user);
        User user1 = new User("Sasha", "Petrov");
        addUser(user1);
        usersAdded = true;
    }

    @Transactional
    @Override
    public void createDatabase() {
        userDao.createDatabase();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public void changeUser(User user) {
        userDao.changeUser(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
       return userDao.getAllUsers();
    }
}