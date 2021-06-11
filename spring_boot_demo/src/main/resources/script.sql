SHOW DATABASES;

CREATE DATABASE customers;
USE customers;
CREATE TABLE IF NOT EXISTS customer
(
    id       bigint AUTO_INCREMENT,
    name     varchar(250),
    username varchar(250),
    password varchar(250),
    PRIMARY KEY (id)
);