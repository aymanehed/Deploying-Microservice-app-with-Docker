package org.sid.billing;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@ConfigurationProperties(prefix = "user")
@Data
public class MyVaultConfig {
    private String username;
    private String password;
    private String tp4;
}
