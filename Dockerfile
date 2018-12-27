FROM openjdk:8
VOLUME /tmp
ADD build/libs/Cassandra-0.0.1-SNAPSHOT.jar Cassandra-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Cassandra-0.0.1-SNAPSHOT.jar"]
