package main.java.antra.deptemp.service;


import main.java.antra.deptemp.dao.CodeDAO;
import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.entity.DeptEmpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService{

    @Autowired
    CodeDAO codeDAO;

    @Override
    public List<DeptEmpCode> getCodeByType(String type) {
        return codeDAO.getByTypeValid(type);
    }

    @Override
    public DeptEmpCode getCodeById(int id) {
        return codeDAO.findOne(id);
    }
}
