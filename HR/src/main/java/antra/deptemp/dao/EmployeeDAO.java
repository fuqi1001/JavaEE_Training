package main.java.antra.deptemp.dao;

import main.java.antra.deptemp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
    @Query("select DISTINCT OBJECT(e) from Employee e ")
    List<Employee> getEmployeeList();
}
