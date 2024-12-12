import random


def criaTabuleiro(nMatiz:int, nBomba:int)-> list:
	tabuleiro = list()
	posicaoBomba = int()
	bombas = int()
	for i in range(nMatiz):
		tabuleiro.append([0]*nMatiz)
	while(bombas <nBomba):
		posicaoBomba = decideBomba(nMatiz)
		if(tabuleiro[(posicaoBomba//10)-1][(posicaoBomba%10)-1] == 0):
			tabuleiro[(posicaoBomba//10)-1][(posicaoBomba%10)-1] = 1
			bombas+=1
			print(bombas)
	return tabuleiro


def decideBomba(nMatiz)->int:
	decisao = random.randint(0,nMatiz*nMatiz)
	return decisao