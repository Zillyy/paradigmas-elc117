package Posto;

import java.util.ArrayList;

/**
 *
 * @author Zilly
 */
class PostoApp {
    public static void main(String args[]){
        ArrayList<Posto> List = new ArrayList<Posto>();
        Posto BR = new Posto(123456789, "Posto de Combustíveis BR", "Posto BR", "Petrobrás", "Rua Venâncio Aires", "Centro", 97956123, "img/br.png");
        Posto Ipiranga = new Posto(984562123, "Posto de Combustíveis Ipiranga LTDA", "Posto Ipiranga", "Branca", "Avenida Rio Branco", "Centro", 97864512, "img/ipiranga.png");
        Posto Shell = new Posto(649537215, "Posto de Combustíveis Shell", "Posto Shell", "Branca", "Avenida Medianeira", "Nossa Senhora Medianeira", 97095483, "img/shell.png");
        List.add(BR); List.add(Ipiranga); List.add(Shell);
        
        for(Posto v : List){
            System.out.println(v.toString());
        }
    }
}
