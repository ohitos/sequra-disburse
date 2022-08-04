# sequra-disburse

## How to build and run this service ##

### Pre-requisites ###

In order to build this service the following software should be installed and added to your PATH:

- OpenJDK 11.0.2 (<https://jdk.java.net/archive/>)
- Apache Maven 3 (3.8.4+ recommended) (<https://maven.apache.org/download.cgi>)


### Building and running ###

First, compile and generate the jar artifact.

```
mvn clean install
```

At this point you could run locally your service with:

```
java -jar target/disburse-0.0.1-SNAPSHOT.jar
./mvnw spring-boot:run
```

### Solution ###
I choose a Repository-Service pattern in this case. 

The controllers will expose the endpoint to work with.
In the service the logic is placed.
The repositories are interface whose will interact with the DB struture.
Each entity-repository has his own service-repository to abstract the logic about them into separated classes.
