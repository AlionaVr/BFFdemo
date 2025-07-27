INSERT INTO orders (user_id, total_amount, currency)
VALUES (1, 299.99, 'USD'),
       (1, 149.50, 'USD'),
       (2, 89.99, 'EUR'),
       (3, 199.99, 'USD'),
       (3, 79.99, 'USD'),
       (4, 349.99, 'USD'),
       (5, 25.99, 'USD');

INSERT INTO order_items (order_id, product_name, quantity, unit_price, total_price)
VALUES (1, 'Laptop Dell XPS 13', 1, 299.99, 299.99),

       (2, 'Wireless Mouse', 2, 29.99, 59.98),
       (2, 'USB-C Cable', 3, 29.84, 89.52),

       (3, 'Mechanical Keyboard', 1, 89.99, 89.99),

       (4, 'Monitor 24"', 1, 199.99, 199.99),

       (5, 'Phone Case', 2, 19.99, 39.98),
       (5, 'Screen Protector', 2, 19.99, 39.98),

       (6, 'Gaming Chair', 1, 349.99, 349.99),

       (7, 'Coffee Mug', 1, 25.99, 25.99);