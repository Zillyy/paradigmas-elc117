package arraylistgui.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @brief Classe que representa um banco de dados em memória para uma revenda de carros.
 * @author alberto
 */
public class TableModelVeiculo extends AbstractTableModel  {
   
   // Lista de veículos do banco de dados.
   private ArrayList <Veiculo> veiculos;
   
   // Array com os nomes das colunas da tabela.
   private static final String[] nomeColunas = {"Marca", "Modelo", "Cor", "Ano", "Placa", "Valor"};
   
   /**
    * Construtor padrão.
    */
   public TableModelVeiculo() {
      veiculos = new ArrayList <> ();
      Veiculo v1 = new Veiculo("ABC1234", "Branco", "Renault", "Clio", 2010, 26050f);
      Veiculo v2 = new Veiculo("DEF5678", "Vermelho", "Toyota", "Corolla", 2012, 66300f);
      Veiculo v3 = new Veiculo("GHI1020", "Preto", "Chevrolet", "Meriva", 2009, 55250f);
      veiculos.add(v1); veiculos.add(v2); veiculos.add(v3);
   }

   /**
    * @return Contagem de linhas do model.
    */
   @Override
   public int getRowCount() {
       return veiculos.size();
   }
   
   /**
    * @return Contagem das colunas do model;
    */
   @Override
   public int getColumnCount() {
      return nomeColunas.length;
   }
   
   /**
    * Operação de CRUD: Adicionar veículo.
    * @param v {@link Veiculo} Novo veículo a ser adicionado.
    */
   public void add(Veiculo v) {
       veiculos.add(v);
      // COMPLETE-ME: insira o veículo v na lista.

      fireTableRowsInserted(veiculos.size()-1, veiculos.size()-1); // Mantenha essa linha no *final* do método!
   }
   
   /**
    * Operação de CRUD: Recupera um veículo do banco de dados para edição.
    * @param rowSelected Linha da tabela visual que foi selecionada.
    * @return {@link Veiculo} assocido a tal linha da tabela visual.
    */
   public Veiculo select(int rowSelected) {
       return veiculos.get(rowSelected);
      // COMPLETE-ME: retorne o veículo da lista associado ao índice rowSelected.
   }
   
   /**
    * Operação de CRUD: Remoção de um veículo do banco de dados.
    * @param rowSelected Linha da tabela visual que contém o veículo a ser apagado.
    */
   public void remove(int rowSelected) {
       veiculos.remove(rowSelected);
      // COMPLETE-ME: remova da lista o veículo associado ao índice rowSelected.
      
      fireTableRowsDeleted(rowSelected, rowSelected); // Mantenha essa linha no *final* do método!
   }
   
   
   
   
   
   /**
    * Operação de CRUD: Atualização de uma entrada do banco de dados.
    * @param rowSelected Linha da tabela visual que contém a entrada a ser atualizada.
    * @param v {@link Veiculo} com os dados atualizados.
    */
   public void update(int rowSelected, Veiculo v) {
      veiculos.set(rowSelected, v);
      fireTableRowsUpdated(rowSelected, rowSelected);
   }  

   /**
    * Pega o nome de uma coluna.
    * @param columnIndex Índice da coluna desejada.
    * @return Nome da coluna.
    */
   @Override
   public String getColumnName(int columnIndex) {
      return nomeColunas[columnIndex];
   }
   
   /**
    * Método usado para preencher a tabela visual.
    * @param rowIndex Linha selecionada.
    * @param columnIndex Coluna selecionada.
    * @return Valor do {@link Veiculo} da referida linha, atributo referente a coluna selecionada.
    */
   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      Veiculo v = veiculos.get(rowIndex);
      switch (columnIndex) {
         case 0: return v.getMarca();
         case 1: return v.getModelo();
         case 2: return v.getCor();
         case 3: return v.getAno();
         case 4: return v.getPlaca();
         case 5: return v.getValor();
      }
      return null;
   }
   
}
