# ===== Stage 1: Build WAR using Maven =====
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the WAR
RUN mvn clean package -DskipTests

# ===== Stage 2: Run WAR using Tomcat =====
FROM tomcat:10.1-jdk17
WORKDIR /usr/local/tomcat/webapps

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR from build stage
COPY --from=build /app/target/*.war ./ROOT.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
