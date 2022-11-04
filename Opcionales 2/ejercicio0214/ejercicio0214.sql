-- nombre de los alumnos de un curso

create or replace function listarNombreAlumnosCurso(curso int) 
returns setof varchar as
$$
begin
	return query select u.nombre from usuariosmm u 
		inner join participarmm p on u.id=p.id_usuario and p.id_curso=curso;
end;
$$
language plpgsql;