package com.solid.principles.solid_principles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolidPrinciplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolidPrinciplesApplication.class, args);

		//Summary of Benefits
		//SRP: Improved modularity and maintainability.
		//OCP: Easily extend functionality without modifying existing code.
		//LSP: Avoid surprises by ensuring correct behavior of derived classes.
		//ISP: Focused and lightweight interfaces.
		//DIP: Decoupled code for better flexibility and testability.
		//By adhering to these principles, you can create a clean and maintainable codebase.



		/**
		 *
		 * 1. Single Responsibility Principle (SRP)
		 * Problem: Classes or modules often take on multiple responsibilities, leading to:
		 *
		 * Hard-to-maintain code.
		 * Higher risk of bugs when changes are made.
		 * Increased difficulty in testing.
		 * Solution:
		 *
		 * Each class should have only one reason to change, meaning it should focus on a single responsibility or functionality.
		 *
		 *
		 * Responsibilities are divided among multiple, smaller classes.
		 *
		 *
		 * Key Benefit:
		 *
		 * Improves maintainability by separating concerns.
		 * Simplifies debugging and testing.
		 *
		 *
		 *
		 * // Violates SRP: One class handles both Order logic and saving to DB.
		 * class Order {
		 *     private String productName;
		 *     private int quantity;
		 *
		 *     public void saveToDatabase() {
		 *         // Logic for saving order to DB
		 *         System.out.println("Saving order to database");
		 *     }
		 * }
		 *
		 * // Follows SRP: Separate classes for business logic and persistence.
		 * class Order {
		 *     private String productName;
		 *     private int quantity;
		 *
		 *     // Getters and setters
		 * }
		 *
		 * class OrderService {
		 *     public void save(Order order) {
		 *         System.out.println("Saving order to database");
		 *     }
		 * }
		 *
		 *
		 *
		 *
		 * 2. Open/Closed Principle (OCP)
		 * Problem: Modifying existing code to add new functionality can introduce bugs and make code brittle:
		 *
		 * Code must be revisited and changed frequently.
		 * Existing functionality might break due to these changes.
		 * Solution:
		 *
		 * Classes, modules, and functions should be open for extension but closed for modification.
		 *
		 *
		 * Use interfaces, abstract classes, or polymorphism to add new functionality without altering existing code.
		 *
		 * it advocates to use polymorphism
		 * Key Benefit:
		 *
		 * Reduces the risk of breaking existing code.
		 * Encourages a modular and flexible design, making it easier to add new features.
		 *
		 *  // Violates OCP: Modifying PaymentService to add a new payment type.
		 * class PaymentService {
		 *     public void processPayment(String type) {
		 *         if (type.equals("CreditCard")) {
		 *             System.out.println("Processing Credit Card payment");
		 *         } else if (type.equals("PayPal")) {
		 *             System.out.println("Processing PayPal payment");
		 *         }
		 *     }
		 * }
		 *
		 * // Follows OCP: Add new payment types by extending the interface.
		 * interface Payment {
		 *     void pay();
		 * }
		 *
		 * class CreditCardPayment implements Payment {
		 *     public void pay() {
		 *         System.out.println("Processing Credit Card payment");
		 *     }
		 * }
		 *
		 * class PayPalPayment implements Payment {
		 *     public void pay() {
		 *         System.out.println("Processing PayPal payment");
		 *     }
		 * }
		 *
		 * class PaymentService {
		 *     public void processPayment(Payment payment) {
		 *         payment.pay();
		 *     }
		 * }
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 * 3. Liskov Substitution Principle (LSP)
		 * Problem: Subclasses that do not properly adhere to the behavior of their base class can cause:
		 *
		 * Unexpected behaviors or broken functionality.
		 * Violations of polymorphism principles.
		 * Solution:
		 *
		 * Ensure that a subclass can replace its base class without altering the correctness of the program.
		 * Subclasses should only add behavior, not override or violate expectations of the base class.
		 *
		 * Subclasses should fulfill expected behaviors of the base class. it advocates to use polymorphism
		 *
		 *
		 *
		 * Key Benefit:
		 *
		 * Ensures correctness and predictability when using polymorphism.
		 * Encourages designing classes with clear, consistent contracts.
		 *
		 *
		 *
		 *
		 * 4. Interface Segregation Principle (ISP)
		 * Problem: Large, monolithic interfaces force classes to implement methods they don't need:
		 *
		 * Large interfaces force classes to implement methods they don't need, so make many interfaces more focused and easier to understand, suitable for Subclass to impl.
		 *
		 *
		 * Leads to bloated or unused code.
		 * Increases maintenance complexity.
		 * Solution:
		 *
		 * Break down large interfaces into smaller, more specific ones.
		 * A class should only implement the interfaces relevant to its responsibilities.
		 * Key Benefit:
		 *
		 * Makes interfaces more focused and easier to understand.
		 * Reduces the impact of changes in unrelated functionalities.
		 *
		 *
		 *
		 *
		 * 5. Dependency Inversion Principle (DIP)
		 * Problem: High-level modules directly depend on low-level modules:
		 *
		 * Creates tight coupling between components.
		 * Makes the code less reusable, harder to test, and difficult to adapt.
		 * Solution:
		 *
		 * High-level modules should depend on abstractions (e.g., interfaces), not concrete implementations.
		 * Low-level modules should also depend on abstractions.
		 * Key Benefit:
		 *
		 * Decouples high-level logic from low-level implementation details.
		 * Improves flexibility, testability, and reusability.
		 * */
	}

}
