package com.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryMethodAbstractFactoryPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryMethodAbstractFactoryPatternApplication.class, args);

		/**
		 * The Factory Method and Abstract Factory are two creational design patterns that deal with object creation, but they are used in slightly different scenarios. Below is a comparison along with Java examples for better understanding.
		 *
		 * Factory Method Design Pattern
		 * Purpose: Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
		 * When to Use: When a class cannot anticipate the type of objects it needs to create.
		 * Key Components:
		 * Product: The interface or abstract class defining the object to be created.
		 * Concrete Product: The actual implementation of the product interface.
		 * Creator: The abstract class or interface defining the factory method.
		 * Concrete Creator: The class implementing the factory method to produce specific products.
		 * */

		//FactoryMethodExample
		ShapeFactory circleFactory = new CircleFactory();
		Shape circle = circleFactory.createShape();
		circle.draw();

		ShapeFactory squareFactory = new SquareFactory();
		Shape square = squareFactory.createShape();
		square.draw();


		/**
		 * Abstract Factory Design Pattern
		 * Purpose: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
		 * When to Use: When the system needs to create multiple families of related objects.
		 * Key Components:
		 * Abstract Factory: An interface defining methods to create abstract products.
		 * Concrete Factory: A class implementing the abstract factory and producing family objects.
		 * Abstract Product: Interface or abstract class for the family of objects.
		 * Concrete Product: Specific implementations of the abstract product.
		 * */



		GUIFactory factory;// Its Connector Interface reference

		// Suppose we are on Windows
		factory = new WindowsFactory();
		Button button = factory.createButton();// ObjectType-1
		Checkbox checkbox = factory.createCheckbox();//ObjectType-2
		button.render();
		checkbox.render();

		// Suppose we switch to MacOS
		factory = new MacOSFactory();
		button = factory.createButton();//ObjectType-1
		checkbox = factory.createCheckbox();//ObjectType-2
		button.render();
		checkbox.render();
	}

}

//Factory Method start
// Product interface
interface Shape {
	void draw();
}

// Concrete Products
class Circle implements Shape {
	public void draw() {
		System.out.println("Drawing a Circle");
	}
}

class Square implements Shape {
	public void draw() {
		System.out.println("Drawing a Square");
	}
}

// Creator
abstract class ShapeFactory {
	public abstract Shape createShape();
}

// Concrete Creators
class CircleFactory extends ShapeFactory {
	public Shape createShape() {
		return new Circle();
	}
}

class SquareFactory extends ShapeFactory {
	public Shape createShape() {
		return new Square();
	}
}

//Abstract Factory start[ two or more interface or abstract class]
// Abstract Products
interface Button {
	void render();
}

interface Checkbox {
	void render();
}

// Concrete Products
class WindowsButton implements Button {
	public void render() {
		System.out.println("Rendering Windows Button");
	}
}

class MacOSButton implements Button {
	public void render() {
		System.out.println("Rendering MacOS Button");
	}
}

class WindowsCheckbox implements Checkbox {
	public void render() {
		System.out.println("Rendering Windows Checkbox");
	}
}

class MacOSCheckbox implements Checkbox {
	public void render() {
		System.out.println("Rendering MacOS Checkbox");
	}
}

// Abstract Factory
interface GUIFactory {
	// The interface which has method to create all Interface Implementation class
	// It's a connector Interface
	Button createButton();
	Checkbox createCheckbox();
}

// Concrete Factories
class WindowsFactory implements GUIFactory {
	public Button createButton() {
		return new WindowsButton();
	}
	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}
}

class MacOSFactory implements GUIFactory {
	public Button createButton() {
		return new MacOSButton();
	}
	public Checkbox createCheckbox() {
		return new MacOSCheckbox();
	}
}