%http://andreiformiga.com/blog/?p=164 e http://andreiformiga.com/blog/?p=157
% Nome, Dia da semana, hora
gera(p(N, D, H)) :- 
    member(N, [lia, mel, nanda, olga, pilar, rute, sara, tina, ninguem]),
    member(D, [segunda, terca, quarta, quinta, sexta]),
    member(H, [8, 9]).

dif(p(N1, D1, _), p(N2, D2, _)) :-
    N1 \= N2, D1 \= D2.
 
todas_dif(P1, P2, P3, P4, P5) :-
    dif(P1, P2), dif(P1, P3), dif(P1, P4), 
    dif(P2, P3), dif(P2, P4), dif(P3, P4),
    dif(P1, P5), dif(P2, P5), dif(P3, P5),
    dif(P4, P5).

todas_dif1(P1, P2, P3, P4) :-
    dif(P1, P2), dif(P1, P3), dif(P1, P4), 
    dif(P2, P3), dif(P2, P4), dif(P3, P4).

gera_ef(P1, P2, P3, P4, P5) :-
    P1 = p(_, segunda, 8),
    P2 = p(_, terca, 8),
    P3 = p(_, quarta, 8),
    P4 = p(_, quinta, 8),
    P5 = p(_, sexta, 8),
    gera(P1), gera(P2), gera(P3), gera(P4), gera(P5),
    todas_dif(P1, P2, P3, P4, P5).

solucao(S) :- 
    S = [P1, P2, P3, P4, P5], 
    gera_ef(P1, P2, P3, P4, P5),
    member(p(N, segunda, 8), S),
    member(p(N, terca, 8), S),
    member(p(ninguem, quarta, 8), S),
    member(p(N, quinta, 8), S),
    member(p(N, sexta, 8), S).