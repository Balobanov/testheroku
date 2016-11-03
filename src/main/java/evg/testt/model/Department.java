package evg.testt.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel{

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Employee> empls;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmpls() {
        return empls;
    }

    public void setEmpls(List<Employee> empls) {
        this.empls = empls;
    }
}
