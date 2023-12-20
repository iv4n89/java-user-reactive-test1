DROP SCHEMA IF EXISTS user_service CASCADE;

CREATE SCHEMA user_service;

CREATE TABLE user_service.user (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT unique_username UNIQUE (username),
    CONSTRAINT unique_email UNIQUE (email)
);

INSERT INTO user_service.user (id, name, username, password, email) VALUES
    ('3322bbe7-5b27-4b7d-9f9a-f5b580c409dc', 'John Doe', 'john.doe', 'Nomelase.103186', 'jon@mail.com');
