create table users(
    id bigint primary key auto_increment,
    run varchar(13) unique not null,
    nombres varchar (225) not null,
    apellidos varchar (225) not null,
    FechaNacimiento Date not null,
    correo varchar (255) unique not null,
    password varchar(225) not null,
    createdAT date
);