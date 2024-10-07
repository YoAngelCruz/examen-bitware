SELECT 
    c.nom_apels AS nombre_cajero,
    p.nombre AS nombre_producto,
    p.precios AS precio_producto,
    m.piso AS piso_maquina
FROM
    venta v
JOIN cajeros c ON v.cajero = c.codigo
JOIN productos p ON v.producto = p.codigo
JOIN maquinas_registradoras m ON v.maquina = m.codigo;
