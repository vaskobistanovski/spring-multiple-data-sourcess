-- Drop the table
DROP TABLE IF EXISTS BOOK;

-- Create the table
CREATE TABLE BOOK (
    ID INT PRIMARY KEY NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    AUTHOR VARCHAR(255) NOT NULL,
    PUBLISH_DATE DATE NOT NULL
);

-- Inserting the first record
INSERT INTO BOOK (ID, TITLE, AUTHOR, PUBLISH_DATE)
VALUES (1, 'The Catcher in the Rye', 'J.D. Salinger', '1951-07-16');

-- Inserting the second record
INSERT INTO BOOK (ID, TITLE, AUTHOR, PUBLISH_DATE)
VALUES (2, 'To Kill a Mockingbird', 'Harper Lee', '1960-07-11');

-- Inserting the third record
INSERT INTO BOOK (ID, TITLE, AUTHOR, PUBLISH_DATE)
VALUES (3, '1984', 'George Orwell', '1949-06-08');

