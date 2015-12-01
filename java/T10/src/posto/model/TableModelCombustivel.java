package posto.model;

import file.manager.CSVReader;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @author Zilly
 */
public class TableModelCombustivel extends AbstractTableModel {

    // Lista de combustiveis
    private ArrayList<Combustivel> combs;

    // Array com os nomes das colunas da tabela
    private static final String[] nomeColunas = {"Tipo de Combustível", "Data de Coleta", "Preço de Venda"};

    //Construtor Padrão
    public TableModelCombustivel(){
        combs = new ArrayList<>();
    }
    
    //Construtor alternativo 1
    public TableModelCombustivel(ArrayList<Combustivel> listCombs){
        this.combs = listCombs;
    }
    
    //Construtor alternativo 2
    public TableModelCombustivel(String fileName) {
        //combs = new ArrayList<>();
        //Combustivel etanol = new Combustivel("Etanol", "31/01/2015", 2.41f);
        combs = TableModelCombustivel.getArrayCombs(".\\src\\file\\csv\\" + fileName);
        //combs.add(etanol);
    }
 
    public static ArrayList<Combustivel> getArrayCombs(String fileName){  //colocar isso em um dao
        return new CSVReader().readFile(".\\src\\file\\csv\\" + fileName);
    }
    
    //Adiciona um novo posto
    public void add(Combustivel c) {
        combs.add(c);
        fireTableRowsInserted(combs.size() - 1, combs.size() - 1);
    }

    //Seleciona um objeto Combustivel na rowSelected passada
    public Combustivel select(int rowSelected) {
        return combs.get(rowSelected);
    }

    //Remove o objeto Combustivel que está na rowSelected
    public void remove(int rowSelected) {
        combs.remove(rowSelected);
        fireTableRowsDeleted(rowSelected, rowSelected);
    }

    //Atualiza um objeto Combustivel
    public void update(int rowSelected, Combustivel c) {
        combs.set(rowSelected, c);
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
        return combs.size();
    }

    //Retorna o número de colunas da tabela
    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    //Retorna o objeto Combustivel que está na rowIndex e columnIndex passada
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Combustivel c = combs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getTipo();
            case 1:
                return c.getDataColeta();
            case 2:
                return c.getPrecoVenda();
        }
        return null;
    }
}
