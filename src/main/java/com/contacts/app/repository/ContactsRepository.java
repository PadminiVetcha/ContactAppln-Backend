package com.contacts.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.contacts.app.domain.Contact;

@Repository
public interface ContactsRepository extends MongoRepository<Contact, Integer> {

	@Query("{'firstName' : ?0}")
	Contact findContactByFirstName(String firstName);
	
	@Query("{'contactId' : ?0}")
	Contact findByContactId(Integer contactId);
}
