//package com.consultation.consultation.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
////@EnableJpaRepositories(basePackages = "com.consultation.consultation.repository", entityManagerFactoryRef = "postgreEntityManager")
//public class JpaConfig {
//
//    @Bean(name = "postgreEntityManager")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("com.consultation.consultation.model");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        em.setJpaProperties(hibernateProperties());
//        return em;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?createDatabaseIfNotExist=true&amp;amp;useUnicode=true&amp;amp;characterEncoding=utf-8&amp;amp;autoReconnect=true");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("superadmin");
//        return dataSource;
//    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
//        return properties;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }
//}
