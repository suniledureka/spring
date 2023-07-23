package co.edureka.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Engine engine;
	
	public Car() {
		System.out.println("Car :: Constructor");
	}	
	
	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void startJourney() {
		boolean status = engine.startEngine();
		if(status)
			System.out.println("###--- HAPPY JOURNEY ---###");
		else
			System.err.println("@@@--- CANCELLED THE TRIP ---@@@");
	}
}
