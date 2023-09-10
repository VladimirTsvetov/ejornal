
create table employees
(
    id              bigserial primary key,
    name            varchar(50) not null,
    patronymic      varchar(50),
    surname         varchar(50) not null,
    phone           varchar(20),
    address         varchar(255) not null,
    email           varchar(255),
    title           varchar(255),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

insert into employees(name,patronymic,surname,phone,address,email,title)
values
        (
            'Пётр',
            'Петрович',
            'Капица',
            '+7(925)1234567',
            'Москва, ул. Марьинский парк, 37, кв. 233',
            'p_kapitsa@email.edu',
            'professor'
        ),
        (
            'Игорь',
            'Куприянович',
            'Волков',
            '+7(890)1234599',
            'Москва, ул. Марьинский парк, 37, кв. 231',
            'volkov@email.net',
            'professor'
        );

create table groups
(
    id              bigserial primary key,
    title           varchar(255),
    employee_id     bigserial references employees(id),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

insert into groups(title,employee_id)
values ('7А7Б',1),('7Б',1),('7А',2),('10Б',2);

create table programs
(
    id              bigserial primary key,
    title           varchar(255),
    group_id        bigserial references groups(id),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

insert into programs (title,group_id)
values
    ('Робототехника',1),
    ('Инструменты компьютерной математики',2),
    ('Микроэлектроника и схемотехника',3),
    ('Информационная безопасность',4);

create table address
(
    id              bigserial primary key,
    city            varchar(255),
    street          varchar(255),
    home            varchar(5),
    apparts         varchar(5)
);

create table schedules
(
    id              bigserial primary key,
    work_day        varchar(255),
    work_time       TIME,
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

insert into schedules(work_day,work_time)
values
    ('понедельник', '16:30'),
    ('вторник','15:30' ),
    ('среда','15:30'),
    ('четверг','15:30');


create table students
(
    id              bigserial primary key,
    name            varchar(50) not null,
    surname         varchar(50) not null,
    age             int not null,
    address         varchar(255) not null,
    group_id        bigserial references groups(id),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

insert into students(name, surname, age, address,group_id )
values
    ('Иван','Иванов', 12, 'Москва, ул. Марьинский парк 43, кв. 1',1),
    ('Петр','Петров', 12, 'Москва, ул. Марьинский парк 43, кв. 2',1),
    ('Сергей','Сергеев', 12, 'Москва, ул. Марьинский парк 43, кв. 3',2),
    ('Федор','Федоров', 12, 'Москва, ул. Марьинский парк 43, кв. 4',2),
    ('Александр','Александров', 16, 'Москва, ул. Марьинский парк 43, кв. 5',4),
    ('Алексей','Алексеев', 16, 'Москва, ул. Марьинский парк 43, кв. 6',4),
    ('Максим','Максимов', 16, 'Москва, ул. Марьинский парк 43, кв. 7',4);
