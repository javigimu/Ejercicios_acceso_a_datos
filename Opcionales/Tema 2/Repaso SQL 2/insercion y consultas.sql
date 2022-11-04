INSERT INTO muebles VALUES (200111413, 'Mesa LACK' , 10 , 'Conglomerado');
INSERT INTO muebles VALUES (702611150, 'Silla MARKUS' , 159 , 'Varios');
INSERT INTO muebles VALUES (791229203, 'Sofá EKTORP' , 249 , 'Tela beige');

-- todos los datos
SELECT * FROM muebles;
-- muestra los nombres de los muebles con precio mayor de 100€ ordenados por nombre descendente
SELECT nombre FROM muebles WHERE precio > 100 ORDER BY nombre DESC;
-- Sillas de menos de 200 euros ordenadas por precio descendente
SELECT * FROM muebles WHERE UPPER(nombre) LIKE "%SILLA%" ORDER BY precio DESC;
-- Cambiar a 269 el precio de los muebles Ektorp
UPDATE muebles SET precio=269 WHERE nombre like "%Ektorp%";
-- Añadir el campo "unidades" a la tabla (podrá tener valores de 0 a 99.999)
ALTER TABLE muebles ADD unidades decimal(6);
