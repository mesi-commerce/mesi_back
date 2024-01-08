# Utiliser une image de base OpenJDK 17
FROM openjdk:21-jdk

# Copier le fichier JAR construit par Maven dans le conteneur
COPY target/*.jar /app/monapplication.jar

# Définir le répertoire de travail à /app
WORKDIR /app


# Exposer le port sur lequel l'application Spring Boot écoute
EXPOSE 8080

# Commande à exécuter lorsque le conteneur démarre
CMD ["java", "-jar", "monapplication.jar"]
