package com.contacts.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.app.domain.Contact;
import com.contacts.app.service.ContactsAppServicesImpl;

@RestController
public class ContactsAppController {
	
	@Autowired
	private ContactsAppServicesImpl contactsAppServicesImpl;

	@GetMapping("/getAllContacts")
	public ResponseEntity<List<Contact>> getAllContacts() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		List<Contact> contactList =  contactsAppServicesImpl.getAllContacts();
		return ResponseEntity.ok().headers(headers).body(contactList);
	}
	
	@GetMapping("/getContact/{contactId}")
	public ResponseEntity<Contact> getContactWithId(@PathVariable Integer contactId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		Contact contact = contactsAppServicesImpl.getContactWithId(contactId);
		return ResponseEntity.ok().headers(headers).body(contact);
	}
	
	@PostMapping("/addContact")
	public ResponseEntity<String> addContact(@RequestBody Contact contact) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:3000");
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, OPTIONS, DELETE");
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type");
		String response =  contactsAppServicesImpl.addContact(contact);
		return ResponseEntity.ok().headers(headers).body(response);
	}
	
	@PutMapping("/editContact/{contactId}")
	public ResponseEntity<Contact> editContact(@PathVariable Integer contactId ,@RequestBody Contact contact) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		Contact con = contactsAppServicesImpl.editContact(contactId, contact);
		return ResponseEntity.ok().headers(headers).body(con);
	}	
	
	@DeleteMapping("/deleteContact/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		String response = contactsAppServicesImpl.deleteContact(contactId);
		return ResponseEntity.ok().headers(headers).body(response);
	}
}
