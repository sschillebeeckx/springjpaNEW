DROP TABLE IF EXISTS guest;

CREATE TABLE guest (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  age INT
);


INSERT INTO guest(name ,age) VALUES ('John', 42);
INSERT INTO guest(name ,age) VALUES('Jane', 42);
INSERT INTO guest(name ,age) VALUES('Jim', 40);

commit;

