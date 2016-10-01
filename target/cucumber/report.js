$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/BuscaEndereco.feature");
formatter.feature({
  "line": 1,
  "name": "BuscaEndereco",
  "description": "Como cliente\nDesejo consultar um endereço a partir do CEP",
  "id": "buscaendereco",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1513205,
  "status": "passed"
});
formatter.before({
  "duration": 863733,
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
  "location": "BuscaEnderecoSteps.possuoCEPCorreto(String)"
});
formatter.result({
  "duration": 68583889,
  "error_message": "cucumber.runtime.CucumberException: Arity mismatch: Step Definition \u0027br.unicamp.exemplo.steps.BuscaEnderecoSteps.possuoCEPCorreto(String) in file:/home/inf300/espsoft58/workspace/VerificacaoValidacaoLab2/target/test-classes/\u0027 with pattern [^Eu possuo um CEP correto com 8 digitos$] is declared with 1 parameters. However, the gherkin step has 0 arguments []. \nStep: Given Eu possuo um CEP correto com 8 digitos\n\tat cucumber.runtime.StepDefinitionMatch.arityMismatch(StepDefinitionMatch.java:102)\n\tat cucumber.runtime.StepDefinitionMatch.transformedArgs(StepDefinitionMatch.java:60)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\n",
  "status": "failed"
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
  "duration": 21570,
  "status": "passed"
});
formatter.before({
  "duration": 17414,
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
  "duration": 20438,
  "status": "passed"
});
formatter.before({
  "duration": 32621,
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
  "duration": 19813,
  "status": "passed"
});
formatter.before({
  "duration": 16455,
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