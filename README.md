# Java - Spring Boot multi-module App to Generate 1 million events.

## Overview
This repository contains example to generate 1 Million Transaction events/data in 2-4 seconds. It uses KafkaProducer to generate those events
and a KafkaConsumer to consume the events. KafkaProducer and KafkaConsumer both exists in different sub-modules. Each sub-module is dockerised
and has its own docker image. The Data currently generated is very basic and dummy data. 



### Data Model
We are generating events(data) related to bank transaction. We have the below data model that is initially created for the data format. 
```java
{
    "transactionID": Long,
    "accountNumber": String,
    "creationTime": String (in format MM/dd/YYYY hh:mm:ss),
    "processingTime": String (in format MM/dd/YYYY hh:mm:ss - initially will be null/empty, will be added when being written to event streaming platform after transformation),
    "persistenceTime": String (in format MM/dd/YYYY hh:mm:ss - initially will be null/empty, will be added when being written to data sinks),
    "amount": Long,
    "operationType": enum with values "CREDIT/DEBIT"
}
```
An Example:
```java
{
    "transactionID": "1",
    "accountNumber": "111111",
    "creationTime": "02/24/2023 01:58:21",
    "processingTime": "",
    "persistenceTime": "",
    "amount": "100",
    "operationType": "CREDIT"
}
```



### Project structure and folder details
- The `event-stream-utility` is a multi-module spring boot app which is built on Spring 2.x and Java 11.
- It uses maven as the build tool.
- The project consists of 3 sub-modules: `event-consumer`, `event-producer` and `streaming-utility`.
- The `event-consumer` module handles creating the Kafka consumer and message de-serialization. The `TransactionDeserializer` class performs the custom deserialization of the messages read from the kafka topic.
- The `event-producer` module handles creating the Kafka Producer, running multiple threads (4 here) to generate 250000 messages parallely and also the message serialization. The `TransactionGenerator` class implements the `Runnable` thread interface to create a multi-threading environment. The `TransactionSerializer` class performs the custom serialization of the messages produced to the kafka topic.
- We also have the `streaming-utility` module that simply contains the util classes for constants and also the entity classes which are auto generated from the AVRO file.
- The AVRO file `transaction.avsc` is also the part of the `streaming-utility` module.
- The `pom.xml` file in the `streaming-utility` module has the `avro-maven-plugin` plugin which is responsible for the auto code generation of entity classes from the AVRO records.
- The `pom.xml` files of each of these 3 sub-modules also have the `dockerfile-maven-plugin` plugin, and each module also has the `Dockerfile` file, which are together responsible for creating the docker images.



### Pre-requisites
You can run this project locally as well as on Cloud Run. Refer below steps.

