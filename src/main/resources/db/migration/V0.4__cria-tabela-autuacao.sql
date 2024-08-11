CREATE TABLE autuacao (
    id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    veiculo_id INT NOT NULL,
    descricao VARCHAR(MAX) NOT NULL,
	valor_multa DECIMAL(10,2) NOT NULL,
	data_ocorrencia DATETIME NOT NULL,
	CONSTRAINT fk_autuacao_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculos(id)
);
