$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/BuscaEndereco.feature");
formatter.feature({
  "line": 1,
  "name": "BuscaEndereco",
  "description": "Como cliente\r\nDesejo consultar um endereço a partir do CEP",
  "id": "buscaendereco",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1156804,
  "status": "passed"
});
formatter.before({
  "duration": 432358,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Consultar um endereco valido",
  "description": "",
  "id": "buscaendereco;consultar-um-endereco-valido",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Eu possuo um CEP correto com 8 digitos",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Eu informo o CEP {13083872}",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "O resultado deve ser o endereço \"Cidade Universitária Zeferino Vaz, Barão Geraldo - Campinas - SP\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 29
    }
  ],
  "location": "BuscaEnderecoSteps.possuoCEPCorreto(String)"
});
formatter.result({
  "duration": 259197661,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 51746,
  "status": "passed"
});
formatter.before({
  "duration": 49180,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Consultar um endereco invalido",
  "description": "",
  "id": "buscaendereco;consultar-um-endereco-invalido",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Eu possuo um CEP incorreto com 8 digitos",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Eu informo o CEP {99999999}",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "O retorno contera um valor de \"erro\" igual a \"true\".",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 31218,
  "status": "passed"
});
formatter.before({
  "duration": 31647,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Consultar um endereco com CEP invalido.",
  "description": "",
  "id": "buscaendereco;consultar-um-endereco-com-cep-invalido.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "Eu possuo um CEP incorreto com mais de 8 digitos",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "Eu informo o CEP {123456789}",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "O retorno da consulta será um 400 (Bad Request).",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 63293,
  "status": "passed"
});
formatter.before({
  "duration": 41910,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Consultar um endereco com CEP invalido.",
  "description": "",
  "id": "buscaendereco;consultar-um-endereco-com-cep-invalido.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "Eu possuo um CEP incorreto com caracteres invalidos.",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "Eu informo o CEP {1 A*n258}",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "O retorno da consulta será um 400 (Bad Request).",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});