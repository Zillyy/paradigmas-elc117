package posto.controller;

import java.io.File;
import javax.swing.JFileChooser;
import posto.model.Combustivel;
import posto.model.TableModelCombustivel;
import posto.model.Posto;
import posto.model.TableModelPosto;
import posto.view.PostoGUI;

/**
 * @author Zilly
 */
public class PostoController {

    private PostoGUI view;
    private TableModelPosto tabelaPosto;
    private TableModelCombustivel tabelaComb;

    public PostoController(PostoGUI view, TableModelPosto tabelaPosto, TableModelCombustivel tabelaComb) {
        this.view = view;
        this.tabelaPosto = tabelaPosto;
        this.tabelaComb = tabelaComb;

        view.setTitle("Postos de Combustível"); // Atualiza o título da janela.
        view.setResizable(false); // Fixa o tamanho da janela.
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
            p.setImagem(view.getImgPosto().getText());
            //p.setHistorico();
            return p;
        } catch (NumberFormatException | NullPointerException e) {
            view.showError("Dado(s) de entrada invalido(s)!");
            return null;
        }
    }

    private Combustivel constroiComb() {
        try {
            Combustivel c = new Combustivel();

            //c.setTipo();
            return c;
        } catch (NumberFormatException | NullPointerException e) {
            view.showError("Dado(s) de combustível invalido(s)!");
            return null;
        }
    }

    public void addPosto() {
        Posto novo = constroiPosto();
        if (novo != null) {
            tabelaPosto.add(novo);
            clearPosto();
        }
    }

    public void updatePosto() {
        int row = view.getJtTabelaPosto().getSelectedRow();
        if (row >= 0) {
            Posto p = constroiPosto();
            if (p != null) {
                tabelaPosto.update(row, p);
            }
        }
    }

    public void deletePosto() {
        int row = view.getJtTabelaPosto().getSelectedRow();
        if (row >= 0) {
            tabelaPosto.remove(row);
            clearPosto();
        }
    }

    public void clearPosto() {
        //Posto
        view.getJtCnpj().setText("");
        view.getJtRazaoSocial().setText("");
        view.getJtNomeFantasia().setText("");
        view.getJtBandeira().setText("");
        view.getJtEndereco().setText("");
        view.getJtBairro().setText("");
        view.getJtCep().setText("");
        view.getJtTabelaPosto().clearSelection();
        view.getImgPosto().setIcon(null);
        view.getImgPosto().setText("");
        view.getBtnRemover().setEnabled(false);
        view.getBtnAlterar().setEnabled(false);

        //Combustivel
        tabelaComb = new TableModelCombustivel();
        view.getJtTabelaComb().setModel(tabelaComb);
    }

    public void selectPosto() {
        int row = view.getJtTabelaPosto().getSelectedRow();
        if (row >= 0) {
            //Posto
            Posto p = view.getTabelaPosto().select(row);
            view.getJtCnpj().setText(p.getCnpj());
            view.getJtRazaoSocial().setText(p.getRazaoSocial());
            view.getJtNomeFantasia().setText(p.getNomeFantasia());
            view.getJtBandeira().setText(p.getBandeira());
            view.getJtEndereco().setText(p.getEndereco());
            view.getJtBairro().setText(p.getBairro());
            view.getJtCep().setText(p.getCep());

            view.getImgPosto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/file/img/" + p.getImagem())));
            view.getImgPosto().setText(p.getImagem());

            view.getBtnRemover().setEnabled(true);
            view.getBtnAlterar().setEnabled(true);

            //Combustivel
            tabelaComb = new TableModelCombustivel(p.getHistorico());
            view.getJtTabelaComb().setModel(tabelaComb);
        }
    }

    public void selectImg() {
        view.getFc().setFileSelectionMode(JFileChooser.FILES_ONLY);
        view.getFc().showOpenDialog(view);
        File f = view.getFc().getSelectedFile();
        System.out.println(pathParser(f.getPath()));

        //String path = f.get
        view.getImgPosto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/file/img/" + pathParser(f.getPath()))));
        view.getImgPosto().setText(pathParser(f.getPath()));
    }

    private String pathParser(String path) {
        String pathR = path.replace("\\", "/");
        String[] split = pathR.split("/");
        return split[split.length - 1];
    }
}
