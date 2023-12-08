package ma.emsi.billing;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  // to create a bean
@ConfigurationProperties(prefix = "user") // to get the properties from consul
@Getter@Setter // to generate getters and setters
public class MyVaultConfig {
    private String username;
    private String password;
    private String otp;

}
