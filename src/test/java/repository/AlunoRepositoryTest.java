package repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import model.Aluno;
import model.Disciplina;

public class AlunoRepositoryTest {

	private static List<Aluno> listaAluno = new ArrayList<>();

	@Test
	public List<Aluno> listar() {
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		
		aluno1.setNome("Gabriel");
		aluno1.setMatricula("01");
		
		aluno2.setNome("Volnei");
		aluno2.setMatricula("02");

		return listaAluno;
	}

	@Test
	public Aluno consultar() {
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();

		aluno1.setNome("Gabriel");
		aluno1.setSobrenome("Reis franzen");
		aluno1.setMatricula("01");

		aluno2.setNome("Volnei");
		aluno2.setSobrenome("Melo Nascimento");
		aluno2.setMatricula("02");

		listaAluno.add(aluno1);
		listaAluno.add(aluno2);

		for(Aluno aluno: listaAluno) {
			if(aluno.getMatricula() == "02") {
				return aluno;
			}
		}
		return null;
	}

	@Test
	public Aluno consultarNomeSobrenome() {
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();

		aluno1.setNome("Gabriel");
		aluno1.setSobrenome("Reis franzen");
		aluno1.setMatricula("01");

		aluno2.setNome("Volnei");
		aluno2.setSobrenome("Melo Nascimento");
		aluno2.setMatricula("02");

		listaAluno.add(aluno1);
		listaAluno.add(aluno2);
		
		for(Aluno aluno: listaAluno) {
			if(aluno.getNome() == "Gabriel" && aluno.getSobrenome() == "Reis Franzen") {
				return aluno;
			}
		}
		return null;
	}

	@Test
	public List<Aluno> consultarAlunosMatriculadosDisciplina() {
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		
		Disciplina matematica = new Disciplina();
		Disciplina portugues = new Disciplina();
		
		matematica.setId(1);
		portugues.setId(2);
		
		aluno1.setNome("Gabriel");
		aluno1.setSobrenome("Reis franzen");
		aluno1.setMatricula("01");
		
		aluno1.getDisciplinas().add(matematica);
		aluno1.getDisciplinas().add(portugues);
		
		aluno2.setNome("Volnei");
		aluno2.setSobrenome("Melo Nascimento");
		aluno2.setMatricula("02");
		
		listaAluno.add(aluno1);
		listaAluno.add(aluno2);
		
		List<Aluno> matriculados = new ArrayList<>();
		for(Aluno aluno: listaAluno) {
			for (Disciplina disciplina: aluno.getDisciplinas()) {
				if(disciplina.getId() == 2) {
					matriculados.add(aluno);
				}
			}
			
		}
		return matriculados;
	}

	@Test
	public String cadastrar() {
		Aluno aluno = new Aluno();
		
		aluno.setNome("Gabriel");
		aluno.setSobrenome("Reis franzen");
		aluno.setMatricula("01");

		Disciplina matematica = new Disciplina();
		Disciplina portugues = new Disciplina();
		
		aluno.getDisciplinas().add(matematica);
		aluno.getDisciplinas().add(portugues);
		
		listaAluno.add(aluno);
		return aluno.toString();
	}

	@Test
	public String matricularDisciplina() {
		Aluno Gabriel = new Aluno();

		Gabriel.setNome("Gabriel");
		Gabriel.setSobrenome("Reis franzen");
		Gabriel.setMatricula("01");

		Disciplina matematica = new Disciplina();
		Disciplina portugues = new Disciplina();

		Gabriel.getDisciplinas().add(matematica);

		for(Aluno aluno: listaAluno) {
			if(aluno.getMatricula() == "01") {
				aluno.getDisciplinas().add(portugues);
				return aluno.toString();
			}
		}
		return null;
	}

	@Test
	public Aluno atualizar() {
		Aluno aluno2 = new Aluno();

		aluno2.setNome("Volnei");
		aluno2.setSobrenome("Melo Nascimento");
		aluno2.setMatricula("02");
		
		listaAluno.add(aluno2);
		return aluno2;
	}
	
	@Test
	public void remover(Aluno aluno) {
		Aluno aluno1 = new Aluno();

		aluno1.setNome("Gabriel");
		aluno1.setSobrenome("Reis Franzen");
		aluno1.setMatricula("01");
		
		Aluno atual = aluno1;
		listaAluno.remove(atual);
	}

	@Test
	public String desmatricularDisciplina() {
		Aluno aluno = new Aluno();
		
		aluno.setNome("Gabriel");
		aluno.setSobrenome("Reis franzen");
		aluno.setMatricula("01");
		
		Disciplina portugues = new Disciplina();
		portugues.setId(1);
		
		Disciplina matematica = new Disciplina();
		portugues.setId(2);
		
		aluno.getDisciplinas().add(portugues);
		aluno.getDisciplinas().add(matematica);
		
		Disciplina disciplina_desmatricular = matematica;
		
		listaAluno.add(aluno);
		
		Aluno aluno_matricula = aluno; 

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
