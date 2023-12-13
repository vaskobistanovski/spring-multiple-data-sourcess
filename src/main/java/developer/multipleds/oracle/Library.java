package developer.multipleds.oracle;

import java.sql.Timestamp;

public record Library(Integer id, String name, String address, Timestamp createdDate) {
}
