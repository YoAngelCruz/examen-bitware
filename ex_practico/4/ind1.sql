-- Poblar tabla productos
INSERT INTO productos (nombre, precio) VALUES
('Laptop', 15000),
('Mouse', 250),
('Teclado', 800),
('Monitor', 4500),
('Impresora', 3200);

-- Poblar tabla cajeros
INSERT INTO cajeros (nom_apels) VALUES
('Juan Pérez'),
('Ana González'),
('Carlos Ramírez'),
('Luisa Fernández'),
('Marta López');

-- Poblar tabla maquinas_registradoras
INSERT INTO maquinas_registradoras (piso) VALUES
(1),
(2),
(3);

-- Poblar tabla venta
INSERT INTO venta (cajero, maquina, producto) VALUES
(1, 1, 1),
(2, 2, 3),
(3, 3, 2),
(4, 1, 3),
(5, 5, 2),
(1, 2, 2),
(2, 1, 1),
(3, 4, 3),
(4, 3, 2),
(5, 1, 2),
(1, 3, 1),
(2, 2, 2),
(3, 1, 3),
(4, 5, 3),
(5, 3, 1);
