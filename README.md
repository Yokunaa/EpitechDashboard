## Projet Dashboard
### Liste des services et widgets
* Weather
    * Weather _(Affiche les informations en fonction de la ville selectionnée)_
* Exchange
    * Conversion _(Affiche le taux de convertion en fonction des devises sélectionnées)_

* Steam
    * Steam _(Affiche le nombre de joueurs en fonction du jeu sélectionné)_

* Youtube
    * Youtube _(Affiche donnée d'une chaîne en fonction de son ID)_

* Discord
    * Discord _(Affiche les informations d'un serveur discord en fonction de l'id fournie par l'utilisateur)_

### Explication du fonctionnement du site

* Le projet est à cloner avec GitHub, il suffira de lancer la commande ./gradlew build puis ./gradlew bootrun pour le lancer.
* Ce projet utilise thymeleaf pour faire passer des données depuis le back jusqu'au front.
* Les maquettes des pages html se trouvent dans le dossier _src.resources.templates_
* Ce projet est structuré en MVC.
* Chaque widget est personnalisable.
* La classe _MysqlCon_ contient toutes les méthodes en lien avec la Base de donnée (Insert, Update, Delete, etc)

___Les languages utilisés sont :___
* Java
* Html / CSS / JS