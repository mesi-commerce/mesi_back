# Utiliser l'image Maven avec JDK 21 pour la construction
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Définir le répertoire de travail dans l'image
WORKDIR /app

# Copier tous les fichiers du contexte vers le répertoire de travail
COPY . .

# Construire l'application avec Maven
RUN mvn clean package

# Deuxième étape pour l'exécution de l'application
# Utiliser une image de base Eclipse Temurin avec JDK 21
FROM eclipse-temurin:21-jdk

# Installer Maven dans l'image
RUN apt-get update && apt-get install -y maven

# Copier le fichier JAR construit par Maven dans le conteneur
# Copier le fichier JAR construit dans le répertoire de travail de la deuxième étape
COPY --from=builder /app/target/*.jar /app/monapplication.jar
# Définir le répertoire de travail à /app

WORKDIR /app

# Exposer le port sur lequel l'application Spring Boot écoute
EXPOSE 8080

# Commande à exécuter lorsque le conteneur démarre
CMD ["java", "-jar", "monapplication.jar"]
