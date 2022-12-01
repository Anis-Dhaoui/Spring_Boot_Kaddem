package tn.janis.kaddem.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
@Slf4j

@Table(name = "t_university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUniv;

    String nameUniv;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departements;
}
