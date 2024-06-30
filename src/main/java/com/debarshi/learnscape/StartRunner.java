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
//        holiday1.setId(1);
//        holiday1.setDay("Jan 1");
//        holiday1.setType(Holiday.Type.FESTIVAL);
//        holiday1.setReason("New Year's Day");
//        holiday1.setCreatedAt(LocalDateTime.now());
//        holiday1.setCreatedBy("Database Admin");
//
//        Holiday holiday6 = new Holiday();
//        holiday6.setId(2);
//        holiday6.setDay("Jan 15");
//        holiday6.setType(Holiday.Type.FESTIVAL);
//        holiday6.setReason("Makar Sankranti");
//        holiday6.setCreatedAt(LocalDateTime.now());
//        holiday6.setCreatedBy("Database Admin");
//
//        Holiday holiday2 = new Holiday();
//        holiday2.setId(3);
//        holiday2.setDay("Jan 26");
//        holiday2.setType(Holiday.Type.FEDERAL);
//        holiday2.setReason("Republic Day");
//        holiday2.setCreatedAt(LocalDateTime.now());
//        holiday2.setCreatedBy("Database Admin");
//
//        Holiday holiday7 = new Holiday();
//        holiday7.setId(4);
//        holiday7.setDay("Mar 25");
//        holiday7.setType(Holiday.Type.FESTIVAL);
//        holiday7.setReason("Holi");
//        holiday7.setCreatedAt(LocalDateTime.now());
//        holiday7.setCreatedBy("Database Admin");
//
//        Holiday holiday3 = new Holiday();
//        holiday3.setId(5);
//        holiday3.setDay("Aug 15");
//        holiday3.setType(Holiday.Type.FEDERAL);
//        holiday3.setReason("Independence Day");
//        holiday3.setCreatedAt(LocalDateTime.now());
//        holiday3.setCreatedBy("Database Admin");
//
//        Holiday holiday8 = new Holiday();
//        holiday8.setId(6);
//        holiday8.setDay("Aug 26");
//        holiday8.setType(Holiday.Type.FESTIVAL);
//        holiday8.setReason("Janmashtami");
//        holiday8.setCreatedAt(LocalDateTime.now());
//        holiday8.setCreatedBy("Database Admin");
//
//        Holiday holiday4 = new Holiday();
//        holiday4.setId(7);
//        holiday4.setDay("Oct 02");
//        holiday4.setType(Holiday.Type.FEDERAL);
//        holiday4.setReason("Gandhi Jayanti");
//        holiday4.setCreatedAt(LocalDateTime.now());
//        holiday4.setCreatedBy("Database Admin");
//
//        Holiday holiday5 = new Holiday();
//        holiday5.setId(8);
//        holiday5.setDay("Dec 25");
//        holiday5.setType(Holiday.Type.FESTIVAL);
//        holiday5.setReason("Christmas");
//        holiday5.setCreatedAt(LocalDateTime.now());
//        holiday5.setCreatedBy("Database Admin");
//
//        holidayRepository.save(holiday1);
//        holidayRepository.save(holiday2);
//        holidayRepository.save(holiday3);
//        holidayRepository.save(holiday4);
//        holidayRepository.save(holiday5);
//        holidayRepository.save(holiday6);
//        holidayRepository.save(holiday7);
//        holidayRepository.save(holiday8);
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

//        Person person = new Person();
//        person.setName("ADMIN");
//        person.setEmail("admin@learnscape.com");
//        person.setMobileNumber("3443434343");
//        person.setPwd(passwordEncoder.encode("12345678"));
//
//        Role role = roleRepository.getByRoleName("ADMIN");
//        if (role == null) {
//            role = new Role();
//            role.setRoleName("ADMIN");
//            role.setCreatedAt(LocalDateTime.now());
//            role.setCreatedBy("DBA");
//            role = roleRepository.save(role);
//        }
//
//        person.setRole(role);
//        person.setCreatedAt(LocalDateTime.now());
//        person.setCreatedBy("Database Admin");
//
//        personRepository.save(person);
    }
}
