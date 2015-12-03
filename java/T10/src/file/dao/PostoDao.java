package file.dao;

import file.manager.CSVReaderPosto;
import file.manager.CSVWriterPosto;
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
    
    public static void salvarPostos(String fileName, ArrayList<Posto> postos){
        new CSVWriterPosto().writeFilePosto(".\\src\\file\\csv\\" + fileName, postos);
    }
}
