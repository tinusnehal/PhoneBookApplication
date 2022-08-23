package com.snehal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.Model.Contact;
import com.snehal.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI{

	@Autowired
	private ContactRepository contactRepository;
	
	
	@Override
	public boolean saveContact(Contact contact) {
		
		Contact save = contactRepository.save(contact);
		
		if(save!=null) {
			return true;
		}else {
		return false;
		}
	}


	@Override
	public List<Contact> getAllContact() {
		List<Contact> findAll = contactRepository.findAll();
		return findAll;
	}


	@Override
	public Contact getContactById(Integer cid) {
		Contact findById = contactRepository.findById(cid).get();
		return findById;
	}

}
