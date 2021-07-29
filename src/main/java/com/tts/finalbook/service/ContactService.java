package com.tts.finalbook.service;

import java.util.List;

import com.tts.finalbook.model.Contact;

public interface ContactService {
	List<Contact> getAllContacts();

	void saveContact(Contact contact);

	Contact getContactById(long id);

	void deleteContactById(long id);

}
