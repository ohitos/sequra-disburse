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
java -jar target/default-unnamed-service-0.1.0-SNAPSHOT.jar
```
