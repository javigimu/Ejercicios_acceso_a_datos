create table cursosMM(
	id serial primary key,
	titulo varchar(30) not null,
	fechaIni date
);

create table usuariosMM(
	id serial primary key,
	nombre varchar(30) not null	
);

create table participarMM (
	id_curso int,
	id_usuario int,
	constraint pk_participar primary key(id_curso, id_usuario),
	constraint fk_participar_cursos foreign key(id_curso) references cursosMM(id),
	constraint fk_participar_usuarios foreign key(id_usuario) references usuariosMM(id)
);