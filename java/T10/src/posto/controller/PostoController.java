package posto.controller;

import file.dao.CombustivelDao;
import java.io.File;
import java.util.ArrayList;
import posto.model.Combustivel;
import posto.model.TableModelCombustivel;
import posto.model.Posto;
import posto.model.TableModelPosto;
import posto.view.PostoGUI;
import file.dao.PostoDao;

/**
 * @author Zilly
 */
public class PostoController {

    private PostoGUI view;
    private TableModelPosto tabelaPosto;
    private TableModelCombustivel tabelaComb;

    //Construtor do Controller
    public PostoController(PostoGUI view, TableModelPosto tabelaPosto, TableModelCombustivel tabelaComb) {
        this.view = view;
        this.tabelaPosto = tabelaPosto;
        this.tabelaComb = tabelaComb;

        view.setTitle("Postos de Combustível"); // Atualiza o título da janela.
        view.setResizable(false); // Fixa o tamanho da janela.
    }

    //-------------------------Métodos relacionados ao Posto
    //Constrói um novo Posto
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
            p.setHistorico(view.getJtHistorico().getText());
            p.setCombustiveis(new ArrayList<>());
            return p;
        } catch (NumberFormatException | NullPointerException e) {
            view.showError("Dado(s) de entrada invalido(s)!");
            return null;
        }
    }

    //Adiciona um novo Posto
    public void addPosto() {
        Posto novo = constroiPosto();
        if (novo != null) {
            tabelaPosto.add(novo);
            clearPosto();
        }
    }

    //Atualiza um Posto
    public void updatePosto() {
        int row = view.getJtTabelaPosto().getSelectedRow();
        if (row >= 0) {
            Posto p = constroiPosto();
            if (p != null) {
                tabelaPosto.update(row, p);
            }
        }
    }

    //Deleta um Posto
    public void deletePosto() {
        int row = view.getJtTabelaPosto().getSelectedRow();
        if (row >= 0) {
            tabelaPosto.remove(row);
            clearPosto();
        }
    }

    //Limpa todos os TextFields do Posto e do Combustível
    public void clearPosto() {
        //Posto
        view.getJtCnpj().setText("");
        view.getJtRazaoSocial().setText("");
        view.getJtNomeFantasia().setText("");
        view.getJtBandeira().setText("");
        view.getJtEndereco().setText("");
        view.getJtBairro().setText("");
        view.getJtCep().setText("");
        view.getJtHistorico().setText("");
        view.getJtTabelaPosto().clearSelection();
        view.getImgPosto().setIcon(null);
        view.getImgPosto().setText("");
        view.getBtnRemoverPosto().setEnabled(false);
        view.getBtnAlterarPosto().setEnabled(false);

        //Combustivel
        tabelaComb = new TableModelCombustivel();
        view.getJtTabelaComb().setModel(tabelaComb);
        view.getJtTipoComb().setText("");
        view.getJtDataColeta().setText("");
        view.getJtPrecoVenda().setText("");
        view.getBtnRemoverComb().setEnabled(false);
        view.getBtnAlterarComb().setEnabled(false);
        view.getBtnInserirComb().setEnabled(false);
        view.getBtnLimparComb().setEnabled(false);

    }

    //Seleciona um Posto
    public void selectPosto() {
        int row = view.getJtTabelaPosto().getSelectedRow();
        if (row >= 0) {
            //Posto
            Posto p = tabelaPosto.select(row);
            view.getJtCnpj().setText(p.getCnpj());
            view.getJtRazaoSocial().setText(p.getRazaoSocial());
            view.getJtNomeFantasia().setText(p.getNomeFantasia());
            view.getJtBandeira().setText(p.getBandeira());
            view.getJtEndereco().setText(p.getEndereco());
            view.getJtBairro().setText(p.getBairro());
            view.getJtCep().setText(p.getCep());
            view.getJtHistorico().setText(p.getHistorico());

            view.getImgPosto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/file/img/" + p.getImagem())));
            view.getImgPosto().setText(p.getImagem());

            view.getBtnRemoverPosto().setEnabled(true);
            view.getBtnAlterarPosto().setEnabled(true);

            //Combustivel
            tabelaComb = new TableModelCombustivel(p.getCombustiveis());
            view.getJtTabelaComb().setModel(tabelaComb);
            view.getJtTipoComb().setText("");
            view.getJtDataColeta().setText("");
            view.getJtPrecoVenda().setText("");
            view.getBtnInserirComb().setEnabled(true);
            view.getBtnLimparComb().setEnabled(true);
        }
    }

    //Abre o FileChooser para seleção da imagem
    public void selectImg() {
        view.getFc().showOpenDialog(view);
        File f = view.getFc().getSelectedFile();
        if (f != null) {
            String path = pathParser(f.getPath());
            view.getImgPosto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/file/img/" + path)));
            view.getImgPosto().setText(path);
        }
    }

    //Função que retorna somente o nome do arquivo
    private String pathParser(String path) {
        String pathR = path.replace("\\", "/");
        String[] split = pathR.split("/");
        return split[split.length - 1];
    }

    //-------------------Métodos relacionados aos Combustíveis
    //Constrói um novo Combustível
    private Combustivel constroiComb() {
        try {
            Combustivel c = new Combustivel();
            c.setTipo(view.getJtTipoComb().getText());
            c.setDataColeta(view.getJtDataColeta().getText());
            c.setPrecoVenda(Float.parseFloat(view.getJtPrecoVenda().getText()));
            return c;
        } catch (NumberFormatException | NullPointerException e) {
            view.showError("Dado(s) de combustível invalido(s)!");
            return null;
        }
    }

    //Adiciona um novo Combustível
    public void addComb() {
        Combustivel novo = constroiComb();
        if (novo != null) {
            tabelaComb.add(novo);
            clearComb();
        }
    }

    //Atualiza um Combustível
    public void updateComb() {
        int row = view.getJtTabelaComb().getSelectedRow();
        if (row >= 0) {
            Combustivel c = constroiComb();
            if (c != null) {
                tabelaComb.update(row, c);
            }
        }
    }

    //Deleta um Combustível
    public void deleteComb() {
        int row = view.getJtTabelaComb().getSelectedRow();
        if (row >= 0) {
            tabelaComb.remove(row);
            clearComb();
        }
    }

    //Reseta os TextFields dos Combustíveis
    public void clearComb() {
        view.getJtTipoComb().setText("");
        view.getJtDataColeta().setText("");
        view.getJtPrecoVenda().setText("");
        view.getBtnRemoverComb().setEnabled(false);
        view.getBtnAlterarComb().setEnabled(false);
        view.getJtTabelaComb().clearSelection();
    }

    //Seleção do Combustível
    public void selectComb() {
        int row = view.getJtTabelaComb().getSelectedRow();
        if (row >= 0) {
            //Posto
            Combustivel c = tabelaComb.select(row);
            view.getJtTipoComb().setText(c.getTipo());
            view.getJtDataColeta().setText(c.getDataColeta());
            view.getJtPrecoVenda().setText(c.getPrecoVenda() + "");

            view.getBtnRemoverComb().setEnabled(true);
            view.getBtnAlterarComb().setEnabled(true);
        }
    }

    //Método para salvar arquivos - o de postos por padrão fica com nome "postos.csv" - os históricos podem ser alterados
    public void salvarArq() {
        PostoDao.salvarPostos("postos.csv", tabelaPosto.getPostos());
        for (Posto posto : tabelaPosto.getPostos()) {
            CombustivelDao.salvarCombustiveis(posto.getHistorico(), posto.getCombustiveis());
        }
    }

    //Pesquisa por bairro
    public void pesquisa() {
        clearPosto();
        ArrayList<Posto> listPronta = new ArrayList<>();
        for (Posto posto : tabelaPosto.getPostos()) {
            if (posto.getBairro().toLowerCase().contains(view.getJtPesquisa().getText().toLowerCase())) {
                listPronta.add(posto);
            }
        }
        tabelaPosto = new TableModelPosto(listPronta);
        view.getJtTabelaPosto().setModel(tabelaPosto);
    }

    //Recarrega a tabelaPosto com dados do arquivo
    public void resetaPesquisa() {
        clearPosto();
        view.getJtPesquisa().setText("");
        tabelaPosto = new TableModelPosto();
        view.getJtTabelaPosto().setModel(tabelaPosto);
    }
}
