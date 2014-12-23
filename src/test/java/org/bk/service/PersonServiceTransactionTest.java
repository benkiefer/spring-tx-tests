package org.bk.service;

import org.bk.TestDatabaseConfig;
import org.bk.domain.Person;
import org.bk.ioc.ServiceConfig;
import org.bk.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

@Test
@ContextConfiguration(classes = {ServiceConfig.class, TestDatabaseConfig.class, HibernateJpaAutoConfiguration.class})
public class PersonServiceTransactionTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void create() {
        Person person = personService.create(person());
        assertNotNull(personRepository.findOne(person.getId()));
    }

    private Person person() {
        Person person = new Person();
        person.setFirstName("first");
        person.setLastName("last");
        return person;
    }

}