package com.stream;

public class FlipKart {
}
/**
 *
 Here’s how you can implement a Flipkart clone in a Spring Boot project using the Abstract Factory design pattern to create product objects dynamically based on their categories, subcategories, and features.

 Implementation Outline
 Abstract Product: Represents general attributes and behavior of products.
 Concrete Product: Specific implementations for each category and subcategory.
 Abstract Factory: Interface for creating products.
 Concrete Factories: Factories for different categories, like Electronics and Fashion.
 Controller: Handles incoming HTTP requests to create and retrieve product details.
 Code Implementation
 1. Abstract Product Interface
 Define an interface for the general product structure.

 java
 Copy code
 package com.flipkart.clone.model;

 import java.util.Map;

 public interface Product {
 String getCategory();
 String getSubCategory();
 Map<String, String> getFeatures();
 }
 2. Concrete Product Implementations
 java
 Copy code
 package com.flipkart.clone.model;

 import java.util.Map;

 // Electronics Product
 public class ElectronicProduct implements Product {
 private final String category = "Electronics";
 private String subCategory;
 private Map<String, String> features;

 public ElectronicProduct(String subCategory, Map<String, String> features) {  // subCategory can be Phone, TV, Computer, Laptop, Accessories
 this.subCategory = subCategory;
 this.features = features;
 }

 @Override
 public String getCategory() {
 return category;
 }

 @Override
 public String getSubCategory() {
 return subCategory;
 }

 @Override
 public Map<String, String> getFeatures() {
 return features;
 }
 }

 // Fashion Product
 public class FashionProduct implements Product {
 private final String category = "Fashion";
 private String subCategory;
 private Map<String, String> features;

 public FashionProduct(String subCategory, Map<String, String> features) {


 // subCategory can be 1. Clothing { subSubCategory [ Top wear, Bottom Wear, Inner Wear]}
 // subCategory can be 2. Non-Clothing {  glass, Shoes, Sleeper,}
 this.subCategory = subCategory;
 this.features = features;
 }

 @Override
 public String getCategory() {
 return category;
 }

 @Override
 public String getSubCategory() {
 return subCategory;
 }

 @Override
 public Map<String, String> getFeatures() {
 return features;
 }
 }
 3. Abstract Factory Interface
 java
 Copy code
 package com.flipkart.clone.factory;

 import com.flipkart.clone.model.Product;

 import java.util.Map;

 public interface ProductFactory {
 Product createProduct(String subCategory, Map<String, String> features);
 }
 4. Concrete Factories
 java
 Copy code
 package com.flipkart.clone.factory;

 import com.flipkart.clone.model.ElectronicProduct;
 import com.flipkart.clone.model.FashionProduct;
 import com.flipkart.clone.model.Product;

 import java.util.Map;

 // Electronics Factory
 public class ElectronicsFactory implements ProductFactory {
 @Override
 public Product createProduct(String subCategory, Map<String, String> features) {
 return new ElectronicProduct(subCategory, features);
 }
 }

 // Fashion Factory
 public class FashionFactory implements ProductFactory {
 @Override
 public Product createProduct(String subCategory, Map<String, String> features) {
 return new FashionProduct(subCategory, features);
 }
 }
 5. Factory Producer
 This class provides the appropriate factory based on the product category.

 java
 Copy code
 package com.flipkart.clone.factory;

 public class FactoryProducer {
 public static ProductFactory getFactory(String category) {
 if (category.equalsIgnoreCase("Electronics")) {
 return new ElectronicsFactory();
 } else if (category.equalsIgnoreCase("Fashion")) {
 return new FashionFactory();
 }
 throw new IllegalArgumentException("Unknown category: " + category);
 }
 }
 6. Spring Boot Controller
 The controller will handle requests to create products.

 java
 Copy code
 package com.flipkart.clone.controller;

 import com.flipkart.clone.factory.FactoryProducer;
 import com.flipkart.clone.model.Product;
 import org.springframework.web.bind.annotation.*;

 import java.util.Map;

 @RestController
 @RequestMapping("/api/products")
 public class ProductController {

 @PostMapping
 public Product createProduct(@RequestParam String category,
 @RequestParam String subCategory,
 @RequestBody Map<String, String> features) {
 ProductFactory factory = FactoryProducer.getFactory(category);
 return factory.createProduct(subCategory, features);
 }
 }
 7. Application Properties
 Add application configuration:

 properties
 Copy code
 server.port=8080
 spring.application.name=flipkart-clone
 How It Works
 Request Example: Create a product in the Fashion category.

 POST /api/products?category=Fashion&subCategory=Shirt
 Body:
 json
 Copy code
 {
 "size": "M",
 "color": "Red",
 "material": "Cotton"
 }
 Response:

 json
 Copy code
 {
 "category": "Fashion",
 "subCategory": "Shirt",
 "features": {
 "size": "M",
 "color": "Red",
 "material": "Cotton"
 }
 }
 Request Example: Create a product in the Electronics category.

 POST /api/products?category=Electronics&subCategory=Laptop
 Body:
 json
 Copy code
 {
 "ram": "16GB",
 "storage": "512GB SSD",
 "processor": "Intel i7"
 }
 Advantages of Using Abstract Factory
 Flexibility: Easy to add new product categories (e.g., Home Appliances).
 Modularity: Factories are encapsulated; changes in one category don't affect others.
 Scalability: Adding new features or categories requires minimal changes.
 This implementation provides a scalable way to handle product creation dynamically in an e-commerce application.

 * */