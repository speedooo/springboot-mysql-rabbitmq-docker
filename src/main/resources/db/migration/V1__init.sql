CREATE TABLE customer (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

insert into customer (name, email) values ('Avijit', 'avijit@abc.com');