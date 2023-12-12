-- Drop the table
DROP TABLE IF EXISTS LIBRARY;

-- Create the table
CREATE TABLE LIBRARY (
    ID INT PRIMARY KEY NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL
);

-- Inserting the first record
INSERT INTO LIBRARY (ID, NAME, ADDRESS)
VALUES (1, 'Central Library', '123 Main Street, Cityville');

-- Inserting the second record
INSERT INTO LIBRARY (ID, NAME, ADDRESS)
VALUES (2, 'Community Library', '456 Oak Avenue, Townsville');

-- Inserting the third record
INSERT INTO LIBRARY (ID, NAME, ADDRESS)
VALUES (3, 'City Public Library', '789 Elm Lane, Metropolis');

