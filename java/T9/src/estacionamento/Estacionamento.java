package estacionamento;

class Estacionamento extends Veiculo {

    private Veiculo veiculo;

    public Estacionamento() {
    }

    public void EntVeiculo(String tipoV, String placaV) {
        veiculo = new Veiculo(tipoV, placaV);
    }

    public double SaiVeiculo(long horaSaida) {
        double aux = 0;
        if (veiculo.getTipoVeiculo() == "Carro") {
            aux = 3 * (horaSaida - veiculo.getHorarioEnt()) / 3600000; //3600000 = qtde de milissegundos em uma hora
        } else if (veiculo.getTipoVeiculo() == "Moto") {
            aux = 1.5 * (horaSaida - veiculo.getHorarioEnt()) / 3600000;
        }
        else{
            System.out.printf("Veículo não é nem carro nem moto!");
            System.exit(0);
        }
        return aux;
    }

    public static void main(String[] args) {
        Estacionamento est = new Estacionamento();
        est.EntVeiculo("Carro", "GDH2049");
        est.veiculo.setHorarioSai(System.currentTimeMillis() + (long) (4 * 3600000));
        System.out.printf("%s de placa %s deve: %.2f reais\n", est.veiculo.getTipoVeiculo(), est.veiculo.getPlaca(), est.SaiVeiculo(est.veiculo.getHorarioSai()));

        est.EntVeiculo("Moto", "IJK1926");
        est.veiculo.setHorarioSai(System.currentTimeMillis() + (long) (5 * 3600000));
        System.out.printf("%s de placa %s deve: %.2f reais\n", est.veiculo.getTipoVeiculo(), est.veiculo.getPlaca(), est.SaiVeiculo(est.veiculo.getHorarioSai()));

    }
}
