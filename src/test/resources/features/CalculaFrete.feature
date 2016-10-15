Feature: CalculaFrete
	Como cliente
	Desejo calcular o frete e o tempo de uma entrega a patir do
	peso, largura, 

Scenario Outline: Calcular Frete e Tempo com todos os campos preenchidos e validos
	Given Que eu possuo uma calculadora de valor de frete e tempo
	When Eu informo Peso <peso>, Largura <largura>, Altura <altura>, Comprimento <comprimento>, Cep <cep> e tipoEntrega <tipoentrega>
	Then Eu recebo um preco <precofrete> e o prazo <prazo>

	Examples: 

		| peso | largura | altura | comprimento | 	   cep 		| 	 tipoentrega 		| 	precofrete	  	|  prazo 	|
		|	3  |	10	 |  30    |		2		|	"10293123"	|	 "PACVAREJO"		| 	"5,20"			|	5		|
		|	2  |	2	 |  4     | 	2		|	"09876123"	|	 "SEDEX10VAREJO"	| 	"20,00"			|	1		|
		|	1  |	0	 |  0     | 	1       |	"12345123"	|	 "SEDEX VAREJO"		| 	"13,20"	 	   	|	2		|

Scenario: Calcular Frete e Tempo com os dados preenchidos e cep invalido
	Given Que eu possuo uma calculadora de valor de frete e tempo
	When Eu informo Peso 10, Largura 2, Altura 2, Comprimento 2, e o tipoEntrega "PACVAREJO"
	When Eu informo um cep "123" invalido
	Then Eu recebo uma mensagem "Por favor corrija os dados de CEP"

	
Scenario: Calcular Frete e Tempo com os dados preenchidos e o servico esta indisponivel
	Given Que eu possuo uma calculadora de valor de frete e tempo
	When Eu informo Peso 10, Largura 2, Altura 2, Comprimento 2, Cep "12345123" e tipoEntrega "PACVAREJO"
	Then Eu recebo uma mensagem de servico indisponivel "Serviço indisponível, tente mais tarde"
	