package file.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import posto.model.Posto;

/**
 * @author Zilly
 */
public class CSVReaderPosto {

    //Delimitador
    private static final String COMMA_DELIMITER = ",";

    //Índice dos atributos
    private static final int POSTO_CNPJ = 0;
    private static final int POSTO_RAZAO_SOCIAL = 1;
    private static final int POSTO_NOME_FANTASIA = 2;
    private static final int POSTO_BANDEIRA = 3;
    private static final int POSTO_ENDERECO = 4;
    private static final int POSTO_BAIRRO = 5;
    private static final int POSTO_CEP = 6;
    private static final int POSTO_IMAGEM = 7;
    private static final int POSTO_HISTORICO = 8;

    public ArrayList<Posto> readFilePosto(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Posto> listPostos = new ArrayList<>();

        try {
            String line;

            //Cria o file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    Posto p = new Posto (tokens[POSTO_CNPJ], tokens[POSTO_RAZAO_SOCIAL], tokens[POSTO_NOME_FANTASIA], tokens[POSTO_BANDEIRA], tokens[POSTO_ENDERECO], tokens[POSTO_BAIRRO], 
                            tokens[POSTO_CEP], tokens[POSTO_IMAGEM], tokens[POSTO_HISTORICO]);
                    listPostos.add(p);
                }
            }

//            for (Posto comb : listPostos) {
//                System.out.println(comb);
//            }

        } catch (IOException e) {
            System.out.println("Arquivo não existe!");
        } catch (NullPointerException e) {
            System.out.println("Erro ao tentar abrir arquivo .CSV dos postos!");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar fileReader!");
            }
        }
        return listPostos;
    }

}
