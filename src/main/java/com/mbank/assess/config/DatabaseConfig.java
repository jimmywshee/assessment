package com.mbank.assess.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Value("${data.source.jdbc.url}")
	private String dataSourceUrl;

	@Value("${data.source.username}")
	private String dataSourceUsername;

	@Value("${data.source.password}")
	private String dataSourcePassword;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.mbank.assess.entity" });

		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(commonHibernateProperties());

		return em;
	}

	private static Properties commonHibernateProperties() {
		final Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "none");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		return props;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername(dataSourceUsername);
		dataSource.setPassword(dataSourcePassword);
		return dataSource;
	}

}
