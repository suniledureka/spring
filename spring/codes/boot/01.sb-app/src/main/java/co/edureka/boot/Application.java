package co.edureka.boot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println();
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println();
		
		System.out.println(" ======== BEAN NAMES =========\n");
		
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(beanName -> System.out.println(beanName));
	}

}
