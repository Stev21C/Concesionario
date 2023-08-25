FROM openjdk:17
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/ProjectConcesionarioCoches.jar /app/ProjectConcesionarioCoches.jar
ENTRYPOINT ["java", "-jar", "/app/ProjectConcesionarioCoches"]