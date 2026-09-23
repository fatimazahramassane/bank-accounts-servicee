package net.fatimazahramassane.compte_bancaire_microservice.repositories;

import net.fatimazahramassane.compte_bancaire_microservice.entities.BankAccount;
import net.fatimazahramassane.compte_bancaire_microservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/byType")
    List<BankAccount> findByType(@Param("ty") AccountType type);
}