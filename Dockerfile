FROM openjdk:8
ENV spring
EXPOSE 8090
RUN mkdir -p /app/
ADD out/artifacts/complete_jar/complete.jar /app/spring-boot-commerce.jar
ENTRYPOINT ["java","-jar","/app/spring-boot-commerce.jar"]