package main.java.antra.deptemp.dao;

import main.java.antra.deptemp.entity.DeptEmpCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CodeDAO extends JpaRepository<DeptEmpCode, Integer>{
    @Query("select c from DeptEmpCode c where c.inactiveInd!='Y' and c.type=?1")
    List<DeptEmpCode> getByTypeValid(String type);
}
