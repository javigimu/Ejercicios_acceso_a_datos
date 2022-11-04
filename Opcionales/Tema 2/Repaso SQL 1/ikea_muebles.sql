CREATE DATABASE ikea;

CREATE TABLE muebles (
    id decimal PRIMARY KEY,
    nombre varchar(30),
    precio decimal(10,2),
    materiales varchar(50)
);