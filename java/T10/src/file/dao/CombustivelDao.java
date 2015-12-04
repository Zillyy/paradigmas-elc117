package file.dao;

import file.manager.CSVReaderComb;
import file.manager.CSVWriterComb;
import java.util.ArrayList;
import posto.model.Combustivel;

/**
 *
 * @author Zilly
 */
public class CombustivelDao {

    //Lê arquivo dos Combustíveis e retorna ArrayList com eles
    public static ArrayList<Combustivel> getArrayCombs(String fileName) {
        return new CSVReaderComb().readFileComb(".\\src\\file\\csv\\" + fileName);
    }
    
    //Escreve arquivos dos Combustíveis
    public static void salvarCombustiveis(String fileName, ArrayList<Combustivel> combs) {
        new CSVWriterComb().writeFileComb(".\\src\\file\\csv\\" + fileName, combs);
    }
}
