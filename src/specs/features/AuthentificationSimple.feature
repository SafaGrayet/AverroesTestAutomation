Feature: LocVac - Authentification Simple
  En tant que Utilisateur
  Je souhaite assurer que mon compte est fonctionnel

  @Auth
  Scenario: Authentification Simple
    Given Utilisateur est dans la page Home
    When Utilisateur navigue dans la page Connectez-vous
    And Utilisateur entrer adreese email  et mot de passe
    Then Message affiche Connexion reussie
