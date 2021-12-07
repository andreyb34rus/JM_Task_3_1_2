insert into roles (id, role_name)
values (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

insert into users (id, first_name, last_name, age, email, password)
values (1, 'admin', 'admin', 35, 'admin@mail.ru'),
       (2, 'user', 'user', 33, 'user@mail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (1, 2),
       (2, 2);