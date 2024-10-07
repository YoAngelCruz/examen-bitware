SELECT m.piso as piso_maquina, COUNT(v.maquina) AS num_ventas
FROM maquinas_registradoras m
JOIN venta v ON m.codigo = v.maquina
GROUP BY m.piso;
