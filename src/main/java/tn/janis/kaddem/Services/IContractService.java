package tn.janis.kaddem.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import tn.janis.kaddem.Entity.Contract;

import java.util.List;

public interface IContractService {

    List<Contract> getAllContract();

    Contract addContract(Contract c);

    ResponseEntity<Object> updateContract(Long id, Contract c);

    ResponseEntity<Object> deleteContract(long id);

    ResponseEntity<Object> getContractById(long id);

    List<Contract> getAllContractByIdUniv(long idUniv);

    List<Contract> getAllContractByThematique(String themat);

    List<Contract> getAllContractByIdUnivWithJpql(long idUniv);

    @Scheduled(cron="*/60******")
    List<Contract> getAllContractByIdUnivWithSql(long idUniv);

}
