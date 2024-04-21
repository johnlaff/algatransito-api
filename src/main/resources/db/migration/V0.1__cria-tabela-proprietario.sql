CREATE TABLE proprietarios (
                               proprietarioid INT PRIMARY KEY CLUSTERED IDENTITY(1,1),
                               nome VARCHAR (60) NOT NULL,
                               email VARCHAR (255) NOT NULL,
                               telefone VARCHAR(20) NOT NULL,
                               CONSTRAINT unique_proprietario_email UNIQUE(email)
);