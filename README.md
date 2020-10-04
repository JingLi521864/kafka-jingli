# kafka-jingli

## Prerequisities
- OpenJDK
- Apache Zookeeper, installed and working
- Apache Kafka, installed and working

## Start Zookeeper

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

## Start Kafka

.\bin\windows\kafka-server-start.bat .\config\server.properties

## Create the Topic

.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --create --topic newtest

## Compile and Build the Fat Jar File

mvn clean compile assembly:single

## Start Comsumer

java -cp target/kafka-jingli-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.kafkajlcom.CustomConsumer newtest group1

## Start Producer

java -cp target/kafka-jingli-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.kafkajlcom.JingLiProducer newtest
