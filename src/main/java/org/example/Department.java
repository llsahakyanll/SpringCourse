package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "my_db.departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "max_salary")
    private int maxSalary;
    @Column(name = "min_salary")
    private int minSalary;

    @OneToMany(mappedBy = "department"
            , cascade = CascadeType.ALL
    , targetEntity = Employee.class)
    private List<Employee> list = new ArrayList<>();

    public Department() {
    }

    public static class DepartmentBuilder {
        private String name;
        private int maxSalary;
        private int minSalary;

        public DepartmentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DepartmentBuilder setMaxSalary(int maxSalary) {
            this.maxSalary = maxSalary;
            return this;
        }

        public DepartmentBuilder setMinSalary(int minSalary) {
            this.minSalary = minSalary;
            return this;
        }

        public Department build() {
            Department department = new Department();
            department.name = this.name;
            department.minSalary = this.minSalary;
            department.maxSalary = this.maxSalary;
            return department;
        }
    }

    public void addEmployee(Employee employee) {
        list.add(employee);
        employee.setDepartment(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }
}
