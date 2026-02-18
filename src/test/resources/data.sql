insert into dancer_details(city_of_birth, year_of_birth)
values ('Kyev', 1980),
       ('Warszawa', 1990),
       ('Charkov', 1999),
       ('Lviv', 2000),
       ('Krakow', 2010),
       ('Moskva', 2005);
insert into dancers
VALUES (1, 'Maria', 'Xiovskaya', 'STACCATO', 1);
insert into dancers
VALUES (2, 'Anna', 'Czerna', 'STACCATO', 2);
insert into dancers
VALUES (3, 'Olga', 'Leboda', 'LEGATO', 3);
insert into dancers
VALUES (4, 'Aleksandra', 'Krasnaya', 'STACCATO', 4);
insert into dancers
VALUES (5, 'Mykhail', 'Kovalski', 'STACCATO', 5);
insert into dancers
VALUES (6, 'Patryk', 'Czechon', 'LEGATO', 6);

insert into dance_play
VALUES (1, 'Swan Lake', 1);
insert into dance_play
VALUES (2, 'Don Kichot', 2);
insert into dance_play
VALUES (3, 'Bolero', null);
insert into dance_play
VALUES (4, 'Nutcracker', 3);
insert into dance_play
VALUES (5, 'Sleeping Beauty', 1);
insert into dance_play
VALUES (6, 'Dracula', null);

INSERT INTO dancer_rating (dancer_id, dance_play_id, date_of_rating, rating)
VALUES (1, 1, '2026-02-01 09:10:00', 4),
       (2, 2, '2026-02-01 10:20:00', 5),
       (3, 3, '2026-02-02 11:30:00', 3),
       (4, 4, '2026-02-02 12:40:00', 2),
       (5, 5, '2026-02-03 13:50:00', 5),
       (6, 6, '2026-02-03 15:00:00', 4),
       (1, 2, '2026-02-04 09:15:00', 3),
       (2, 3, '2026-02-04 10:25:00', 4),
       (3, 4, '2026-02-05 11:35:00', 5),
       (4, 5, '2026-02-05 12:45:00', 3),
       (5, 6, '2026-02-06 13:55:00', 2),
       (6, 1, '2026-02-06 15:05:00', 5),
       (1, 1, '2026-02-07 16:15:00', 5),
       (2, 2, '2026-02-07 17:25:00', 3),
       (3, 3, '2026-02-08 18:35:00', 4),
       (4, 4, '2026-02-08 19:45:00', 5);