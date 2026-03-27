# Banking Kata

## Description
Implémentation du **Banking Kata** en utilisant le **Test-Driven Development (TDD)**
et l'**Architecture Hexagonale** (Ports & Adapters).

L'accent est mis sur la structure du code, les principes du clean code et les tests
plutôt que sur la complexité métier.

## Fonctionnalités
- Déposer de l'argent sur un compte
- Retirer de l'argent d'un compte
- Afficher le relevé de compte en ordre anti-chronologique
  
### Prérequis
- Java 25
- Maven 3.9+
- Node.js 20+
- Angular CLI 21+

### Lancer le backend
```bash
cd backend
./mvnw spring-boot:run
```

Le backend tourne sur `http://localhost:8080`


### Lancer le frontend
```bash
cd frontend
ng serve
```

Le frontend tourne sur `http://localhost:4200`

### Lancer tous les tests
```bash
# Backend
cd backend
./mvnw test

# Frontend
cd frontend
ng test --watch=false
```

### Décisions de conception
- **Domaine sans framework** → Pas d'annotations Spring dans la couche domaine
- **BeanConfiguration** → Configuration Spring isolée dans adapter/config
- **Transaction immuable** → Java record pour l'objet valeur
- **Angular Signals** → Gestion d'état réactive moderne
- **InMemoryRepository** → Stockage simple, facilement remplaçable

## Principes Clean Code appliqués
- Principe de Responsabilité Unique (SRP)
- Principe d'Inversion de Dépendance (DIP)
- Ne pas se répéter (DRY)
- Nommage significatif
- Méthodes petites et focalisées
