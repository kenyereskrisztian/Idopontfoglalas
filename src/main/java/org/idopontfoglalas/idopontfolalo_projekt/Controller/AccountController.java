package org.idopontfoglalas.idopontfolalo_projekt.Controller;

import org.idopontfoglalas.idopontfolalo_projekt.Service.AccountService;
import org.idopontfoglalas.idopontfolalo_projekt.dto.incoming.AccountCreateUpdateCommand;
import org.idopontfoglalas.idopontfolalo_projekt.dto.outgoing.AccountOutgoingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAccountById")
    public ResponseEntity<AccountOutgoingDTO> getAccountById(@RequestBody Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/getAllAccount")
    public ResponseEntity<List<AccountOutgoingDTO>> getAllAccount() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PostMapping("/registerAdminAccount")
    public ResponseEntity<AccountOutgoingDTO> registerAdminAccount(@RequestBody AccountCreateUpdateCommand command) {
        AccountOutgoingDTO accountOutgoingDTO = accountService.registerAdminAccount(command);
        return ResponseEntity.ok(accountOutgoingDTO);
    }

    @PostMapping("/registerUserAccount")
    public ResponseEntity<AccountOutgoingDTO> registerUserAccount(@RequestBody AccountCreateUpdateCommand command) {
        AccountOutgoingDTO accountOutgoingDTO = accountService.registerUserAccount(command);
        return ResponseEntity.ok(accountOutgoingDTO);
    }

    @DeleteMapping("/deleteAccountById")
    public ResponseEntity<Void> deleteAccountById(@RequestBody Long id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateAccountById/{id}")
    public ResponseEntity<AccountOutgoingDTO> updateAccountById(@RequestBody AccountCreateUpdateCommand command,
                                                                @PathVariable Long id) {
        AccountOutgoingDTO accountOutgoingDTO = accountService.updateAccountById(id, command);
        return ResponseEntity.ok(accountOutgoingDTO);
    }
}
