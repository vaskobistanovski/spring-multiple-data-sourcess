package developer.multipleds.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final JdbcClient jdbcClient;

    public UserService(@Qualifier("userJdbcClient") JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<User> findAll() {

        return jdbcClient.sql("SELECT * FROM USERS")
                .query(User.class)
                .list();
    }

    public Optional<User> findById(Integer id) {

        return jdbcClient.sql("SELECT * FROM USERS u WHERE u.ID = :id")
                .param("id", id)
                .query(User.class)
                .optional();
    }
}
