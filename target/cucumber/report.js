$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/CalculaEntregaPedido.feature");
formatter.feature({
  "line": 1,
  "name": "CalculaEntregaPedido",
  "description": "Como cliente\nDesejo consultar um endereço a partir do CEP",
  "id": "calculaentregapedido",
  "keyword": "Feature"
});
formatter.before({
  "duration": 681447,
  "status": "passed"
});
formatter.before({
  "duration": 389524,
  "status": "passed"
});
formatter.before({
  "duration": 379608,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Calcular Frete e Tempo com todos os campos preenchidos e validos",
  "description": "",
  "id": "calculaentregapedido;calcular-frete-e-tempo-com-todos-os-campos-preenchidos-e-validos",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Eu possuo um Peso de 20 quilos preenchido e valido",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Eu possuo uma Largura de 1 metro preenchido e valido",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Eu informo o Peso {20}",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Eu informo a Largura {1}",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "O resultado deve ser TRUE",
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});