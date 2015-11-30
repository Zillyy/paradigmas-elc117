package disciplinagui.model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrea
 */

public class TableModelDisciplina extends AbstractTableModel {

    private static final String[] columnNames = {"Ano", "Semestre", "Nome", "Nota"};

    private ArrayList<Disciplina> discips;

    public TableModelDisciplina() {
        discips = new ArrayList<Disciplina>();
        discips.add(new Disciplina(2010,2,"Logica e Algoritmo", 8.2f));
        discips.add(new Disciplina(2010,2,"Lab I", 7.8f));
        discips.add(new Disciplina(2011,1,"Lab II", 8.0f));
        discips.add(new Disciplina(2011,2,"Paradigmas", 8.8f));
    }

    public void remove(int index) {
	discips.remove(index);
	fireTableRowsDeleted(index, index);
    }

    public Disciplina select(int index) {
        return discips.get(index);
    }
    
    public void add(Disciplina d) {
        // Adds the element in the last position in the list
        discips.add(d);
        fireTableRowsInserted(discips.size()-1, discips.size()-1);
    }

    public void update(int index, Disciplina d) {
        discips.set(index, d);
        fireTableRowsUpdated(index, index);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return discips.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return discips.get(rowIndex).getAno();
            case 1: return discips.get(rowIndex).getSemestre();
            case 2: return discips.get(rowIndex).getNome();
            case 3: return discips.get(rowIndex).getNota();
        }
        return null;
    }

}

