create or replace function cantidadUsuarioPorCurso(curso integer) returns integer
as
$$
declare
	cantidad integer;
begin
	select count(*) into cantidad from participarmm where id_curso=curso;
	return cantidad;
end;
$$
language plpgsql;
