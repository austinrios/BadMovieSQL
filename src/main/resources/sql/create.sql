Drop table showtime;
drop table theater;
drop table movie;
drop table director;

CREATE TABLE director(
  id int,
  first_name varchar,
  last_name varchar,
  PRIMARY key (id)
);

CREATE TABLE theater(
  id int,
  location varchar,
  number int,
  parent_co varchar,
  primary key (id)
);

CREATE TABLE movie(
  id int,
  title VARCHAR(40),
  directorId INT,
  runTime INT ,
  release_date date,
  PRIMARY key (id),
  FOREIGN key (directorId) references director(id)
);

CREATE TABLE showtime(
  id int,
  show_time TIMESTAMP,
  movie_id INT,
  theater_id INT,
  PRIMARY key (id),
  FOREIGN key (movie_id) references movie(id),
  FOREIGN key (theater_id) references theater(id)
);
