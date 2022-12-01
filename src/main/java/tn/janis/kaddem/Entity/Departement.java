package tn.janis.kaddem.Entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
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
@Table(name = "t_department")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idDepart;

    String nameDepart;

    //Relation between Department and Student
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    private Set<Student> students;
}
