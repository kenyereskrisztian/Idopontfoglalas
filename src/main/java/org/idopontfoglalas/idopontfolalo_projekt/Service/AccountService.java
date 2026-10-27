package org.idopontfoglalas.idopontfolalo_projekt.Service;

import org.idopontfoglalas.idopontfolalo_projekt.Repository.AccountRepository;
import org.idopontfoglalas.idopontfolalo_projekt.domain.Account;
import org.idopontfoglalas.idopontfolalo_projekt.domain.AccountRole;
import org.idopontfoglalas.idopontfolalo_projekt.dto.incoming.AccountCreateUpdateCommand;
import org.idopontfoglalas.idopontfolalo_projekt.dto.outgoing.AccountOutgoingDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;
    private final ObjectMapper objectMapper;

    public AccountService(AccountRepository accountRepository, ObjectMapper objectMapper) {
        this.accountRepository = accountRepository;
        this.objectMapper = objectMapper;
    }

    public AccountOutgoingDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow();
        AccountOutgoingDTO accountOutgoingDTO = objectMapper.convertValue(account, AccountOutgoingDTO.class);
        return accountOutgoingDTO;
    }

    public List<AccountOutgoingDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(account -> objectMapper.convertValue(account, AccountOutgoingDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    public AccountOutgoingDTO registerAdminAccount(AccountCreateUpdateCommand command) {
        Account account = objectMapper.convertValue(command, Account.class);
        account.setRole(AccountRole.ADMIN);
        accountRepository.save(account);
        return objectMapper.convertValue(account, AccountOutgoingDTO.class);
    }

    public AccountOutgoingDTO registerUserAccount(AccountCreateUpdateCommand command) {
        return null;
    }

    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    public AccountOutgoingDTO updateAccountById(Long id, AccountCreateUpdateCommand command) {
        Account account = accountRepository.findById(id).orElseThrow();
        objectMapper.updateValue(account, command);
        accountRepository.save(account);
        return objectMapper.convertValue(account, AccountOutgoingDTO.class);
    }
}
