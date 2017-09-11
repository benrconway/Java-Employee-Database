package example.codeclan.com.employee_starter;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;

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
                this.name, this.getSalary(), this.getDepartment().getId(), this.getId());
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all(){
        String sql = "SELECT * FROM employees;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while(rs.next()){
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int departmentId = rs.getInt("department_id");
                int personalId = rs.getInt("id");
                System.out.println("Employee #" + personalId + ": " + name + ", works in department " + departmentId +
                " for a salary of " + salary + " / year.");
            }
        }catch (Exception e){
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        }finally{
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll(){
        String sql = "DELETE FROM employees;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete(){
        String sql = String.format("DELETE FROM employees WHERE id = %d;", this.getId());
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


// something to work on.
    public static Department find_by_id(int deptId) {
        String sql = String.format("SELECT * FROM departments WHERE id = %d;", deptId);
        ResultSet rs = SqlRunner.executeQuery(sql);
        String title = null;
        int departmentId = 0;
        try {
            while (rs.next())
            title = rs.getString("title");
            departmentId = rs.getInt("id");

        }catch (Exception e){
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        }finally {
            SqlRunner.closeConnection();
        }
        Department departmentFound = new Department(title);
        departmentFound.applyId(departmentId);
        return departmentFound;
    }
}
