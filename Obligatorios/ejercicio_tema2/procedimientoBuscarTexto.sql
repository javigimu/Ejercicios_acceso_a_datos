-- Búsqueda por texto.
-- Funcion que obtiene chistes que contengan el texto pasado. 
-- Búsquedas parciales (no sensibles a mayúsculas) de los chistes que
-- contengan el texto independientemente del idioma y los mostrará
-- como resultados
create or replace function buscar_chistes(texto varchar)
returns setof jokes as
$$
begin
	return query select * from jokes where 
		joke ilike '%'||texto||'%' or
		setup ilike '%'||texto||'%' or
		delivery ilike '%'||texto||'%';
end;
$$
language 'plpgsql';