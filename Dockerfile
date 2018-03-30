FROM openjdk:8
EXPOSE 8090
ADD build/libs/gs-accessing-data-mysql-0.1.0.jar spring-boot-commerce.jar
ENTRYPOINT ["java","-jar","spring-boot-commerce.jar"]