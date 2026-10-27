package org.idopontfoglalas.idopontfolalo_projekt.dto.incoming;

import lombok.Data;

@Data
public class AccountCreateUpdateCommand {
    private String name;
    private String email;
    private String password;
}
