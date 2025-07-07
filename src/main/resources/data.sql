-- TABLAS
CREATE TABLE IF NOT EXISTS role (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(800) NOT NULL
);

CREATE TABLE IF NOT EXISTS "user" (
    id INT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    is_active BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE IF NOT EXISTS course_category (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(800) NOT NULL
);

CREATE TABLE IF NOT EXISTS course (
    id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(800) NOT NULL,
    category_id INT NOT NULL,
    manager_id INT NOT NULL,
    instructor_id INT NOT NULL,
    publish_date DATE NOT NULL,
    price DECIMAL(15,3) NOT NULL,
    image VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_course_category FOREIGN KEY (category_id) REFERENCES course_category(id),
    CONSTRAINT fk_course_manager FOREIGN KEY (manager_id) REFERENCES "user"(id),
    CONSTRAINT fk_course_instructor FOREIGN KEY (instructor_id) REFERENCES "user"(id)
);

CREATE TABLE IF NOT EXISTS enrollments (
    id INT PRIMARY KEY,
    course_id INT NOT NULL,
    user_id INT NOT NULL,
    enrollment_date TIMESTAMP NOT NULL,
    CONSTRAINT fk_enrollment_course FOREIGN KEY (course_id) REFERENCES course(id),
    CONSTRAINT fk_enrollment_user FOREIGN KEY (user_id) REFERENCES "user"(id)
);

CREATE TABLE IF NOT EXISTS course_content (
    id INT PRIMARY KEY,
    course_id INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    url VARCHAR(800) NOT NULL,
    order_index INT NOT NULL,
    CONSTRAINT fk_content_course FOREIGN KEY (course_id) REFERENCES course(id)
);

CREATE TABLE IF NOT EXISTS course_quiz (
    id INT PRIMARY KEY,
    course_id INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(800) NOT NULL,
    quiz_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_quiz_course FOREIGN KEY (course_id) REFERENCES course(id)
);

CREATE TABLE IF NOT EXISTS course_quiz_question (
    id INT PRIMARY KEY,
    quiz_id INT NOT NULL,
    question_text VARCHAR(800),
    option_a VARCHAR(800),
    option_b VARCHAR(800),
    option_c VARCHAR(800),
    option_d VARCHAR(800),
    correct_option VARCHAR(1),
    order_index INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_question_quiz FOREIGN KEY (quiz_id) REFERENCES course_quiz(id)
);

CREATE TABLE IF NOT EXISTS course_comment (
    id INT PRIMARY KEY,
    course_id INT NOT NULL,
    user_id INT NOT NULL,
    comment_text VARCHAR(800) NOT NULL,
    rating INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_comment_course FOREIGN KEY (course_id) REFERENCES course(id),
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES "user"(id)
);

-- Roles
INSERT INTO role (id, name, description) VALUES (1, 'ADMINISTRADOR', 'Administrador del sistema');
INSERT INTO role (id, name, description) VALUES (2, 'COORDINADOR', 'Coordinador académico');
INSERT INTO role (id, name, description) VALUES (3, 'INSTRUCTOR', 'Instructor de cursos');
INSERT INTO role (id, name, description) VALUES (4, 'SOPORTE', 'Soporte técnico');
INSERT INTO role (id, name, description) VALUES (5, 'ALUMNO', 'Alumno del sistema');

-- Usuarios
INSERT INTO "user" (id, first_name, last_name, email, password_hash, role_id, is_active, created_at, updated_at) VALUES (1, 'Admin', 'Principal', 'admin@edutech.com', 'admin123', 1, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO "user" (id, first_name, last_name, email, password_hash, role_id, is_active, created_at, updated_at) VALUES (2, 'Juan', 'Pérez', 'juan@edutech.com', 'alumno123', 5, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO "user" (id, first_name, last_name, email, password_hash, role_id, is_active, created_at, updated_at) VALUES (3, 'Ana', 'García', 'ana@edutech.com', 'instructor123', 3, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Categorías de curso
INSERT INTO course_category (id, name, description) VALUES (1, 'Matemáticas', 'Cursos de matemáticas');
INSERT INTO course_category (id, name, description) VALUES (2, 'Ciencias', 'Cursos de ciencias');
INSERT INTO course_category (id, name, description) VALUES (3, 'Historia', 'Cursos de historia');

-- Cursos
INSERT INTO course (id, title, description, category_id, manager_id, instructor_id, publish_date, price, image, status) VALUES (1, 'Álgebra Básica', 'Curso introductorio de álgebra', 1, 1, 3, '2024-01-01', 0.00, 'algebra.jpg', 'HABILITADO');
INSERT INTO course (id, title, description, category_id, manager_id, instructor_id, publish_date, price, image, status) VALUES (2, 'Física I', 'Curso básico de física', 2, 1, 3, '2024-01-01', 0.00, 'fisica.jpg', 'HABILITADO');

-- Inscripciones
INSERT INTO enrollments (id, course_id, user_id, enrollment_date) VALUES (1, 1, 2, CURRENT_TIMESTAMP);

-- Contenido de curso
INSERT INTO course_content (id, course_id, title, content_type, url, order_index) VALUES (1, 1, 'Introducción al Álgebra', 'video', 'https://video.com/algebra', 1);

-- Quiz y preguntas
INSERT INTO course_quiz (id, course_id, title, description, quiz_type, created_at) VALUES (1, 1, 'Quiz Álgebra', 'Evaluación de conceptos básicos', 'AUTOEVALUACION', CURRENT_TIMESTAMP);
INSERT INTO course_quiz_question (id, quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option, order_index, created_at) VALUES (1, 1, '¿Cuánto es 2+2?', '3', '4', '5', '6', 'B', 1, CURRENT_TIMESTAMP);

-- Comentarios
INSERT INTO course_comment (id, course_id, user_id, comment_text, rating, created_at) VALUES (1, 1, 2, 'Muy buen curso', 5, CURRENT_TIMESTAMP);
