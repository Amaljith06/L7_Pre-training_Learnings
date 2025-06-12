CREATE DATABASE university;

CREATE TABLE advisors (
	advisor_id INT PRIMARY KEY AUTO_INCREMENT,
    advisor_name VARCHAR(60) NOT NULL,
    email VARCHAR(100) UNIQUE,
    specialization VARCHAR(60)
);

CREATE TABLE students (
	student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    email VARCHAR(40) UNIQUE NOT NULL,
    birth_date DATE,
    advisor_id INT,
    CONSTRAINT fk_students_advisor_id
		FOREIGN KEY(advisor_id) REFERENCES advisors(advisor_id) 
        ON DELETE SET NULL
);

CREATE TABLE courses (
	course_code VARCHAR(10) PRIMARY KEY,
    title VARCHAR(100),
    description TEXT,
    instructor VARCHAR(60)
);

CREATE TABLE enrollments (
	student_id INT,
    course_code VARCHAR(10),
    enrollment_status VARCHAR(15) DEFAULT 'pending' CHECK (enrollment_status IN ('pending', 'active', 'completed', 'cancelled')),
    enrollment_date DATE,
    PRIMARY KEY(student_id, course_code),
    CONSTRAINT fk_enrollments_student
		FOREIGN KEY(student_id) REFERENCES students(student_id) 
        ON DELETE CASCADE,
    CONSTRAINT fk_enrollments_course 
		FOREIGN KEY(course_code) REFERENCES courses(course_code) 
        ON DELETE CASCADE
);