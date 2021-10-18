create table note.role
(
    id   int primary key,
    code varchar not null
);

insert into note.role
values
       (1, 'admin'),
       (2, 'user');

create table note.user_role
(
    id      serial primary key,
    user_id int not null
        references note.user (id),
    role_id int not null
        references note.role (id)
);
