Feature: CalculaFrete
	Como cliente
	Desejo calcular o frete e o tempo de uma entrega a patir do
	peso, largura, 

Scenario: Calcular Frete e Tempo com todos os campos preenchidos e validos
	Given Que eu possuo o uma calculadora de valor de frete e tempo
	When Eu informo <peso>, <largura>, <altura>, <comprimento>, <cep> e <tipoentrega>
	Then Eu recebo um <objeto> contendo valor do Frete e o Tempo
	Examples: 
		| peso | largura | altura | comprimento | 	   cep 		| 	 tipoentrega 		| 	objeto  	|
		|	1  |	0	 |  0     | 	1       |	12345123	|	 SEDEX VAREJO		| 	13,20/1 	|
		|	2  |	2	 |  4     | 	2		|	09876123	|	 SEDEX 10 VAREJO	| 	"14,20/1 	|
		|	3  |	10	 |  30    |		2		|	10293123	|	 PAC VAREJO			| 	"5,20/1"	|