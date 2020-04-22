create table users
(
    username varchar(100) not null
        constraint users_pkey
            primary key,
    password  varchar(100) not null,
    enabled   smallint     not null
);

insert into users values ('admin', '{noop}11111', 1), ('user', '{noop}11111', 1);

create table authorities (
    username varchar(100) not null,
    authority varchar(100) not null
);

ALTER TABLE authorities ADD CONSTRAINT username_authority UNIQUE (username, authority);
ALTER TABLE authorities ADD CONSTRAINT fk_name foreign key (username) references users(username);

INSERT INTO authorities VALUES ('admin', 'ROLE_ADMIN'), ('user', 'ROLE_USER');

create table item
(
    id          serial not null
        constraint items_pk
            primary key,
    name        varchar(100),
    description text,
    price       numeric,
    user_name     varchar(100) not null
);

ALTER TABLE item ADD CONSTRAINT fk_user_name foreign key (user_name) references users(username);