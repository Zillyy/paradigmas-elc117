package arraylist_demo;

import java.util.*;

class VeiculoApp{

    public static void main(String args[]) {
        ArrayList<Veiculo> List = new ArrayList<Veiculo>();
        Veiculo v0 = new Veiculo("ELC1170", "Vermelho", "Renault", "Clio", 2013, 23000.0f);
        Veiculo v1 = new Veiculo("ELC1171", "Azul", "Fiat", "Palio", 2014, 26000.0f);
        Veiculo v2 = new Veiculo("ELC1172", "Verde", "Ford", "Ka", 2012, 34000.0f);
        Veiculo v3 = new Veiculo("ELC1173", "Amarelo", "Chevrolet", "Agile", 2015, 43000.0f);
        List.add(v0); List.add(v1); List.add(v2); List.add(v3);
        
        //List.add(new Veiculo("ELC1173", "Amarelo", "Chevrolet", "Agile", 2015, 43000.0f));
        
        for(int i = 0; i < List.size(); i++){
            System.out.printf("Marca: %s, Modelo: %s, Ano: %d, Cor: %s, Placa: %s, Valor: %.2f\n",
                List.get(i).getMarca(), List.get(i).getModelo(), List.get(i).getAno(), List.get(i).getCor(), List.get(i).getPlaca(), List.get(i).getValor());
        }
        
        System.out.println(List.get(1).getModelo());
        
        List.remove(List.size() - 1);
        
        for(Veiculo veic : List){
            System.out.printf("Marca: %s, Modelo: %s, Ano: %d, Cor: %s, Placa: %s, Valor: %.2f\n",
                veic.getMarca(), veic.getModelo(), veic.getAno(), veic.getCor(), veic.getPlaca(), veic.getValor());
        }
        
        //System.out.printf("Marca: %s, Modelo: %s, Ano: %d, Cor: %s, Placa: %s, Valor: %.2f\n",
          //      v.getMarca(), v.getModelo(), v.getAno(), v.getCor(), v.getPlaca(), v.getValor());
    }
}
