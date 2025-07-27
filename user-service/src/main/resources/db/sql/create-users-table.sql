CREATE TABLE IF NOT EXISTS users
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    username
    VARCHAR
(
    255
) NOT NULL,
    address VARCHAR
(
    255
),
    phone_number VARCHAR
(
    20
),
    email VARCHAR
(
    255
) UNIQUE NOT NULL
    );