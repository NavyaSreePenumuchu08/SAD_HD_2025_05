package SOLID;

public class ISP_02 {
    // Split into smaller interfaces
    public interface Workable {
        void work();
    }
 
    public interface Restable {
        void rest();
    }
 
    public static class Developer implements Workable, Restable {
        @Override
        public void work() {
            System.out.println("Developer is coding ...");
        }
 
        @Override
        public void rest() {
            System.out.println("Developer is making a break!");
        }
    }
 
    public static class Robot implements Workable {
        @Override
        public void work() {
            System.out.println("Robot is working hard ...");
        }
    }
 
    // Adjust the working cycle for Workable only
    public static void workingCycle(Workable worker) {
        worker.work();
 
        // Optional: check if it can rest too
        if (worker instanceof Restable) {
            ((Restable) worker).rest();
        }
    }
 
    public static void main(String[] args) {
        workingCycle(new Developer());
        workingCycle(new Robot());
    }
}