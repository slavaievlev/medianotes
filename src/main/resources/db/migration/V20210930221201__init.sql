create table note.user
(
    id         serial primary key,
    first_name varchar     not null,
    last_name  varchar     not null,
    email      varchar     not null,
    created_at timestamptz not null default now()
);

create table note.note
(
    id         serial primary key,
    title      varchar     not null,
    content    varchar,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),
    creator_id int         not null
        references note.user (id)
);
