![CI](https://github.com/hassandiallodev/secure-cloud-agent/actions/workflows/ci.yml/badge.svg)

# secure-cloud-agent

Portfolio DevSecOps / Cloud Security (AWS) en Java 17 + Spring Boot.

## Modules
- **api-centrale** : API Spring Boot (endpoint `/hello`) + healthcheck Actuator (`/actuator/health`) + tests JUnit.
- **sec-agent** : futur agent de sécurité (analyse, contrôles, intégration CI/CD).

## Prérequis
- Java 17
- Maven (commande locale recommandée : `D:\sprojet\tools\mvn17`)

## Lancer les tests
```bash
D:\sprojet\tools\mvn17 test