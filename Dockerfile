
FROM openjdk:8-jdk-alpine AS base

VOLUME /tmp
RUN apk add --no-cache bash
ENV GRADLE_VER 6.0.1
RUN wget -q https://services.gradle.org/distributions/gradle-6.0.1-bin.zip \
    && unzip gradle-$GRADLE_VER-bin.zip -d /opt \
    && rm gradle-6.0.1-bin.zip
ENV GRADLE_HOME /opt/gradle-6.0.1
ENV PATH $PATH:/opt/gradle-6.0.1/bin:/usr/src/example
COPY . /usr/src/example
RUN chmod +x /usr/src/example/wait-for-it.sh


FROM base AS api
EXPOSE 8083
ENTRYPOINT ["java","-jar","/usr/src/example/karate-test-prime-example-1.0-SNAPSHOT.jar"]


FROM base AS e2e

