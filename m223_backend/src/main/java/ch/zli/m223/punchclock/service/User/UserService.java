package ch.zli.m223.punchclock.service.User;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.User.User;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager entityManager;

    public UserService() {
    }

    @Transactional 
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional 
    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }


    @Transactional 
    public void deleteUser(Long id) {
        var deleteUser = entityManager.find(User.class, id);
        entityManager.remove(deleteUser);
    }

    public User getUser(String username, String passwort) {
        var query = entityManager.createQuery("FROM User WHERE username='" +username +"' and passwort='" + passwort + "'");
        return (User) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        var query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }
}