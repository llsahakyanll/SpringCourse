package org.example;

import javax.persistence.*;

@Entity
@Table(name = "my_db.employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private int salary;

    @ManyToOne(cascade = CascadeType.ALL , targetEntity = Department.class)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Detail.class)
    @JoinColumn(name = "detail_id")
    private Detail detail;


    public Employee() {
    }

    public static class EmployeeBuilder {
        private String name;
        private String surname;
        private int salary;
        private Department department;
        private Detail detail;

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public EmployeeBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder setDepartment(Department department) {
            this.department = department;
            return this;
        }

        public EmployeeBuilder setDetail(Detail detail) {
            this.detail = detail;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.name = this.name;
            employee.surname = this.surname;
            employee.salary = this.salary;
            employee.detail = this.detail;
            employee.department = this.department;
            return employee;
        }
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
