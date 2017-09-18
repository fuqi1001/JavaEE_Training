package main.java.antra.deptemp.service;

import main.java.antra.deptemp.dao.DepartmentDAO;
import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.pojo.DepartmentVO;
import main.java.antra.deptemp.utility.DomainVOConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentDAO deptDAO;


    @Override
    @Transactional
    public void saveDept(DepartmentVO deptVO) {
        Department dept = DomainVOConverter.converDeptVOtoDomain(deptVO);
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
}
