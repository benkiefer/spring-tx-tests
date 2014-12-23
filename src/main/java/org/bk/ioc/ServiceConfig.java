package org.bk.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "org.bk.service")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.bk.repository")
public class ServiceConfig {

}
