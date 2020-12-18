CREATE TABLE IF NOT EXISTS authority (
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(100),
    username VARCHAR(100),
    password VARCHAR(255),
    created VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    project_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);


CREATE TABLE IF NOT EXISTS plants (
    id INT NOT NULL AUTO_INCREMENT,
    latin_name VARCHAR(100),
    polish_name VARCHAR(100),
    variety VARCHAR(50),
    start_of_blooming VARCHAR(2),
    end_of_blooming VARCHAR(2),
    month_of_fertilization VARCHAR(2),
    type_of_fertilizer VARCHAR(255),
    month_of_cutting VARCHAR(2),
    cutting_type VARCHAR(255),
    plant_description VARCHAR (255),
    PRIMARY KEY (id)
);