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

import model.Disciplina;
import repository.DisciplinaRepository;

@Path("/disciplina")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DisciplinaService {

	@Inject
	private DisciplinaRepository disciplinaRepository;

	@GET
	public Response listar() {
		return Response.ok().entity(this.disciplinaRepository.listar()).build();
	}

	@GET
	@Path("/{id}")
	public Response consultar(@PathParam("id") Integer id) {
		return Response.ok().entity(this.disciplinaRepository.consultar(id)).build();
	}

	@POST
	public Response cadastrar(Disciplina novo) {
		return Response.ok().entity(this.disciplinaRepository.cadastrar(novo)).build();
	}

	@PUT
	public Response atualizar(Disciplina funcionario) {
		try {
			this.disciplinaRepository.remover(funcionario);
			return Response.ok(this.disciplinaRepository.atualizar(funcionario)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	public Response remover(Disciplina funcionario) {
		try {
			this.disciplinaRepository.remover(funcionario);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}
