package massane.fatimazahra.bankaccountsservicee.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
@DiscriminatorValue("CURR")
public class CurrentAccount extends BankAccount {
    private double overdraft;
}