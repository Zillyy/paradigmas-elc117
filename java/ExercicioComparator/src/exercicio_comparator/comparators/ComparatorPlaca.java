package exercicio_comparator.comparators;

import exercicio_comparator.Veiculo;
import java.util.Comparator;

/**
 * Comparator para veículos que usa placa como critério.
 * @author alberto
 */
public class ComparatorPlaca implements Comparator <Veiculo> {

   /**
    * Implementação do método da interface Comparator.
    * O critério de comparação é "ordem natural" ou "alfabética".
    * @param o1 Primeiro veículo da comparação.
    * @param o2 Segundo veículo da comparação.
    * @return Valor negativo se o1 deve proceder o2, zero se o1 é equivalente
    * a o2 ou valor positivo se o1 deve suceder o2.
    */
   @Override
   public int compare(Veiculo o1, Veiculo o2) {
      return o1.getPlaca().compareTo(o2.getPlaca());
   }
   
}
