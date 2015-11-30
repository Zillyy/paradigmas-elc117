package disciplinagui.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrea
 */
public class Disciplina {

    private int ano;
    private int semestre;
    private String nome;
    private float nota;

    public Disciplina() {
    }
    
    public Disciplina(int ano, int semestre, String nome, float nota) {
        this.ano = ano;
        this.semestre = semestre;
        this.nome = nome;
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

}
