package main.java.antra.deptemp.service;

import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.entity.DeptEmpCode;

import java.util.List;

public interface CodeService {
    public List<DeptEmpCode> getCodeByType(String type);
    public DeptEmpCode getCodeById(int id);
}
