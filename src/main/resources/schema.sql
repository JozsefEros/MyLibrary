CREATE TABLE readers (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(255) NULL,
    middle_name VARCHAR(255) NULL,
    last_name VARCHAR(255) NULL,
    year_of_birth INT NULL,
    registration_date DATE NULL,
    created_at DATE NULL,
    modified_at DATE NULL
);

CREATE TABLE catalog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    published VARCHAR(4) NOT NULL,
    publisher VARCHAR(100) NOT NULL,
    language VARCHAR(20) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    available VARCHAR(4) NULL
);

CREATE TABLE lending (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book int NOT NULL,
    reader int NOT NULL,
    lending_date date NOT NULL,
    expiration_date date NOT NULL,
    return_date date NOT NULL
);