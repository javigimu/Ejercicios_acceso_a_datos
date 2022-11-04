-- Crea una tabla "marcas", con campos id (alfabético) y nombre.
CREATE TABLE marcas(
    id int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(30)
);

--Crea una tabla "portatiles", con campos id (autonumérico), marca (que hará referencia al "id" de "marcas", modelo, procesador, memoria).
CREATE TABLE portatiles(
    id int AUTO_INCREMENT PRIMARY KEY,
    marca varchar(20),
    modelo varchar(30),
    procesador varchar(20),
    memoria varchar(10),
    FOREIGN KEY (marca) REFERENCES marcas(id)
);

-- Añade tres portátiles y tres marcas, que no estén totalmente relacionados (por ejemplo, alguna marca de la que no tengamos ningún portátil).
INSERT INTO marcas VALUES('asus', 'asus');
INSERT INTO marcas VALUES('msi', 'msi');
INSERT INTO marcas VALUES('hp', 'hp');
INSERT INTO portatiles(marca, memoria, modelo, procesador) VALUES('hp', '4Gb', '1024 pro', 'I7' );
INSERT INTO portatiles(marca, memoria, modelo, procesador) VALUES('hp', '6Gb', '355', 'I7' );
INSERT INTO portatiles(marca, memoria, modelo, procesador) VALUES('asus', '8Gb', 'a-51', 'I7' );

-- Muestra los datos de todos los portátiles (nombre de la marca, modelo, procesador, memoria).
select m.nombre, modelo, procesador, memoria from portatiles p 
inner join marcas m 
on m.id=p.marca;

-- Muestra todas las marcas, junto con los modelos de esa marca (si existen; también deben aparecer las marcas de las que no tengamos ningún modelo de portátil).
select m.nombre, p.modelo from marcas m 
left outer join portatiles p
on m.id=p.marca;

-- Muestra todos los modelos, junto el nombre de su marca (si existe; si alguna marca no existiera en la tabla "marcas" -no esperable, al ser clave ajena-), aun así debería aparecer el modelo.
select p.modelo, m.nombre from portatiles p
left outer join marcas m
on p.marca=m.id;

-- Muestra las marcas de las que no tenemos ningún modelo.
select * from marcas m where m.id not in (select marca from portatiles);

-- Muestra los ordenadores de la marca más popular (aquella de la que tenemos información sobre más portátiles).
select * from portatiles where marca=(select max(marca) from portatiles);