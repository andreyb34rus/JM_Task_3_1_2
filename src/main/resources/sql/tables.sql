drop table if exists users;

drop table if exists roles;

drop table if exists users_roles;

create table if not exists users
(
    id         serial,
    first_name varchar(50),
    last_name  varchar(50),
    age        int,
    email      varchar(255),
    password varchar(255),
    primary key (id)
);

create table if not exists roles(
    id serial,
    role_name varchar(50),
    primary key (id)
);

create table if not exists users_roles(
  user_id int,
  role_id int,
  primary key(user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);


