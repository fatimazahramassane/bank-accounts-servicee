package massane.fatimazahra.bankaccountsservicee.entities;



import jakarta.persistence.EnumType;
import jakarta.persistence.*;
import lombok.*;
import massane.fatimazahra.bankaccountsservicee.enums.AccountType;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private double balance;
   // @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
   // @Enumerated(EnumType.STRING)
   @Enumerated(EnumType.STRING)
   private AccountType type;
   private String currency  ;
}