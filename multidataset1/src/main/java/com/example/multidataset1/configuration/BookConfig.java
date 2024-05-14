package com.example.multidataset1.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = {"com.example.multidataset1.repository.bookRepository"},
    entityManagerFactoryRef = "entityManagerFactory2",
    transactionManagerRef = "transactionManager2"
)
public class BookConfig {

    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource2") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.multidataset1.model")
                .persistenceUnit("Book")
                .build();
    }

    @Bean(name = "transactionManager2")
    public PlatformTransactionManager transactionManager2(
            @Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
