-- Добавление нового вида кофе
INSERT INTO Drinks (name_en, name_local, price) VALUES ('Americano', 'Американо', 3.50);

-- Обновление цены существующего кофе
UPDATE Drinks SET price = 4.00 WHERE name_en = 'Latte';

-- Вывод всех напитков
SELECT * FROM Drinks;
