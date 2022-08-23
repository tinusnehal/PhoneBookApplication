package com.snehal.service;

import java.util.List;

import com.snehal.Model.Contact;

public interface ContactServiceI {

	boolean saveContact(Contact contact);
	List<Contact>getAllContact();
	Contact getContactById(Integer cid);
	public boolean updateContact(Contact contact);
	
}
