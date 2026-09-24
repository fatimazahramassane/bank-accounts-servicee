package net.fatimazahramassane.compte_bancaire_microservice.dto;

import net.fatimazahramassane.compte_bancaire_microservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {

    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;

    private AccountType type;
}
