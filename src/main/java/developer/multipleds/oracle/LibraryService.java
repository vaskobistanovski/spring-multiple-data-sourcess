package developer.multipleds.oracle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final JdbcClient jdbcClient;

    public LibraryService(@Qualifier("oracleJdbcClient") JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Library> findAll() {

        return jdbcClient.sql("SELECT * FROM LIBRARY")
                .query(Library.class)
                .list();
    }

    public Optional<Library> findById(Integer id) {

        return jdbcClient.sql("SELECT * FROM LIBRARY l WHERE l.ID = :id")
                .param("id", id)
                .query(Library.class)
                .optional();
    }
}
