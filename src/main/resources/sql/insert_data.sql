-- Напитки
INSERT INTO Drinks (name_en, name_local, price) VALUES ('Latte', 'Латте', 4.50);
INSERT INTO Drinks (name_en, name_local, price) VALUES ('Espresso', 'Эспрессо', 3.00);

-- Десерты
INSERT INTO Desserts (name_en, name_local, price) VALUES ('Cheesecake', 'Чизкейк', 6.00);
INSERT INTO Desserts (name_en, name_local, price) VALUES ('Brownie', 'Брауни', 5.50);

-- Сотрудники
INSERT INTO Staff (full_name, phone, email, position) VALUES ('John Doe', '+123456789', 'john.doe@example.com', 'Barista');
INSERT INTO Staff (full_name, phone, email, position) VALUES ('Jane Smith', '+987654321', 'jane.smith@example.com', 'Pastry Chef');

-- Клиенты
INSERT INTO Customers (full_name, date_of_birth, phone, email, discount) VALUES ('Alice Johnson', '1990-05-10', '+456123789', 'alice.johnson@example.com', 10.0);
INSERT INTO Customers (full_name, date_of_birth, phone, email, discount) VALUES ('Bob Brown', '1985-12-20', '+789456123', 'bob.brown@example.com', 5.0);
