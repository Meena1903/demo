package com.example.multidataset.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactory",
    basePackages = "com.example.multidataset.userRepository"
)
public class UseDBConfig {

    @Primary
    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.user.dataset")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("dataSource") DataSource dataSource
    ) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        
        return builder
            .dataSource(dataSource)
            .packages("com.example.modelUser")
            .persistenceUnit("User")
            .properties(properties)
            .build();
    }
}
