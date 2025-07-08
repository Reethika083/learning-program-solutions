CREATE TABLE IF NOT EXISTS department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL,
    permanent BOOLEAN NOT NULL,
    date_of_birth DATE NOT NULL,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(id)
);

CREATE TABLE IF NOT EXISTS skill (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(id)
);

-- Insert sample departments
INSERT INTO department (name) VALUES ('Engineering'), ('HR'), ('Finance');

-- Insert sample employees
INSERT INTO employee (name, salary, permanent, date_of_birth, em_dp_id) VALUES 
('Alice', 75000, TRUE, '1990-04-15', 1),
('Bob', 65000, FALSE, '1992-06-20', 2),
('Charlie', 80000, TRUE, '1988-11-30', 1);

-- Insert sample skills
INSERT INTO skill (name) VALUES ('Java'), ('Python'), ('Excel');

-- Associate employees with skills
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1), (1, 2), (2, 3), (3, 1);