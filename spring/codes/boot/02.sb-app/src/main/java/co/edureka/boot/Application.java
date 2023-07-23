package co.edureka.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import co.edureka.boot.beans.Car;
import co.edureka.boot.beans.Ticket;
import co.edureka.boot.utils.PasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println();
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println();
		
		//Car car = context.getBean(Car.class);
		//Car car = (Car) context.getBean("car");
		//Car car = context.getBean("car", Car.class);
		Car car = (Car) context.getBean("mycar");
		car.startJourney();
		System.out.println();
		
		//PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
		//PasswordEncoder encoder = (PasswordEncoder) context.getBean("getEncoder");
		//PasswordEncoder encoder = (PasswordEncoder) context.getBean("security");
		PasswordEncoder encoder = (PasswordEncoder) context.getBean("encryptor");
		String myPwd = "LetmeIn$123";
		String encodedPwd = encoder.encodePassword(myPwd);
		System.out.println("encoded password = " + encodedPwd);
		System.out.println();
		
		Ticket tkt = (Ticket)context.getBean(Ticket.class);
		System.out.println(tkt);
		
		context.close();
	}
}
