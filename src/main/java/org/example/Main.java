package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = new Department.DepartmentBuilder()
                    .setName("IT")
                    .setMaxSalary(11000)
                    .setMinSalary(100)
                    .build();
            Employee employee = new Employee.EmployeeBuilder()
                    .setName("Rafael")
                    .setSurname("Sahakyan")
                    .setSalary(2000)
                    .setDetail(
                            new Detail.DetailBuilder()
                                    .setCity("Yerevan")
                                    .setEmail("hopeleessheart@gmail.com")
                                    .setPhoneNumber("+37499611013")
                                    .build()
                    )
                    .build();

            department.addEmployee(employee);

            session.save(department);

            session.getTransaction().commit();

        } finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }
}
