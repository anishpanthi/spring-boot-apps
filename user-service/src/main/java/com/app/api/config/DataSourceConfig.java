package com.app.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Anish Panthi
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.app.api.repository")
@EntityScan(basePackages = "com.app.api.domain")
public class DataSourceConfig {
}
