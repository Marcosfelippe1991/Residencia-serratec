create database ecommerce;

create schema vendas;

create table vendas.funcionario
(
	idfuncionario serial primary key,
	nomeFuncionario varchar(100),
	cpfFuncionario varchar(11)
);

create table vendas.bairro
(
	idbairro serial primary key,
	Bairro varchar(100)
);

create table vendas.cidade
(
	idcidade serial primary key,
	cidade varchar(100),
	uf varchar(2)
);

create table vendas.endereco
(
	idEndereco serial primary key,
	Logradouro varchar(160),
	idbairro integer REFERENCES vendas.bairro (idbairro),
	idcidade integer REFERENCES vendas.cidade (idcidade),
	CEP varchar(8),
	numero varchar(10)
);

create table vendas.cliente
(
	idCliente serial primary key,
	nomeCompleto varchar(160),
	nomeUsuario varchar(50),
	email varchar(160),
	cpf varchar(11),
	dataNascimento date,
	idEndereco integer REFERENCES vendas.endereco (idEndereco)
);

create table vendas.categoria
(
	idcategoria serial primary key,
	nomeCat varchar(160),
	descricaoCat varchar(200)
);

create table vendas.produto
(
	idProduto serial primary key,
	nomeProduto varchar(100),
	descricaoProduto varchar(200),
	qtdEstoque integer,
	dataFabricacao date,
	valorUnitario double precision,
	idcategoria integer REFERENCES vendas.categoria (idcategoria),
	idfuncionario integer REFERENCES vendas.funcionario (idfuncionario)
);

create table vendas.NotaFiscal
(
	idnota serial primary key,
	idCliente integer REFERENCES vendas.cliente (idCliente),
	serie varchar(10),
	emissao timestamp,
	vltotalNota double precision
);

create table vendas.PedidoItem
(
	idpedidoitem serial primary key,
	idnota integer REFERENCES vendas.NotaFiscal (idnota),
	idProduto integer REFERENCES vendas.produto (idProduto),
	quantidade integer,
	valorUnitario double precision
);

create table vendas.Pedido
(
	idPedido serial primary key,
	idCliente integer REFERENCES vendas.cliente (idCliente),
	idpedidoitem integer REFERENCES vendas.PedidoItem (idpedidoitem),
	pedidoData date
);

insert into vendas.funcionario
(nomeFuncionario, cpfFuncionario)
values
('Funcionário 1', '11111111111'),
('Funcionário 2', '22222222222'),
('Funcionário 3', '33333333333'),
('Funcionário 4', '44444444444'),
('Funcionário 5', '55555555555');

insert into vendas.bairro
(Bairro)
values
('Centro'),
('Vila Velha'),
('Unamar'),
('Bairro 2'),
('Lagoinha');

insert into vendas.cidade
(Cidade, uf)
values
('Petrópolis', 'RJ'),
('Rio Verde', 'GO'),
('Cabo Frio', 'RJ'),
('Mogi Guaçu', 'SP'),
('Campinas', 'SP');

insert into vendas.endereco
(Logradouro, idbairro, idcidade, CEP, numero)
values
('Rua 1', 1, 1, '25635030', '11'),
('Rua 2', 2, 2, '54987531', '12'),
('Rua 3', 3, 3, '98765421', '13'),
('Rua 4', 4, 5, '21654842', '14'),
('Rua 5', 5, 4, '13546821', '5');

insert into vendas.cliente
(nomeCompleto, nomeUsuario, email, cpf, dataNascimento, idendereco)
values
('Maria da Silva', 'msilva', 'maria@gmail.com', '23365487999', '04-03-1989', 1),
('João Fonseca', 'joao_f', 'joao@gmail.com', '98854785122', '25-10-1988', 2),
('Paulo Andrade', 'pauloandrade', 'paulo@gmail.com', '65432965498', '29-01-1961', 3),
('Ana Antunes', 'anaAntunes', 'ana@gmail.com', '91532647896', '03-02-1975', 4),
('José Oliveira', 'jose_ol', 'jose@gmail.com', '39654896320', '02-07-1992', 5);

insert into vendas.categoria
(nomeCat, descricaoCat)
values
('Categoria 1', 'Descrição da categoria 1'),
('Categoria 2', 'Descrição da categoria 2'),
('Categoria 3', 'Descrição da categoria 3'),
('Categoria 4', 'Descrição da categoria 4'),
('Categoria 5', 'Descrição da categoria 5');

insert into vendas.produto
(nomeProduto, descricaoProduto, qtdEstoque, dataFabricacao, valorUnitario, idcategoria, idfuncionario)
values
('Produto 1', 'Descrição produto 1', 24, '01-01-2022', 250.90, 1, 1),
('Produto 2', 'Descrição produto 2', 100, '21-05-2022', 300, 2, 1),
('Produto 3', 'Descrição produto 3', 2, '10-03-2021', 1200.85, 3, 3),
('Produto 4', 'Descrição produto 4', 15, '08-05-2021', 150, 4, 2),
('Produto 5', 'Descrição produto 5', 8, '30-8-2020', 50, 5, 5);

insert into vendas.NotaFiscal
(idcliente, serie, emissao)
values
(1, '1A1B', '26-08-2022 15:02:00'),
(2, '2A2B', '14-08-2022 08:30:00'),
(3, '3A3B', '04-07-2022 12:16:00'),
(4, '4A4B', '02-07-2022 16:45:00'),
(5, '5A5B', '12-06-2022 19:06:00');

insert into vendas.PedidoItem
(idnota, idProduto, quantidade, valorUnitario)
values
(1, 1, 1, 250.90),
(1, 2, 2, 100),
(2, 5, 2, 50),
(3, 3, 1, 1200.85),
(3, 4, 1, 150);

insert into vendas.Pedido
(idpedidoitem, idCliente, pedidoData)
values
(1, 2, '25-08-2022'),
(1, 3, '12-08-2022'),
(2, 1, '02-07-2022'),
(3, 1, '30-06-2022'),
(5, 5, '10-06-2022');

update vendas.NotaFiscal set serie = '2A2B2C' where idnota = 2;

delete from vendas.funcionario where idfuncionario = 4;

select count(idproduto) from vendas.produto
group by idfuncionario;

select * from vendas.produto pd
left join vendas.funcionario fc on fc.idfuncionario = pd.idfuncionario;

select cl.nomecompleto, ed.logradouro, ba.bairro, ci.cidade, ci.uf from vendas.cliente cl
left join vendas.endereco ed on ed.idendereco = cl.idendereco
left join vendas.bairro ba on ba.idbairro = ed.idbairro
left join vendas.cidade ci on ci.idcidade = ed.idcidade;

select count(uf) from vendas.cliente cl
left join vendas.endereco ed on ed.idendereco = cl.idendereco
left join vendas.bairro ba on ba.idbairro = ed.idbairro
left join vendas.cidade ci on ci.idcidade = ed.idcidade;

update vendas.NotaFiscal set vltotalNota = (select sum(quantidade * (valorUnitario)) from vendas.PedidoItem where idnota = 1);

select 
	c.nomecompleto, 
	c.nomeusuario, 
	c.email, 
	c.cpf,
	serie, 
	emissao,
	p.nomeproduto, 
	p.descricaoproduto, 
	p.datafabricacao, 
	i.quantidade, 
	i.valorunitario, 
	nf.vltotalNota
from vendas.NotaFiscal nf
left join vendas.cliente c on c.idcliente = nf.idcliente
left join vendas.PedidoItem i on i.idnota = nf.idnota
left join vendas.produto p on p.idproduto = i.idproduto
where nf.idnota = 1;
