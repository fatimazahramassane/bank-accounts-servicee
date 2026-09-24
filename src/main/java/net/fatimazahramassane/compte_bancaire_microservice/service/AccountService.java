package net.fatimazahramassane.compte_bancaire_microservice.service;

import net.fatimazahramassane.compte_bancaire_microservice.dto.BankAccountRequestDTO;
import net.fatimazahramassane.compte_bancaire_microservice.dto.BankAccountResponseDTO;
import net.fatimazahramassane.compte_bancaire_microservice.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
