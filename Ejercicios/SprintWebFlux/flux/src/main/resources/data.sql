--personas
CREATE TABLE PERSONAS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    edad INT
);

--creacion de datos
INSERT INTO PERSONAS (nombre, edad) VALUES ('Carlos', 30);
INSERT INTO PERSONAS (nombre, edad) VALUES ('Ana', 25);