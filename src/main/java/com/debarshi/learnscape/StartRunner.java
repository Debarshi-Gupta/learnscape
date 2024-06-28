package com.debarshi.learnscape;

import com.debarshi.learnscape.model.Holiday;
import com.debarshi.learnscape.model.Person;
import com.debarshi.learnscape.model.Role;
import com.debarshi.learnscape.repository.HolidayRepository;
import com.debarshi.learnscape.repository.PersonRepository;
import com.debarshi.learnscape.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class StartRunner implements ApplicationRunner {

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

//        Holiday holiday1 = new Holiday();
//        holiday1.setDay("Jan 1");
//        holiday1.setType(Holiday.Type.FESTIVAL);
//        holiday1.setReason("New Year's Day");
//        holiday1.setCreatedAt(LocalDateTime.now());
//        holiday1.setCreatedBy("Database Admin");
//
//        Holiday holiday2 = new Holiday();
//        holiday2.setDay("Jan 26");
//        holiday2.setType(Holiday.Type.FESTIVAL);
//        holiday2.setReason("Republic Day");
//        holiday2.setCreatedAt(LocalDateTime.now());
//        holiday2.setCreatedBy("Database Admin");
//
//        Holiday holiday3 = new Holiday();
//        holiday3.setDay("Aug 15");
//        holiday3.setType(Holiday.Type.FESTIVAL);
//        holiday3.setReason("Independence Day");
//        holiday3.setCreatedAt(LocalDateTime.now());
//        holiday3.setCreatedBy("Database Admin");
//
//        Holiday holiday4 = new Holiday();
//        holiday4.setDay("Dec 25");
//        holiday4.setType(Holiday.Type.FESTIVAL);
//        holiday4.setReason("Christmas");
//        holiday4.setCreatedAt(LocalDateTime.now());
//        holiday4.setCreatedBy("Database Admin");
//
//        holidayRepository.save(holiday1);
//        holidayRepository.save(holiday2);
//        holidayRepository.save(holiday3);
//        holidayRepository.save(holiday4);
//
//        Role role1 = new Role();
//        role1.setRoleName("ADMIN");
//        role1.setCreatedAt(LocalDateTime.now());
//        role1.setCreatedBy("DBA");
//
//        Role role2 = new Role();
//        role2.setRoleName("STUDENT");
//        role2.setCreatedAt(LocalDateTime.now());
//        role2.setCreatedBy("DBA");
//
//        roleRepository.save(role1);
//        roleRepository.save(role2);

//        Person person = new Person();
//        person.setName("ADMIN");
//        person.setEmail("admin@learnscape.com");
//        person.setMobileNumber("3443434343");
//        person.setPwd(passwordEncoder.encode("12345678"));
//        person.setRole(roleRepository.getByRoleName("ADMIN"));
//        person.setCreatedAt(LocalDateTime.now());
//        person.setCreatedBy("Database Admin");
//
//        personRepository.save(person);

        Person person = new Person();
        person.setName("ADMIN");
        person.setEmail("admin@learnscape.com");
        person.setMobileNumber("3443434343");
        person.setPwd(passwordEncoder.encode("12345678"));

        Role role = roleRepository.getByRoleName("ADMIN");
        if (role == null) {
            role = new Role();
            role.setRoleName("ADMIN");
            role.setCreatedAt(LocalDateTime.now());
            role.setCreatedBy("DBA");
            role = roleRepository.save(role);
        }

        person.setRole(role);
        person.setCreatedAt(LocalDateTime.now());
        person.setCreatedBy("Database Admin");

        personRepository.save(person);
    }
}
