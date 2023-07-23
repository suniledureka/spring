package co.edureka.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	@Qualifier("petrolEngine")
	private Engine engine;   
	
	public void startJourney() {
		boolean status = engine.startEngine();
		if(status)
			System.out.println("###--- HAPPY JOURNEY ---###");
		else
			System.err.println("@@@--- CANCELLED THE TRIP ---@@@");
	}
}
