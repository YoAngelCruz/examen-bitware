SELECT p.nombre AS producto, COUNT(v.producto) AS num_ventas
FROM productos p
JOIN venta v ON p.codigo = v.producto
GROUP BY p.nombre
ORDER BY num_ventas DESC;