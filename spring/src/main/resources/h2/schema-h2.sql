DROP TABLE employee IF EXISTS;

CREATE TABLE employee (
    `id` BIGINT,
    `username` VARCHAR(40),
    `name` VARCHAR(20),
    `age` INT,
    `balance` DECIMAL(10, 2),
    PRIMARY KEY(`id`)
);