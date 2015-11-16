package exercicio_comparator;

import exercicio_comparator.comparators.ComparatorPlaca;
import exercicio_comparator.comparators.ComparatorMarca;
import exercicio_comparator.comparators.ComparatorPreco;
import java.util.Arrays;

/**
 * @author alberto
 */
public class ExercicioComparator {

    public static void main(String[] args) {
        // Cria um array com alguns veículos.
        Veiculo[] veiculos = {
            new Veiculo("ITF-8112", "Vermelho", "Ford", "Focus", 2014, 65000f),
            new Veiculo("ABC-2475", "Verde", "Fiat", "Uno", 2011, 30000f),
            new Veiculo("ITF-2143", "Azul", "Renault", "Clio", 2013, 45000.0f),
            new Veiculo("GHQ-5235", "Prata", "Volkswagen", "Gol", 2012, 19900.0f),
            new Veiculo("LEV-0111", "Preto", "Volkswagen", "Golf", 2014, 65000.0f)
        };

        // Ordenação por placa, ordem A...Z.
        System.out.println("Ordenados por placa: ");

        Arrays.sort(veiculos, new ComparatorPlaca());
        for (Veiculo v : veiculos) {
            System.out.println(v);
        }

      // TODO: Ordenação por marca. Lembre-se de exibir o resultado no terminal.
        System.out.println("Ordenados por marca: ");

        Arrays.sort(veiculos, new ComparatorMarca());
        for (Veiculo v : veiculos) {
            System.out.println(v);
        }

        // TODO: Ordenação por preço. Lembre-se de exibir o resultado no terminal.
        System.out.println("Ordenados por preço: ");
        
        Arrays.sort(veiculos, new ComparatorPreco());
        for (Veiculo v : veiculos) {
            System.out.println(v);
        }
    }

}
