package co.edureka.cms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import co.edureka.cms.entity.Contact;
import co.edureka.cms.repository.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		/*
		//--- sorting with the OrderBy method (approach-1)
		//List<Contact> contacts = contactRepo.findByOrderByContactNameAsc();
		List<Contact> contacts = contactRepo.findByOrderByContactNameDesc();
		printContacts(contacts);
		*/
		
		/*
		//--- sorting with Sort parameter in findAll() (approach-2)
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName"));
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").ascending());
		List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").descending());
		printContacts(contacts);
		*/
		
		//---retrieving contacts using Pagination
		//int pageNo = 0;
		int pageNo = 1;
		int pageSize = 4;
		Page<Contact> page = contactRepo.findAll(PageRequest.of(pageNo, pageSize));
		List<Contact> contacts = page.getContent();
		printContacts(contacts);
		
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
