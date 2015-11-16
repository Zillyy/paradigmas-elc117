package exercicio_comparator.comparators;

import exercicio_comparator.Veiculo;
import java.util.Comparator;
/**
 *
 * @author Zilly
 */
public class ComparatorPreco implements Comparator<Veiculo> {

    @Override
    public int compare(Veiculo o1, Veiculo o2) {
        return Float.compare(o1.getValor(), o2.getValor());
    }
    
}
