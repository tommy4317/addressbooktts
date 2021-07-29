package com.tts.finalbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.finalbook.model.Contact;
import com.tts.finalbook.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	// display page
	@GetMapping("/")
	public String viewPage(Model model) {
		model.addAttribute("listContacts", contactService.getAllContacts());
		return "index";
	}

	// new contact form display
	@GetMapping("/showNewContactForm")
	public String newContactForm(Model model) {
		// model attribute for form data
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "new_contact";
	}

	// save contact
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		// add contact to database
		contactService.saveContact(contact);
		return "redirect:/";

	}

	// update form display
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get contact from service
		Contact contact = contactService.getContactById(id);

		// set contact as model attribute
		model.addAttribute("contact", contact);
		return "update_contact";
	}

	// delete contact
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable(value = "id") long id) {
		this.contactService.deleteContactById(id);
		return "redirect:/";
	}

}
