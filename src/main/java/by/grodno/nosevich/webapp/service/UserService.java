package by.grodno.nosevich.webapp.service;

import by.grodno.nosevich.webapp.entities.User;
import org.hibernate.query.Query;

import java.util.List;

import static by.grodno.nosevich.webapp.service.SessionUtil.*;

public class UserService implements DAO<User>{
    private static UserService userService = new UserService();
    private UserService(){}

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM user_table";
        Query query = openSession().createNativeQuery(sql).addEntity(User.class);
        List<User> result = query.list();
        shutDown();
        return result;
    }

    @Override
    public void add(User ob) {
        openSession().save(ob);
        shutDown();
    }

    @Override
    public User getById(int id) {
        User result = (User) openSession().get(User.class, id);
        shutDown();
        return result;
    }

    @Override
    public void update(User ob) {
        openSession().update(ob);
        shutDown();
    }

    @Override
    public void delete(User ob) {
        openSession().remove(ob);
        shutDown();
    }

    public void deleteById(int id) {
        Query query = openSession().createQuery("DELETE User WHERE id = :id");
        getSession().beginTransaction();
        query.setParameter("id",id);
        query.executeUpdate();
        getSession().getTransaction().commit();
        shutDown();
    }

    public static UserService getUserService(){
        return userService;
    }
}