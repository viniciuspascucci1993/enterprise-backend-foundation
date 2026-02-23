# ---------- BUILD STAGE ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copia tudo (monorepo)
COPY . .

# Builda apenas o módulo do serviço
RUN mvn -pl services/spring-boot-template -am clean package -DskipTests


# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Cria usuário não-root (boa prática de segurança)
RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

# Copia o jar gerado
COPY --from=build /app/services/spring-boot-template/target/*.jar app.jar

HEALTHCHECK --interval=30s --timeout=5s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8080/actuator/health || exit 1

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]