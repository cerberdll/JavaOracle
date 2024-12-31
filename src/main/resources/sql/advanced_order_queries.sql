-- Клиенты, которые заказывали напитки сегодня, и информация о бариста
SELECT DISTINCT c.full_name AS customer_name, s.full_name AS barista_name
FROM Customers c
         JOIN Orders o ON c.id = o.customer_id
         JOIN OrderDetails od ON o.id = od.order_id
         JOIN Staff s ON s.id = (SELECT staff_id FROM Schedule WHERE work_date = CURRENT_DATE LIMIT 1)
WHERE od.item_type = 'Drink' AND o.order_date = CURRENT_DATE;

-- Средняя сумма заказа в конкретную дату
SELECT AVG(total_price) AS avg_order_price FROM Orders WHERE order_date = '2024-12-30';

-- Максимальная сумма заказа в конкретную дату
SELECT MAX(total_price) AS max_order_price FROM Orders WHERE order_date = '2024-12-30';

-- Клиент, который совершил максимальную сумму заказа в конкретную дату
SELECT c.full_name, o.total_price
FROM Customers c
         JOIN Orders o ON c.id = o.customer_id
WHERE o.order_date = '2024-12-30'
ORDER BY o.total_price DESC LIMIT 1;
