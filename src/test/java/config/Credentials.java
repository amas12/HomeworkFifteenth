package config;

import org.aeonbits.owner.ConfigFactory;

public interface Credentials {

    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
}

