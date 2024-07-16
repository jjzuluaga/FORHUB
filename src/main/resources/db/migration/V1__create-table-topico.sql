create table topicos(

id bigint not null auto_increment,
titulo varchar(100) not null unique,
mensaje varchar(100) not null unique,
fechaCreacion DATE not null,
status BOOLEAN not null,
autor varchar(100) not null,
curso varchar(100) not null,

primary key(id)

);