import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Exemplo de construção de interface auxílio de IDE para a construção da
 * interface gráfica.
 *
 * @author alberto.
 */
public class SemIDE extends JFrame {

    private int contagemCliques;
    private JButton btnIncrementa;
    private JButton btnDecrementa;
    private GridLayout layout;

    /**
     * Método construtor. Cria uma nova janela.
     */
    public SemIDE() {
        super("Exemplo construído sem IDE (0)");
        contagemCliques = 0;
        criaComponentes();
    }

    /**
     * Método que monta a interface. Adiciona os componentes, define
     * configurações de layout e vincula os eventos aos métodos que devem ser
     * executados.
     */
    private void criaComponentes() {
        // Inicialização da JFrame.
        this.setMinimumSize(new Dimension(320, 240));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new GridLayout(1, 2);
        
        this.setLayout(layout);

        // Cria um botão e põe na tela.
        btnIncrementa = new JButton("Incrementa!");
        this.getContentPane().add(btnIncrementa);

        btnDecrementa = new JButton("Decrementa!");
        this.getContentPane().add(btnDecrementa); 
        
        this.add(btnIncrementa);
        this.add(btnDecrementa);

        // Registra a ação a ser executada ao pressionar o botão.
        btnIncrementa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIncrementaClicado(e);
                atualizaTitulo();
            }
        });
        
        btnDecrementa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                btnDecrementaClicado(e);
                atualizaTitulo();
            }
        });

        // Avisa ao gerenciador de layout que não há novos componentes a serem adicionados.
        this.pack();
    }

    /**
     * Método tratador de evento de clique do mouse no botão. Esse método
     * incrementa um contador e atualiza o texto do botão na tela com o valor
     * corrente.
     *
     * @param evt Evento gerado pelo SWING.
     */
    private void btnIncrementaClicado(ActionEvent evt) {
        this.contagemCliques += 1;
    }
    
    private void btnDecrementaClicado(ActionEvent evt){
        this.contagemCliques -=1;
    }
    
    private void atualizaTitulo(){
        this.setTitle("Exemplo construído sem IDE (" + contagemCliques + ")");
    }

    /**
     * Método estático main. Cria o programa e lança uma instância de SemIDE na
     * tela.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SemIDE tela = new SemIDE();
                tela.setVisible(true);
            }
        });
    }

}
