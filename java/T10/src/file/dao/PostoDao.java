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

    //Lê arquivo dos Postos e retorna ArrayList com eles
    public static ArrayList<Posto> getArrayPostos(String fileName) {
        return new CSVReaderPosto().readFilePosto(".\\src\\file\\csv\\" + fileName);
    }
    
    //Escreve arquivos dos Postos
    public static void salvarPostos(String fileName, ArrayList<Posto> postos) {
        new CSVWriterPosto().writeFilePosto(".\\src\\file\\csv\\" + fileName, postos);
    }
}
