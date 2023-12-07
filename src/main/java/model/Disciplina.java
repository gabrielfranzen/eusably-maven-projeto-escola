package model;

public class Disciplina {
    private Integer id;
    private String nome;
    private String descricao;
    private String professor;

    public String toString() {
        return "Disciplina {" +
                "id= " + id +
                ", descricao= " + descricao +
                ", professor= " + professor +" }";
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

}