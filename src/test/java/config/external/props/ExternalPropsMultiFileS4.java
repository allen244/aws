package config.external.props;
import com.avs.aws.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

/**
 * Created by jt on 5/7/16.
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:testing.properties"),
        @PropertySource("classpath:encrypted-testing.properties")
})
public class ExternalPropsMultiFileS4 {

    @Autowired
    Environment env;

    @Bean
    public FakeJmsBroker fakeJmsBrokerMultiS4(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(env.getProperty("com.avs.aws.jms.server"));
        fakeJmsBroker.setPort(env.getRequiredProperty("com.avs.aws.jms.port", Integer.class));
        fakeJmsBroker.setUser(env.getProperty("com.avs.aws.jms.user"));
        fakeJmsBroker.setPassword(env.getProperty("com.avs.aws.jms.encrypted.password"));
        return fakeJmsBroker;
    }
}