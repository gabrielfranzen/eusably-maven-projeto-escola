package repository;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateful;

import model.Endereco;

@Stateful
public class EnderecoRepository {
	
	private static List<Endereco> listaEndereco = new ArrayList<>();
	
	public Integer cadastrar(Endereco novo) {
		int maxId = listaEndereco.size() + 1;
		novo.setId(maxId);
		
		listaEndereco.add(novo);
		return novo.getId();
	}
	
	public Endereco atualizar(Endereco endereco) {	
		listaEndereco.add(endereco);		
		return endereco;
	}
		
	public List<Endereco> listar() {
		return listaEndereco;
	}

	public Endereco consultar(String cep) {
		for(Endereco endereco: listaEndereco) {
			if(endereco.getCep() == cep) {
				return endereco;
			}
		}
		return null;
	}

	
	public void remover(String cep_endereco) throws Exception {
		Endereco atual = this.consultar(cep_endereco);
		if(atual == null)
			throw new Exception("Endereço não encontrado");
		
		listaEndereco.remove(atual);
	}
}
