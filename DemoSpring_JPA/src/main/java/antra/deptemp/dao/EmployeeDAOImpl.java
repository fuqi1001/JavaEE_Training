package main.java.antra.deptemp.dao;

import main.java.antra.deptemp.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Employee> getEmployeeList() {
        Query query = em.createQuery("select DISTINCT OBJECT(e) from Employee e ");
        return query.getResultList();
    }
}
