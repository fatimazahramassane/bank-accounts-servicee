package massane.fatimazahra.bankaccountsservicee;

import massane.fatimazahra.bankaccountsservicee.entities.BankAccount;
import massane.fatimazahra.bankaccountsservicee.enums.AccountType;
import massane.fatimazahra.bankaccountsservicee.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountsServiceeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountsServiceeApplication.class, args);
    }


    @Bean
    <BankAccoutRepository>
    CommandLineRunner start(BankAccoutRepository BankAccountRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .balance(10000 * Math.random() * 90000)
                        .createdAI(new Date())
                        .currency("MAD")
                        .build();
    BankAccountRepository.save(bankAccount);

            };
        };
    }

}



