package com.snehal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.Model.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer>{

}
