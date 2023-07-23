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
		
		/*
		//------ saving/updating a contact in persistence store ------
		Contact contact = new Contact();
		contact.setContactId(1001);
		contact.setContactName("Sanjay Patil");
		contact.setContactNumber("9848586877");
		
		contactRepo.save(contact);
		System.out.println("Contact Saved to Store!!");
		*/
		
		//------ saving multiple contacts in persistence store ------
		List<Contact> contacts = Arrays.asList(
					new Contact(1002,"Praveen Kumar", "7744885596"),
					new Contact(1003,"Manoj", "4584885596"),
					new Contact(1004,"Marck", "1234567890"),
					new Contact(1005,"Laura", "7744885596")
				);
		contactRepo.saveAll(contacts);
		
		((ConfigurableApplicationContext)context).close();
	}

}
