package developer.multipleds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class JdbcClientConfiguration {

    @Bean
    JdbcClient h2JdbcClient(@Qualifier("h2DataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean
    JdbcClient oracleJdbcClient(@Qualifier("oracleDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean
    JdbcClient postgresJdbcClient(@Qualifier("postgresDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }
}
