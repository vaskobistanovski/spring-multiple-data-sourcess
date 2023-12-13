package developer.multipleds.h2;

import java.sql.Timestamp;
import java.time.LocalDate;

public record Book(Integer id, String title, String author, LocalDate publishDate, Timestamp createdDate) {
}
