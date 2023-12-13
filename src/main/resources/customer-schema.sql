-- Drop the table
DROP TABLE IF EXISTS CUSTOMER;

-- Create the table
CREATE TABLE CUSTOMER (
    ID INT PRIMARY KEY NOT NULL,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    YEARS NUMERIC NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL
);

-- Inserting the first record
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME, YEARS, ADDRESS, CREATED_DATE)
VALUES (1, 'John', 'Doe', 25, '123 Maple Street, Anytown', current_timestamp);

-- Inserting the second record
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME, YEARS, ADDRESS, CREATED_DATE)
VALUES (2, 'Jane', 'Smith', 40, '456 Oak Avenue, Sometown', current_timestamp);

-- Inserting the third record
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME, YEARS, ADDRESS, CREATED_DATE)
VALUES (3, 'Bob', 'Johnson', 58, '789 Pine Lane, Cityville', current_timestamp);

