FROM openjdk:11-jre-slim

LABEL maintainer  = "amir.bayan"
LABEL version     = "0.0.1"
LABEL description = "Persona java image"

# Setup the needed files
ADD /build/libs/persona-*-SNAPSHOT.jar persona.jar
COPY /build/resources/main/log4j2.xml log4j2.xml


COPY /src/main/resources/application-uat.yaml application-uat.yaml

ENV spring_profiles_active uat

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/persona.jar"]
