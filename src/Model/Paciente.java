/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ariel
 */
public class Paciente {

    private long id;
    private String nome;
    private int idade;
    private String dataNasc;
    private String sexo;
    private String nomePai;
    private String nomeMae;
    private String escolaridade;
    private long id_usuario;

    public Paciente(long id, String nome, int idade, String dataNasc, String sexo, String nomePai, String nomeMae, String escolaridade, long id_usuario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.escolaridade = escolaridade;
        this.id_usuario = id_usuario;
    }


    public Paciente() {
        super();
        // TODO Auto-generated constructor stub
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

  

}
