package example.codeclan.com.employee_starter;

/**
 * Created by user on 22/02/2017.
 */

public class Runner {
    public static void main(String[] args){
        Department.deleteAll();
        Employee.deleteAll();
        Department department1 = new Department("HR");
        Department department2 = new Department("Marketing");

        department1.save();
        department2.save();

        Employee employee1 = new Employee("Suzie Smith", department1, 45000);
        Employee employee2 = new Employee("Jamie Jones", department2, 25000);

        employee1.save();
        employee2.save();

        Department department3 = new Department("Sales");
        department3.save();
        Department department4 = new Department("Finance");
        department4.save();
        Department department5 = new Department("Admin");
        department5.save();

        Employee employee3 = new Employee("John Paul", department3, 22000);
        employee3.save();
        Employee employee4 = new Employee("Alan Jones", department3, 100000);
        employee4.save();

        Employee employee5 = new Employee("Gina Gertrude", department4, 33000);
        employee5.save();
        Employee employee6 = new Employee("Peter Rincewind", department4, 40000);
        employee6.save();

        Employee employee7 = new Employee("Garibaldi", department5, 24000);
        employee7.save();
        Employee employee8 = new Employee("Arren Arrenson", department5, 200000);
        employee8.save();

        Employee employee9 = new Employee("FalconMan", department1, 60000);
        employee9.save();
        Employee employee10 = new Employee("Gyroscopic Boy", department2, 40000);
        employee10.save();

    }
}
