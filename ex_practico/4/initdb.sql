CREATE DATABASE IF NOT EXISTS almacenes;
\c almacenes;

CREATE TABLE productos (
    codigo SERIAL PRIMARY KEY,
    nombre NVARCHAR(100),
    precio INT
);

CREATE TABLE cajeros (
    codigo SERIAL PRIMARY KEY,
    nom_apels NVARCHAR(255)
);

CREATE TABLE maquinas_registradoras (
    codigo SERIAL PRIMARY KEY,
    piso INT
);

CREATE TABLE venta (
    cajero INT,
    maquina INT,
    producto INT,
    PRIMARY KEY (cajero, maquina, producto),
    FOREIGN KEY (cajero) REFERENCES cajeros(codigo),
    FOREIGN KEY (maquina) REFERENCES maquinas_registradoras(codigo),
    FOREIGN KEY (producto) REFERENCES productos(codigo)
);
