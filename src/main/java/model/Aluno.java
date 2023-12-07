package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
    private String matricula;
    private String nome;
    private String sobrenome;
    private int idade;
    private Endereco endereco;
    private String serie;
    private String sexo;
    private static List<Disciplina> listaDisciplinas = new ArrayList<>();

    
    public String toString() {
        return "Aluno " + nome + " " + sobrenome + "{" +
                "idade= " + idade +
                ", endereco= " + endereco +
                ", serie= " + serie +
                ", sexo= " + sexo +
                ", disciplinas= " + listaDisciplinas +" }";
    }
    
    
    public void adicionarDisciplina(Disciplina disciplina) {
    	listaDisciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return listaDisciplinas;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}