package main.java.antra.deptemp.service;

import main.java.antra.deptemp.entity.Employee;
import main.java.antra.deptemp.pojo.EmployeeVO;

import java.util.List;

public interface EmployeeService {
    public List<Employee> loadEmpBasicInfo();

    public Employee getEmpById(int id);

    void saveEmployee(EmployeeVO empVO);
}
