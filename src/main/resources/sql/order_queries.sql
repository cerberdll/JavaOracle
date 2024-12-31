-- Заказы в конкретную дату
SELECT * FROM Orders WHERE order_date = '2024-12-30';

-- Заказы в указанном промежутке дат
SELECT * FROM Orders WHERE order_date BETWEEN '2024-12-01' AND '2024-12-31';

-- Количество заказов десертов в конкретную дату
SELECT COUNT(*) AS dessert_orders FROM OrderDetails
WHERE item_type = 'Dessert' AND order_id IN (SELECT id FROM Orders WHERE order_date = '2024-12-30');

-- Количество заказов напитков в конкретную дату
SELECT COUNT(*) AS drink_orders FROM OrderDetails
WHERE item_type = 'Drink' AND order_id IN (SELECT id FROM Orders WHERE order_date = '2024-12-30');
