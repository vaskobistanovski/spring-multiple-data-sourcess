package developer.multipleds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class JdbcClientConfiguration {

    @Bean
    JdbcClient bookJdbcClient(@Qualifier("bookDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean
    JdbcClient libraryJdbcClient(@Qualifier("libraryDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean
    JdbcClient userJdbcClient(@Qualifier("userDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }
}
