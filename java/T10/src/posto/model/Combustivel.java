package posto.model;

/**
 * @author Zilly
 */
public class Combustivel {

    private String tipo;
    private String dataColeta;
    private float precoVenda;
   
    public Combustivel(){
        this("", "", 0f);
    }

    public Combustivel(String tipo, String dataColeta, float precoVenda) {
        this.tipo = tipo;
        this.dataColeta = dataColeta;
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString(){
        return "Tipo: " + this.tipo + ", Data de Coleta: " + this.dataColeta + ", Preço de Venda: " + this.precoVenda;
    }
    
    //Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }
    
}
