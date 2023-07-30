package co.edureka.cms.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edureka.cms.entity.Contact;

@Repository //optional
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

	List<Contact> findByOrderByContactNameAsc();

	List<Contact> findByOrderByContactNameDesc();


}
