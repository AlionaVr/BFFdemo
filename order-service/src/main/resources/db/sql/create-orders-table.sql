CREATE TABLE IF NOT EXISTS orders
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    user_id
    BIGINT
    NOT
    NULL,
    total_amount
    DECIMAL
(
    19,
    2
) NOT NULL,
    currency VARCHAR
(
    3
) NOT NULL DEFAULT 'USD',
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP

                             );

CREATE TABLE IF NOT EXISTS order_items
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    order_id
    BIGINT
    NOT
    NULL
    REFERENCES
    orders
(
    id
) ON DELETE CASCADE,
    product_name VARCHAR
(
    255
) NOT NULL,
    quantity INTEGER NOT NULL CHECK
(
    quantity >
    0
),
    unit_price DECIMAL
(
    19,
    2
) NOT NULL CHECK
(
    unit_price
    >=
    0
),
    total_price DECIMAL
(
    19,
    2
) NOT NULL CHECK
(
    total_price
    >=
    0
)
    );