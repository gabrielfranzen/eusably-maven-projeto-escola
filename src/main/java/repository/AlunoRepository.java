package repository;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Disciplina;
import model.Endereco;

public class AlunoRepository {

	private static List<Aluno> listaAluno = new ArrayList<>();
	
	public List<Aluno> listar() {
		return listaAluno;
	}

	public Aluno consultar(String matricula) {
		for(Aluno aluno: listaAluno) {
			if(aluno.getMatricula() == matricula) {
				return aluno;
			}
		}
		return null;
	}
	
	public Aluno consultarNomeSobrenome(String nome, String sobrenome) {
		for(Aluno aluno: listaAluno) {
			if(aluno.getNome() == nome && aluno.getSobrenome() == sobrenome) {
				return aluno;
			}
		}
		return null;
	}
	
	public List<Aluno> consultarAlunosMatriculadosDisciplina(Integer id_disciplina) {
		List<Aluno> matriculados = new ArrayList<>();
		
		for(Aluno aluno: listaAluno) {
			for (Disciplina disciplina: aluno.getDisciplinas()) {
				if(disciplina.getId() == id_disciplina) {
					matriculados.add(aluno);
				}
			}
			
		}
		return matriculados;
	}


	public String cadastrar(Aluno novo) {
		listaAluno.add(novo);
		return novo.toString();
	}
	
	public String matricularDisciplina(String matricula_aluno, Disciplina disciplina_matricular) {
		for(Aluno aluno: listaAluno) {
			if(aluno.getMatricula() == matricula_aluno) {
				aluno.getDisciplinas().add(disciplina_matricular);
			}
		}
		
		return null;
	}
	
	
	public Aluno atualizar(Aluno novo) {	
		listaAluno.add(novo);		
		return novo;
	}

	
	public void remover(Aluno aluno) throws Exception {
		Aluno atual = this.consultar(aluno.getMatricula());
		if(atual == null)
			throw new Exception("Aluno não encontrado");
		
		listaAluno.remove(atual);
	}
	
	
	public Endereco atualizarEndereco(String matricula, Endereco endereco) {
		Aluno aluno = this.consultar(matricula);
		aluno.setEndereco(endereco);
		return aluno.getEndereco();
	}
	
	
	public String desmatricularDisciplina(String matricula_aluno, Disciplina disciplina_desmatricular) throws Exception {
		
		Aluno aluno_matricula = this.consultar(matricula_aluno); 
		if(aluno_matricula == null)
			throw new Exception("Aluno não encontrado");
		
		
		for(Disciplina disciplina: aluno_matricula.getDisciplinas()) {
			if(disciplina.getId() == disciplina_desmatricular.getId()) {
				aluno_matricula.getDisciplinas().remove(disciplina);
				return ("Aluno " + aluno_matricula.getNome() + 
						" " + aluno_matricula.getSobrenome() + 
						"Desmatriculado de " + disciplina.getNome() +
						" com sucesso.");
			}
		}
		
		return null;
	}
}
