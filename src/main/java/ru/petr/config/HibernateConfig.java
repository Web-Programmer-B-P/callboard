package ru.petr.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    private static final String POSTGRES_SQL_DRIVER = "org.postgresql.Driver";
    private static final String URL_WITH_HOST_AND_DB_NAME = "jdbc:postgresql://localhost:5432/board";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static final String DIALECT = "org.hibernate.dialect.PostgreSQL94Dialect";
    private static final String FLAG_SHOW_SQL = "false";
    private static final String ENTITY_PATH = "ru.petr.entity";
    private static final String PROPERTY_KEY_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_KEY_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(ENTITY_PATH);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(POSTGRES_SQL_DRIVER);
        dataSource.setUrl(URL_WITH_HOST_AND_DB_NAME);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty(PROPERTY_KEY_HIBERNATE_DIALECT, DIALECT);
                setProperty(PROPERTY_KEY_HIBERNATE_SHOW_SQL, FLAG_SHOW_SQL);
            }
        };
    }
}

