# cassandra

## Docker compose

will start cassandra and a rest web service in front of cassandra:

gradlew build   or  ./gradlew build (on Linux)

creates an executable jar file for the rest web service

docker-compose up --build

build is used to force the creation of a new image for the rest web service.

## Alternative to Docker compose

Starting cassandra:

docker run --name my-cassandra -p 9042:9042 cassandra:3.0

Build the rest web service:

gradlew build   or  ./gradlew build (on Linux)

Create the Docker image:

docker build -t cqrs .

Docker image definiton: https://github.com/charroux/cassandra/blob/master/Dockerfile

Start the rest web service:

docker run --name boots --link my-cassandra:db -p 8080:8080 cqrs

## If needed (stopping and removing the containers):

docker container rm containerID
docker container stop containerID

## The code

The persistent class: https://github.com/charroux/cassandra/blob/master/src/main/java/com/example/Cassandra/Event.java

The Sring data repository: https://github.com/charroux/cassandra/blob/master/src/main/java/com/example/Cassandra/EventRepository.java

The rest web service: https://github.com/charroux/cassandra/blob/master/src/main/java/com/example/Cassandra/RestWebService.java

Cassandra configuration access: https://github.com/charroux/cassandra/blob/master/src/main/java/com/example/Cassandra/CassandraConfig.java

A retry pattern is used to retry a connection after a delay of 10 secondes (waits for Cassandra).
 
Rest web service parameters: https://github.com/charroux/cassandra/blob/master/src/main/resources/application.properties:

spring.cassandra.host is used in: https://github.com/charroux/cassandra/blob/master/docker-compose.yml





