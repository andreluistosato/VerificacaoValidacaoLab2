Feature: CalculaFrete
	Como cliente
	Desejo calcular o frete e o tempo de uma entrega a patir do
	peso, largura, 

Scenario: Calcular Frete e Tempo com todos os campos preenchidos e validos
Given Que eu possuo o uma calculadora de valor de frete e tempo
#Peso de 20 quilos, uma Largura de 1 metro, uma Altura de 1 metro e Comprimento de 1 metro
When Eu informo Peso {20}, Largura {1}, Altura {1}, Comprimento {1}, Cep {12345123} e TipoEntrega {1}
Then eu recebo um Objeto contendo valor do Frete e o Tempo