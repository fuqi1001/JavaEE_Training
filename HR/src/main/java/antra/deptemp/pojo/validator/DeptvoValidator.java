package main.java.antra.deptemp.pojo.validator;


import main.java.antra.deptemp.pojo.DepartmentVO;
import main.java.antra.deptemp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DeptvoValidator implements Validator {


    @Autowired
    private DepartmentService deptService;

    @Override
    public boolean supports(Class<?> clazz) {
        return DepartmentVO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DepartmentVO dept = (DepartmentVO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "dept.name.required","default wrong name");
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
