package tn.janis.kaddem.Entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import tn.janis.kaddem.Entity.Enum.Levels;

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

@Table(name = "t_team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idTeam;


    String nameTeam;

    @Enumerated(EnumType.STRING)
    Levels level;

    //Relation between Team and Student Many to Many
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> students;

    //Relation between Team and TeamDetail
    @OneToOne(mappedBy = "team")
    private TeamDetail teamDetail;
}
