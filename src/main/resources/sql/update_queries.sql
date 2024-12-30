-- Изменить цену напитка
UPDATE Drinks SET price = 5.00 WHERE name_en = 'Latte';

-- Изменить email кондитеру
UPDATE Staff SET email = 'new.email@example.com' WHERE position = 'Pastry Chef';

-- Изменить телефон бариста
UPDATE Staff SET phone = '+111222333' WHERE position = 'Barista';

-- Изменить процент скидки клиента
UPDATE Customers SET discount = 15.0 WHERE full_name = 'Alice Johnson';
