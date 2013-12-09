DROP TABLE conference;
DROP TABLE Users;
DROP TABLE demo;
DROP TABLE Categories;
DROP TABLE Participants;
DROP TABLE user_roles;

CREATE TABLE demo (
	id IDENTITY PRIMARY KEY,
    data VARCHAR(100)
);

CREATE TABLE conference (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    startDate DATETIME NOT NULL,
    endDate DATETIME NOT NULL,
    description varchar(1000),
    city varchar(255) NOT NULL,
    street varchar(255) NOT NULL,
    category_id int NOT NULL,
    creator_id int NOT NULL
);

CREATE TABLE  Users(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
  USER_ROLE_ID IDENTITY PRIMARY KEY,
  USER_ID INT NOT NULL,
  AUTHORITY VARCHAR(45) NOT NULL
);

CREATE TABLE Categories(
  id IDENTITY PRIMARY KEY,
  category_title varchar(255) NOT NULL
);

CREATE TABLE Participants(
  id IDENTITY PRIMARY KEY,
  participant_id int NOT NULL,
  conference_id int NOT NULL
);

CREATE INDEX startDate ON conference (startDate);
CREATE INDEX endDate ON conference (endDate);
