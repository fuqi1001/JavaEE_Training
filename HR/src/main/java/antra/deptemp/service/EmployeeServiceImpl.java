package main.java.antra.deptemp.service;

import main.java.antra.deptemp.dao.EmployeeDAO;
import main.java.antra.deptemp.entity.Employee;
import main.java.antra.deptemp.pojo.EmployeeVO;
import main.java.antra.deptemp.utility.DomainVOConverter;
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

    @Override
    public Employee getEmpById(int id) {
        return empDAO.findOne(id);
    }

    @Override
    public void saveEmployee(EmployeeVO empVO) {
        Employee emp = DomainVOConverter.convertEmpVOtoEmp(empVO);
        empDAO.save(emp);
    }
}
