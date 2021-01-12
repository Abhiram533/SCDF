FROM node:latest
# Install OpenJDK-8
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;

# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME
ENV SPRING_CLOUD_DATAFLOW_APPLICATIONPROPERTIES_STREAM_SPRING_CLOUD_STREAM_KAFKA_BINDER_BROKERS=PLAINTEXT://kafka-broker:9092
ENV SPRING_CLOUD_DATAFLOW_APPLICATIONPROPERTIES_STREAM_SPRING_CLOUD_STREAM_KAFKA_STREAMS_BINDER_BROKERS=PLAINTEXT://kafka-broker:9092
ENV SPRING_CLOUD_DATAFLOW_APPLICATIONPROPERTIES_STREAM_SPRING_CLOUD_STREAM_KAFKA_BINDER_ZKNODES=zookeeper:2181
ENV SPRING_CLOUD_DATAFLOW_APPLICATIONPROPERTIES_STREAM_SPRING_CLOUD_STREAM_KAFKA_STREAMS_BINDER_ZKNODES=zookeeper:2181
RUN npm install pm2 -g
ADD spring-cloud-dataflow-server-2.7.0.jar  spring-cloud-dataflow-server-2.7.0.jar
ADD spring-cloud-skipper-server-2.6.0.jar  spring-cloud-skipper-server-2.6.0.jar
ADD spring-cloud-dataflow-shell-2.7.0.jar spring-cloud-dataflow-shell-2.7.0.jar
ADD producer-0.0.1-SNAPSHOT.jar producer-0.0.1-SNAPSHOT.jar
ADD processor-0.0.1-SNAPSHOT.jar processor-0.0.1-SNAPSHOT.jar
ADD consumer-0.0.1-SNAPSHOT.jar consumer-0.0.1-SNAPSHOT.jar
ADD process.json process.json
CMD ["pm2-runtime","process.json"]




