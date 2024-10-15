CREATE DATABASE event_management;

USE event_management;

CREATE TABLE events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(100) NOT NULL,
    event_date DATE NOT NULL,
    venue VARCHAR(100),
    description TEXT
);

CREATE TABLE attendees (
    attendee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    event_id INT,
    FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE
);
