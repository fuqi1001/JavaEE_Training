package main.java.antra.deptemp.controller;


import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeptController {

    @Autowired
    DepartmentService deptService;

    @RequestMapping("/viewDept")
    public String showDept(ModelMap model) {
        model.addAttribute("deptList", deptService.loadDeptBasicInfo());
        return "dept";
    }

    @RequestMapping("/manageDept")
    public String showManageDept(ModelMap model) {
        return "manageDept";
    }

    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    public String showAddDept(Department dept, ModelMap model) {
        try {
            deptService.saveDept(dept);
            model.addAttribute("success", "Successfully add a department.");
        } catch(Exception e) {
            model.addAttribute("fail", "sorry, it failed to add a department.");
        }
        return "manageDept";
    }
}
