# Sécurité dans la CI (2C)

## 1) Secret scanning (Gitleaks)
Workflow : `.github/workflows/security-secrets.yml`

### Objectif
Détecter automatiquement les secrets committés par erreur (tokens, clés, mots de passe, clés privées).

### Déclenchement
- à chaque push sur `main`
- à chaque pull request vers `main`

### Fonctionnement
- Checkout du dépôt (avec historique complet `fetch-depth: 0`)
- Exécution de Gitleaks
- Si un secret est détecté : le job échoue (CI rouge)

## 2) Dependency scanning (OWASP Dependency-Check)
Workflow : `.github/workflows/security-deps.yml`

### Objectif
Détecter des vulnérabilités (CVE) dans les dépendances Maven (transitives incluses).

### Règle de blocage
Le pipeline échoue uniquement si une vulnérabilité critique est détectée (`--failOnCVSS 9`).

### Preuve
Un rapport HTML est généré et uploadé dans les artifacts GitHub Actions.
