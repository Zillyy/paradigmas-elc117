package posto.model;

import file.dao.PostoDao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @author Zilly
 */
public class TableModelPosto extends AbstractTableModel {

    // Lista de veículos
    private ArrayList<Posto> postos;

    // Array com os nomes das colunas da tabela.
    private static final String[] nomeColunas = {"CNPJ", "Razão Social", "Nome Fantasia", "Bandeira", "Endereço", "Bairro", "CEP"};

    //Construtor Padrão
    public TableModelPosto() {
        postos = PostoDao.getArrayCombs("postos.csv");
    }

    //Adiciona um novo posto
    public void add(Posto p) {
        postos.add(p);
        fireTableRowsInserted(postos.size() - 1, postos.size() - 1);
    }

    //Seleciona um objeto Posto na rowSelected passada
    public Posto select(int rowSelected) {
        return postos.get(rowSelected);
    }

    //Remove o objeto Posto que está na rowSelected
    public void remove(int rowSelected) {
        postos.remove(rowSelected);
        fireTableRowsDeleted(rowSelected, rowSelected);
    }

    //Atualiza um objeto Posto
    public void update(int rowSelected, Posto p) {
        postos.set(rowSelected, p);
        fireTableRowsUpdated(rowSelected, rowSelected);
    }

    
    //Pega o nome de uma coluna da tabela
    @Override
    public String getColumnName(int columnIndex) {
        return nomeColunas[columnIndex];
    }

    //Retorna o número de linhas da tabela
    @Override
    public int getRowCount() {
        return postos.size();
    }

    //Retorna o número de colunas da tabela
    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    //Retorna o objeto posto que está na rowIndex e columnIndex passada
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Posto p = postos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getCnpj();
            case 1:
                return p.getRazaoSocial();
            case 2:
                return p.getNomeFantasia();
            case 3:
                return p.getBandeira();
            case 4:
                return p.getEndereco();
            case 5:
                return p.getBairro();
            case 6:
                return p.getCep();
            case 7:
                return p.getImagem();
        }
        return null;
    }
}
