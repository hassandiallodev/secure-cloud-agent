\# Dev setup (Windows)



\## MavenJDK

\- Maven utilisé  `Dsprojettoolsmvn17`

\- Objectif  exécuter les buildstests en Java 17 sans impacter l'environnement de travail.



\## Tests Maven  stabilité en CLI (Surefire  Mockito)

\### Symptôme

Les tests passaient dans IntelliJ mais échouaient en ligne de commande (`mvn test`) avec une erreur du type 

\- `Could not initialize plugin org.mockito.plugins.MockMaker`

ou des crashs de JVM forkée (Surefire).



\### Cause (résumé)

En CLI, Maven utilise le plugin Surefire pour lancer les tests. Sur certaines configurations WindowsJDK 17,

Mockito (utilisé via `spring-boot-starter-test`) peut avoir besoin de l'Attach APIbytecode instrumentation, et le fork de JVM peut être instable.



\### Fix appliqué

Dans `api-centralepom.xml`, ajout d'une configuration Surefire 

\- `forkCount=0`  désactive le fork de JVM pour stabiliser l'exécution des tests sur Windows

\- `-Djdk.attach.allowAttachSelf=true`  autorise l'auto-attach nécessaire à certains mécanismes d'instrumentation (MockitoByteBuddy)



\### Vérification

Depuis la racine du repo 

\- `Dsprojettoolsmvn17 test`

Le build doit finir par `BUILD SUCCESS` sur tous les modules.

