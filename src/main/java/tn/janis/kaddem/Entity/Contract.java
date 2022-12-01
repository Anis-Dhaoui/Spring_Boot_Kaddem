package tn.janis.kaddem.Entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import tn.janis.kaddem.Entity.Enum.Specialities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
@Slf4j

@Table(name="t_contract")
public class Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idContract;

    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    Specialities speciality;

    Boolean archive;

    //Relation between Student and Contract
    @ManyToOne
    Student student;

}
