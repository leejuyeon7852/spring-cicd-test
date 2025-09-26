# 1. JDK 베이스 이미지
FROM openjdk:21-jdk-slim

# 2. 작업 디렉토리
WORKDIR /app

# 3. 빌드된 JAR 복사
COPY build/libs/*-SNAPSHOT.jar app.jar

# 4. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]