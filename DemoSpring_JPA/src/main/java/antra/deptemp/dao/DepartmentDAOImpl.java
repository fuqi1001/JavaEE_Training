package main.java.antra.deptemp.dao;

import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Department dept) {
        em.persist(dept);
    }

    @Override
    public List<Department> findAllDepartments() {
        Query query = em.createQuery("select DISTINCT OBJECT(d) from Department d JOIN FETCH d.employeeList");
        return query.getResultList();
    }

    @Override
    public List<Department> findBasicDeptInfo() {
        Query query = em.createQuery("select DISTINCT OBJECT(d) from Department d ");
        return query.getResultList();
    }
}
