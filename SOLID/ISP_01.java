package SOLID;

public class ISP_01 {

    /*
     * TASK:
     * This SimplePrinter is not a multi functional printer but a very
     * simple one.
     * Please fix this to obey the ISP (Interface Segregation Principle)!
     */
    
        public interface Printable {
        void printDocument();
    }
 
    public interface Scannable {
        void scanDocument();
    }
 
    public interface Faxable {
        void faxDocument();
    }
 
    public static class SimplePrinter implements Printable {
        @Override
        public void printDocument() {
            System.out.println("Sending document to the printer ...");
        }
    }
 
    public static void main(String[] args) {
        Printable printer = new SimplePrinter();
        printer.printDocument();
    }
}