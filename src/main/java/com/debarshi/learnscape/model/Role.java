package com.debarshi.learnscape.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int roleId;

    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,targetEntity = Person.class)
    private Set<Person> persons;

}