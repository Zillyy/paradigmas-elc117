package estacionamento;

class Estacionamento extends Veiculo {

    private Veiculo veiculo;

    public Estacionamento() {
    }

    public void EntVeiculo(String tipoV, String placaV) {
        veiculo = new Veiculo(tipoV, placaV);
    }

    public long SaiVeiculo(long horaSaida) {
        long aux = 0;
        if (veiculo.getTipoVeiculo() == "Carro") {
            aux = (long) 3 * (horaSaida - veiculo.getHorarioEnt()) / 3600000;
        } else if (veiculo.getTipoVeiculo() == "Moto") {
            aux = (long) 1.5 * (horaSaida - veiculo.getHorarioEnt()) / 3600000;
        }
        return aux;
    }

    public static void main(String[] args) {
        Estacionamento est = new Estacionamento();
        est.EntVeiculo("Carro", "GDH2049");
        long aux;
        aux = est.SaiVeiculo(System.currentTimeMillis() + (2 * 3600000));
        est.veiculo.setHorarioSai(aux);
        System.out.printf("%s de placa %s deve: %s reais\n", est.veiculo.getTipoVeiculo(), est.veiculo.getPlaca(), est.SaiVeiculo(est.veiculo.getHorarioSai()));
    }
}
