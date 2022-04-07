package eu.ensup.manageraccount.repository;

import eu.ensup.manageraccount.entity.Account;
import eu.ensup.manageraccount.entity.TypeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByType(TypeAccount type);
}