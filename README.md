# 🔪 Spring MVC Lab avec Thymeleaf

## 📚 Objectif

Ce projet est une introduction pratique à l'architecture **Spring MVC** intégrée avec **Thymeleaf** pour développer des applications web dynamiques basées sur le modèle MVC.

---

## 🧐 Concepts Clés

### 🌱 Architecture Spring MVC

- **Model** : Représente les données de l'application (ex. : classe `Student`)
- **View** : Modèles Thymeleaf qui gèrent l'affichage HTML
- **Controller** : Gère les requêtes HTTP et les réponses

### 🔁 Flux de Données

1. Le navigateur envoie une requête à une URL
2. `DispatcherServlet` intercepte et traite la requête
3. Spring mappe la requête au contrôleur approprié
4. Le contrôleur traite la logique métier, met les données dans le `Model`
5. Le contrôleur retourne le nom d'une vue
6. Thymeleaf affiche la vue avec les données du `Model`
7. Le navigateur reçoit la réponse HTML

### 🧹 Fonctionnalités Thymeleaf

- ✅ **Natural templating** : les fichiers HTML restent valides même sans traitement
- 💬 **Expressions** : `${...}` pour les variables, `*{...}` pour les objets liés
- 🔗 **Liens dynamiques** : `@{...}`
- 🔄 **Boucles** : `th:each`
- ❗ **Conditions** : `th:if`, `th:unless`
- 📝 **Formulaires** : `th:field`, `th:object` pour la liaison de formulaire

---

## 🏠 Fonctionnalités du Projet

- Affichage de la liste des étudiants
- Ajout de nouveaux étudiants
- Intégration Thymeleaf pour l'affichage et la gestion des formulaires

---

## 📌 Devoirs / Extensions

Pour approfondir les compétences :

- ✏️ Ajouter l’**édition** d’un étudiant existant
- 🗑️ Ajouter une **fonction de suppression**
- 🔍 Intégrer une **recherche par nom ou spécialité**
- 📊 Créer un **dashboard avec des statistiques** (ex : nombre d’étudiants par spécialité)
- ⚠️ Améliorer la **validation** avec des **messages d’erreurs personnalisés**

---

## 📟 Conclusion

Ce laboratoire vous guide à travers les bases du modèle **MVC de Spring** avec l'intégration de **Thymeleaf**, en vous permettant de créer des interfaces web dynamiques et maintenables. Un excellent point de départ pour construire des applications web robustes avec Java Spring.

