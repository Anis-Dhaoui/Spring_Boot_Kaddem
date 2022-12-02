package tn.janis.kaddem.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.janis.kaddem.Entity.Contract;

import java.util.List;

@Repository
public interface ContractRepo extends CrudRepository<Contract, Long> {

//    $$$$$$$$$$$$$$$$ GET ALL CONTRACTS BY UNIVERSITY ID USING SQL QUERY $$$$$$$$$$$$$$$
    @Query(value = "select * from t_contract c join student s "+
            "on c.student_id_student = s.id_student join " +
            "t_department dep on dep.id_depart=s.departement_id_depart join "+
            "t_university_departements ud on dep.id_depart= ud.departements_id_depart " +
            "where ud.university_id_univ=?1 ",nativeQuery = true)
    List<Contract> repoGetAllContratByUnivId(long id);


//    $$$$$$$$$$$$$$$ GET CONTRACTS BY THEMATIQUE USING KEYWORDS $$$$$$$$$$$$$$$
    List<Contract> findByStudentTeamsTeamDetailThematique(String thematique);


    //    $$$$$$$$$$$$$$$ GET CONTRACTS BY UNIVERSITY ID USING JPQL $$$$$$$$$$$$$$$
    @Query(value = "select c from Contract c join University u on c.student member u.departements")
    List<Contract>getAllContratByIdUnivWithJpql(long id);
}
