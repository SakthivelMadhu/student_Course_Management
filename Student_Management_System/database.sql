CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    date_of_birth VARCHAR(255),
    gender VARCHAR(255),
    unique_student_code VARCHAR(255),
    email VARCHAR(255),
    mobile_number VARCHAR(255),
    parents_name VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(255),
    description VARCHAR(255),
    course_type VARCHAR(255),
    duration VARCHAR(255),
    topics VARCHAR(255)
);

CREATE TABLE student_course (
    student_id BIGINT,
    course_id BIGINT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Insert sample data into the user table
INSERT INTO users (username, password)
VALUES
    ('user1', '12345'), -- Password: password1
    ('user2', '123456'); -- Password: password2

-- Insert sample data into the Student table
INSERT INTO student (name, date_of_birth, gender, unique_student_code)
VALUES
    ('John Doe', '1995-05-15', 'Male', 'STD001'),
    ('Alice Smith', '1996-08-25', 'Female', 'STD002'),
    ('Bob Johnson', '1994-03-10', 'Male', 'STD003');

-- Insert sample data into the Course table
INSERT INTO course (course_name, description, course_type, duration)
VALUES
    ('Mathematics 101', 'Introductory math course', 'Math', 90),
    ('Computer Science 101', 'Introductory programming course', 'Computer Science', 120),
    ('History 101', 'Introductory history course', 'History', 75);

-- Insert sample data into the StudentCourse table (student-course relationships)
INSERT INTO student_course (student_id, course_id)
VALUES
    (1, 1), -- John Doe enrolled in Mathematics 101
    (1, 2), -- John Doe enrolled in Computer Science 101
    (2, 2), -- Alice Smith enrolled in Computer Science 101
    (3, 1), -- Bob Johnson enrolled in Mathematics 101
    (3, 3); -- Bob Johnson enrolled in History 101