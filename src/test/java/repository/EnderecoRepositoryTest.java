package repository;

import java.util.ArrayList;
import java.util.List;

import model.Endereco;

public class EnderecoRepositoryTest {

	private static List<Endereco> listaEndereco = new ArrayList<>();
	
	public Void listar() {
		
		Endereco endereco1 = new Endereco();
		Endereco endereco2 = new Endereco();
		
		endereco1.setId(1);;
		endereco1.setCep("88495-000");;
		
		endereco2.setId(2);;
		endereco2.setCep("88495-000");;
		
		listaEndereco.add(endereco1);
		listaEndereco.add(endereco2);
		
		System.out.println(listaEndereco);
		return null;
	}

	public Void consultar() {
		
		Endereco endereco1 = new Endereco();
		Endereco endereco2 = new Endereco();
		
		endereco1.setId(1);;
		endereco1.setCep("88495-000");;
		
		endereco2.setId(2);;
		endereco2.setCep("88495-000");;
		
		listaEndereco.add(endereco1);
		listaEndereco.add(endereco2);
		
		String cep = endereco1.getCep();
		String numero = endereco1.getNumero();
		
		for(Endereco endereco: listaEndereco) {
			if(endereco.getCep() == cep && endereco.getNumero() == numero) {
				System.out.println(endereco);
			}
		}
		return null;
	}

	public Void cadastrar() {
		
		Endereco endereco1 = new Endereco();
		int maxId = listaEndereco.size() + 1;
		
		endereco1.setId(maxId);
		endereco1.setCep("88495-000");;
		
		listaEndereco.add(endereco1);
		System.out.println(endereco1.toString());
		return null;
	}
	
	public Void atualizar() {
		
		Endereco endereco = new Endereco();
		endereco.setId(1);
		endereco.setCep("88495-000");
		
		listaEndereco.add(endereco);
		System.out.println(listaEndereco);
		return null;

	}

	
	public Void remover()  {
		
		Endereco endereco = new Endereco();
		endereco.setId(1);
		endereco.setCep("88495-000");
		
		Endereco endereco2 = new Endereco();
		endereco2.setId(2);
		endereco2.setCep("88495-000");
		
		listaEndereco.add(endereco);
		listaEndereco.add(endereco2);
		
		Endereco atual = endereco2;
		listaEndereco.remove(atual);
		
		System.out.println(listaEndereco);
		return null;
	}
}
