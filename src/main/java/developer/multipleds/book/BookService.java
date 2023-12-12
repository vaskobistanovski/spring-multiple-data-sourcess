package developer.multipleds.book;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final JdbcClient jdbcClient;

    public BookService(@Qualifier("bookJdbcClient") JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Book> findAll() {

        return jdbcClient.sql("SELECT * FROM BOOK")
                .query(Book.class)
                .list();
    }

    public Optional<Book> findById(Integer id) {

        return jdbcClient.sql("SELECT * FROM BOOK b WHERE b.ID = :id")
                .param("id", id)
                .query(Book.class)
                .optional();
    }
}
