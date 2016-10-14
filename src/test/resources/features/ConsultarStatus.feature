Feature: ConsultarStatusEntrega
	Eu como cliente desejo consultar o status de entrega a partir de um codigo de rastreamento
	

Scenario: O comprador consulta o status de entrega de sua compra com um codigo valido 
Given Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore 
When O cliente informar o 123 de rastreamento
Then O cliente recebera o status:"Objeto entregue ao destinatário"

Scenario: O comprador consulta o status de entrega de sua compra com um codigo invalido
Given Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore 
When O cliente informar o 123 de rastreamento
Then O cliente recebera o codigo de erro

Scenario: O comprador consulta o status de entrega de sua compra porem o servico esta fora
Given Eu possuo um codigo de rastreamento de uma compra efetuado no BookStore 
When O cliente informar o 123 de rastreamento
Then O cliente recebera o codigo de erro

