package main.java.antra.deptemp.dao;

import main.java.antra.deptemp.entity.Department;

import java.util.List;

public interface DepartmentDAO {

    void save(Department dept);

    List<Department> findAllDepartments();

    List<Department> findBasicDeptInfo();
}
