insert into director("id","first_name","last_name")
values
(1,'Joel','Shumacher'),
(2,'Robert','Iscove');

INSERT INTO theater("id", "location", "number", "parent_co")
VALUES
(1, 'Malvern', 69, 'AMC'),
(2, 'Ardmore', 12, 'Regal');

insert into movie("id","title","director_id", "run_time", "release_date")
values
(1,'Batman and Robin', 1, 125, '1997-06-20'),
(2,'She''s all that', 2, 95, '1999-01-29');

INSERT INTO showtime("id", "movie_id", "show_time", "theater_id")
VALUES
(1,1, '2018-10-25 06:10:00-05', 1),
(2,2, '2018-10-25 08:10:00-05', 1),
(3,1, '2018-10-26 10:20:00-05', 2),
(4,2, '2018-10-26 11:40:00-05', 2);