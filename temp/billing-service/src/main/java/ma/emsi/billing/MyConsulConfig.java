package ma.emsi.billing;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  // to create a bean
@ConfigurationProperties(prefix = "token") // to get the properties from consul
@Getter@Setter // to generate getters and setters
public class MyConsulConfig {
    private Long accessTokenTimeout;
    private Long refreshTokenTimeout;

}
