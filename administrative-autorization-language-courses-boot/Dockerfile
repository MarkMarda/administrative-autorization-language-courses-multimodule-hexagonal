# # Stage 1: Build Stage
# FROM maven:3.9.12-eclipse-temurin-21 AS build
# WORKDIR /workspace
# COPY . .
# # compile only boot module
# RUN mvn -pl administrative-autorization-language-courses-boot -am clean package -DskipTests
#
# # # Stage 2: Create minimal Java runtime with JLink
# # FROM eclipse-temurin:21-jdk-alpine AS jlink
# # RUN $JAVA_HOME/bin/jlink \
# #     --module-path $JAVA_HOME/jmods \
# #     --add-modules java.base,java.logging,java.xml,java.sql,jdk.unsupported,java.desktop \
# #     --output /javaruntime \
# #     --compress=2 --no-header-files --no-man-pages
#
# # Stage 2: JLink con detección automática
# # FROM eclipse-temurin:21-jdk-alpine AS jlink
# # WORKDIR /workspace
# # COPY --from=build /workspace/administrative-autorization-language-courses-boot/target/*.jar app.jar
# #
# # RUN JAVA_MODULES=$(jdeps --ignore-missing-deps --print-module-deps --multi-release 21 app.jar),java.desktop,jdk.unsupported && \
# #     $JAVA_HOME/bin/jlink \
# #     --module-path $JAVA_HOME/jmods \
# #     --add-modules $JAVA_MODULES \
# #     --strip-debug \
# #     --no-header-files \
# #     --no-man-pages \
# #     --output /javaruntime
#
# # Stage 2: JLink con detección automática + módulos críticos manuales
# FROM eclipse-temurin:21-jdk-alpine AS jlink
# WORKDIR /workspace
# COPY --from=build /workspace/administrative-autorization-language-courses-boot/target/*.jar app.jar
#
# RUN JAVA_MODULES=$(jdeps --ignore-missing-deps --print-module-deps --multi-release 21 app.jar),java.desktop,jdk.unsupported,java.management,java.naming && \
#     $JAVA_HOME/bin/jlink \
#     --module-path $JAVA_HOME/jmods \
#     --add-modules $JAVA_MODULES \
#     --strip-debug \
#     --no-header-files \
#     --no-man-pages \
#     --output /javaruntime
#
# # Stage 3: Final Stage
# FROM alpine:3.20
# WORKDIR /app
# COPY --from=jlink /javaruntime /opt/java-minimal
# ENV PATH="/opt/java-minimal/bin:$PATH"
# #COPY --from=build /app/target/*.jar /app/app.jar
# COPY --from=build /workspace/administrative-autorization-language-courses-boot/target/*.jar /app/app.jar
#
# # EXPOSE 8081
# ENTRYPOINT ["java", "-jar", "/app/app.jar"]

#------------------------------------------------------------------------------------

# Stage 1: Build Stage
FROM maven:3.9.12-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY . .
# Compilar solo el módulo boot y sus dependencias
RUN mvn -pl administrative-autorization-language-courses-boot -am clean package -DskipTests

# Stage 2: Final Stage (Usamos el JRE completo oficial)
# Esta imagen ya incluye java.desktop, java.management, jgss, etc.
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el JAR generado en el Stage 1
COPY --from=build /workspace/administrative-autorization-language-courses-boot/target/*.jar /app/app.jar

# Exponer el puerto (opcional, informativo)
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

#------------------------------------------------------

# ---------- STAGE 1: Build ----------
# FROM eclipse-temurin:21-jdk AS builder
#
# WORKDIR /app
#
# # Copiar todo el proyecto
# COPY . .
#
# # Construir jar
# RUN ./mvnw clean package -DskipTests
#
#
# # ---------- STAGE 2: Runtime ----------
# FROM eclipse-temurin:21-jdk
#
# WORKDIR /app
#
# # ===== Seguridad =====
# # Crear grupo y usuario sin privilegios
# RUN groupadd --system app && useradd --system --gid app app
#
# # Crear directorio dedicado (permiso usuario app)
# RUN mkdir -p /app && chown -R app:app /app
#
# # Cambiar usuario
# USER app
#
# # ===== Variables =====
# ENV JAVA_OPTS="-XX:MaxRAMPercentage=75"
# ENV SPRING_PROFILES_ACTIVE=prod
#
# # Copiar jar ya compilado
# COPY --from=builder /app/administrative-autorization-language-courses-boot/target/*.jar app.jar
#
# # Puerto interno (opcional)
# #EXPOSE 8080
#
# # ===== Arranque =====
# ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]



