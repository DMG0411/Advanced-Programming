package Repositories;

import Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepository {
    public void create(User user) {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public User findById(Long id) {
        EntityManager em = PersistenceManager.getEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public List<User> findByName(String namePattern) {
        EntityManager em = PersistenceManager.getEntityManager();
        TypedQuery<User> query = em.createNamedQuery("User.findByName", User.class);
        query.setParameter("name", "%" + namePattern + "%");
        List<User> users = query.getResultList();
        em.close();
        return users;
    }
}

