package co.edureka.cms;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import co.edureka.cms.entity.Contact;
import co.edureka.cms.repository.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		//--- fetching a Contact based on properties other than Primary Key ---
		Optional<Contact> optContact = contactRepo.findByContactName("Sanjay Patil");
		if(optContact.isPresent()) {
			Contact contact = optContact.get();
			System.out.println(contact);
		}else {
			System.err.println("no matching contact found!!");
		}
		
		
		Contact contact = contactRepo.findByContactNumber("1234567890");
		System.out.println(contact);
		System.out.println();
		
		contact = contactRepo.findByContactNameAndContactNumber("Sanjay","1234567890");
		System.out.println(contact);
		
		List<Contact> contacts = contactRepo.findByContactNameOrContactNumber("Manoj","1234567890");
		for(Contact ct : contacts) {
			System.out.println(ct);
		}
		System.out.println();
		
		System.out.println("------ contact names ------");
		List<String> cNames = contactRepo.getContactNames();
		for(String name : cNames) {
			System.out.println("----> " + name);
		}
		System.out.println();
		
		contact = contactRepo.findContactByName("Marck");
		System.out.println(contact);
		
		context.close();
	}

}
