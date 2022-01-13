create table if not exists Note
(
    id           int          not null,
    content      varchar(255) not null,
    creationDate timestamp    not null,
    primary key (id)
);

create table if not exists User
(
    id       int         not null,
    username varchar(20) not null,
    password varchar(20) not null,
    email    varchar(20) not null,
    primary key (id)
);

create table if not exists Note_User
(
    note int not null,
    user int not null
);

alter table Note_User add foreign key (note) references Note(id);
alter table Note_User add foreign key (user) references User(id);




