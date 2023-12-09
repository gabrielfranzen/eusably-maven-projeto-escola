package repositoryTests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import model.Aluno;
import model.Disciplina;
import model.Endereco;
import repository.AlunoRepository;


public class AlunoRepositoryTest {
	
	private AlunoRepository alunoRepository = new AlunoRepository();
	private Gson gson = new Gson();


	@Test
	public void cadastrar() {
		
		Aluno aluno = new Aluno();
		aluno.setMatricula("01");
		aluno.setNome("Gabriel");
		aluno.setSobrenome("Reis Franzen");
		
		Disciplina portugues = new Disciplina();
		portugues.setId(1);
		portugues.setNome("Português");
		
		aluno.adicionarDisciplina(portugues);
		
		String matricula = this.alunoRepository.cadastrar(aluno);
		System.out.printf("Matrícula registrada: "+ matricula);
		Assert.assertTrue(matricula != null);
		
	}
	
	
	@Test
	public void atualizar() {
		
		Aluno aluno = new Aluno();
		aluno.setMatricula("01");
		aluno.setNome("Gabriel");
		aluno.setSobrenome("Reis Franzen");
		
		Aluno atualizado = this.alunoRepository.atualizar(aluno);
		System.out.println(this.gson.toJson(atualizado));
		Assert.assertTrue(atualizado != null);
		
	}
	
	@Test
	public void atualizarEndereco() {
		
		this.cadastrar();
		Endereco endereco = new Endereco();
		
		Endereco atualizado = this.alunoRepository.atualizarEndereco("01", endereco);
		System.out.println(this.gson.toJson(atualizado));
		Assert.assertTrue(atualizado != null);
		
	}
	
	
	@Test
	public void listar() {
		this.cadastrar();
		List<Aluno> lista = this.alunoRepository.listar();		
		System.out.println(this.gson.toJson(lista));		
	
	}

	@Test
	public void consultar() {
		this.cadastrar();
		Aluno aluno = this.alunoRepository.consultar("01");		
		System.out.println(this.gson.toJson(aluno));
		Assert.assertTrue(aluno != null);

	}

	@Test
	public void consultarNomeSobrenome() {
		this.cadastrar();		
		Aluno aluno = this.alunoRepository.consultarNomeSobrenome("Gabriel", "Reis Franzen");
		System.out.println(this.gson.toJson(aluno));
		Assert.assertTrue(aluno != null);
		
	}

	@Test
	public void consultarAlunosMatriculadosDisciplina() {
		this.cadastrar();
		List<Aluno> matriculados = this.alunoRepository.consultarAlunosMatriculadosDisciplina(1);
		
		for(Aluno aluno: matriculados) {
			System.out.println(this.gson.toJson(aluno));			
		}
		Assert.assertTrue(matriculados != null);
		
	}
	
	
	@Test
	public void remover() throws Exception {
		this.cadastrar();
		Aluno aluno = new Aluno();
		aluno.setMatricula("01");
		this.alunoRepository.remover(aluno.getMatricula());
		
	}

	

	@Test
	public void matricularDisciplina() {
		this.cadastrar();
		
		Disciplina matematica = new Disciplina();
		matematica.setId(2);
		matematica.setNome("Matemática");
		
		Aluno aluno = this.alunoRepository.matricularDisciplina("01", matematica);		
		System.out.println(this.gson.toJson(aluno));
		Assert.assertTrue(aluno != null);
		
	}

	
	
	@Test
	public void desmatricularDisciplina() throws Exception {
		this.cadastrar();
		
		Aluno aluno = this.alunoRepository.desmatricularDisciplina("01", 1);		
		System.out.println(this.gson.toJson(aluno));
		
	}
}
