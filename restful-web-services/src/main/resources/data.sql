INSERT INTO user_details(id, birth_date, name)
VALUES (100, current_date(), 'RAJA 100'),
(200, current_date(), 'RAJA 200'),
(300, current_date(), 'RAJA 300');

INSERT INTO post(id, description, user_id)
VALUES (101, 'I want to Learn Spring', 100),
(102, 'I want to Learn AWS', 200);