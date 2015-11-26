package PostoController;

import PostoModel.Posto;
import PostoModel.TableModelPosto;
import PostoView.PostoGUI;
import javax.swing.JOptionPane;

/**
 *
 * @author Zilly
 */
public class PostoController {
    private PostoGUI view;
    private TableModelPosto tabelaPosto;

    public PostoController(PostoGUI view, TableModelPosto tabelaPosto) {
        this.view = view;
        this.tabelaPosto = tabelaPosto;
    }
    
    private Posto constroiPosto() {
        try {
            Posto p = new Posto();
            p.setCnpj(view.getJtCnpj().getText());
            p.setRazaoSocial(view.getJtRazaoSocial().getText());
            p.setNomeFantasia(view.getJtNomeFantasia().getText());
            p.setBandeira(view.getJtBandeira().getText());
            p.setEndereco(view.getJtEndereco().getText());
            p.setBairro(view.getJtBairro().getText());
            p.setCep(view.getJtCep().getText());
            //p.setImagem();
            return p;
        } catch (NumberFormatException|NullPointerException e) {
            JOptionPane.showMessageDialog(view, "Dado(s) de entrada invalido(s)!");
        }
        return null;
    }
    
    public void add(){
        Posto novo = constroiPosto();
        if (novo != null) {
            tabelaPosto.add(novo);
            clear();
        }
    }
    
    public void update(){
        int row = view.getJtPostos().getSelectedRow();
        if (row >= 0) {
            Posto p = constroiPosto();
            if (p != null) {
                tabelaPosto.update(row, p);
            }
        }
    }
    
    public void delete(){
        int row = view.getJtPostos().getSelectedRow();
        if (row >= 0) {
            tabelaPosto.remove(row);
            clear();
        }
    }
    
    public void clear(){
        view.getJtCnpj().setText("");
        view.getJtRazaoSocial().setText("");
        view.getJtNomeFantasia().setText("");
        view.getJtBandeira().setText("");
        view.getJtEndereco().setText("");
        view.getJtBairro().setText("");
        view.getJtCep().setText("");
        view.getJtPostos().clearSelection();
        view.getImgPosto().setIcon(null);
        view.getBtnRemover().setEnabled(false);
        view.getBtnAlterar().setEnabled(false);
    }
    
    public void select(){
        int row = view.getJtPostos().getSelectedRow();
        if (row >= 0) {
            Posto p = view.getTabelaPosto().select(row);
            view.getJtCnpj().setText(p.getCnpj());
            view.getJtRazaoSocial().setText(p.getRazaoSocial());
            view.getJtNomeFantasia().setText(p.getNomeFantasia());
            view.getJtBandeira().setText(p.getBandeira());
            view.getJtEndereco().setText(p.getEndereco());
            view.getJtBairro().setText(p.getBairro());
            view.getJtCep().setText(p.getCep());
            
            view.getImgPosto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + p.getImagem())));
            
            view.getBtnRemover().setEnabled(true);
            view.getBtnAlterar().setEnabled(true);
        }
    }
}
