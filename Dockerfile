# OpenJDK 17 기반 이미지 사용
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 래퍼 파일 복사
COPY gradlew gradlew.bat settings.gradle ./
COPY gradle gradle/

# Gradle 의존성 캐시를 위한 디렉토리 생성
RUN mkdir -p .gradle && chmod +x gradlew

# Gradle 빌드 의존성 설치
RUN ./gradlew --no-daemon dependencies

# 소스 코드 복사
COPY . .

# 애플리케이션 빌드
RUN ./gradlew build --no-daemon

# 실행 파일 위치 설정
ENV JAR_FILE=build/libs/velog-export-*.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/${JAR_FILE}"]

# 애플리케이션 포트 열기
EXPOSE 8080
