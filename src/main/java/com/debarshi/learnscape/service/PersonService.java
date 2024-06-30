package com.debarshi.learnscape.service;

import com.debarshi.learnscape.constants.LearnscapeConstants;
import com.debarshi.learnscape.model.Person;
import com.debarshi.learnscape.model.Role;
import com.debarshi.learnscape.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.debarshi.learnscape.repository.PersonRepository;

import java.util.Objects;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Role role = roleRepository.getByRoleName(LearnscapeConstants.STUDENT_ROLE);
        person.setRole(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (!Objects.isNull(person) && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }

}
