package main.java.antra.deptemp.controller;


import main.java.antra.deptemp.pojo.DepartmentVO;
import main.java.antra.deptemp.pojo.validator.DeptvoValidator;
import main.java.antra.deptemp.service.CodeService;
import main.java.antra.deptemp.service.DepartmentService;
import main.java.antra.deptemp.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DeptController {
    @Autowired
    DepartmentService deptService;

    @Autowired
    CodeService codeService;

    @Autowired
    DeptvoValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
        binder.registerCustomEditor( Date.class, new CustomDateEditor( new SimpleDateFormat( "MM/dd/yyyy"), true ));
        binder.registerCustomEditor( String.class, new StringTrimmerEditor( true ));
    }

    @RequestMapping(value = "/newDept", method = RequestMethod.GET)
    public String showNewDept(ModelMap model, @ModelAttribute("dept") DepartmentVO dept) {
        model.addAttribute("active_tab", "new_dept");
        model.addAttribute("statusCodeList", codeService.getCodeByType(Constants.DEPT_STATUS));
        return "createDept";
    }

    @PostMapping(value = "/newDept")
    public String addNewDept(ModelMap model, @ModelAttribute("dept") @Valid DepartmentVO dept, RedirectAttributes rediAtrb, BindingResult br) {
        model.addAttribute("active_tab", "new_dept");
        if(!br.hasErrors()) {
            deptService.saveDept(dept);
            rediAtrb.addFlashAttribute("successMsg", "Successfully add a department.");
            return "redirect:/main";
        } else {
            model.addAttribute("statusCodeList", codeService.getCodeByType(Constants.DEPT_STATUS));
            return "newDept";
        }
    }

    @RequestMapping("/manageDept")
    public String showManageDept(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("active_tab", "manage_dept");
        model.addAttribute("deptList", deptService.loadDeptDetails());
        return "manageDept";
    }
}
