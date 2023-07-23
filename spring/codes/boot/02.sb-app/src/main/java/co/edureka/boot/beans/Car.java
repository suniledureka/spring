package co.edureka.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

//@Component
@Component("mycar")
public class Car {
	
	public Car() {
		System.out.println("Car :: Constructor");
	}

	public void startJourney() {
		boolean journeyStatus = new Random().nextBoolean();
		if(journeyStatus)
			System.out.println("Happy Journey");
		else
			System.err.println("Journey Cancelled");
	}
}
