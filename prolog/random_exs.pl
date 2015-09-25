%
fatorial(0, 1).
fatorial(N, F) :-
	N > 0, 
	N1 is N - 1, 
	fatorial(N1, F1), 
	F is N * F1.

% 
estrela(N) :- N == 0.
estrela(N) :- write('*'), N1 is N - 1, estrela(N1).

%
localizacao(mesa, escritorio).
localizacao(abajur, mesa).

esta_em(T1, T2) :- localizacao(T1, T2).
esta_em(T1, T2) :- localizacao(X, T2), esta_em(T1, X).

%
listSize(0, []).
listSize(N, [_|T]) :- listSize(N1, T), N is 1 + N1.

%
isInList(X, [X|_]).
isInList(X, [_|T]) :- isInList(X, T).