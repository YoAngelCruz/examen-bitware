SELECT DISTINCT
    c.codigo AS codigo_cajero,
    c.nom_apels AS nombre_cajero
FROM cajeros c
JOIN venta v ON c.codigo = v.cajero
JOIN productos p ON v.producto = p.codigo
JOIN maquinas_registradoras m ON v.maquina = m.codigo
GROUP BY c.codigo, c.nom_apels
HAviNg SUM(p.precio) < 5000
