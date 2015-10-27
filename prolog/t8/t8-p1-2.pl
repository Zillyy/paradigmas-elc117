gera_nomes(comb(N, _), [N], []) :- !.
gera_nomes(comb(N, _), Nomes, Resto) :- 
	select(N, Nomes, Resto).

gera_dt_hr(comb(_, D), [D], []) :- !.
gera_dt_hr(comb(_, D), Datahora, Resto) :- 
	select(D, Datahora, Resto).

gera_comb(C, atr(Ns, Ds), atr(Ns2, Ds2)) :-
	gera_nomes(C, Ns, Ns2), gera_dt_hr(C, Ds, Ds2).

gera_combs([], _) :- !.
gera_combs([N|Ns], Atribs) :-
        gera_comb(N, Atribs, Atribs2), gera_combs(Ns, Atribs2).

gera_sol([P1, P2, P3, P4, P5]) :-
	Nomes = [lia, mel, nanda, olga, pilar, rute, sara, tina, ninguem],
	Datas = [segunda8, segunda9, terca8, terca9, quarta8, quarta9, quinta8, quinta9, sexta8, sexta9],
	gera_combs([P1, P2, P3, P4, P5], atr(Nomes, Datas)).

solucao(S) :-
	P1 = comb(_, segunda8),
	P2 = comb(_, terca8),
	P3 = comb(_, quarta8),
	P4 = comb(_, quinta8),
	P5 = comb(_, sexta8),
	S = [P1, P2, P3, P4, P5], !,
	member(comb(ninguem, quarta8), S),
	member(comb(lia, _), S), member(comb(rute, _), S),
	member(comb(N, _), S), N \= sara,
	gera_sol(S).

