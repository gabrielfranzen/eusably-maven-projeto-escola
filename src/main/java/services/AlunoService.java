package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Aluno;
import model.Disciplina;
import model.Endereco;
import repository.AlunoRepository;

@Path("/aluno")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AlunoService {

	@Inject
	private AlunoRepository alunoRepository;

	@GET
	public Response listar() {
		return Response.ok().entity(this.alunoRepository.listar()).build();
	}

	@GET
	@Path("/{matricula}")
	public Response consultar(@PathParam("matricula") String matricula) {
		return Response.ok().entity(this.alunoRepository.consultar(matricula)).build();
	}
	
	@GET
	@Path("/matriculas-disciplinas/{id_disciplina}")
	public Response consultarAlunosMatriculadosDisciplina(@PathParam("id_disciplina") Integer id_disciplina) {
		return Response.ok().entity(this.alunoRepository.consultarAlunosMatriculadosDisciplina(id_disciplina)).build();
	}
	
	@GET
	@Path("/nome")
	public Response consultarNomeSobrenome(String nome, String sobrenome ) {
		return Response.ok().entity(this.alunoRepository.consultarNomeSobrenome(nome, sobrenome)).build();
	}

	@POST
	public Response cadastrar(Aluno novo) {
		return Response.ok().entity(this.alunoRepository.cadastrar(novo)).build();
	}



	@PUT
	public Response atualizar(Aluno aluno) {
		try {
			this.alunoRepository.remover(aluno);
			return Response.ok(this.alunoRepository.atualizar(aluno)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@PUT
	@Path("/endereco/{matricula}")
	public Response atualizarEndereco(@PathParam("matricula") String matricula, Endereco endereco) {
		try {
			return Response.ok(this.alunoRepository.atualizarEndereco(matricula, endereco)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	@PUT
	@Path("/matricular/{matricula_aluno}")
	public Response matricularDisciplina(String matricula_aluno, Disciplina disciplina_matricular) {
		return Response.ok().entity(this.alunoRepository.matricularDisciplina(matricula_aluno, disciplina_matricular)).build();
	}
	
	@PUT
	@Path("/desmatricular/{matricula_aluno}")
	public Response desmatricularDisciplina(String matricula_aluno, Disciplina disciplina_desmatricular) {
		return Response.ok().entity(this.alunoRepository.matricularDisciplina(matricula_aluno, disciplina_desmatricular)).build();
	}
	
	
	@DELETE
	public Response remover(Aluno aluno) {
		try {
			this.alunoRepository.remover(aluno);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
}
