package example.codeclan.com.employee_starter;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;

import db.SqlRunner;

public class Department {
    private int id;
    private String title;

    public Department(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void applyId(int newId){
        this.id = newId;
    }

    public void save() {
        String sql = String.format("INSERT INTO departments (title) VALUES ('%s');" , this.getTitle());
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void deleteAll(){
        String sql = "DELETE FROM departments;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete(){
        String sql = String.format("DELETE FROM departments WHERE id = %d;", this.getId());
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update(){
        String sql = String.format("UPDATE departments SET (title) = ('%s') " +
                "WHERE id = %d", this.getId());
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all(){
        String sql = "SELECT * FROM departments;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while (rs.next()){
                String title = rs.getString("title");
                int departmentId = rs.getInt("id");
                System.out.println("Department #: " + departmentId + " is " + title);
            }
        }catch (Exception e){
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        }finally {
            SqlRunner.closeConnection();
        }
    }
}