package net.fatimazahramassane.compte_bancaire_microservice;

import net.fatimazahramassane.compte_bancaire_microservice.entities.BankAccount;
import net.fatimazahramassane.compte_bancaire_microservice.entities.Customer;
import net.fatimazahramassane.compte_bancaire_microservice.enums.AccountType;
import net.fatimazahramassane.compte_bancaire_microservice.repositories.BankAccountRepository;
import net.fatimazahramassane.compte_bancaire_microservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class CompteBancaireMicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CompteBancaireMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository,CustomerRepository customerRepository) {
		return args -> {

				Stream.of("Salma", "Mohammed", "Ali", "Fati").forEach(c->{
					Customer customer = Customer.builder()
							.name(c)
							.build();
					customerRepository.save(customer);
				});

			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i < 10 ; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.balance(10000+Math.random()*90000)
							.createdAt(new Date().getTime())
							.currency("MAD")
							.customer(customer)
							.build();

					bankAccountRepository.save(bankAccount);
				}
			});
		};
	}

}
