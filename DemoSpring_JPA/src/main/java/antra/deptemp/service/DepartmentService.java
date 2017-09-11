package main.java.antra.deptemp.service;

import main.java.antra.deptemp.entity.Department;

import java.util.List;

public interface DepartmentService {
    public void saveDept(Department dept);

    public List<Department> loadDeptDetails();

    public List<Department> loadDeptBasicInfo();
}
