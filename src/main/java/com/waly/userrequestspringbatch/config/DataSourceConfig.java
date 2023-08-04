package com.waly.userrequestspringbatch.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource springDS() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5433/spring_batch");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("1234567");
        return dataSourceBuilder.build();
    }

    @Bean
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource appDS() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5433/app");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("1234567");
        return dataSourceBuilder.build();
    }

    @Bean
    public PlatformTransactionManager transactionManagerApp(@Qualifier("appDS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}