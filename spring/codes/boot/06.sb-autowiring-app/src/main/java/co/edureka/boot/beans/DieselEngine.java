package co.edureka.boot.beans;

import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DieselEngine implements Engine {

	public DieselEngine() {
		System.out.println("DieselEngine :: Constructor");
	}

	@Override
	public boolean startEngine() {
		System.out.println("starting Diesel engine....");
		boolean startStatus = new Random().nextBoolean();
		return startStatus;
	}

}
