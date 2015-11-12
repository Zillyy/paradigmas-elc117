package heranca;

/**
 * Professor: especializacao de Pessoa
 *
 * @author andrea
 */
public class Professor extends Pessoa {

    private boolean emFerias;

    public Professor() {
        emFerias = false;
    }

    public Professor(String nome) {
        // a completar
    }

    public void comecaFerias() {
        emFerias = true;
    }

    public void terminaFerias() {
        emFerias = false;
    }
    
    public void mostra() {
        super.mostra();
        System.out.println("Em ferias: " + emFerias);
    }
}
