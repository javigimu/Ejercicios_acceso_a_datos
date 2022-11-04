-- crear una tabla "programadores" y una tabla "Lenguajes", con una relación M:M (muchos a muchos) "conocer". 
-- En esta relación habrá un atributo "nivel", que es el nivel que cada programador tiene en un cierto lenguaje, de 0 a 10.
-- base de datos creada en postgreeSQL
CREATE TABLE programadores(
    id serial PRIMARY KEY,
    nombre varchar(30)
);

CREATE TABLE lenguajes(
    id varchar(10) PRIMARY KEY
);

CREATE TABLE conocer(
    id_programador int NOT NULL,
    id_lenguaje varchar(10) NOT NULL,
    nivel int CHECK (nivel BETWEEN 0 AND 10),
    CONSTRAINT PK_CONOCER PRIMARY KEY(id_programador, id_lenguaje),
    CONSTRAINT FK_CONOCER_PROGRAMADORES FOREIGN KEY (id_programador) REFERENCES programadores(id)
    	ON DELETE CASCADE,
    CONSTRAINT FK_CONOCER_LENGUAJES FOREIGN KEY (id_lenguaje) REFERENCES lenguajes(id)
    	ON DELETE CASCADE
);

-- Añadir datos
INSERT INTO programadores(nombre) VALUES('javier');
INSERT INTO programadores(nombre) VALUES('raul');
INSERT INTO programadores(nombre) VALUES('esteban');
INSERT INTO programadores(nombre) VALUES('hugo');
INSERT INTO programadores(nombre) VALUES('rocio');
INSERT INTO programadores(nombre) VALUES('virginia');
INSERT INTO programadores(nombre) VALUES('carlos');
INSERT INTO programadores(nombre) VALUES('manuel');
INSERT INTO lenguajes VALUES('c#');
INSERT INTO lenguajes VALUES('java');
INSERT INTO lenguajes VALUES('javascript');
INSERT INTO lenguajes VALUES('python');
INSERT INTO lenguajes VALUES('kotlin');
INSERT INTO lenguajes VALUES('html');
INSERT INTO conocer VALUES(1, 'c#', 8);
INSERT INTO conocer VALUES(2, 'c#', 9);
INSERT INTO conocer VALUES(4, 'java', 7);
INSERT INTO conocer VALUES(1, 'java', 9);
INSERT INTO conocer VALUES(6, 'python', 5);
INSERT INTO conocer VALUES(5, 'html', 8);
INSERT INTO conocer VALUES(3, 'javascript', 8);
INSERT INTO conocer VALUES(4, 'javascript', 9);
INSERT INTO conocer VALUES(2, 'python', 10);
insert into conocer values(1, 'html', 8);
insert into conocer values(4, 'python', 5);
insert into conocer values(6, 'java', 6);


-- Muestra la lista de programadores que tenemos, junto con los lenguajes que 
-- conocen.
select p.nombre, c.id_lenguaje from programadores p
inner join conocer c
on p.id=c.id_programador order by nombre;

-- Muestra la lista de programadores que tenemos, junto con los lenguajes que 
-- conocen, incluso si no conocen ninguno.
select p.nombre, c.id_lenguaje from programadores p
left outer join conocer c on p.id=c.id_programador;

-- Muestra la lista de programadores que tenemos y para los cuales no aparezca 
-- ningún lenguaje.
select * from programadores where id not in (select id_programador from conocer);

-- Muestra los programadores que programan en lenguajes que programan en Java.
select * from programadores p inner join conocer c 
on p.id=c.id_programador and c.id_lenguaje='java';

-- Muestra los programadores que programan en Java pero no en Javascript.
select distinct p.nombre from programadores p inner join conocer c 
on p.id=c.id_programador and c.id_programador not in 
(select id_programador from conocer where id_lenguaje='javascript')
order by p.nombre;

-- Muestra el (o los) lenguajes para el (los) que tenemos más programadores.
select id_lenguaje from conocer group by id_lenguaje
having count(*)=(select count(*) from conocer group by id_lenguaje having 
				id_lenguaje in (select max(id_lenguaje) from conocer));

-- Crea un vista "expertos" que te muestre todos los programadores que dominen 
-- 3 o más lenguajes.
create view expertos as
select * from programadores where id in
(select id_programador from conocer group by id_programador 
having count(*)>=3
order by id_programador);

-- Crea un tabla "uso" con 3 campos: tipo, descripción, fecha. Crea un "trigger" 
-- que, cada vez que se borre un dato de un programador, anote un registro con tipo 
-- "borrado", nombre del programador como descripción y la fecha actual.

create table uso(
	tipo varchar(10) default 'borrado',
	descripcion varchar(30),
	fecha date default current_date
);

-- Crea un tabla "uso" con 3 campos: tipo, descripción, fecha. Crea un "trigger" 
-- que, cada vez que se borre un dato de un programador, anote un registro con tipo 
-- "borrado", nombre del programador como descripción y la fecha actual.

CREATE TRIGGER borrardo
AFTER DELETE ON programadores 
FOR EACH ROW 
	INSERT INTO uso(descripcion) VALUES(OLD.nombre);

