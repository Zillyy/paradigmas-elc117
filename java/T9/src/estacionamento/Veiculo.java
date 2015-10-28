package estacionamento;

class Veiculo {

    private String tipoVeiculo;
    private String placa;
    private long horarioEnt;
    private long horarioSai;

    public Veiculo() {
    }

    public Veiculo(String veiculo, String placa) {
        this.tipoVeiculo = veiculo;
        this.placa = placa;
        this.horarioEnt = System.currentTimeMillis();
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public long getHorarioEnt() {
        return horarioEnt;
    }

    public void setHorarioEnt(long horarioEnt) {
        this.horarioEnt = horarioEnt;
    }

    public long getHorarioSai() {
        return horarioSai;
    }

    public void setHorarioSai(long horarioSai) {
        this.horarioSai = horarioSai;
    }
}
