package ru.ilyas.service;

import ru.ilyas.entity.Contact;

import java.util.List;


public interface ContactService {

    Contact save(Contact contact);

    List<Contact> findAll();

}
