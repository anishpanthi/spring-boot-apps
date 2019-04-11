package com.app.jms.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * @author Anish
 *
 */
@Configuration
@Slf4j
public class JmsConfig {

    private String url;

    private String username;

    private String password;

    private String connectionFactoryName;

    private String targetQueue;

    @Bean
    public JndiTemplate jndiTemplate(){

        return null;
    }

    @Bean
    public JndiObjectFactoryBean jndiObjectFactoryBean(final JndiTemplate jndiTemplate){

        return null;
    }

    @Bean
    public ConnectionFactory connectionFactory(final JndiObjectFactoryBean jndiObjectFactoryBean){

        return null;
    }

    @Bean
    public Destination jmsQueueName(){

        return null;
    }

    @Bean
    public DestinationResolver destinationResolver(){

        return null;
    }

    @Bean
    public JmsTemplate jmsTemplate(final ConnectionFactory connectionFactory, final DestinationResolver destinationResolver){

        return null;
    }

    @Bean
    public JmsListenerContainerFactory<?> containerFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer){

        return null;
    }
}
