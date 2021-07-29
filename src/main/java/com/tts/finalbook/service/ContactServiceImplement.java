package com.tts.finalbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.finalbook.model.Contact;
import com.tts.finalbook.repository.ContactRepository;

@Service
public class ContactServiceImplement implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	// Return list of contacts to controller
	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	// Save contact to database
	@Override
	public void saveContact(Contact contact) {
		this.contactRepository.save(contact);
	}

	@Override
	public Contact getContactById(long id) {
		Optional<Contact> optional = contactRepository.findById(id);
		Contact contact = null;
		if (optional.isPresent()) {
			contact = optional.get();
		} else {
			throw new RuntimeException("Sorry, Contact not found :: " + id);
		}
		return contact;
	}

	@Override
	public void deleteContactById(long id) {
		this.contactRepository.deleteById(id);
	}

}
