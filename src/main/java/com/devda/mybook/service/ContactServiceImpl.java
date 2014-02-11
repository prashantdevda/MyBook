package com.devda.mybook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devda.mybook.dao.ContactDAO;
import com.devda.mybook.form.Contact;

/**
 * This class is implementation of {@link ContactService} it use
 * {@link ContactDAO} to persist contact into database.
 * 
 * @author Prashant
 * 
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO contactDAO;
	
	/* (non-Javadoc)
	 * @see com.devda.mybook.service.ContactService#addContact(com.devda.mybook.form.Contact)
	 */
	@Transactional
	@Override
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	/* (non-Javadoc)
	 * @see com.devda.mybook.service.ContactService#ListContact()
	 */
	@Transactional
	@Override
	public List<Contact> ListContact() {
		return contactDAO.ListContact();
	}

	/* (non-Javadoc)
	 * @see com.devda.mybook.service.ContactService#removeContact(java.lang.Integer)
	 */
	@Transactional
	@Override
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}

	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);		
	}

	@Override
	public Contact getContact(Integer contactId) {
		return contactDAO.getContact(contactId);
	}

}
