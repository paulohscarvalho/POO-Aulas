CREATE TABLE contatos (
	id int not null AUTO_INCREMENT,
	nome char(100),
	telefone char(30),
	email char(100),
	descricao varchar(255),
	PRIMARY KEY (id)
);