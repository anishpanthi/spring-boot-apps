package com.app.boot.jpa.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Anish
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.app.boot.jpa.domain"})
@EnableJpaRepositories(basePackages = {"com.app.boot.jpa.dao"})
@Slf4j
public class DataSourceConfig {

    /*
     * Here, you can define multiple data sources. You can create multiple entity managers to handle
     * multiple data sources.
     */
}
