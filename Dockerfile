FROM openjdk:17
COPY build/libs/ProjectConcesionarioCoches.jar .
ENTRYPOINT ["java", "-jar", "ProjectConcesionarioCoches.jar"]