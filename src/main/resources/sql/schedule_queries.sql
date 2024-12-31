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

-- Расписание работы конкретного бариста на неделю
SELECT * FROM Schedule WHERE staff_id = 1 AND work_date BETWEEN CURRENT_DATE AND (CURRENT_DATE + 6);

-- Расписание работы всех бариста на неделю
SELECT s.full_name, sc.work_date, sc.shift_start, sc.shift_end
FROM Staff s
         JOIN Schedule sc ON s.id = sc.staff_id
WHERE s.position = 'Barista' AND sc.work_date BETWEEN CURRENT_DATE AND (CURRENT_DATE + 6);

-- Расписание работы всех работников кафе на неделю
SELECT s.full_name, s.position, sc.work_date, sc.shift_start, sc.shift_end
FROM Staff s
         JOIN Schedule sc ON s.id = sc.staff_id
WHERE sc.work_date BETWEEN CURRENT_DATE AND (CURRENT_DATE + 6);
