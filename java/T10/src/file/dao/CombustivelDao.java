package file.dao;

import file.manager.CSVReaderComb;
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
}
