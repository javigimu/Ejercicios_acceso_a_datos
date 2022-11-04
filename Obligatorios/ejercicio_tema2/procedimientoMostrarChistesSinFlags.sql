-- Chistes sin flags. 
-- Procedimiento que devuelve aquellos chistes que no tienen ningún flag asociado
create or replace function listar_chistes_sin_flags() 
returns setof jokes as
$$
begin
	return query select * from jokes j where j.id_idioma not in (
		select f.idioma from flags f where j.id_idioma=f.idioma
		and j.id_chiste=f.chiste)
		and
		id_chiste not in(
		select f.chiste from flags f where j.id_idioma=f.idioma
		and j.id_chiste=f.chiste)
		order by id_idioma, id_chiste;
end;
$$
language 'plpgsql';