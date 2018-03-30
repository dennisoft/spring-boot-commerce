FROM openjdk:8
COPY ./out/production/classes/commerce/ /tmp
COPY ./out/production/resources/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","Application"]