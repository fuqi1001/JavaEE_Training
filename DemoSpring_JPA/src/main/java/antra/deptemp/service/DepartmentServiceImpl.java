package main.java.antra.deptemp.service;

import main.java.antra.deotemp.utility.Constants;
import main.java.antra.deptemp.dao.DepartmentDAO;
import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.entity.DeptEmpCode;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentDAO deptDAO;


    @Override
    @Transactional
    public void saveDept(Department dept) {
        if(dept.getStatus() == null) {
            DeptEmpCode status = new DeptEmpCode();
            status.setId(Constants.DEFAUL_DEPT_STATUS_ID);
            dept.setStatus(status);
        }
        deptDAO.save(dept);
    }

    @Override
    @Transactional
    public List<Department> loadDeptDetails() {
        return deptDAO.findAllDepartments();
    }

    @Override
    public List<Department> loadDeptBasicInfo() {
        return deptDAO.findBasicDeptInfo();
    }
}
