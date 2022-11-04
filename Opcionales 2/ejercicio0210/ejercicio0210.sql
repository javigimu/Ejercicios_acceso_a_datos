create table cursos(
	id serial primary key,
	titulo varchar(30) not null,
	fechaIni date
);

create table usuarios(
	id serial primary key,
	nombre varchar(30) not null,
	id_table int,
	constraint fk_usuarios_cursos foreign key(id_table) references cursos(id)
);