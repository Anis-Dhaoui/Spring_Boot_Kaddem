package tn.janis.kaddem.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.janis.kaddem.Entity.Contract;

@Repository
public interface ContractRepo extends CrudRepository<Contract, Long> {
}
