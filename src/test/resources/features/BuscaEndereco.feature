Feature: BuscaEndereco
	Como cliente
	Desejo consultar um endereço a partir do CEP


Scenario: Consultar um endereco valido 
Given Eu possuo um CEP correto com 8 digitos 
When Eu informo o CEP 01001000
Then O resultado deve ser o endereco "Praca da Se" 

Scenario: Consultar um endereco invalido 
Given Eu possuo um CEP incorreto com 8 digitos 
When Eu informo o CEP 99999999
Then O retorno contera um valor de "erro=true".

Scenario: Consultar um endereco com CEP invalido. 
Given Eu possuo um CEP incorreto com mais de 8 digitos 
When Eu informo o CEP 123456789
Then O retorno da consulta será um 400 (Bad Request).

Scenario: Consultar um endereco com CEP invalido. 
Given Eu possuo um CEP incorreto com caracteres invalidos. 
When Eu informo o CEP 1A*n258
Then O retorno da consulta será um 400 (Bad Request). 
