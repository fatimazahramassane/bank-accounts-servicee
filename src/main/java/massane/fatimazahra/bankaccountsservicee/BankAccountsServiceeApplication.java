package massane.fatimazahra.bankaccountsservicee;
import massane.fatimazahra.bankaccountsservicee.entities.AccountStatus;
import massane.fatimazahra.bankaccountsservicee.entities.CurrentAccount;
import massane.fatimazahra.bankaccountsservicee.entities.BankAccount;
import massane.fatimazahra.bankaccountsservicee.entities.SavingAccount;
import massane.fatimazahra.bankaccountsservicee.enums.AccountType;
import massane.fatimazahra.bankaccountsservicee.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import lombok.experimental.SuperBuilder;
import java.util.Date;
import java.util.UUID;

@Bean
CommandLineRunner start(BankAccountRepository bankAccountRepository) {
    return args -> {
        CurrentAccount ca = CurrentAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(9000)
                .createdAt(new Date())
                .status(AccountStatus.CREATED)
                .overdraft(5000)
                .build();
        bankAccountRepository.save(ca);

        SavingAccount sa = SavingAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(12000)
                .createdAt(new Date())
                .status(AccountStatus.ACTIVATED)
                .interestRate(5.5)
                .build();
        bankAccountRepository.save(sa);

        bankAccountRepository.findAll().forEach(a -> System.out.println(a));
    };
}


