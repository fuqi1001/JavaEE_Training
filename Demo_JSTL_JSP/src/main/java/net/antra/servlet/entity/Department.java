package main.java.net.antra.servlet.entity;

import java.util.List;

/**
 * Created by qifu on 17/8/30.
 */
public class Department {
    private Integer id;
    private String name;
    private String email;
    private List<Employee> employeeList;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
