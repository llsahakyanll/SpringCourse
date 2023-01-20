package org.example;

import javax.persistence.*;

@Entity
@Table(name = "my_db.details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detail"
    , targetEntity = Employee.class)
    private Employee employee;

    public Detail() {
    }

    public static class DetailBuilder {
        private String city;
        private String phoneNumber;
        private String email;

        public DetailBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public DetailBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public DetailBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Detail build() {
            Detail detail = new Detail();
            detail.city = this.city;
            detail.phoneNumber = this.phoneNumber;
            detail.email = this.email;
            return detail;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
