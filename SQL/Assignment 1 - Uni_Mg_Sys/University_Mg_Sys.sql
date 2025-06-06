CREATE DATABASE university;

CREATE TABLE advisors (
	adv_id INT PRIMARY KEY,
    adv_name VARCHAR(20),
    adv_email VARCHAR(40) UNIQUE,
    specialization VARCHAR(40)
);

CREATE TABLE students (
	st_id INT PRIMARY KEY,
    st_name VARCHAR(20),
    st_email VARCHAR(20) UNIQUE,
    birth_date DATE,
    adv_id INT,
    FOREIGN KEY(adv_id) REFERENCES advisors(adv_id) ON DELETE SET NULL
);

CREATE TABLE courses (
	crs_code VARCHAR(10) PRIMARY KEY,
    title VARCHAR(40),
    crs_description TEXT,
    instructor VARCHAR(20)
);

CREATE TABLE enrollments (
	st_id INT,
    crs_code VARCHAR(10),
    PRIMARY KEY(st_id, crs_code),
    FOREIGN KEY(st_id) REFERENCES students(st_id) ON DELETE CASCADE,
    FOREIGN KEY(crs_code) REFERENCES courses(crs_code) ON DELETE CASCADE
);