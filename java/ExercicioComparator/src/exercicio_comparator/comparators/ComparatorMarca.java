package exercicio_comparator.comparators;

import exercicio_comparator.Veiculo;
import java.util.Comparator;
/**
 *
 * @author Zilly
 */
public class ComparatorMarca implements Comparator<Veiculo> {

    @Override
    public int compare(Veiculo o1, Veiculo o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
    
}
