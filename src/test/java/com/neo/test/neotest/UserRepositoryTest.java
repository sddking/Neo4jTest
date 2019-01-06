package com.neo.test.neotest;

import com.neo.test.TestApplicationTests;
import com.neo.test.domain.Person;
import com.neo.test.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryTest extends TestApplicationTests {
    Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void init(){
        personRepository.deleteAll();
        Person person = new Person();
        person.setName("张三");
        person.setPhone("110");
        person.setSex(1);
        Person save=personRepository.save(person);
        logger.info(save.toString());
        Assert.assertTrue(save!=null);
    }

    @Test
    public void test(){
        Person p=personRepository.findByName("张三");
        logger.info(p.toString());
    }
}
