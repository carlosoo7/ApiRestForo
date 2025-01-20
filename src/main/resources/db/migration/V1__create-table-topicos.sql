create table topicos
(

    id      bigint       not null auto_increment,
    titulo  varchar(100) not null UNIQUE,
    mensaje varchar(200) not null UNIQUE,
    fecha   DATETIME     not null,
    status  tinyint      not null,
    autor   varchar(100) not null,
    curso   varchar(100) not null,
    primary key (id)

);
