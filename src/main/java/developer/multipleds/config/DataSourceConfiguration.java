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

    private static final String H2_SQL_SCHEMA = "classpath:h2-schema.sql";
    private static final String ORACLE_SQL_SCHEMA = "classpath:oracle-schema.sql";
    private static final String POSTGRES_SQL_SCHEMA = "classpath:postgres-schema.sql";



    /* Book Datasource Configuration */

    /**
     * Load the database configuration properties
     */
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.h2")
    public DataSourceProperties h2DataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Establish database connection, using the database properties
     */
    @Bean
    @Primary
    public DataSource h2DataSource(@Qualifier("h2DataSourceProperties") DataSourceProperties dataSourceProperties) {

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
    DataSourceScriptDatabaseInitializer h2DataSourceScriptDatabaseInitializer(@Qualifier("h2DataSource") DataSource dataSource) {

        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of(H2_SQL_SCHEMA));

        // set mode = EMBEDDED, because the H2 is in memory database
        settings.setMode(DatabaseInitializationMode.EMBEDDED);

        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }

    /* Library Datasource Configuration */

    /**
     * Load the database configuration properties
     */
    @Bean
    @ConfigurationProperties("app.datasource.oracle")
    public DataSourceProperties oracleDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Establish database connection, using the database properties
     */
    @Bean
    public DataSource oracleDataSource(@Qualifier("oracleDataSourceProperties") DataSourceProperties dataSourceProperties) {

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
    DataSourceScriptDatabaseInitializer oracleDataSourceScriptDatabaseInitializer(@Qualifier("oracleDataSource") DataSource dataSource) {

        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of(ORACLE_SQL_SCHEMA));

        // set mode = ALWAYS, because the oracle is local database
        settings.setMode(DatabaseInitializationMode.ALWAYS);

        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }

    /* Customer Datasource Configuration */

    /**
     * Load the database configuration properties
     */
    @Bean
    @ConfigurationProperties("app.datasource.postgres")
    public DataSourceProperties postgresDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Establish database connection, using the database properties
     */
    @Bean
    public DataSource postgresDataSource(@Qualifier("postgresDataSourceProperties") DataSourceProperties dataSourceProperties) {

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
    DataSourceScriptDatabaseInitializer postgresDataSourceScriptDatabaseInitializer(@Qualifier("postgresDataSource") DataSource dataSource) {

        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of(POSTGRES_SQL_SCHEMA));

        // set mode = ALWAYS, because the postgres is local database
        settings.setMode(DatabaseInitializationMode.ALWAYS);

        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }
}
