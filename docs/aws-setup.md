# AWS Setup (Séances 1A + 2A)

## Objectif
Sécuriser le compte AWS et rendre traçables les actions (audit).

## IAM / Accès
- Root : MFA activé, usage exceptionnel uniquement.
- Utilisateur admin : `admin_hassan` (MFA activé) pour l’administration courante.
- Connexion IAM : Account ID = 7646-5216-5729 + username IAM.

## Région
- Région de travail : Europe (Paris) `eu-west-3`.

## CloudTrail (traçabilité)
- CloudTrail = journalisation des actions AWS (qui a fait quoi, quand, depuis où).
- "Historique des événements" : montre les *management events* (90 derniers jours) sans créer forcément un Trail.
- Exemple de lecture d’un event :
  - `eventName` (action) / `eventSource` (service) / `awsRegion` (région)
  - `userIdentity.userName` (qui) / `sourceIPAddress` (d’où)
- S3 Bucket “cloudtrail-logs …” : stockage des journaux si on active un Trail.
  (bucket = “dossier cloud” pour stocker des fichiers)

## Notes
- Un bucket et une clé KMS doivent être dans la même région (sinon erreur).
