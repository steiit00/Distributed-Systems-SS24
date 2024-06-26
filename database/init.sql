CREATE DATABASE IF NOT EXISTS db_todo;
USE db_todo;

CREATE TABLE IF NOT EXISTS tbl_todo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    todo VARCHAR(255) NOT NULL,
    priority INT NOT NULL
);