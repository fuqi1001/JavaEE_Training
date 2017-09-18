package main.java.antra.deptemp.service;

import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.pojo.DepartmentVO;

import java.util.List;

public interface DepartmentService {
    public void saveDept(DepartmentVO dept);

    public List<Department> loadDeptDetails();

    public List<Department> loadDeptBasicInfo();
}
