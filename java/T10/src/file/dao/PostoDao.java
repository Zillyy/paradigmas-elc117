package file.dao;

import file.manager.CSVReaderPosto;
import java.util.ArrayList;
import posto.model.Posto;

/**
 *
 * @author Zilly
 */
public class PostoDao {
    public static ArrayList<Posto> getArrayCombs(String fileName) {
        return new CSVReaderPosto().readFilePosto(".\\src\\file\\csv\\" + fileName);
    }
}
