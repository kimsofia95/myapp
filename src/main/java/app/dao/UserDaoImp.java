package app.dao;

import app.model.User;
import app.web.config.HibernateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void createDatabase() {

    }

    @Override
    public void addUser(User user) {
        EntityManagerFactory factory = entityManager.getEntityManagerFactory();
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void changeUser(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = entityManager;
        List<User> users = em.createQuery("SELECT from User")
                .getResultList();
        return users;
    }
}
