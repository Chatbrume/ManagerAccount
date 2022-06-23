package eu.ensup.manageraccount.repository;

import eu.ensup.manageraccount.entity.Operation;
import eu.ensup.manageraccount.entity.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Integer> {
    List<Operation> findByTypeOperation(TypeOperation typeOperation);
    List<Operation> findByAccount(int idAccount);
}
