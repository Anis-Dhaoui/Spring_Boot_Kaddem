package tn.janis.kaddem.Entity;

import javax.persistence.*;

@Entity
public class TeamDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer sallon;
    String thematique;

    //Relation between Team and TeamDetail
    @OneToOne
    private Team team;
}
