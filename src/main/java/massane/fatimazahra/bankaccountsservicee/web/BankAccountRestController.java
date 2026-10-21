package massane.fatimazahra.bankaccountsservicee.web;


import lombok.AllArgsConstructor;
import massane.fatimazahra.bankaccountsservicee.entities.BankAccount;
import massane.fatimazahra.bankaccountsservicee.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;

    @GetMapping("/accounts")
    public List<BankAccount> accounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount account(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElse(null);
    }
}