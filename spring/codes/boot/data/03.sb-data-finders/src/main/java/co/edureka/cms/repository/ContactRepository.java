package co.edureka.cms.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edureka.cms.entity.Contact;

@Repository //optional
public interface ContactRepository extends CrudRepository<Contact, Serializable> {

	Optional<Contact> findByContactName(String string);
	
	Contact findByContactNumber(String cNo);
	
	Contact findByContactNameAndContactNumber(String cname, String cno);
	
	List<Contact> findByContactNameOrContactNumber(String cname, String cno);
	
	//@Query("select contactName from co.edureka.cms.entity.Contact") //HQL
	@Query(value = "select CONTACT_NAME from CONTACT_MASTER", nativeQuery = true)
	List<String> getContactNames();
	
	@Query("select contact from co.edureka.cms.entity.Contact contact where contactName= :cname")
	Contact findContactByName(String cname);
}
