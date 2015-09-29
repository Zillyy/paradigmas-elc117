/* Ex 1
A função verifica se o elemento da segunda lista é igual ao de mesmo
índice*/

% Ex 2
ziplus([], [], []).
ziplus([H|T], [H1|T1], [H2|T2]) :- H2 is H + H1, ziplus(T, T1, T2).  

% Ex 3
countdown(-1, []).
countdown(N, [H|T]) :- H is N, N1 is N - 1, countdown(N1, T).

% Ex 4
potencias(N, L) :- C is 0, potenciasAux(C, N, L).

potenciasAux(_, 0, []).
potenciasAux(C, N, [H|T]) :- H is 2 ^ C, N1 is N - 1, C1 is C + 1, potenciasAux(C1, N1, T).