-- crea una base de datos "dia02". 
-- Añade en ella una tabla "clientes" (id de texto, nombre, fecha de alta). 
-- Introduce 2 datos de ejemplo. Muestra los que comienzan por "A".


create table clientes(
	id varchar(20),
	nombre varchar(30),
	fecha date default current_date
);

insert into clientes values('JAVI1', 'JAVIER GIMENEZ');
select * from clientes where nombre like 'A%';
