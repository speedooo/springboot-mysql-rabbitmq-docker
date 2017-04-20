FROM java:8
VOLUME /tmp
ADD /target/springboot-mysql-rabbitmq-docker.jar springboot-mysql-rabbitmq-docker.jar
RUN bash -c 'touch /springboot-mysql-rabbitmq-docker.jar'
ENTRYPOINT ["java","-jar","/springboot-mysql-rabbitmq-docker.jar"]