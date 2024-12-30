-- Добавление расписания для сотрудника
INSERT INTO Schedule (staff_id, work_date, shift_start, shift_end)
VALUES (1, '2024-01-01', '08:00:00', '16:00:00');

-- Обновление расписания на конкретный день
UPDATE Schedule SET shift_start = '09:00:00', shift_end = '17:00:00'
WHERE work_date = '2024-01-01';

-- Удаление расписания на конкретный день
DELETE FROM Schedule WHERE work_date = '2024-01-01';

-- Вывод расписания
SELECT * FROM Schedule;
