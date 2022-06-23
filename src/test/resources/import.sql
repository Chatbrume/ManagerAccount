INSERT INTO account (id, creation_date, discount, type) VALUES(1, '2022-04-06', 0, 'CURRENT');
INSERT INTO account (id, creation_date, discount, type) VALUES(2, '2022-04-07', 1000, 'SPARE');
INSERT INTO account (id, creation_date, discount, type) VALUES(3, '2022-04-08', 500, 'CURRENT');

INSERT INTO user (id, password, role, username) VALUES(1, '$2a$10$1u/iLrtbfeGz4rBON4rrk.2oKoERc5YHp1mk5ZrbjdsRJx3Vfo4Yy', 'ADMIN', 'Admin');
INSERT INTO user (id, password, role, username) VALUES(2, '$2a$10$SOLRryhqG6aunSFm7psljudG0cibSehaq.yzXvTE8/IiTbi2fbozy', 'USER', 'Toto');