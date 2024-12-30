-- Таблица для напитков
CREATE TABLE Drinks (
    id SERIAL PRIMARY KEY,
    name_en VARCHAR(100) NOT NULL,
    name_local VARCHAR(100) NOT NULL,
    price NUMERIC(5, 2) NOT NULL
);

-- Таблица для десертов
CREATE TABLE Desserts (
    id SERIAL PRIMARY KEY,
    name_en VARCHAR(100) NOT NULL,
    name_local VARCHAR(100) NOT NULL,
    price NUMERIC(5, 2) NOT NULL
);

-- Таблица для сотрудников
CREATE TABLE Staff (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(200) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    position VARCHAR(50) CHECK (position IN ('Barista', 'Waiter', 'Pastry Chef'))
);

-- Таблица для клиентов
CREATE TABLE Customers (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(200) NOT NULL,
    date_of_birth DATE NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    discount NUMERIC(3, 1) DEFAULT 0
);

-- Таблица для расписания работы персонала
CREATE TABLE Schedule (
    id SERIAL PRIMARY KEY,
    staff_id INT REFERENCES Staff(id),
    work_date DATE NOT NULL,
    shift_start TIME NOT NULL,
    shift_end TIME NOT NULL
);

-- Таблица для заказов
CREATE TABLE Orders (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES Customers(id),
    order_date DATE NOT NULL,
    total_price NUMERIC(10, 2) NOT NULL
);

-- Таблица для деталей заказов
CREATE TABLE OrderDetails (
    id SERIAL PRIMARY KEY,
    order_id INT REFERENCES Orders(id),
    item_type VARCHAR(10) CHECK (item_type IN ('Drink', 'Dessert')) NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL
);
