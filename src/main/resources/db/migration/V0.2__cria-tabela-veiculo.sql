CREATE TABLE veiculos (
                          id INT PRIMARY KEY IDENTITY(1,1),
                          proprietarioid INT NOT NULL,
                          marca VARCHAR(20) NOT NULL,
                          modelo VARCHAR(20) NOT NULL,
                          placa VARCHAR(7) NOT NULL,
                          status VARCHAR(20) NOT NULL,
                          data_cadastro DATETIME NOT NULL,
                          data_apreensao DATETIME,
                          CONSTRAINT FK_veiculo_proprietario FOREIGN KEY (proprietarioid) REFERENCES proprietarios(proprietarioid),
                          CONSTRAINT unique_veiculo_placa UNIQUE(placa)
);