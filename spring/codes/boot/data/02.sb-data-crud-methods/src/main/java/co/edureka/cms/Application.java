package co.edureka.cms;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
		
		/*
		//--- to get a Contact based on ID property ---
		Optional<Contact> optContact = contactRepo.findById(1007);
		if(optContact.isPresent()) {
			Contact contact = optContact.get();
			System.out.println(contact);
		}else {
			System.err.println("No Matching Contact found!!");
		}	
		*/		
		
		/*
		//--- to get contacts based on multiple IDs ----
		Iterable<Serializable> contactIds = Arrays.asList(1003,2005,7125,1004,1001);
		Iterable<Contact> contacts = contactRepo.findAllById(contactIds);
		printContacts(contacts);
		*/
		
		/*
		//--- to get all Contacts ---
		Iterable<Contact> contacts = contactRepo.findAll();
		printContacts(contacts);
		*/
		
		//--- to get the number of Contacts ---
		long noOfContacts = contactRepo.count();
		System.out.println("no of contacts = " + noOfContacts);
		
		//--- to check whether a contact is existing with a specific contact id ---
		boolean isExists = contactRepo.existsById(1001);
		System.out.println("contact with contact id: 1001 exists = "+ isExists);
		
		//--- to delete a contact based on contactId ---
		contactRepo.deleteById(1005);
		context.close();
	}

	private static void printContacts(Iterable<Contact> contacts) {
		for(Contact contact : contacts) {
			System.out.println(contact);
			try {
				TimeUnit.SECONDS.sleep(1); //Thread.sleep(1000);
			}catch(Exception ex) {}
		}		
	}
}
