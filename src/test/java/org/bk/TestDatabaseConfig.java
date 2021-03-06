package org.bk;

import com.googlecode.flyway.core.Flyway;
import org.bk.service.IServiceHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

import static org.mockito.Mockito.mock;

@Configuration
public class TestDatabaseConfig {
    @Bean
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Throwable {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("org.bk.domain");
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        entityManager.setJpaProperties(jpaProperties);
        return entityManager;
    }

    @Bean
    public IServiceHelper serviceHelper() {
        return mock(IServiceHelper.class);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS \"public\"\\;");
        return dataSource;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource());
        flyway.setSchemas("PUBLIC");
        return flyway;
    }
}
