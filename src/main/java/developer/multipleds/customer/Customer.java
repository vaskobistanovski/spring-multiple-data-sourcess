package developer.multipleds.customer;

import java.sql.Timestamp;

public record Customer(Integer id, String firstName, String lastName, Integer years, String address, Timestamp createdDate) {
}
