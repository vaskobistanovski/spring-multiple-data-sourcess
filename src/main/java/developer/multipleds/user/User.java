package developer.multipleds.user;

import java.sql.Timestamp;

public record User(Integer id, String firstName, String lastName, String address, Timestamp createdDate) {
}
