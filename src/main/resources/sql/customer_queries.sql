-- Самый молодой клиент
SELECT full_name, date_of_birth FROM Customers ORDER BY date_of_birth DESC LIMIT 1;

-- Самый возрастной клиент
SELECT full_name, date_of_birth FROM Customers ORDER BY date_of_birth ASC LIMIT 1;

-- Клиенты с днем рождения сегодня
SELECT full_name, date_of_birth FROM Customers WHERE EXTRACT(MONTH FROM date_of_birth) = EXTRACT(MONTH FROM CURRENT_DATE)
                                                 AND EXTRACT(DAY FROM date_of_birth) = EXTRACT(DAY FROM CURRENT_DATE);

-- Клиенты без контактного почтового адреса
SELECT full_name FROM Customers WHERE email IS NULL OR email = '';
