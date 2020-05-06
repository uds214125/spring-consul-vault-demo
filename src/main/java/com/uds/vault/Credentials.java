package com.uds.vault;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credentials {

    String username;
    String password;

    public Credentials() {

    }

}