package exercicio_comparator;

/**
 * @brief Abstração de veículos.
 * @author alberto
 */
public class Veiculo {
   
   protected String placa;
   protected String cor;
   protected String marca;
   protected String modelo;
   protected int ano;
   protected float valor;
   
   
   /**
    * Construtor padrão.
    * Todos os atributos do objeto são iniciados com {@link null}, 
    * exceto infoEntrada.
    */
   public Veiculo() {   
      placa = "";
      cor = "";
      marca = "";
      modelo = "";
      ano = 0;
      valor = 0.0f;
   }

   /**
    * Construtor alternativo.
    * Prepara os atributos do objeto com os campos informados.
    * @param placa Placa a ser utilizada.
    * @param cor Cor do veículo.
    * @param marca A marca. 
    * @param modelo Modelo do veículo.
    * @param ano Ano de fabricação.
    * @param valor Valor de venda do veículo.
    */
   public Veiculo(String placa, String cor, String marca, String modelo, int ano, float valor) {
      this.placa = placa;
      this.cor = cor;
      this.marca = marca;
      this.ano = ano;
      this.valor = valor;
      this.modelo = modelo;
   }

   /**
    * Converte o objeto para sua representação em {@link String}.
    * @return Objeto seriado em {@link String}.
    */
   @Override
   public String toString() {
      String s = String.format("Veiculo [placa = %s, cor = %s, marca = %s, modelo = %s, ano = %d, valor = %f]", 
         this.placa,
         this.cor,
         this.marca,
         this.modelo,
         this.ano,
         this.valor);
      return s;
   }
   
   // ================= Getters e setters daqui para baixo.
   
   public int getAno() {
      return ano;
   }

   public String getCor() {
      return cor;
   }

   public String getMarca() {
      return marca;
   }

   public String getPlaca() {
      return placa;
   }

   public float getValor() {
      return valor;
   }

   public String getModelo() {
      return modelo;
   }

   public void setAno(int ano) {
      this.ano = ano;
   }

   public void setCor(String cor) {
      this.cor = cor;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public void setPlaca(String placa) {
      this.placa = placa;
   }

   public void setValor(float valor) {
      this.valor = valor;
   } 

   public void setModelo(String modelo) {
      this.modelo = modelo;
   }
   
}
