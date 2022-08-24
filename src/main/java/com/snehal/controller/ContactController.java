package com.snehal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.Model.Contact;
import com.snehal.service.ContactServiceI;

@RestController
public class ContactController {
      
	@Autowired
	private ContactServiceI contactServiceI;
	
	//save
	
	@PostMapping(value="/saveContact",consumes="application/json")
	public ResponseEntity<String>saveContact(@RequestBody Contact contact){
		
		boolean saveContact = contactServiceI.saveContact(contact);
		
		if(saveContact==true) {
			String msg="Contact saved succesfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);	
		}else {
			String msg="Contact not saved Succesfully";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
			
	}
	
	//getAll
	@GetMapping(value="/getAllContact",produces="application/json")
	public ResponseEntity<List<Contact>>getAllContact(){
		List<Contact> allContact = contactServiceI.getAllContact();
		
		if(allContact!=null) {
			
			return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
		}else {
			String msg="Data not found";
			return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		}
			
	}
	
	//getBy Server
	
	@GetMapping(value="/getContactById/{cid}",produces="application/json")
	public ResponseEntity<Contact>getContactById(@PathVariable Integer cid){
		
		Contact contactById = contactServiceI.getContactById(cid);
			
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
		}
		
	//update 
	
	
	
	@PutMapping(value="/updateContact",consumes="application/json")
	public ResponseEntity<String>updateContact(@RequestBody Contact contact){
		
		 boolean updateContact = contactServiceI.updateContact(contact);
		 
		
		if(updateContact==true) {
			String msg="Contact updated succesfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);	
		}else {
			String msg="Contact not updated Succesfully";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	//deleteById
	@DeleteMapping(value="/deleteById/{cid}")
	public ResponseEntity<String>deleteById(@PathVariable Integer cid){
		boolean deleteById = contactServiceI.deleteById(cid);
		if(deleteById) {
			
			return new  ResponseEntity<String>("contact deleted succesfully",HttpStatus.OK);
		}else {
			return new  ResponseEntity<String>("contact  not deleted succesfully",HttpStatus.BAD_REQUEST);
		}
			
	}
	
	
	
	
	
}

