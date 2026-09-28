package massane.fatimazahra.bankaccountsservicee.repositories;

import massane.fatimazahra.bankaccountsservicee.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
