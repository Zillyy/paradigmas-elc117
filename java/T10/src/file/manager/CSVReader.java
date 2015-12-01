package file.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import posto.model.Combustivel;

/**
 * @author Zilly
 */
public class CSVReader {

    //Delimitador
    private static final String COMMA_DELIMITER = ",";

    //Índice dos atributos
    private static final int COMB_TIPO = 0;
    private static final int COMB_DATA_COLETA = 1;
    private static final int COMB_PRECO = 2;

    public ArrayList<Combustivel> readFile(String fileName) { //tratar io nos catch

        BufferedReader fileReader = null;
        ArrayList<Combustivel> listCombs = new ArrayList<>();

        try {
            String line;

            //Cria o file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    Combustivel c = new Combustivel(tokens[COMB_TIPO], tokens[COMB_DATA_COLETA], Float.parseFloat(tokens[COMB_PRECO]));
                    listCombs.add(c);
                }
            }

            for (Combustivel comb : listCombs) {
                System.out.println(comb);
            }

        } catch (IOException e){
            System.out.println("Arquivo não existe!");
        } catch (NumberFormatException e) {
            System.out.println("Erro ao tentar ler preços!");
        } catch (NullPointerException e) {
            System.out.println("Erro ao tentar abrir arquivo .CSV!");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar fileReader!");
            }
        }
        return listCombs;
    }

}
