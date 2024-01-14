create schema if not exists eazybank;
use eazybank;

set foreign_key_checks = 0;

drop table if exists users;
create table users
(
    id       bigint auto_increment
        primary key,
    username varchar(50)  not null,
    password varchar(500) not null,
    enabled  tinyint(1)   not null
);

drop table if exists authorities;
create table authorities
(
    id        bigint auto_increment
        primary key,
    username  varchar(50) not null,
    authority varchar(50) not null,
    user_id   bigint      not null,
    constraint fk_authorities_users
        foreign key (user_id) references users (id)
            on update cascade on delete cascade
);

create table customer (
    id bigint not null auto_increment primary key,
    email varchar(45) not null,
    pwd varchar(255) not null,
    role varchar(45) not null
)

insert into users(username, password, enabled)
values ('ehigh', '123', 1);

insert into authorities(username, authority, user_id)
values('ehigh', 'write', 1);

insert into customer(email, pwd, role)
values('test@gmail.com', '123', 'admin');

set foreign_key_checks = 1;