drop table if exists categories;
drop table if exists language;
drop table if exists types;
drop table if exists flags;
drop table if exists jokes;

create table categories(
	id varchar(20) primary key
);

create table languages(
	id varchar(2) primary key
);

create table types(
	id varchar(10) primary key,
	constraint ck_types check (id='single' or id='twopart')
);

create table jokes(
	id_idioma varchar(2),
	id_chiste int,
	joke varchar,
	setup varchar,
	delivery varchar,
	id_category varchar(20),
	id_type varchar(10),
	constraint pk_jokes primary key(id_idioma, id_chiste),
	constraint fk_jokes_languages foreign key(id_idioma)
		references languages(id),
	constraint fk_jokes_categories foreign key(id_category) 
		references categories(id),
	constraint fk_jokes_types foreign key(id_type)
		references types(id)
);

create table flags(
	id varchar(20),
	idioma varchar(2),
	chiste int,
    constraint pk_flags primary key(id, idioma, chiste),
	constraint fk_flags_jokes foreign key(idioma, chiste)
		references jokes(id_idioma, id_chiste)
);