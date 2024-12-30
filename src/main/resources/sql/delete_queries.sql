-- Удалить десерт
DELETE FROM Desserts WHERE name_en = 'Cheesecake';

-- Удалить официанта
DELETE FROM Staff WHERE position = 'Waiter' AND full_name = 'John Smith';

-- Удалить клиента
DELETE FROM Customers WHERE full_name = 'Alice Johnson';
