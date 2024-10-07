CREATE DATABASE practica1;

\c practica1;

CREATE TABLE usuarios(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    email VARCHAR(50),
    direccion VARCHAR(50)
);