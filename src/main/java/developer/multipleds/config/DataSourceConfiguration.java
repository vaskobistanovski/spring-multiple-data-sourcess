package developer.multipleds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.List;


@Configuration(proxyBeanMethods = false)
public class DataSourceConfiguration {


    /* Book Datasource Configuration */

    /**
     * Load the database configuration properties
     */
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.book")
    public DataSourceProperties bookDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Establish database connection, using the database properties
     */
    @Bean
    @Primary
    public DataSource bookDataSource(@Qualifier("bookDataSourceProperties") DataSourceProperties dataSourceProperties) {

        return DataSourceBuilder
                .create()
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
    }

    /**
     * Set the desired DDL script to apply to the database
     */
    @Bean
    DataSourceScriptDatabaseInitializer bookDataSourceScriptDatabaseInitializer(@Qualifier("bookDataSource") DataSource dataSource) {

        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:book-schema.sql"));

        // set mode = EMBEDDED, because the H2 is in memory database
        settings.setMode(DatabaseInitializationMode.EMBEDDED);

        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }

    /* Library Datasource Configuration */

    /**
     * Load the database configuration properties
     */
    @Bean
    @ConfigurationProperties("app.datasource.library")
    public DataSourceProperties libraryDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Establish database connection, using the database properties
     */
    @Bean
    public DataSource libraryDataSource(@Qualifier("libraryDataSourceProperties") DataSourceProperties dataSourceProperties) {

        return DataSourceBuilder
                .create()
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
    }

    /**
     * Set the desired DDL script to apply to the database
     */
    @Bean
    DataSourceScriptDatabaseInitializer libraryDataSourceScriptDatabaseInitializer(@Qualifier("libraryDataSource") DataSource dataSource) {

        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:library-schema.sql"));

        // set mode = EMBEDDED, because the H2 is in memory database
        settings.setMode(DatabaseInitializationMode.EMBEDDED);

        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }

    /* User Datasource Configuration */

    /**
     * Load the database configuration properties
     */
    @Bean
    @ConfigurationProperties("app.datasource.user")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Establish database connection, using the database properties
     */
    @Bean
    public DataSource userDataSource(@Qualifier("userDataSourceProperties") DataSourceProperties dataSourceProperties) {

        return DataSourceBuilder
                .create()
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .driverClassName(dataSourceProperties.getDriverClassName())
                .build();
    }

    /**
     * Set the desired DDL script to apply to the database
     */
    @Bean
    DataSourceScriptDatabaseInitializer userDataSourceScriptDatabaseInitializer(@Qualifier("userDataSource") DataSource dataSource) {

        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:user-schema.sql"));

        // set mode = ALWAYS, because the postgres id local database
        settings.setMode(DatabaseInitializationMode.ALWAYS);

        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }
}
