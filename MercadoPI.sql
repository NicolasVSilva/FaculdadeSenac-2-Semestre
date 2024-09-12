create database MercadoPI;

use MercadoPI;
drop table cliente;
create table cliente(
	id int primary key auto_increment,
	nome varchar(50),
    cpf varchar(14),
    cep varchar(9),
    cidade varchar (32),
    estado varchar(10),
    rua varchar(50),
    email varchar(70),
    numeroResidencia int,
    telefone varchar(15),
    dataNascimento datetime,
    genero varchar(15),
    estadoCivil varchar(15)
);
select * from cliente;

drop table produto;
create table produto(
	idProduto int primary key auto_increment,
    nome varchar(50),
    tipoUnidade varchar(7),
    categoria varchar(15),
    descricao text,
    codBarras varchar(15),
    quantidade int,
    dataValidade date,
    preco float
);
select * from produto;

