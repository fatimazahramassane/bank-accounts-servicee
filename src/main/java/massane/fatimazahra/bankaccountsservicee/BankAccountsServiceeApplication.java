package massane.fatimazahra.bankaccountsservicee;

import massane.fatimazahra.bankaccountsservicee.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class BankAccountsServiceeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountsServiceeApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BankAccoutRepository bankAccountRepository){
        return args -> {
            for (int i =0 ; i<10 ; i++ ){
                BankAccount bankAccount= BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(10000*Math.random*90000)


                        .build();

            }

        }
    }





}