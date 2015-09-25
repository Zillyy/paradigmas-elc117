/* Ex 1
A função verifica se o elemento da segunda lista é igual ao de mesmo
índice*/

countdown(-1, []).
countdown(N, [H|T]) :- H is N, N1 is N - 1, countdown(N1, T).