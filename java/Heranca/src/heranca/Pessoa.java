package heranca;

/**
 * Represetacao simples de uma pessoa.
 *
 * @author andrea
 */
public class Pessoa {

    protected String nome;

    public Pessoa() {
        nome = "";
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void mostra() {
        System.out.println("Nome: " + nome);
    }
}
