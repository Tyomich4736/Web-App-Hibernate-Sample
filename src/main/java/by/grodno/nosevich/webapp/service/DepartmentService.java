package by.grodno.nosevich.webapp.service;

import by.grodno.nosevich.webapp.entities.Department;
import by.grodno.nosevich.webapp.entities.User;
import org.hibernate.query.Query;

import java.util.List;

import static by.grodno.nosevich.webapp.service.SessionUtil.*;
import static by.grodno.nosevich.webapp.service.UserService.getUserService;

public class DepartmentService implements DAO<Department>{
    private static DepartmentService departmentService = new DepartmentService();
    private DepartmentService(){}

    @Override
    public List<Department> getAll() {
        String sql = "SELECT * FROM department_table";
        Query query = openSession().createNativeQuery(sql).addEntity(Department.class);
        List<Department> result = query.list();
        shutDown();
        return result;
    }

    @Override
    public void add(Department ob) {
        openSession().save(ob);
        shutDown();
    }

    @Override
    public Department getById(int id) {
        Department result = (Department) openSession().get(Department.class, id);
        shutDown();
        return result;
    }

    @Override
    public void update(Department ob) {
        openSession().update(ob);
        shutDown();
    }

    @Override
    public void delete(Department ob) {
        openSession().remove(ob);
        shutDown();
    }

    public void deleteById(int id) {
        Query query = openSession().createQuery("DELETE Department WHERE id = :id");
        getSession().beginTransaction();
        query.setParameter("id",id);
        query.executeUpdate();
        getSession().getTransaction().commit();
        shutDown();
    }

    public boolean userContainsDepartment(Department department){
        for (User user : getUserService().getAll()){
            if (user.getDepartment().equals(department)){
                return true;
            }
        }
        return false;
    }

    public static DepartmentService getDepartmentService(){
        return departmentService;
    }
}
