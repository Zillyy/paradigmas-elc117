package Posto;

/* @author Zilly
 */
public class Posto {

    protected int cnpj;
    protected String razaoSocial;
    protected String nomeFantasia;
    protected String bandeira;
    protected String endereco;
    protected String bairro;
    protected int cep;
    protected String imagem;
    
    @Override
    public String toString(){
        return "CNPJ: " + this.cnpj + ", Razão Social: " + this.razaoSocial + ", Nome Fantasia: " + this.nomeFantasia + 
                ", Bandeira: " + this.bandeira + ", Endereço: " + this.endereco + ", Bairro: " + this.bairro + 
                ", CEP: " + this.cep + ", Caminho da imagem: " + this.imagem;
    }

    //Construtor padrão
    public Posto() {
        this.cnpj = 0;
        this.razaoSocial = "";
        this.nomeFantasia = "";
        this.bandeira = "";
        this.endereco = "";
        this.bairro = "";
        this.cep = 0;
        this.imagem = "";
    }

    //Construtor alternativo
    public Posto(int cnpj, String razaoSocial, String nomeFantasia, String bandeira, String endereco, String bairro, int cep, String imagem) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.bandeira = bandeira;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.imagem = imagem;
    }

    //Getters e Setters
    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
