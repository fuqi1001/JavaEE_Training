package main.java.antra.deptemp.service;

import main.java.antra.deptemp.dao.EmployeeDAO;
import main.java.antra.deptemp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDAO empDAO;


    @Override
    public List<Employee> loadEmpBasicInfo() {
        return empDAO.getEmployeeList();
    }
}
