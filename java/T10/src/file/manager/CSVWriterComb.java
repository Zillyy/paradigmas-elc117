package file.manager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import posto.model.Combustivel;

/**
 *
 * @author Zilly
 */
public class CSVWriterComb {

    //Delimitadores do CSV
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public void writeFileComb(String fileName, ArrayList<Combustivel> listCombs) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            for (int i = 0; i < listCombs.size(); i++) {
                fileWriter.append(listCombs.get(i).getTipo());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listCombs.get(i).getDataColeta());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listCombs.get(i).getPrecoVenda() + "");
                if (i != listCombs.size() - 1) {
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao escrever arquivo!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar fileWriter!");
            }
        }
    }
}
