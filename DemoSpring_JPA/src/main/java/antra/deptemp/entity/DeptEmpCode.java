package main.java.antra.deptemp.entity;

import javax.persistence.*;

@Entity
@Table(name="code")

public class DeptEmpCode {
    private Integer id;
    private String type;
    private String value;
    private String desc;
    private String inactiveInd;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "CODE_TYPE", length = 45, nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "VALUE", length = 45, nullable = false)
    public String getValue(){
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "DESC", length = 45)
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Column(name = "INACTIVE_IND", length = 1)
    public String getInactiveInd(){
        return inactiveInd;
    }
    public void setInactiveInd(String inactiveInd) {
        this.inactiveInd = inactiveInd;
    }
}
