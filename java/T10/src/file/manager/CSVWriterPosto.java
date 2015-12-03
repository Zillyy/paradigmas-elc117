package file.manager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import posto.model.Posto;

/**
 *
 * @author Zilly
 */
public class CSVWriterPosto {

//Delimitadores do CSV
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public void writeFilePosto(String fileName, ArrayList<Posto> listPostos) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            for (int i = 0; i < listPostos.size(); i++) {
                fileWriter.append(listPostos.get(i).getCnpj());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPostos.get(i).getRazaoSocial());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPostos.get(i).getNomeFantasia());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPostos.get(i).getBandeira());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPostos.get(i).getEndereco());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPostos.get(i).getBairro());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPostos.get(i).getCep());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPostos.get(i).getImagem());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPostos.get(i).getHistorico());
                if (i != listPostos.size() - 1) {
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
            } finally {
                System.out.println("Arquivo de postos salvo com sucesso!");
            }
        }
    }
}
