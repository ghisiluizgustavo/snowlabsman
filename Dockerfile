# Usar uma imagem base com JDK 17 para executar o JAR
FROM eclipse-temurin:17-jdk-jammy

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado localmente na pasta 'target' para o contêiner
COPY target/*.jar app.jar

# Expor a porta usada pela aplicação Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]