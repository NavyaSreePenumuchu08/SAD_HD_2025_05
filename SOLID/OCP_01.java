package SOLID;
 
import java.util.HashMap;
import java.util.Map;

/*
     * TASK:
     * How to add a new discount type (customerType) without
     * violating OCP (Open/Closed Principle)?
     */
 
/**
 * Demonstrates the Open/Closed Principle using the Strategy pattern for discounts.
 * <p>
 * Each customer‐type class implements {@link DiscountStrategy} and therefore can be added
 * without changing the surrounding calculation code.  The {@code @Override} annotations
 * ensure compile‑time checking that the contract is respected.
 */
interface DiscountStrategy {
    /**
     * Calculates the discount (not the final price) to apply for the given amount.
     *
     * @param amount the price before discount
     * @return the monetary value of the discount
     */
    double applyDiscount(double amount);
}
 
// Concrete strategies
class RegularCustomer implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.10; // 10 % discount
    }
}
 
class PremiumCustomer implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.20; // 20 % discount
    }
}
 
class GoldCustomer implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.30; // 30 % discount
    }
}
 
/**
 * Calculator that delegates discount computation to the appropriate strategy.
 */
public class OCP_01 {
 
    public static class DiscountCalculator {
        private final Map<String, DiscountStrategy> strategyMap = new HashMap<>();
 
        public DiscountCalculator() {
            strategyMap.put("Regular", new RegularCustomer());
            strategyMap.put("Premium", new PremiumCustomer());
            strategyMap.put("Gold", new GoldCustomer()); // OCP‑friendly addition
        }
 
        public double calculateDiscount(String customerType, double amount) {
            DiscountStrategy strategy = strategyMap.get(customerType);
            return (strategy != null) ? strategy.applyDiscount(amount) : 0.0;
        }
    }
 
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Regular Discount: " + calculator.calculateDiscount("Regular", 200.0));
        System.out.println("Premium Discount: " + calculator.calculateDiscount("Premium", 200.0));
        System.out.println("Gold Discount: " + calculator.calculateDiscount("Gold", 200.0));
    }
}
 
 