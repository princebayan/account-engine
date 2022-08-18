FROM openjdk:11-jre-slim

LABEL maintainer  = "amir.bayan"
LABEL version     = "0.0.1"
LABEL description = "Account Engine java image"

# Setup the needed files
ADD /build/libs/account-engine-*-SNAPSHOT.jar account-engine.jar
COPY /build/resources/main/log4j2.xml log4j2.xml


COPY /src/main/resources/application-uat.yaml application-uat.yaml

ENV spring_profiles_active uat

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/account-engine.jar"]
