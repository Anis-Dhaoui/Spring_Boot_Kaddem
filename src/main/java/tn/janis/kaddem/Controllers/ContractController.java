package tn.janis.kaddem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.janis.kaddem.Entity.Contract;
import tn.janis.kaddem.Services.IContractService;

import java.util.List;

@RestController
@RequestMapping("contracts")
public class ContractController {
    @Autowired
    IContractService iContractService;

//    $$$$$$$$$$$$$$$$ GET ALL CONTRACTS $$$$$$$$$$$$$$$$
    @GetMapping("/fetch")
    public ResponseEntity<Object> fetchAllContracts(){
        List<Contract> contracts = iContractService.getAllContract();
        return new ResponseEntity<>(contracts, HttpStatus.ACCEPTED);
    }

//    $$$$$$$$$$$$$$$$ ADD NEW CONTRACT $$$$$$$$$$$$$$$$
    @PostMapping("/add")
    public ResponseEntity<Object> postNewContract(@RequestBody Contract c){
        iContractService.addContract(c);
        return new ResponseEntity<>("Contract added successfully", HttpStatus.CREATED);
    }

    //    $$$$$$$$$$$$$$$$ UPDATE CONTRACT $$$$$$$$$$$$$$$$
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateContract(@PathVariable("id") long id, @RequestBody Contract c){
        System.out.println(id);
        return iContractService.updateContract(id, c);
    }
    //    $$$$$$$$$$$$$$$$ DELETE CONTRACT $$$$$$$$$$$$$$$$
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteContract(@PathVariable("id") long id){
        return iContractService.deleteContract(id);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Object> getOneContract(@PathVariable("id") long id){
        return iContractService.getContractById(id);
    }

    //    $$$$$$$$$$$$$$$$ GET ALL CONTRACTS BY UNIVERSITY ID USING SQL QUERY $$$$$$$$$$$$$$$
    @GetMapping("/univ/{id}")
    public List<Contract> fetchContractByUniV(@PathVariable("id") long id) {
        return iContractService.getAllContractByIdUniv(id);
    }


    //    $$$$$$$$$$$$$$$$ GET ALL CONTRACTS BY UNIVERSITY ID USING SQL QUERY $$$$$$$$$$$$$$$
    @GetMapping("/univ/{thematique}")
    public List<Contract> fetchContractByThematique(@PathVariable("thematique") String thematique) {
        return iContractService.getAllContractByThematique(thematique);
    }


    //    $$$$$$$$$$$$$$$ GET CONTRACTS BY UNIVERSITY ID USING JPQL $$$$$$$$$$$$$$$
    @GetMapping("/univ/{id}")
    public List<Contract> fetchContractByUnivIdWithJpql(@PathVariable("id") long id) {
        return iContractService.getAllContractByIdUnivWithJpql(id);
    }
}
