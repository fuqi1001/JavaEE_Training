package main.java.net.antra.servlet.bussinessLogic;

import main.java.net.antra.servlet.entity.Department;
import main.java.net.antra.servlet.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/8/30.
 */
public class DepartmentService  {
    public List<Department> addNewDepartment(String name, String email, String[] employee, Object existingDeptList, Object existingEmpList) {

        List<Department> deptList;
        if(existingDeptList == null){
            deptList = new ArrayList<Department>();
        }else{
            deptList = (ArrayList<Department>)existingDeptList;
        }
        Department newDept = new Department();
        newDept.setName(name);
        newDept.setEmail(email);
        List<Employee> empListTobeAdded = new ArrayList<Employee>();
        List<Employee> empList;
        if(existingEmpList != null){
            empList = (ArrayList<Employee>)existingEmpList;
            for(String empIdstr : employee){
                int empId = Integer.parseInt(empIdstr);
                for(Employee emp : empList){
                    if(empId == emp.getId()){
                        empListTobeAdded.add(emp);
                    }
                }
            }
        }
        newDept.setEmployeeList(empListTobeAdded);
        deptList.add(newDept);
        return deptList;
    }

}
