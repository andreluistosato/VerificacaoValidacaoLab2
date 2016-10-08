Feature: ConsultarStatusEntrega
	Eu como cliente desejo consultar o status de entrega a partir de um codigo de rastreamento
	

Scenario: O comprador consulta o status de entrega de sua compra 
Given Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore 
When O cliente informar o <codigo> de rastreamento
Then O cliente recebera o <status> da entrega
