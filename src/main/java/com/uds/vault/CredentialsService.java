package com.uds.vault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

@Service
public class CredentialsService {

    private final String SECRET_ENGINE = "cubbyhole";
    private final String APP = "myapp";

    @Autowired
    private VaultTemplate vaultTemplate;

    public void setCredentials(Credentials credentials) {
        vaultTemplate.write(SECRET_ENGINE+"/"+APP, credentials);
    }

    public Credentials getCredentials() {
        VaultResponseSupport<Credentials> response = vaultTemplate.read(SECRET_ENGINE+"/"+APP, Credentials.class);
        return (response.getData() !=null) ? response.getData(): null;
    }

}