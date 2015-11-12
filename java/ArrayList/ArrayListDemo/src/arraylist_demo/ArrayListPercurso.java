package arraylist_demo;

import java.util.*;

class ArrayListPercurso {

   public static void main(String args[]) {
      // ... 
      ArrayList<String> list = new ArrayList<String>();
      System.out.println("Tamanho inicial: " + list.size());

      // ...
      list.add("Fulano");
      list.add("Beltrano");
      list.add("Sicrano");
      list.add("Fulana");
      System.out.println("Conteudo: " + list);

      // ...
      for (String s : list) {
         System.out.println(s.toUpperCase());
      }

      // ...
      System.out.println("Conteudo: " + list);
   }
}
