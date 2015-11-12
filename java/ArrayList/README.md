# Aula prática, 5/11 (Quinta feira)

## Tópicos abordados
 - Parte final de Herança e Polimorfismo (aula [00](../00_slides-java-heranca-polimorfismo-2015b.pdf));
 - Classes abstratas, interfaces, tipos genéricos e *collections* (aula [01](../01_slides-java-abstract-2015b.pdf)).

## Material extra
 - Você pode baixar [aqui](slides-java-rev-00-01-2015b.pdf) o material de revisão das aulas 00 e 01. Esses slides contém alguns exemplos práticos sobre os conceitos abordados nas aulas teóricas;
 - Abusos no uso de herança [\[1\]](http://www.gotw.ca/publications/mill06.htm) [\[2\]](http://www.gotw.ca/publications/mill07.htm): artigos em inglês que tratam do "overengineering" de software. Os exemplos são para C++ mas as dicas servem para qualquer outra linguagem OO (Java, Python, Go, C#, Obj C, ...).

## Parte 1
1. Baixe o arquivo [ArrayListDemo.zip](ArrayListDemo.zip), que contém o projeto Netbeans que será utilizado nesse exercício. Descompacte o projeto e abra-o no Netbeans.

2. Entre na pasta src do projeto e analise o programa `ArrayListOps.java`. Esse programa usa a classe `ArrayList`. O que faz cada linha do programa? Qual será sua saída?

3. Execute o programa no NetBeans (abra o arquivo `ArrayListOps.java` e tecle Shift-F6). 

4. Analise o programa `ArrayListPercurso.java`. O que faz cada linha do programa? Qual será sua saída?

5. O programa `VeiculoApp.java` ilustra o uso da classe Veiculo, que é definida em `Veiculo.java`. Qual será a saída deste programa?

6. Altere o programa `VeiculoApp.java` para fazer o seguinte:
   - criar uma `ArrayList` de objetos da classe `Veiculo`;
   - criar 4 veículos e inseri-los na `ArrayList`;
   - mostrar todo o conteúdo da `ArrayList`, usando um laço for com índice `i`;
   - obter e mostrar o segunda veículo da `ArrayList`;
   - remover o último veículo da `ArrayList`;
   - mostrar novamente todo o conteúdo da `ArrayList`, usando um laço for-each.


## Parte 2
1. Baixe o programa [ArrayListGUI.jar](ArrayListGUI.jar). Esse é um programa com interface gráfica que faz operações semelhantes às do exercício anterior. Execute e teste este programa, pois no restante dos exercícios você completará um código para reproduzir o comportamento deste executável. Para executar o programa, clique sobre ele ou execute:
```Shell
   java -jar ./ArrayListGUI.jar
```

2. Baixe o arquivo [ArrayListGUI.zip](ArrayListGUI.zip), que contém o projeto NetBeans da aplicação ArrayListGUI. Este projeto está incompleto.

3. Entre na pasta `src/arraylistgui/gui` e abra o arquivo `TableModelVeiculo.java`. Este arquivo contém uma classe que encapsula uma ArrayList de Veículos e implementa métodos para representar seus dados na forma de uma tabela.

4. Estude o código da classe `TableModelVeiculo` e procure completar as partes marcadas com "COMPLETE-ME". Se tudo der certo, o programa deverá compilar e executar sem erros, e executar as operações corretamente.

