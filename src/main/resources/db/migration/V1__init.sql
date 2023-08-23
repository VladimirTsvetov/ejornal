create table programs
(
    id              bigserial primary key,
    title           varchar(255),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

insert into programs (title)
values
    ('Спортивная робототехника'),
    ('Инструменты компьютерной математики'),
    ('Микроэлектроника и схемотехника'),
    ('Информационная безопасность');