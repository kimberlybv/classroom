INSERT INTO COURSE_CATEGORY (id, name) VALUES (1, 'Matemáticas');
INSERT INTO COURSE_CATEGORY (id, name) VALUES (2, 'Ciencias');
INSERT INTO COURSE_CATEGORY (id, name) VALUES (3, 'Historia');

INSERT INTO COURSE (id, name, category_id) VALUES (1, 'Álgebra Básica', 1);
INSERT INTO COURSE (id, name, category_id) VALUES (2, 'Física I', 2);
INSERT INTO COURSE (id, name, category_id) VALUES (3, 'Historia Universal', 3);

INSERT INTO USER (id, username, password, role) VALUES (1, 'admin', 'admin', 'ADMIN');
INSERT INTO USER (id, username, password, role) VALUES (2, 'alumno', 'alumno', 'USER');
