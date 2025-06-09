package SOLID;

public class LSP_02 {
    public static abstract class Bird {
        public void move() {
            System.out.println("The bird is moving...");
        }
    }
 
    public interface Flyable {
        void fly();
    }
 
    public static class Sparrow extends Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying...");
        }
 
        @Override
        public void move() {
            fly();
        }
    }
 
    public static class Penguin extends Bird {
        @Override
        public void move() {
            System.out.println("The penguin is swimming...");
        }
    }
 
    public static void move(Bird bird) {
        bird.move();
    }
 
    public static void main(String[] args) {
        move(new Sparrow());   // The sparrow is flying...
        move(new Penguin());   // The penguin is swimming...
    }
}