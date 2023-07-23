package co.edureka.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine {

	public PetrolEngine() {
		System.out.println("PetrolEngine :: Constructor");
	}

	@Override
	public boolean startEngine() {
		System.out.println("starting Petrol engine....");
		boolean startStatus = new Random().nextBoolean();
		return startStatus;
	}

}
