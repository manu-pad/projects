CREATE DATABASE hive

CREATE TABLE hive.produto
(
    IDproduto INT,
    NomeProduto VARCHAR (20),
    Descricao VARCHAR (50),
    Preco INT,
        PRIMARY KEY (IDproduto),
);

CREATE TABLE hive.user
(
    IDuser INT,
    IDProduto INT,
    nome VARCHAR(30),
    Email VARCHAR(30),
        PRIMARY KEY (IDuser),
        FOREIGN KEY (IDProduto) REFERENCES hive.produto (IDProduto)
);
