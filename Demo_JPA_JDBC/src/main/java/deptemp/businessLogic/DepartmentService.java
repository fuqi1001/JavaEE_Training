package main.java.deptemp.businessLogic;

import main.java.deptemp.entity.Department;
import main.java.deptemp.utility.JpaUtility;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DepartmentService {
    public List<Department> addNewDepartment(String name, String email) {

        EntityManager em = JpaUtility.getEntityManager();
        em.getTransaction().begin();
        Department dept = new Department();
        dept.setEmail(email);
        dept.setName(name);
        em.persist(dept);
        em.getTransaction().commit();
        return getDeptList();
    }

    public List<Department> getDeptList() {
        EntityManager em = JpaUtility.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select distinct d from Department d");
        List<Department> resList = query.getResultList();
        em.getTransaction().commit();
        return resList;
    }
}
