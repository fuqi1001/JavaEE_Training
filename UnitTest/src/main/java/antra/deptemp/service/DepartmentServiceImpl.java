package main.java.antra.deptemp.service;

import main.java.antra.deotemp.utility.Constants;
import main.java.antra.deptemp.dao.DepartmentDAO;
import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.entity.DeptEmpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDAO deptDAO;


    @Override
    @Transactional
    public void saveDept(Department dept) {
        if(dept.getStatus() == null) {
            DeptEmpCode status = new DeptEmpCode();
            status.setcId(Constants.DEFAUL_DEPT_STATUS_ID);
            dept.setStatus(status);
        }
        deptDAO.save(dept);
    }

    @Override
    @Transactional

    public List<Department> loadDeptDetails() {
        List<Department> dList = deptDAO.findAllDepartments();
        return dList;
    }

    @Override
    @Transactional
    public List<Department> loadDeptBasicInfo() {
        return deptDAO.findBasicDeptInfo();
    }

    public DepartmentDAO getDeptDAO() {
        return deptDAO;
    }

    public void setDeptDAO(DepartmentDAO deptDAO) {
        this.deptDAO = deptDAO;
    }
}
