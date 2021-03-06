package main.java.net.antra.servlet.bussinessLogic;

import main.java.net.antra.servlet.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/8/30.
 */
public class EmployeeService {
    public List<Employee> addNewEmployee(String firstName, String lastName, String age, Object existingList){
        Employee newEmp = new Employee();
        newEmp.setFirstName(firstName);
        newEmp.setLastName(lastName);
        if(age != null && !"".equals(age.trim())){
            newEmp.setAge(Integer.parseInt(age));
        }
        List<Employee> empList;
        if(existingList == null){
            empList = new ArrayList<Employee>();
            empList.add(newEmp);
        }else{
            empList = (ArrayList<Employee>)existingList;
            empList.add(newEmp);
        }
        return empList;
    }
}
