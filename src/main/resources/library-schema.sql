-- Drop the table
DROP TABLE LIBRARY;

-- Create the table
CREATE TABLE LIBRARY (
    ID INT PRIMARY KEY NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL
);

-- Inserting the first record
INSERT INTO LIBRARY (ID, NAME, ADDRESS, CREATED_DATE)
VALUES (1, 'Central Library', '123 Main Street, Cityville', current_timestamp);

-- Inserting the second record
INSERT INTO LIBRARY (ID, NAME, ADDRESS, CREATED_DATE)
VALUES (2, 'Community Library', '456 Oak Avenue, Townsville', current_timestamp);

-- Inserting the third record
INSERT INTO LIBRARY (ID, NAME, ADDRESS, CREATED_DATE)
VALUES (3, 'City Public Library', '789 Elm Lane, Metropolis', current_timestamp);

