CREATE TABLE Agencia (
idAgencia INTEGER AUTO_INCREMENT PRIMARY KEY,
nomeAgencia VARCHAR(255),
enderecoAgencia VARCHAR(255),
telefoneAgencia VARCHAR(15)
);

CREATE TABLE Cliente (
idCliente INTEGER AUTO_INCREMENT PRIMARY KEY,
emailCliente VARCHAR(255),
nomeCliente VARCHAR(255),
cpfCliente VARCHAR(12),
telefoneCliente VARCHAR(15),
enderecoCliente VARCHAR(255)
);

CREATE TABLE Destinos (
idDestinos INTEGER AUTO_INCREMENT PRIMARY KEY,
precoDestino DECIMAL(10,2),
descricaoDestino VARCHAR(255),
nomeDestino VARCHAR(255),
localizacaoDestino VARCHAR(255)
);

CREATE TABLE Promocao (
idPromocao INTEGER AUTO_INCREMENT PRIMARY KEY,
descricaoPromocao VARCHAR(255),
destinosIcluidos VARCHAR(255),
dataPromocao DATETIME
);


CREATE TABLE Passagem (
idPassagem INTEGER AUTO_INCREMENT PRIMARY KEY,
dataViagem DATETIME,
precoPassagem DECIMAL(10,2),
idCliente INTEGER,
idDestinos INTEGER,
FOREIGN KEY(idCliente) REFERENCES Cliente (idCliente),
FOREIGN KEY(idDestinos) REFERENCES Destinos (idDestinos)
);

