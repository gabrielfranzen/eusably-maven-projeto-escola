package repositoryTests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import model.Endereco;
import repository.EnderecoRepository;

public class EnderecoRepositoryTest {

	private EnderecoRepository enderecoRepository = new EnderecoRepository();
	private Gson gson = new Gson();
	
	@Test
	public void cadastrar() {
		Endereco endereco = new Endereco();
		endereco.setId(1);
		endereco.setEstado("SC");
		endereco.setMunicipio("Garopaba");
		endereco.setBairro("Centro");
		endereco.setLogradouro("30 de Dezembro");
		endereco.setNumero("359");
		endereco.setCep("88495000");
		
		int id = this.enderecoRepository.cadastrar(endereco);
		System.out.println(String.format("ID registrado: %d", id));
		Assert.assertTrue(id > 0);
		
	}

	@Test
	public void atualizar() {
		Endereco endereco = new Endereco();
		endereco.setId(1);
		endereco.setEstado("SC");
		endereco.setMunicipio("Garopaba");
		endereco.setBairro("Centro");
		endereco.setLogradouro("30 de Novembro");
		endereco.setNumero("380");
		endereco.setCep("88495000");
		
		Endereco atualizado = this.enderecoRepository.atualizar(endereco);
		System.out.println(this.gson.toJson(atualizado));
		Assert.assertTrue(atualizado != null);
		
	}

	@Test
	public void listar() {
		this.cadastrar();
		List<Endereco> lista = this.enderecoRepository.listar();		
		System.out.println(this.gson.toJson(lista));
		
	}

	@Test
	public void consultar() {
		this.cadastrar();
		Endereco endereco = this.enderecoRepository.consultar("88495000");		
		System.out.println(this.gson.toJson(endereco));
		Assert.assertTrue(endereco != null);
		
	}

	@Test
	public void remover() throws Exception {
		Endereco endereco = new Endereco();
		endereco.setCep("10101010");
		enderecoRepository.cadastrar(endereco);
		this.enderecoRepository.remover(endereco.getCep());
		
	}
}
