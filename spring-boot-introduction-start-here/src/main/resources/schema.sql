  CREATE TABLE tasks(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  summary VARCHAR(256) NOT NULL,
  description TEXT,
  status VARCHAR(256) NOT NULL
  );

create table users (
username varchar(50) not null primary key,
password varchar(500) not null,
authority enum('ADMIN', 'USER') not null
);