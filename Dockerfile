# FROM openjdk:11-slim AS builder
# RUN mkdir /project
# ADD . /project
# RUN cd /project && ./gradlew clean bootJar

FROM openjdk:11-slim
RUN mkdir /app
# COPY  --from=builder /project/build/libs/*.jar  /app/tcp.jar
COPY  build/libs/*.jar  /app/tcp.jar
WORKDIR /app
CMD ["java", "-jar", "tcp.jar"]