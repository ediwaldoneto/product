package br.com.api.product.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DataSource {

    @Value("${DATASOURCE.DRIVER_CLASS_NAME}")
    private String driverName;
    @Value("${DATASOURCE.POOL_NAME}")
    private String poolName;
    @Value("${DATASOURCE.URL}")
    private String url;
    @Value("${DATASOURCE_USERNAME}")
    private String userName;
    @Value("${DATASOURCE_PASSWORD}")
    private String userPass;
    @Value("${DATASOURCE.CONNECTION_TIMEOUT}")
    private Long connectionTimeOut;
    @Value("${DATASOURCE.MAX_POOL_SIZE}")
    private int maxPoolSize;

    @Bean(name = "primaryJdbcTemplate")
    public HikariDataSource dataSource() {
        final HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(userName);
        dataSource.setPassword(userPass);
        dataSource.setPoolName(poolName);
        dataSource.setConnectionTimeout(connectionTimeOut);
        dataSource.setMaximumPoolSize(maxPoolSize);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(final HikariDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(final HikariDataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}