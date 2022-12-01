package tn.janis.kaddem.Entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import tn.janis.kaddem.Entity.Enum.Option;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
@Slf4j

public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStudent;

    String firstName;
    String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="opt")
    Option option;

    //Relation between Student and Contract
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Contract> contracts;

    //Relation between Department and Student
    @ManyToOne
    Departement departement;

    //Relation between Team and Student Many to Many
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
    private Set<Team> teams;

}
