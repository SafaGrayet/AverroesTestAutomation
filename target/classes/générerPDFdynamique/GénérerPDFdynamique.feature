
Feature: Averroès-Génération d'un PDF dynamique

En tant que administrateur 
			 Je souhaite verifer la génération d'un PDF bien déterminer avec les données saisis 

  Background: 
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus
@GenererPDFdynamique

  Scenario: Génération d'un PDF dynamique avec emplacement dynamique
    Given je créé un nouveau processus "Génération d'un PDF dynamique dans un emplacement dynamique"
    And je créé la varible de processus nom de type texte
    And je créé la variable de processus prenom de type texte
    And je créé la varible de processus "fichier" de type Contenu GED contenu
    And je créé la varible de processus "dossier" de type Contenu GED
    Then je réalise le workflow de génération PDF dynamique dans un emplacement dynamique
    And je créé le formulaire contenat les champs nom, prénom, fichier,dossier dans le noeud de début
    And je configure la tache système génération PDF dynamique avec emplacement dynamique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Génération d'un PDF dynamique dans un emplacement dynamique
    Then je consule la dashlet bibliothéque
    And je trouve le fichier généré dynamiqument dans l'emplacement dynamique
