create database residencias;
use residencias;

create table dono(

	cpf varchar(11) primary key,
    nome varchar(60),
    telefone varchar(20),
    renda_mensal float
);

create table residencia(

	cod_residencia integer primary key,
    area float,
    endereco varchar(50),
    bairro varchar(20)

);

create table venda(

	cod_venda varchar(40) primary key,
    cpf varchar(11),
    cod_residencia integer,
    data date,
    valor_venda float,
    foreign key (cpf) references dono(cpf),
    foreign key (cod_residencia) references residencia(cod_residencia)
  
  );
  


