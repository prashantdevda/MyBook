package com.devda.mybook.service;

import java.util.List;

import com.devda.mybook.form.Contact;

/**
 * Interface for contact service.
 * @author Prashant
 *
 */
public interface ContactService {
	/**
	 * @param contact
	 * To add contact into database.
	 */
	public void addContact(Contact contact);

	/**
	 * @return the list of contact.
	 */
	public List<Contact> ListContact();

	/**
	 * @param id of the contact
	 * To delete the contact.
	 */
	public void removeContact(Integer id);
	
	/**
	 * @param contact
	 * To update the contact
	 */
	public void updateContact(Contact contact);
	/**
	 * @param contactId
	 * @return {@link Contact} 
	 * To get the contact object according to conatactId 
	 */
	public Contact getContact(Integer contactId);
}
