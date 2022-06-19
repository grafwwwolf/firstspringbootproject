BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost NUMERIC(6, 2));
INSERT INTO products (title, cost) VALUES
                                                   ('black leather jacket', 3600.00),
                                                   ('black leather bandana', 540.00),
                                                   ('black jeans', 2200.00),
                                                   ('black leather gloves', 1050.00),
                                                   ('T-shirt with print AC/DC', 700.00),
                                                   ('T-shirt with print MANOWAR', 700.00),
                                                   ('T-shirt with print ARIA', 700.00),
                                                   ('Sunglasses', 600.00),
                                                   ('black motorcycle boots', 4300.00),
                                                   ('black leather vest', 2300.00);

DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO buyers (name) VALUES
                                       ('Stas'),
                                       ('Alex'),
                                       ('Dmitry'),
                                       ('Sergey');

DROP TABLE IF EXISTS buyers_products CASCADE;
CREATE TABLE buyers_products (buyers_id bigserial REFERENCES buyers(id), products_id bigserial REFERENCES products(id));
INSERT INTO buyers_products (buyers_id, products_id) VALUES
                              (1, 1),
                              (1, 3),
                              (2, 1),
                              (2, 3),
                              (2, 2),
                              (2, 10),
                              (3, 9),
                              (4, 1),
                              (4, 2),
                              (4, 3),
                              (4, 4),
                              (4, 8);

COMMIT;