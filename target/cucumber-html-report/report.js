$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/specs/features/générerPDFdynamique/GénérerPDFdynamique.feature");
formatter.feature({
  "line": 2,
  "name": "Génération d\u0027un PDF",
  "description": "\r\nEn tant que administrateur \r\n\t Je souhaite verifer la génération d\u0027un PDF bien déterminer avec les données saisis",
  "id": "génération-d\u0027un-pdf",
  "keyword": "Feature"
});
formatter.before({
  "duration": 16207323999,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 8,
  "name": "je connecte à Averroès en tant que admin",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "je vois le dashboard d\u0027admin",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "je clique sur le lien du dashlet administration processus",
  "keyword": "And "
});
formatter.match({
  "location": "FiligranerPDFSteps.jeConnecteAAverroesEnTantQueAdmin()"
});
formatter.result({
  "duration": 698768695,
  "status": "passed"
});
formatter.match({
  "location": "FiligranerPDFSteps.jeVoisLeDashboardDAdmin()"
});
formatter.result({
  "duration": 3094803323,
  "status": "passed"
});
formatter.match({
  "location": "FiligranerPDFSteps.jeCliqueSurLeLienDuDashletAdministrationProcessus()"
});
formatter.result({
  "duration": 4598281632,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Génération d\u0027un PDF dynamique avec emplacement dynamique",
  "description": "",
  "id": "génération-d\u0027un-pdf;génération-d\u0027un-pdf-dynamique-avec-emplacement-dynamique",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@GenererPDFdynamique"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "je créé un nouveau processus \"Génération d\u0027un PDF dynamique dans un emplacement dynamique\"",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "je créé la varible de processus nom de type texte",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "je créé la variable de processus prenom de type texte",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "je créé la varible de processus \"fichier\" de type Contenu GED contenu",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "je créé la varible de processus \"dossier\" de type Contenu GED",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "je réalise le workflow de génération PDF dynamique dans un emplacement dynamique",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "je créé le formulaire contenat les champs nom, prénom, fichier,dossier dans le noeud de début",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "je configure la tache système génération PDF dynamique avec emplacement dynamique",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "je clique sur l\u0027icone générer",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "je clique sur l\u0027icone activer",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "je consule la dashlet processus",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "je lance le processus Génération d\u0027un PDF dynamique dans un emplacement dynamique",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "je consule la dashlet bibliothéque",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "je trouve le fichier généré dynamiqument dans l\u0027emplacement dynamique",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Génération d\u0027un PDF dynamique dans un emplacement dynamique",
      "offset": 30
    }
  ],
  "location": "AlimentationVariableTest.jeCreeUnNouveauProcessus(String)"
});
formatter.result({
  "duration": 9282470097,
  "status": "passed"
});
formatter.match({
  "location": "AlimentationVariableTest.jeCreeLaVaribleDeProcessusDeTypeTexte()"
});
formatter.result({
  "duration": 13277980619,
  "status": "passed"
});
formatter.match({
  "location": "AlimentationVariableTest.jeCreeLaVariableDeProcessusDeTypeTexte()"
});
formatter.result({
  "duration": 8513765612,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "fichier",
      "offset": 33
    }
  ],
  "location": "MetadonneesSteps.jeCreeLaVaribleDeProcessusDeTypeContenuGEDContenu(String)"
});
formatter.result({
  "duration": 9746765563,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dossier",
      "offset": 33
    }
  ],
  "location": "MetadonneesSteps.jeCreeLaVaribleDeProcessusDeTypeContenuGED(String)"
});
formatter.result({
  "duration": 11223531327,
  "status": "passed"
});
formatter.match({
  "location": "GenerationPDF.jeRealiseLeWorkflowDeGenerationPDFDynamiqueDansUnEmplacementDynamique()"
});
formatter.result({
  "duration": 17882594181,
  "status": "passed"
});
formatter.match({
  "location": "GenerationPDF.jeCreeLeFormulaireContenatLesChampsNomPrenomFichierDossierDansLeNoeudDeDebut()"
});
formatter.result({
  "duration": 48220114760,
  "status": "passed"
});
formatter.match({
  "location": "GenerationPDF.jeConfigureLaTacheSystemeGenerationPDFDynamiqueAvecEmplacementDynamique()"
});
formatter.result({
  "duration": 20881837888,
  "status": "passed"
});
formatter.match({
  "location": "FiligranerPDFSteps.jeCliqueSurLIconeGenerer()"
});
formatter.result({
  "duration": 61600249278,
  "status": "passed"
});
formatter.match({
  "location": "FiligranerPDFSteps.jeCliqueSurLIconeActiver()"
});
formatter.result({
  "duration": 7573478195,
  "status": "passed"
});
formatter.match({
  "location": "FiligranerPDFSteps.jeConsuleLaDashletProcessus()"
});
formatter.result({
  "duration": 14361240851,
  "status": "passed"
});
formatter.match({
  "location": "GenerationPDF.jeLanceLeProcessusGenrationDUnPDFDynamiqueDansUnEmplacementDynamique()"
});
formatter.result({
  "duration": 21138198765,
  "status": "passed"
});
formatter.match({
  "location": "GenerationPDF.jeConsuleLaDashletBibliotheque()"
});
formatter.result({
  "duration": 20587001321,
  "status": "passed"
});
formatter.match({
  "location": "GenerationPDF.jeTrouveLeFichierGenereDynamiqumentDansLEmplacementDynamique()"
});
formatter.result({
  "duration": 34847177850,
  "status": "passed"
});
formatter.after({
  "duration": 335846,
  "status": "passed"
});
});