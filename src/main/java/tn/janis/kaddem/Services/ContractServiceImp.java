package tn.janis.kaddem.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.janis.kaddem.Entity.Contract;
import tn.janis.kaddem.Repositories.ContractRepo;

import java.util.List;

@Slf4j
@Service
public class ContractServiceImp implements IContractService{

    @Autowired
    ContractRepo contractRepo;

    @Override
    public List<Contract> getAllContract() {
        return (List<Contract>) contractRepo.findAll();
    }

    @Override
    public Contract addContract(Contract c) {
        return contractRepo.save(c);
    }

    @Override
    public ResponseEntity<Object> updateContract(Long id, Contract c) {
        System.out.println("id param in ContractService: " + id);
        if(contractRepo.existsById(id)){
            return new ResponseEntity<>(contractRepo.save(c), HttpStatus.OK);
        }
            return new ResponseEntity<>("Contract not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> deleteContract(long id) {
        if(contractRepo.existsById(id)){
            contractRepo.deleteById(id);
            return new ResponseEntity<>("Contract deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Contract not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getContractById(long id) {
        if(contractRepo.existsById(id)){
            return new ResponseEntity<>(contractRepo.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Contract not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Contract> getAllContractByIdUniv(long idUniv) {
        return null;
    }

    //    $$$$$$$$$$$$$$$ GET CONTRACTS BY THEMATIQUE USING KEYWORDS $$$$$$$$$$$$$$$
    @Override
    public List<Contract> getAllContractByThematique(String themat) {
        return contractRepo.findByStudentTeamsTeamDetailThematique(themat);
    }

    //    $$$$$$$$$$$$$$$ GET CONTRACTS BY UNIVERSITY ID USING JPQL $$$$$$$$$$$$$$$
    @Override
    public List<Contract> getAllContractByIdUnivWithJpql(long idUniv) {
        return contractRepo.getAllContratByIdUnivWithJpql(idUniv);
    }

    //    $$$$$$$$$$$$$$$$ GET ALL CONTRACTS BY UNIVERSITY ID USING SQL QUERY $$$$$$$$$$$$$$$
    @Override
    public List<Contract> getAllContractByIdUnivWithSql(long idUniv) {
        return contractRepo.repoGetAllContratByUnivId(idUniv);
    }
}
