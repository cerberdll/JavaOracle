-- Минимальная скидка
SELECT MIN(discount) AS min_discount FROM Customers;

-- Максимальная скидка
SELECT MAX(discount) AS max_discount FROM Customers;

-- Клиенты с минимальной скидкой
SELECT full_name, discount FROM Customers WHERE discount = (SELECT MIN(discount) FROM Customers);

-- Клиенты с максимальной скидкой
SELECT full_name, discount FROM Customers WHERE discount = (SELECT MAX(discount) FROM Customers);

-- Средняя скидка
SELECT AVG(discount) AS avg_discount FROM Customers;
