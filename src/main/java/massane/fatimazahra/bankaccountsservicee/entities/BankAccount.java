package massane.fatimazahra.bankaccountsservicee.entities;




import jakarta.persistence.*;
        import lombok.*;
import massane.fatimazahra.bankaccountsservicee.enums.AccountType;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {

    @Id
    private String id;
    private double balance;
   // @Temporal(TemporalType.TIMESTAMP)
    private Date createdAI;
   // @Enumerated(EnumType.STRING)
    private AccountType type;
    private string currency  ;
}