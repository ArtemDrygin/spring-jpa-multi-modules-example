create table users
(
    id bigint not null
        constraint users_pkey
            primary key,
    name varchar(255)
);

create table messages
(
    id bigint not null
        constraint messages_pkey
            primary key,
    text varchar(255),
    user_id bigint not null
        constraint fk_messages_users
            references users
);