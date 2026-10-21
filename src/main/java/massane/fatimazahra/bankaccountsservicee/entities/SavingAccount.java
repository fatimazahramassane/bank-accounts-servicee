package massane.fatimazahra.bankaccountsservicee.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
@DiscriminatorValue("SAVE")
public class SavingAccount extends BankAccount {
    private double interestRate;
}