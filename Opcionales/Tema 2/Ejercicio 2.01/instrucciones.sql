create database dia01;
use \c dia01;
create table articulos(id int primary key, nombre varchar(100));
insert into articulos values(1, 'mesa');
insert into articulos values(2, 'silla');
select * from articulos;