#### To run Locally:
1. Clone the repository (`master` branch): https://bitbucket.org/ilabs-capco/event-generator/src/master/
2. Import the project as a maven project in IntelliJ IDE or any other IDE of your choice.
3. Let maven dependencies be downloaded in the IDE. Wait for the process to finish. You should have no errors in the IDE.
4. Before running the project, we need to set Kafka cluster with 3 brokers in you local machine. You can do it in two ways.
5. To run Kafka locally on a docker container, refer: https://developer.confluent.io/quickstart/kafka-docker/
6. To run Kafka directly on your machine locally, you need to first download the kafka binaries and run zookeeper and kafka locally in the terminal window. Refer this for more details: https://www.conduktor.io/kafka/how-to-install-apache-kafka-on-mac/. <em><b>NOTE: Please make sure you have Java 11 installed on your machine and also set the PATH variable in your bash file/environment variables to your JAVA 11 bin folder path.</b></em>
7. To create and run 3 kafka brokers along with the single zookeeper, refer this: https://sagarkudu.medium.com/set-up-a-kafka-cluster-in-local-with-multiple-kafka-brokers-98d4e4e7a343 
8. With the above setup done, you should have one zookeeper and 3 kafka brokers running together on your machine directly.
9. Next, you need to open a new terminal in your machine and create the kafka topic required for this app. The command for it is: 
``` java
kafka-topics.sh --create --topic test-topic --bootstrap-server <broker_1_hostname:port>,<broker_2_hostname:port>,<broker_3_hostname:port> --partitions 3 --replication-factor 2
```
10. Once the topic is created, you can now go to your IDE and run the command `mvn clean install` on the root folder. This should show a SUCCESS for each sub-module in the spring app. 
11. When the above command runs successfully, you will see `target` folders created for each sub-modules which will have the jars created for each of them. You will also be generating the docker images for each of those sub-modules.
12. To view the docker images created, open a terminal and run the command `docker image ls` and you should see your images created with the tag `0.0.1`. For example: `event-consumer: 0.0.1`, `event-producer:0.0.1` and `streaming-utility:0.0.1`.
13. Now you can run this app either through your IDE, by running the main class as a java application, or running the docker images in a terminal.
14. To run the app in IDE, go to file `TransactionConsumer.java` and run the main class and also go to file `TransactionProducer.java` and again run the main file. You should see events being generated by the producer and consumed by the consumer. You can also re-run the `TransactionConsumer.java` file to create multiple consumer instances in the consumer group. You will notice the `JOIN_GROUP` request sent by every other consumer that joins the group, before it starts consuming the messages generated by the producer.
15. Before running the docker images for Producer and Consumer locally in the terminal, we will need to change the IP addresses used by each of our 3 kafka brokers. This is because the docker container cannot connect to `localhost` or `127.0.0.1` on which the kafka brokers will be running locally on your machine. 
16. To get your host machine IP address, run the command `ipconfig getifaddr en0`, copy and paste the IP address shown there in your code (file: `KafkaConstants.java`).
17. Next, replace the listeners attribute in all kafka broker's `server.properties` file to `“listeners = PLAINTEXT://<IP_ADDRESS>:<PREVIOUS_PORT>”`, etc.
18. Restart your zookeeper and kafka broker instances running locally in your terminals.
19. Re-run `mvn clean install` and make sure the `target` folder is created properly and has the jars created.
20. Also, re-check if your docker images are re-created.
21. Now, to run the app's docker images in a terminal, open two terminals and first run the consumer and then the producer. Again here, you can run the consumer docker image multiple times to create multiple consumer instances consuming the messages. It should all run without any connection issues. Refer below commands to run the docker images:
```java
docker run event-consumer:0.0.1
docker run event-producer:0.0.1
```
16. You should observe that the producer takes approximately 2-4 secs to finish generating the 1 Million messages.



#### To run on Cloud Run:
********* To be added *********



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Kafka-Docker Quickstart](https://developer.confluent.io/quickstart/kafka-docker/)
* [Kafka-Mac setup](https://www.conduktor.io/kafka/how-to-install-apache-kafka-on-mac/)
* [Multiple Kafka Brokers setup](https://sagarkudu.medium.com/set-up-a-kafka-cluster-in-local-with-multiple-kafka-brokers-98d4e4e7a343)



### Guides
Extra learning materials:

* [Kafka Avro Serializer-Deserializer example](https://codenotfound.com/spring-kafka-apache-avro-serializer-deserializer-example.html)
* [Dockerfile Best Practices](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)
* [Dockerizing Spring Boot app](https://medium.com/@wizardom/dockerizing-spring-boot-microservices-and-deploying-them-on-google-cloud-platform-5e83cb197198)
* [Spring boot multi-module app example](https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-custom-starter)
* [Optimizing Kafka performance](https://granulate.io/blog/optimizing-kafka-performance/#:~:text=Increasing%20the%20number%20of%20partitions,replica%20sets%20will%20also%20increase.)
* [Optimizing Kafka Producer/Consumer performance](https://docs.confluent.io/cloud/current/client-apps/optimizing/throughput.html#producer-acks)
* [Overview of ExecutorService thread in Java](https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/)
* [Setup JAVA_HOME in MAC terminal](https://stackoverflow.com/questions/22842743/how-to-set-java-home-environment-variable-on-mac-os-x-10-9)
* [Multithreading in Java](https://www.mygreatlearning.com/blog/multithreading-in-java/#:~:text=In%20Java%2C%20Multithreading%20refers%20to,and%20share%20the%20process%20resources.)