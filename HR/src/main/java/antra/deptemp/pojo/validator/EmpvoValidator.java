package main.java.antra.deptemp.pojo.validator;

import main.java.antra.deptemp.pojo.EmployeeVO;
import main.java.antra.deptemp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmpvoValidator implements Validator {

    @Autowired
    private EmployeeService ems;

    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeVO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeVO emp = (EmployeeVO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "emp.firstname.required","default wrong name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "emp.lastname.required","default wrong name");
        if(!errors.hasErrors()){
//            if(projectService.findProjectByName(proj.getProjectName())!=null){
//                errors.rejectValue("projectName", "project.name.duplicated", "Wrong Name");
//            }
//            if(projectService.findProjectByNum(proj.getProjectNumber())!=null){
//                errors.rejectValue("projectNumber", "project.number.duplicated", "Wrong Number");
//            }
        }
    }
}
