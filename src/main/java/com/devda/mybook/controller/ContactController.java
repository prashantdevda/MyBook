package com.devda.mybook.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devda.mybook.form.Contact;
import com.devda.mybook.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/index")
	public String listContect(Map<String, Object> map){
		
		map.put("contact", new Contact());
		map.put("contactList", contactService.ListContact());
		
		return "contact";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result){
		contactService.addContact(contact);
		return "redirect:/index";
	}
	
	@RequestMapping("delete/{contactId}")	
	public String deleteContact(@PathVariable("contactId") Integer contactId){
		contactService.removeContact(contactId);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/edit/{contactId}", method = RequestMethod.GET)
	public ModelAndView editContactPage(@PathVariable Integer contactId){
		ModelAndView modelAndView = new ModelAndView("editContact");
		Contact contact = (Contact) contactService.getContact(contactId);
		modelAndView.addObject("contact", contact);
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit/{contactId}", method = RequestMethod.POST)
//	public String editContact(@ModelAttribute("contact") Contact contact, @PathVariable("contactId") Integer contactId){
		public String editContact(@ModelAttribute("contact") Contact contact, BindingResult result){		
		contactService.updateContact(contact);		
		return "redirect:/index";
	}
}
