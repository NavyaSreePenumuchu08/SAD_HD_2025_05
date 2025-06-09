package SOLID;

public class DIP_02 {

      public interface Notification {
        void doNotify();
    }
 
    // Concrete implementation
    public static class EmailNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Sending notification via email!");
        }
    }
 
    // Employee now depends on the abstraction
    public static class Employee {
        private Notification notification;  // DIP FIXED: depends on interface
 
        public Employee(Notification notification) {
            this.notification = notification;
        }
   
        public void notifyEmployee() {
            notification.doNotify();
        }
    }
 
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification(); // Polymorphic
        Employee employee = new Employee(emailNotification);
        employee.notifyEmployee();
    }
}