package co.edureka.cms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edureka.cms.entity.Contact;

@Repository //optional
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
