@authentication
Feature: tester la page connexion
  ETQ utilisateur je souhaite tester la page connexion 

  @cnx
  Scenario: tester la page connexion - CNEA
    Given Je me connecte sur l'application CNEA
    When Je saisie le UserName
    And Je saisie le mot de passe
    And Je clique sur le bouton Login
    Then Je me redirige vers la mage Home
    @cnx1
    Scenario: tester la page de connexion invalide -CNEA 
    Given je me connecte sur l'application cnea
    When je saisie le UserName invalide
    And je saisie le mot de passe 
    And je clique sur le bouton Login 
    Then je me redirige vers la page Home 