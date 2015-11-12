package heranca;

/**
 * Estudante: especializacao de Pessoa
 *
 * @author andrea
 */
public class Estudante extends Pessoa {

    private String curso;

    public Estudante() {
        curso = "";
    }

    public Estudante(String nome, String curso) {
        //this.nome = nome;
        super(nome);
        this.curso = curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void mostra() {
        super.mostra();
        System.out.println("Curso: " + curso);
    }
}
