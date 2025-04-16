# 빌드 스테이지
FROM gradle:8.7-jdk17 AS build
WORKDIR /app

# Gradle 캐시 최적화를 위해 설정 복사
COPY build.gradle settings.gradle gradle.properties* /app/
COPY gradle /app/gradle

ENV SPRING_PROFILES_ACTIVE=prod

RUN gradle build || return 0

# 전체 소스 복사 후 빌드
COPY . /app
RUN gradle build --no-daemon

# 실행 스테이지
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# 빌드 결과 JAR 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 컨테이너 실행 시 JAR 실행
ENTRYPOINT ["java","-jar","/app/app.jar"]
