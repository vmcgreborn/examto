DROP TABLE IF EXISTS FRIEND;

CREATE TABLE FRIEND(
friend_id int, 
name varchar(100),
lastName varchar(100),
age int
);


INSERT INTO FRIEND(friend_id, name,lastName,age) 
VALUES (1, 'Raul','padilla',23)
,(2, 'Raul','Galvez',25)
,(3,'fernando','Sola',34)
;

