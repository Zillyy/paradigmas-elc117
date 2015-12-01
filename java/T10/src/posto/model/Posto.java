package posto.model;

/** 
 * @author Zilly
 */
public class Posto {

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String bandeira;
    private String endereco;
    private String bairro;
    private String cep;
    private String imagem;
    private String historico;
    
    //Construtor padrão
    public Posto() {
        this("", "", "", "", "", "", "", "", "");
    }

    //Construtor alternativo
    public Posto(String cnpj, String razaoSocial, String nomeFantasia, String bandeira, String endereco, String bairro, String cep, String imagem, String historico) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.bandeira = bandeira;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.imagem = imagem;
        this.historico = historico;
    }

    @Override
    public String toString(){
        return "CNPJ: " + this.cnpj + ", Razão Social: " + this.razaoSocial + ", Nome Fantasia: " + this.nomeFantasia + 
                ", Bandeira: " + this.bandeira + ", Endereço: " + this.endereco + ", Bairro: " + this.bairro + 
                ", CEP: " + this.cep + ", Caminho da imagem: " + this.imagem + ", Histórico de Combs: " + this.historico;
    }
    
    //Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
}

