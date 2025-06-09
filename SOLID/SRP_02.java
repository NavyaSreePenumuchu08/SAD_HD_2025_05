package SOLID;

public class SRP_02 {    
    public static final class Employee {
        private final int id;
        private String designation;
        private double salary;
 
        public Employee(int id, String designation, double salary) {
            this.id = id;
            this.designation = designation;
            this.salary = salary;
        }
 
        public int getId()            
        { return id; }
        public String getDesignation()
        { return designation; }
        public double getSalary()      
        { return salary; }
 
        void setDesignation(String designation)
        { this.designation = designation; }
        void setSalary(double salary)          
        { this.salary = salary; }
    }
 
    /** Handles salary updates only – its single responsibility. */
    public static final class SalaryService {
        public void updateSalary(Employee employee, double newSalary) {
            employee.setSalary(newSalary);
        }
    }
 
    /** Sends mail – and nothing else – so SRP is satisfied. */
    public static final class MailService {
        public void sendMail(Employee employee, String message) {
            // stub implementation
            System.out.printf("Email to employee %d: %s%n", employee.getId(), message);
        }
    }
 
   
    public static void main(String[] args) {
        Employee emp = new Employee(1, "Developer", 60_000);
        SalaryService salaryService = new SalaryService();
        MailService   mailService   = new MailService();
 
        System.out.printf("Before raise: %.2f%n", emp.getSalary());
        salaryService.updateSalary(emp, 65_000);
        System.out.printf("After raise:  %.2f%n", emp.getSalary());
 
        mailService.sendMail(emp, "Your salary has been updated!");
    }
}