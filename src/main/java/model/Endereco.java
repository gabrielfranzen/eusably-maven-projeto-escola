package model;

public class Endereco {
	
    private Integer id;
    private String logradouro;
    private String bairro;
    private String numero;
    private String municipio;
    private String estado;
    private String cep;
    
    @Override
    public String toString() {
        return "Endereco {" +
                "logradouro= " + logradouro +
                ", bairro= " + bairro +
                ", numero= " + numero +
                ", municipio= " + municipio +
                ", estado= " + estado +
                ", cep= " + cep +" }";
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}