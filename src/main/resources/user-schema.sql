-- Drop the table
DROP TABLE IF EXISTS USERS;

-- Create the table
CREATE TABLE USERS (
    ID INT PRIMARY KEY NOT NULL,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL
);

-- Inserting the first record
INSERT INTO USERS (ID, FIRST_NAME, LAST_NAME, ADDRESS, CREATED_DATE)
VALUES (1, 'John', 'Doe', '123 Maple Street, Anytown', current_timestamp);

-- Inserting the second record
INSERT INTO USERS (ID, FIRST_NAME, LAST_NAME, ADDRESS, CREATED_DATE)
VALUES (2, 'Jane', 'Smith', '456 Oak Avenue, Sometown', current_timestamp);

-- Inserting the third record
INSERT INTO USERS (ID, FIRST_NAME, LAST_NAME, ADDRESS, CREATED_DATE)
VALUES (3, 'Bob', 'Johnson', '789 Pine Lane, Cityville', current_timestamp);

