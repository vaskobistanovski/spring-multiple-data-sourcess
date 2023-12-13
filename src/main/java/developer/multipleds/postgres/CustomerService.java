package developer.multipleds.postgres;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final JdbcClient jdbcClient;

    public CustomerService(@Qualifier("postgresJdbcClient") JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Customer> findAll() {

        return jdbcClient.sql("SELECT * FROM CUSTOMER")
                .query(Customer.class)
                .list();
    }

    public Optional<Customer> findById(Integer id) {

        return jdbcClient.sql("SELECT * FROM CUSTOMER c WHERE c.ID = :id")
                .param("id", id)
                .query(Customer.class)
                .optional();
    }
}
