package next.users.model;

import next.users.dao.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Next on 29.04.2016.
 */
public class UsersHibernate {
    @PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @Transactional
    public boolean addUser(User user) {
        if (em.find(User.class, user.getId()) != null) return false;
        em.persist(user);
        return true;
    }

    public List<User> getAllUsers() {
        return em.createQuery("select u from User u").getResultList();
    }

    @Transactional
    public boolean edit(User user) {
        User userResult = em.find(User.class, user.getId());
        if (userResult == null) return false;
        userResult.setName(user.getName());
        userResult.setAge(user.getAge());
        userResult.setAdmin(user.isAdmin());
        userResult.setCreatedDate(user.getCreatedDate());
        return true;
    }

    @Transactional
    public boolean delete(int id) {
        User user = em.find(User.class, id);
        if (user == null) return false;
        em.remove(user);
        return true;
    }

    public User getUser(int id) {
        return em.find(User.class, id);
    }

    public List<User> findByName(String userName, int page, int pageSize) {
        Query query = em.createQuery("select u from User u where u.name like '%" + userName + "%'");
        query.setFirstResult((page - 1)*pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public long getNumgerOfRecords(String userName) {
        return (Long) em.createQuery("select count (u.id) from User u where u.name like '%" + userName + "%'").getSingleResult();
    }
}
