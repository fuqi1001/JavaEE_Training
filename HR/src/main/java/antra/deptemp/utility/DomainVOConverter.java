package main.java.antra.deptemp.utility;

import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.entity.DeptEmpCode;
import main.java.antra.deptemp.entity.Employee;
import main.java.antra.deptemp.pojo.DepartmentVO;
import main.java.antra.deptemp.pojo.EmployeeVO;

public class DomainVOConverter {
    public static Employee convertEmpVOtoEmp(EmployeeVO empVO) {
        Employee employee = new Employee();
        employee.setAddress(empVO.getAddress());
        employee.setContact(empVO.getEmail());
        employee.setFirstName(empVO.getFirstName());
        employee.setLastName(empVO.getLastName());
        employee.setStatus(new DeptEmpCode(empVO.getStatusId()));
        return employee;
    }

    public static Department converDeptVOtoDomain(DepartmentVO vo) {
        Department dept = new Department();
        dept.setName(vo.getName());
        dept.setEmail(vo.getEmail());
        dept.setContact(vo.getPhone());
        dept.setDesc(vo.getDesc());
        dept.setStatus(new DeptEmpCode(vo.getStatusId()));
        return dept;
    }
}
