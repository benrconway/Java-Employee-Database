package example.codeclan.com.employee_starter;

/**
 * Created by user on 30/08/2017.
 */

import db.SqlRunner;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;

    public Employee(String name, Department department, double salary) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void save() {
        String sql = String.format("INSERT INTO employees (name, salary, department_id)" +
                "VALUES ('%s', %7.2f, %d);",
                this.name, this.getSalary(), this.getDepartment().getId());
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update() {
        String sql = String.format("UPDATE employees SET (name, salary, department_id)" +
                "= ('%s', %7.2f, %d) WHERE id = %d;",
                this.name, this.getSalary(), this.getDepartment().getId())
    }
}
