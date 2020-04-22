package ru.petr.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class JdbcConfig {
    private static final Logger LOG = LogManager.getLogger(JdbcConfig.class.getName());
    @Autowired
    private Environment env;

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(securityDataSource());
    }

    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException pve) {
            LOG.error("Ошибка при чтении проперти для базы", pve);
        }
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setInitialPoolSize(parseString("connection.pool.initialPoolSize"));
        dataSource.setMinPoolSize(parseString("connection.pool.minPoolSize"));
        dataSource.setMaxPoolSize(parseString("connection.pool.maxPoolSize"));
        dataSource.setMaxIdleTime(parseString("connection.pool.maxIdleTime"));
        return dataSource;
    }

    private int parseString(String property) {
        String value = env.getProperty(property);
        return Integer.parseInt(value);
    }
}

