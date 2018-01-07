package com.avs.aws.test.config;

import com.avs.aws.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootJavaConfig {
    @Value("${com.avs.aws.jms.server}")
    String jmsServer;

    @Value("${com.avs.aws.jms.port}")
    Integer jmsPort;

    @Value("${com.avs.aws.jms.user}")
    String jmsUser;

    @Value("${com.avs.aws.jms.password}")
    String jmsPassword;

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(jmsServer);
        fakeJmsBroker.setPort(jmsPort);
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        return fakeJmsBroker;
    }
}