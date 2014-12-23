package org.bk.controller;

import org.bk.domain.Person;
import org.bk.model.PersonModel;
import org.bk.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonMapper personMapper;

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ResponseEntity<Person> create(@RequestBody PersonModel model) {
        Person mapped = personMapper.toDomain(model);
        return new ResponseEntity<>(personService.create(mapped), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getById(@PathVariable String id) {
        Person person = personService.getById(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
