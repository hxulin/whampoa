DROP TABLE user IF EXISTS;

CREATE TABLE user (
    id BIGINT,
    username VARCHAR(40),
    name VARCHAR(20),
    age INT,
    balance DECIMAL(10, 2),
    PRIMARY KEY(id)
);