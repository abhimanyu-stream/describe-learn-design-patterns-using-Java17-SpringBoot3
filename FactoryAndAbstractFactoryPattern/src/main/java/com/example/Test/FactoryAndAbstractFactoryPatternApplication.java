package com.example.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryAndAbstractFactoryPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryAndAbstractFactoryPatternApplication.class, args);


		//Factory Patter Implementation
		// Create a Warrior character
		Character warrior = new Warrior();
		warrior.attack();
		warrior.defence();

		// Create a Wizard character
		Character wizard = new Wizard();
		wizard.attack();
		wizard.defence();

		// Create an Archer character
		Character archer = new Archer();
		archer.attack();
		archer.defence();

		//Abstract Factory Patter Implementation
		CharacterFactory factoryC = new ArcherFactory();
		Character character1 = factoryC.createCharacter();
		character1.attack();
		character1.defence();

		//Abstract Factory Patter Implementation
		CharacterFactory factory = new WarriorFactory();
		Character character = factory.createCharacter();
		character.attack();
		character.defence();

	}

}
