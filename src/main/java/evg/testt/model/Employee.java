package evg.testt.model;

import javax.persistence.*;

@Entity(name = "employees")
public class Employee extends BaseModel{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departments_id")
    Department department;

    private String firstName;
    private String secondName;

    public Employee(String firstName) {
        this.firstName = firstName;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
