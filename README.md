FOR RUNNING the app in DOCKER
=============================
USING DOCKER RUN
----------------
cd directory springboot-mysql-rabbitmq-docker
>mvn clean install

>docker build -f Dockerfile -t springbootmysqlrabbitmqdocker:1.0 .

>docker images

>docker run -p 3306:3306 --name demo-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -e MYSQL_USER=demo_user -e MYSQL_PASSWORD=demo_pass -d mysql:5.6

PORT EXPOSED
>docker run -p 3306:3306 --name demo-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -e MYSQL_USER=demo_user -e MYSQL_PASSWORD=demo_pass -d mysql:5.6


>docker run -p 8080:8080 --name demo-app --link demo-mysql:mysqlhost -d springbootmysqlrabbitmqdocker:1.0

>docker ps

>docker-machine ls

>curl http://<docker-ip>:8080

>docker stop <container_id> <container_id> ...

>docker ps -a

>docker rm <container-name>

>>docker rmi <imageid>

USING DOCKER COMPOSE
--------------------
cd directory springboot-mysql-rabbitmq-docker
>mvn clean install

>docker build -t springbootmysqlrabbitmqdocker:1.0 .

>docker images

>docker-compose up -d

>docker ps

>docker-machine ls

>docker logs -f <container_name>

>HIT http://<docker-ip>:8080

>docker ps -a

>docker stop <container_id> <container_id> ...

>docker rm <container_id> <container_id> ...


========
/create?email=[email]&name=[name]: create a new customer with an auto-generated id and email and name as passed values.
/getByEmail?email=[email]: retrieve the id for the customer with the given email address.
/update?id=[id]&email=[email]&name=[name]:update the email and the name for the customer identified by the given id.
/delete?id=[id]: delete the customer with the passed id.

TO SEE MYSQL DB
================

>docker exec -it <CONTAINER_ID> bash

>mysql --user=demo_user --password=demo_pass

>show databases;
>connect demo;
>show tables;
>select * from customer;