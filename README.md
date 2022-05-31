# Practices - Data engineering

## Tools you need
Have a stackoverflow account : https://stackoverflow.com/

Have a github account : https://github.com/

And a github repo to push your code.

### Fork the repo on your own Github account
* https://github.com/polomarcus/tp/fork

### Docker and Compose
Take time to read and install

https://docs.docker.com/get-started/overview/
```
docker --version
Docker version 20.10.14
```

https://docs.docker.com/compose/
```
docker-compose --version
docker-compose version 1.29.2
```


## TP1 - [Apache Kafka](https://kafka.apache.org/)
* Open `tp-docker-kafka-bash`

Answer these questions with what you can find on the documentation :

- What problems does Kafka solve ?
https://kafka.apache.org/documentation/#intro_streaming
- Which use cases ?
https://kafka.apache.org/documentation/#intro_usage
- What is a producer ?
Producers are those client applications that publish (write) events to Kafka, and consumers are those that subscribe to (read and process) these events. In Kafka, producers and consumers are fully decoupled and agnostic of each other, which is a key design element to achieve the high scalability that Kafka is known for. For example, producers never need to wait for consumers. Kafka provides various guarantees such as the ability to process events exactly-once.
- What is a consumer ?
consumers are those that subscribe to (read and process) these events. In Kafka, producers and consumers are fully decoupled and agnostic of each other, which is a key design element to achieve the high scalability that Kafka is known for. For example, producers never need to wait for consumers.
- What are consumer groups ?

- What is a offset ?

- Why using partitions ? 

- Why using replication ?

- What are  In-Sync Replicas (ISR) ?


![](https://content.linkedin.com/content/dam/engineering/en-us/blog/migrated/datapipeline_simple.png)

### Try to install Kafka without docker
https://kafka.apache.org/documentation/#gettingStarted

### Use kafka with docker
Start multiples kakfa servers (called brokers) by downloading a docker compose recipe : 
* https://github.com/conduktor/kafka-stack-docker-compose#single-zookeeper--multiple-kafka

Check on the docker hub the image used : 
* https://hub.docker.com/r/confluentinc/cp-kafka


### Verify
```
docker ps
CONTAINER ID   IMAGE                             COMMAND                  CREATED          STATUS         PORTS                                                                                  NAMES
b015e1d06372   confluentinc/cp-kafka:7.0.1       "/etc/confluent/dock…"   10 seconds ago   Up 9 seconds   0.0.0.0:9092->9092/tcp, :::9092->9092/tcp, 0.0.0.0:9999->9999/tcp, :::9999->9999/tcp   kafka1
(...)
```

### Getting started with Kafka
1. Connect to your kafka cluster with 2 command-line-interface (CLI)

Using [Docker exec](https://docs.docker.com/engine/reference/commandline/exec/#description)

```
docker exec -ti my_kafka_container_name bash
> pwd
```

```
> kafka-topics 
# will give you help to use this command
> kafka-topics --describe --bootstrap-server localhost:9092 
# will give you an error
```
Read this blog article to fix `Broker may not be available.` error : https://rmoff.net/2018/08/02/kafka-listeners-explained/

Pay attention to the `KAFKA_ADVERTISED_LISTENERS` config from the docker-compose file.

2. Create a "mailbox" - a topic with the default config : https://kafka.apache.org/documentation/#quickstart_createtopic
3. Check on which Kafka broker the topic is located using `--describe`
5. Send events to a topic on one terminal : https://kafka.apache.org/documentation/#quickstart_send
4. Keep reading events from a topic from one terminal : https://kafka.apache.org/documentation/#quickstart_consume
* try the default config
* what does the `--from-beginning` config do ?
* 
* If the consumer does not already have  
                                           an established offset to consume     
                                           from, start with the earliest        
                                           message present in the log rather    
                                           than the latest message.
 
* what about using the `--group` option for your producer ?
* --group <String: consumer group id>      The consumer group id of the consumer.
6. stop reading
7. Keep sending some messages to the topic

#### Partition 
1. Check consumer group with `kafka-console-consumer` : https://kafka.apache.org/documentation/#basic_ops_consumer_group
* notice if there is [lag](https://univalence.io/blog/articles/kafka-et-les-groupes-de-consommateurs/) for your group
2. read from a new group, what happened ?
3. read from a already existing group, what happened ?
4. Recheck consumer group

#### Replication - High Availability
1. Increase replication in case one of your broker goes down : https://kafka.apache.org/documentation/#topicconfigs
2. Stop one of your brokers with docker
3. Describe your topic, check the ISR (in-sync replica) config : https://kafka.apache.org/documentation/#design_ha
4. Restart your stopped broker
5. Check again your topic

## TP3 - Functional programming for data engineering
* Open `tp-data-processing-framework`

## TP 4 - Kafka Streams to read and write to Kafka
* https://kafka.apache.org/documentation/streams/
* https://github.com/polomarcus/Spark-Structured-Streaming-Examples
* Kafka User Interface (UI) : https://www.conduktor.io/download/
<<<<<<< HEAD

### Continuous Integration (CI)
If it works on your machine, congrats. Test it on a remote servers now thanks to a Continuous Integration (CI) system such as [GitHub Actions](https://github.com/features/actions) :
* How to use containers inside a CI : https://docs.github.com/en/github-ae@latest/actions/using-containerized-services/about-service-containers
<<<<<<< HEAD
* A Github Action example : https://github.com/conduktor/kafka-stack-docker-compose/blob/master/.github/workflows/main.yml

# Tools
* Scala IDE : https://www.jetbrains.com/idea/
* Kafka User Interface (UI) : https://www.conduktor.io/download/
=======
* A Github Action example : https://github.com/conduktor/kafka-stack-docker-compose/blob/master/.github/workflows/main.yml
>>>>>>> cfcdc8fd955785268d52ec080060bae0757c4bde
=======
>>>>>>> 1a0b0b03f788c9ad1a1a48792701b8f13ad3c1f6
