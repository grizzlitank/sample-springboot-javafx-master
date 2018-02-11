package ru.ilyas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ilyas.entity.Contact;
import ru.ilyas.repository.ContactRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод добавляет парочку записей в БД после запуска приложения,
     * чтобы не было совсем пусто.
     *
     * Из-за того, что подключена H2 (in-memory) БД.
     */


    @Override
    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }
}
