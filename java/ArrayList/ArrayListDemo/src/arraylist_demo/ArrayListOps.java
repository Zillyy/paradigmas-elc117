package arraylist_demo;

import java.util.*;

class ArrayListOps {

   public static void main(String args[]) {
      // ...
      ArrayList<String> list = new ArrayList<String>();
      System.out.println("Tamanho inicial: " + list.size());

      // ...
      list.add("Fulano");
      list.add("Beltrano");
      list.add("Sicrano");
      list.add("Fulana");
      System.out.println("Novo tamanho: " + list.size());
      
      // ...
      list.remove("Beltrano");
      System.out.println("Primeiro elemento: " + list.get(0));
      
      // ...
      list.remove(0);
      System.out.println("Novo tamanho: " + list.size());
      System.out.println("Conteudo: " + list);
   }
}
