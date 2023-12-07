package repository;

import java.util.ArrayList;
import java.util.List;

import model.Endereco;

public class EnderecoRepository {
	
	private static List<Endereco> listaEndereco = new ArrayList<>();
	
	public List<Endereco> listar() {
		return listaEndereco;
	}

	public Endereco consultar(String cep, String numero) {
		for(Endereco endereco: listaEndereco) {
			if(endereco.getCep() == cep && endereco.getNumero() == numero) {
				return endereco;
			}
		}
		return null;
	}

	public String cadastrar(Endereco novo) {
		int maxId = listaEndereco.size() + 1;
		novo.setId(maxId);
		listaEndereco.add(novo);
		return novo.toString();
	}
	
	public Endereco atualizar(Endereco endereco) {	
		listaEndereco.add(endereco);		
		return endereco;
	}

	
	public void remover(Endereco endereco) throws Exception {
		Endereco atual = this.consultar(endereco.getBairro(), endereco.getNumero());
		if(atual == null)
			throw new Exception("Endereço não encontrado");
		
		listaEndereco.remove(atual);
	}
}
