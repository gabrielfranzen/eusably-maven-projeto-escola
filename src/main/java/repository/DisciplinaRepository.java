package repository;

import java.util.ArrayList;
import java.util.List;

import model.Disciplina;


public class DisciplinaRepository {

	private static List<Disciplina> listaDisciplina = new ArrayList<>();
	
	public List<Disciplina> listar() {
		return listaDisciplina;
	}

	public Disciplina consultar(Integer id) {
		for(Disciplina disciplina: listaDisciplina) {
			if(disciplina.getId() == id) {
				return disciplina;
			}
		}
		return null;
	}

	public String cadastrar(Disciplina novo) {
		int maxId = listaDisciplina.size() + 1;
		novo.setId(maxId);
		listaDisciplina.add(novo);
		return novo.toString();
	}
	
	public Disciplina atualizar(Disciplina novo) {	
		listaDisciplina.add(novo);		
		return novo;
	}

	public void remover(Disciplina disciplina) throws Exception {
		Disciplina atual = this.consultar(disciplina.getId());
		if(atual == null)
			throw new Exception("Disciplina não encontrada");
		
		listaDisciplina.remove(atual);
	}
}
