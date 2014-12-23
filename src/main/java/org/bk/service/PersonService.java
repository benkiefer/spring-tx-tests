package org.bk.service;

import org.bk.domain.Person;
import org.bk.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private IServiceHelper serviceHelper;

    @Transactional
    public Person create(Person person) {
        Person save = personRepository.save(person);
        serviceHelper.help();
        return save;
    }

    public Person getById(String id) {
        return personRepository.findOne(id);
    }
}
