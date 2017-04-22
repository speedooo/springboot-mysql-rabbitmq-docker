FROM java:8
ADD /target/springboot-mysql-rabbitmq-docker.jar springboot-mysql-rabbitmq-docker.jar
ENTRYPOINT ["java","-jar","/springboot-mysql-rabbitmq-docker.jar"]