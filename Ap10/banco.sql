CREATE DATABASE IF NOT EXISTS faeterj_alerta;
USE faeterj_alerta;

CREATE TABLE IF NOT EXISTS ocorrencia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    localizacao VARCHAR(100) NOT NULL,
    data_hora DATETIME DEFAULT CURRENT_TIMESTAMP,
    foto VARCHAR(255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS comunicado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    status VARCHAR(50) NOT NULL, -- Valores: Funcionamento normal, Alerta, Faculdade fechada
    data_hora DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(50) UNIQUE NOT NULL,
    tipo VARCHAR(20) NOT NULL -- Valores: aluno, admin
);

-- Insert a default "Normal" status so the app always has at least one status
INSERT INTO comunicado (mensagem, status, data_hora) VALUES ('A faculdade está funcionando normalmente.', 'Funcionamento normal', NOW());
