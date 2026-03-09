INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');
INSERT INTO users (name, email) VALUES ('Alice Smith', 'alice@example.com');

INSERT INTO orders (product, status, total, user_id)
VALUES ('Laptop', 'DELIVERED', 1200, 1);

INSERT INTO orders (product, status, total, user_id)
VALUES ('Phone', 'SHIPPED', 800, 1);

INSERT INTO orders (product, status, total, user_id)
VALUES ('Tablet', 'PROCESSING', 400, 2);