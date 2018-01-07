package config.external.props;

import com.avs.aws.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:testing.properties")
public class ExternalPropsEnvironment {

    @Autowired
    Environment env; //also from Spring 3.1

    @Bean
    public FakeJmsBroker fakeJmsBrokerEnv(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(env.getProperty("com.avs.aws.jms.server"));
        fakeJmsBroker.setPort(env.getRequiredProperty("com.avs.aws.jms.port", Integer.class));
        fakeJmsBroker.setUser(env.getProperty("com.avs.aws.jms.user"));
        fakeJmsBroker.setPassword(env.getProperty("com.avs.aws.jms.password"));
        return fakeJmsBroker;
    }
}