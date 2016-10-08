Feature: CalculaEntregaPedido
	Como cliente
	Desejo consultar um endereço a partir do CEP


Scenario: Calcular Frete e Tempo com todos os campos preenchidos e validos
Given Eu possuo um Peso de 20 quilos preenchido e valido
And Eu possuo uma Largura de 1 metro preenchido e valido
When Eu informo o Peso {20}
And Eu informo a Largura {1}
Then O resultado deve ser TRUE

#
#Scenario: Consultar um endereco invalido 
#Given Eu possuo um CEP incorreto com 8 digitos 
#When Eu informo o CEP {99999999}
#Then O retorno contera um valor de "erro" igual a "true".
#
#Scenario: Consultar um endereco com CEP invalido. 
#Given Eu possuo um CEP incorreto com mais de 8 digitos 
#When Eu informo o CEP {123456789}
#Then O retorno da consulta será um 400 (Bad Request).
#
#Scenario: Consultar um endereco com CEP invalido. 
#Given Eu possuo um CEP incorreto com caracteres invalidos. 
#When Eu informo o CEP {1 A*n258}
#Then O retorno da consulta será um 400 (Bad Request).
