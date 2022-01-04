create table if not exists Note
(
    id           int          not null,
    content      varchar(255) not null,
    creationDate timestamp    not null,
    primary key (id)
);
