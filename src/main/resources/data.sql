INSERT INTO brand (id, name) VALUES (1, 'ZARA');

INSERT INTO product (id, name) VALUES (35455, 'Sample Product');

INSERT INTO price_list (id, name) VALUES
(1, 'Tarifa estandar'),
(2, 'Promoción verano'),
(3, 'Promoción invierno'),
(4, 'Tarifa premium');

INSERT INTO prices (brand_id, product_id, price_list, start_date, end_date, priority, price, currency)
VALUES
(1, 35455, 1, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 0, 35.50, 'EUR'),
(1, 35455, 2, '2020-06-14T15:00:00', '2020-06-14T18:30:00', 1, 25.45, 'EUR'),
(1, 35455, 3, '2020-06-15T00:00:00', '2020-06-15T11:00:00', 1, 30.50, 'EUR'),
(1, 35455, 4, '2020-06-15T16:00:00', '2020-12-31T23:59:59', 1, 38.95, 'EUR');