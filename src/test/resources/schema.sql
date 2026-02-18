create table dancer_details
(
    dancer_details_id int auto_increment,
    city_of_birth     varchar(150),
    year_of_birth     int,
    primary key (dancer_details_id)
);

CREATE TABLE dancers
(
    dancer_id         int auto_increment,
    first_name        varchar(150),
    last_name         varchar(150),
    preferred_dance   varchar(150),
    dancer_details_id int,
    primary key (dancer_id),
    FOREIGN KEY (dancer_details_id) REFERENCES dancer_details (dancer_details_id)
);

CREATE TABLE dance_play
(
    dance_play_id     int auto_increment,
    title             varchar(150),
    primaballerina_id INT,
    primary key (dance_play_id),
    FOREIGN KEY (primaballerina_id) REFERENCES dancers (dancer_id)
);

create table dancer_rating
(
    dancer_rating_id int auto_increment,
    dance_play_id    int       not null,
    dancer_id        int       not null,
    date_of_rating   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    rating           int,
    primary key (dancer_rating_id),
    CONSTRAINT fk_dancer_rating_dancer
        FOREIGN KEY (dancer_id)
            REFERENCES dancers (dancer_id),

    CONSTRAINT fk_dancer_rating_dance_play
        FOREIGN KEY (dance_play_id)
            REFERENCES dance_play (dance_play_id)
);