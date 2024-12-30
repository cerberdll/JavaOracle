-- Добавление нового заказа с напитком
INSERT INTO Orders (customer_id, order_date, total_price) VALUES (1, CURRENT_DATE, 6.50);
INSERT INTO OrderDetails (order_id, item_type, item_id, quantity) VALUES (currval('orders_id_seq'), 'Drink', 1, 2);

-- Вывод всех заказов
SELECT * FROM Orders;

-- Удаление конкретного заказа
DELETE FROM Orders WHERE id = 1;
