create table usuarios
(

    id   bigint       not null auto_increment,
    user varchar(100) not null,
    pass varchar(200) not null,
    primary key (id)
);
