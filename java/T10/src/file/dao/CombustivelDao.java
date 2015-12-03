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

    public static ArrayList<Combustivel> getArrayCombs(String fileName) {
        return new CSVReaderComb().readFileComb(".\\src\\file\\csv\\" + fileName);
    }
    
    public static void salvarCombustiveis(String fileName, ArrayList<Combustivel> combs){
        new CSVWriterComb().writeFileComb(".\\src\\file\\csv\\" + fileName, combs);
    }
}
