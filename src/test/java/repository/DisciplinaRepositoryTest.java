package repository;

import java.util.ArrayList;
import java.util.List;

import model.Disciplina;


public class DisciplinaRepositoryTest {

	private static List<Disciplina> listaDisciplina = new ArrayList<>();
	
	public List<Disciplina> listar() {
		Disciplina matematica = new Disciplina();
		Disciplina portugues = new Disciplina();
		
		matematica.setNome("Matemática");
		matematica.setId(1);
		
		portugues.setNome("Português");
		matematica.setId(2);
		
		listaDisciplina.add(matematica);
		listaDisciplina.add(portugues);

		return listaDisciplina;
	}

	public Disciplina consultar() {
		Disciplina matematica = new Disciplina();
		Disciplina portugues = new Disciplina();
		
		matematica.setNome("Matemática");
		matematica.setId(1);
		
		portugues.setNome("Português");
		matematica.setId(2);
		
		listaDisciplina.add(matematica);
		listaDisciplina.add(portugues);
		
		for(Disciplina disciplina: listaDisciplina) {
			if(disciplina.getId() == 2) {
				return disciplina;
			}
		}
		return null;
	}

	public String cadastrar() {
		Disciplina matematica = new Disciplina();
		Disciplina portugues = new Disciplina();
		
		matematica.setNome("Matemática");
		matematica.setId(1);
		listaDisciplina.add(matematica);
		
		portugues.setNome("Português");
		
		int maxId = listaDisciplina.size() + 1;
		portugues.setId(maxId);
		
		listaDisciplina.add(portugues);
		return portugues.toString();
	}
	
	public String atualizar() {
		Disciplina matematica = new Disciplina();
		
		matematica.setNome("Matemática");
		matematica.setId(1);
		listaDisciplina.add(matematica);
		
		return matematica.toString();
	}

	public void remover() {
		
		Disciplina matematica = new Disciplina();
		
		matematica.setNome("Matemática");
		matematica.setId(1);
		
		Disciplina atual = matematica;
		
		listaDisciplina.remove(atual);
	}
}
