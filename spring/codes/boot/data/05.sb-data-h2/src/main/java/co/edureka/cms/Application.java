package co.edureka.cms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import co.edureka.cms.entity.Contact;
import co.edureka.cms.repository.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
	
		//------ saving multiple contacts in persistence store ------

		List<Contact> contacts = Arrays.asList(
					new Contact("Praveen Kumar", "7744885596"),
					new Contact("Manoj", "4584885596"),
					new Contact("Marck", "1234567890"),
					new Contact("Laura", "7744885596")
				);

		contactRepo.saveAll(contacts);
	}

}
