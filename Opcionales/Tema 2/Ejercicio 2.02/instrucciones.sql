alter table articulos add precio decimal(10,2);
update articulos set precio=100;
insert into articulos values(3, 'helado de chocolate', 2.50);
select * from articulos where precio < 10;