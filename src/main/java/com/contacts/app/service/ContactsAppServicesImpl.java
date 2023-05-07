package com.contacts.app.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.app.domain.Contact;
import com.contacts.app.repository.ContactsRepository;

@Service
public class ContactsAppServicesImpl {

	private static final Logger log = (Logger) LoggerFactory.getLogger("ContactsAppServicesImpl");
	
	@Autowired
	private ContactsRepository contactsRepository;
	
	public List<Contact> getAllContacts() {
		log.info("Get all the contacts - Start");
		List<Contact> contacts = contactsRepository.findAll();
		log.info("Get all the contacts - End");
		return contacts;
	}

	public Contact getContactWithId(Integer contactId) {
		log.info("Get the contact with given contact id - Start");
		Contact contact = contactsRepository.findByContactId(contactId);
		log.info("Get the contact with given contact id - End");
		return contact;
	}

	public String addContact(Contact contact) {
		log.info("Adding a new contact - Start");
		contactsRepository.save(contact);
		log.info("Adding a new contact - End");
		return "The contact has been added successfully";
	}

	public String deleteContact(Integer contactId) {
		log.info("Deleting a new contact - Start");
		contactsRepository.deleteById(contactId);
		log.info("Deleting a new contact - End");
		return "The Contact has been deleted";
	}

	public Contact editContact(Integer contactId, Contact contact) {
		log.info("Editing an existing contact - Start");
		Contact con = contactsRepository.findByContactId(contactId);
		if(con != null) { 
		con.setFirstName(contact.getFirstName());
		con.setLastName(contact.getLastName());
		con.setMobileNo(contact.getMobileNo());
		con.setEmailId(contact.getEmailId());
		contactsRepository.save(con);
		log.info("Editing an existing contact - End");}
		return con;
	}
}