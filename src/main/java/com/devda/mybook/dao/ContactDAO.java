package com.devda.mybook.dao;

import java.util.List;

import com.devda.mybook.form.Contact;

/**
 * @author Prashant
 *	DAO for the Contact.
 */
public interface ContactDAO {
	
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
	 * @param contact TODO
	 * To update the contact object
	 */
	public void updateContact(Contact contact);
	
	/**
	 * @param contactId
	 * @return {@link Contact} 
	 * To get the contact object according to conatactId 
	 */
	public Contact getContact(Integer contactId);
}
