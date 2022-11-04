-- select round(avg(id_usuario)) from participarmm group by id_curso;

create or replace function calcularMediaUsuariosCurso(out curso int, out media int) 
returns setof record
as
$$
declare
	registro record;
begin
	for registro in select id_curso, round(avg(id_usuario)) as media_usr 
		from participarmm group by id_curso loop
		curso=registro.id_curso;
		media=registro.media_usr;
		return next;
	end loop;
	return;
end;
$$
language plpgsql;