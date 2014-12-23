package org.bk.controller;

import org.bk.domain.Person;
import org.bk.model.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person toDomain(PersonModel model) {
        Person domain = new Person();
        domain.setFirstName(model.getFirstName());
        domain.setLastName(model.getLastName());
        return domain;
    }
}
