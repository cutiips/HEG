# appTaches - gestionnaire de tâches en Java

Ce projet est un gestionnaire de tâches simple qui permet à l'utilisateur de gérer une liste de tâches à faire. Il permet notamment aux utilisateurs d'ajouter, de marquer des tâches comme terminées, de supprimer toutes les tâches terminées et d'afficher la liste de toutes les tâches.

## Introduction
Ce projet a été réalisé dans le cadre du cours de SDA (Structure de données avancées) de la HEG-Neuchâtel. Il a pour but de mettre en pratique les concepts de base de la programmation orientée objet en Java. Cette application offre les fonctionnalités suivantes : 
1. Ajout d'une nouvelle tâche
2. Marquage d'une tâche comme terminée
3. Suppression de toutes les tâches terminées
4. Affichage de la liste de toutes les tâches

## Structure du projet
- **ch.heg.ig.sda.app** : contient le code principal de l'application appTaches
  - Main.java : contient la méthode main() qui permet de lancer l'application
  - TaskView.java : contient la classe TaskView qui permet d'afficher le menu de l'application et de gérer les entrées de l'utilisateur
  - TaskInput.java : contient la classe TaskInput qui permet de gérer les entrées de l'utilisateur 
- **ch.heg.ig.sda.service** : fournit une couche de service pour la gestion des tâches
  - ITaskService : définit le contrat de gestion des tâches
  - TaskServiceImpl : implémente ITaskService et interagit avec TaskManager
  - TaskServiceException : gestion des exceptions pour la couche de service
- **ch.heg.ig.sda.business**  : contient la logique métier des tâches
  - Task : représente une tâche unique avec une description et un état
  - TaskManager : gère les tâches comme l'ajout, l'état et la suppression
  - RecurrentTask : est une sous-classe de Task et représente une tâche récurrente
  - BusinessTaskException : gestion des exceptions pour la couche métier

## Fonctionnalités
1. Ajout d'une nouvelle tâche : sélectionnez 1 et entrez la description de la tâche
2. Marquage d'une tâche comme terminée : sélectionnez 2, et entrez le numéro de la tâche à marquer comme terminée
3. Suppression de toutes les tâches terminées : sélectionnez 3
4. Affichage de la liste de toutes les tâches sélectionnez 4
5. Quitter l'application : sélectionnez 5

## Exécution du projet
1. Cloner le projet
2. Ouvrir le projet dans un IDE (IntelliJ, Eclipse, etc.)
3. Importer la bibliothèque ConsoleMenuLibrary.jar (qui se trouve dans le dossier lib) dans le projet (dans IntelliJ : File > Project Structure > Libraries > + > Java > sélectionner le fichier ConsoleMenuLibrary.jar)
4. Exécuter la classe Main.java
5. Suivre les instructions affichées dans la console
6. Enjoy!
   
