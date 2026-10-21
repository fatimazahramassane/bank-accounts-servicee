package massane.fatimazahra.bankaccountsservicee.entities;



import jakarta.persistence.EnumType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import massane.fatimazahra.bankaccountsservicee.enums.AccountType;

import java.util.Date;

// BankAccount.java
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
}