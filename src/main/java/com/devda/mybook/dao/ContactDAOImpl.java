package com.devda.mybook.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devda.mybook.form.Contact;

/**
 * @author Prashant
 * ContactDAOImpl is user access data form database 
 */
@Repository
public class ContactDAOImpl implements ContactDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.devda.mybook.dao.ContactDAO#addContact(com.devda.mybook.form.Contact)
	 */
	@Override
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	/* (non-Javadoc)
	 * @see com.devda.mybook.dao.ContactDAO#ListContact()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> ListContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	/* (non-Javadoc)
	 * @see com.devda.mybook.dao.ContactDAO#removeContact(java.lang.Integer)
	 */
	@Override
	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
		if (contact != null) {
			sessionFactory.getCurrentSession().delete(contact);
		}
	}

	@Override
	public void updateContact(Contact contact) {
		Contact updateContact = getContact(contact.getId());
		updateContact.setFirstname(contact.getFirstname());
		updateContact.setLastname(contact.getLastname());
		updateContact.setEmail(contact.getEmail());
		updateContact.setAddress(contact.getAddress());
		updateContact.setTelephone(contact.getTelephone());
		sessionFactory.getCurrentSession().update(updateContact);		
	}

	@Override
	public Contact getContact(Integer contactId) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, contactId);
		return contact;
	}



}
