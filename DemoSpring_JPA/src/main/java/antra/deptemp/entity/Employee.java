package main.java.antra.deptemp.entity;


import javax.persistence.*;

@Entity
@Table(name = "employee")

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Department department;
    private String contact;
    private String address;
    private DeptEmpCode status;

    public Employee() {

    }

    public Employee(int id, String first, String last, Integer age, Department department) {
        this.id = id;
        this.firstName = first;
        this.lastName = last;
        this.age = age;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name", length = 150, nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name ="last_name", length = 150, nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age", columnDefinition = "int")
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="dept_id")
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToOne
    @JoinColumn(name = "status")
    public DeptEmpCode getStatus() {
        return status;
    }
    public void setStatus(DeptEmpCode status) {
        this.status = status;
    }

    @Column(name = "contact", length = 45)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass())
            return false;

        Employee other = (Employee) obj;
        if(age == null) {
            if(other.age != null) return false;
        } else if(!age.equals(other.age))
            return false;

        if(firstName == null) {
            if(other.firstName != null)
                return false;
        } else if(!firstName.equals(other.firstName)) {
            return false;
        }

        if(lastName == null) {
            if(other.lastName != null)
                return false;
        } else if(!lastName.equals(other.lastName)){
            return false;
        }
        return true;
    }

    @Column(name = "address", length = 300)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
