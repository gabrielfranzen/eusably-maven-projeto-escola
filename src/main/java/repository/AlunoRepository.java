package repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import model.Aluno;
import model.Disciplina;
import model.Endereco;

@Stateful
public class AlunoRepository {

	private static List<Aluno> listaAluno = new ArrayList<>();
	
	public String cadastrar(Aluno novo) {
		listaAluno.add(novo);
		return novo.getMatricula();
	}
	
	public Aluno atualizar(Aluno novo) {	
		listaAluno.add(novo);		
		return novo;
	}

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
	
	public void remover(String matricula) throws Exception {
		Aluno atual = this.consultar(matricula);
		if(atual == null)
			throw new Exception("Aluno não encontrado");
		
		listaAluno.remove(atual);
	}

	public Aluno matricularDisciplina(String matricula_aluno, Disciplina disciplina_matricular) {
		Aluno aluno = this.consultar(matricula_aluno);
		aluno.getDisciplinas().add(disciplina_matricular);
		
		return aluno;
	}
	
	
	public Endereco atualizarEndereco(String matricula, Endereco endereco) {
		Aluno aluno = this.consultar(matricula);
		aluno.setEndereco(endereco);
		return aluno.getEndereco();
	}
	
	
	public Aluno desmatricularDisciplina(String matricula_aluno, Integer disciplina_desmatricular) throws Exception {
		
		Aluno aluno_matriculado = this.consultar(matricula_aluno); 
		if(aluno_matriculado == null)
			throw new Exception("Aluno não encontrado");
		
		
		Disciplina remover = new Disciplina();
		for(Disciplina disciplina: aluno_matriculado.getDisciplinas()) {
			if(disciplina.getId() == disciplina_desmatricular) {
				remover = disciplina;
				System.out.println("TEste achou");
			}
		}
		
		aluno_matriculado.getDisciplinas().remove(remover);

		return aluno_matriculado;
	}
}
