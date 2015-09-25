% Exemplo de programa em Prolog que define
% fatos e regras sobre pessoas e localizacoes geograficas.

% Ex 1
localizado_em(santa_maria, rs).
localizado_em(salvador, bahia).
localizado_em(rs, brasil).
localizado_em(bahia, brasil).
localizado_em(paris, franca).
localizado_em(franca, europa).

nasceu_em(andre, santa_maria).
nasceu_em(joao, salvador).
nasceu_em(X, Y) :- localizado_em(Z, Y), nasceu_em(X, Z).

mora_em(andre, paris).
mora_em(joao, salvador).
mora_em(X, Y) :- localizado_em(Z, Y), mora_em(X, Z).

idade(andre, 25).
idade(joao, 32).

gaucho(X) :- nasceu_em(X, rs).
brasileiro(X) :- nasceu_em(X, brasil).
europeu(X) :- nasceu_em(X, europa).

% Ex 2
nasceu_em(joana, salvador).
nasceu_em(michel, paris).

idade(joana, 22).
idade(michel, 40).

% Ex 4
maisVelho(X, Y) :- idade(X, IdadeX),
				 idade(Y, IdadeY),
				 IdadeX > IdadeY.

% Ex 5
soma(A, B, C) :- C is A + B.
pred(A, B, C) :- X is (A + B) ^ 2, C is X * 2 + 1.

% Ex 6
anoNasc(P, A) :- idade(P, I), A is 2015 - I.

% Ex 7
/*
"member" verifica se o primeiro argumento pertence à lista;
"length" retorna o número de elementos da lista passada ao segundo argumento;
"nextto" verifica a lista e retorna o proximo elemento em relação àquele passado,
ou true/false se forem passados possíveis vizinhos
*/

% Ex 8