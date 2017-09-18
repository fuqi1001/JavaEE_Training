package main.java.antra.deptemp.controller;


import main.java.antra.deptemp.service.DepartmentService;
import main.java.antra.deptemp.vo.DeptVO;
import main.java.antra.deptemp.vo.DeptValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller

public class DeptController {

    @Autowired
    DepartmentService deptService;

    @RequestMapping("/viewDept")
    public String showDept(ModelMap model) {
        model.addAttribute("deptList", deptService.loadDeptBasicInfo());
        return "dept";
    }

    @RequestMapping("/mamageDept")
    public String showManageDept(@ModelAttribute("department")DeptVO department) {
        department.setName("1");
        return "manageDept";
    }

    @Autowired
    DeptValidator dValidator;

    @RequestMapping(value ="/addDept", method = RequestMethod.POST)

    public String showAddDept(@ModelAttribute("department") @Valid DeptVO department, BindingResult res, Error error, ModelMap model) {

        if(res.hasErrors()) {
            model.addAttribute("fail", "Sorry, it failed to add a department");
        } else {
            model.addAttribute("success", "Successfully add a department.");
        }
        return "manageDept";
    }
}
