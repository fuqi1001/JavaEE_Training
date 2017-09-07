package main.java.deptemp.businessLogic;

import main.java.deptemp.entity.Employee;
import main.java.deptemp.utility.JdbcUtility;
import main.java.deptemp.utility.JpaUtility;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class EmployeeService {
    public List<Employee> addNewEmployee(String firstName, String lastName, String age, int deptId) throws SQLException{
        try(Connection conn = JdbcUtility.getConnection();
            PreparedStatement stmt = conn.prepareStatement("insert into employee (first_name, last_name, age, dept_id) values (?,?,?,?) ");) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            if(age != null && !"".equals(age.trim())){
                stmt.setInt(3, Integer.parseInt(age));
            }else{
                stmt.setNull(3, Types.INTEGER);
            }
            stmt.setInt(4, deptId);
            stmt.executeUpdate();
        } catch (Exception se) {
            se.printStackTrace();
        }
        return getEmployeeList();
    }
    public List<Employee> getEmployeeList() throws SQLException{
        EntityManager em = JpaUtility.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select e from Employee e");
        List<Employee> resList = query.getResultList();
        em.getTransaction().commit();
        return resList;
    }
}
