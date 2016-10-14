Feature: ConsultarStatusEntrega
	Eu como cliente desejo consultar o status de entrega a partir de um codigo de rastreamento
	
Scenario Outline: O comprador consulta o status de entrega de sua compra com um codigo valido 
Given Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore 
When O cliente informar o codigo <codigo> de rastreamento
Then O cliente recebera o status: <status>

	Examples: 

		| codigo 			 | status                                 								| 
		|	"SQ458226057BR"  |	"Objeto entregue ao destinatário"	  								| 
		|	"SQ458226058BR"	 |	"A entrega não pode ser efetuada - Carteiro não atendido"         	| 
		|	"SQ458226059BR"	 |	"A entrega não pode ser efetuada - Cliente mudou-se"                | 
	
Scenario: O comprador consulta o status de entrega de sua compra com um codigo invalido
Given Eu possuo um codigo invalido de rastreamento de uma compra efetuado no BookStore 
When O cliente informar o codigo "SA123" de rastreamento
Then O cliente recebera o codigo de erro

Scenario: O comprador consulta o status de entrega de sua compra porem o servico esta fora
Given Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore 
When O cliente informar o codigo "SQ458226057BR" de rastreamento
Then O cliente recebera o codigo de erro

