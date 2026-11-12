-- ======================================================== --
-- PROJETO EXCHANGE DE CRIPTOMOEDAS - SCRIPT DO BANCO       --
-- ======================================================== --

-- 1. Remove tabelas antigas se existirem (na ordem correta de dependência)
DROP TABLE IF EXISTS operacao CASCADE;
DROP TABLE IF EXISTS cotacao CASCADE;
DROP TABLE IF EXISTS investidor CASCADE;

-- 2. Criação da Tabela: investidor
CREATE TABLE investidor (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(6) NOT NULL,
    tipo VARCHAR(15) DEFAULT 'investidor',
    saldo_reais NUMERIC(15,2) DEFAULT 0.00,
    saldo_bitcoin NUMERIC(20,8) DEFAULT 0.00000000,
    saldo_ethereum NUMERIC(20,8) DEFAULT 0.00000000,
    saldo_ripple NUMERIC(20,8) DEFAULT 0.00000000
);

-- 3. Criação da Tabela: cotacao
CREATE TABLE cotacao (
    moeda VARCHAR(3) PRIMARY KEY,
    valor_reais NUMERIC(20,8) NOT NULL,
    taxa_compra NUMERIC(5,4) NOT NULL,
    taxa_venda NUMERIC(5,4) NOT NULL
);

-- 4. Criação da Tabela: operacao (Histórico para o Extrato)
-- Nota: 'taxa' ajustada para NUMERIC(15,2) para suportar valores monetários em Reais sem estourar o limite
CREATE TABLE operacao (
    id SERIAL PRIMARY KEY,
    cpf_usuario VARCHAR(11) NOT NULL,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo VARCHAR(10) NOT NULL,
    moeda VARCHAR(4) NOT NULL,
    quantidade NUMERIC(20,8),
    cotacao_unitaria NUMERIC(20,8),
    taxa NUMERIC(15,2) DEFAULT 0.00,
    valor_reais NUMERIC(20,2) NOT NULL,
    saldo_reais NUMERIC(15,2) NOT NULL,
    saldo_bitcoin NUMERIC(20,8) NOT NULL,
    saldo_ethereum NUMERIC(20,8) NOT NULL,
    saldo_ripple NUMERIC(20,8) NOT NULL,
    CONSTRAINT fk_operacao_investidor FOREIGN KEY (cpf_usuario) REFERENCES investidor(cpf) ON DELETE CASCADE
);

-- 5. Carga Inicial de Cotações (Taxas definidas na proposta)
INSERT INTO cotacao (moeda, valor_reais, taxa_compra, taxa_venda) VALUES 
    ('BTC', 300000.00, 0.0200, 0.0300), 
    ('ETH', 10000.00, 0.0100, 0.0200), 
    ('XRP', 2.50, 0.0100, 0.0100);

-- 6. Inserção de Contas para Testes
INSERT INTO investidor (cpf, nome, senha, tipo, saldo_reais, saldo_bitcoin, saldo_ethereum, saldo_ripple) VALUES 
    ('12345678902', 'Gabriela Biondi', '654321', 'investidor', 580.00, 0.01580000, 1.03000000, 200.35000000),
    ('11122233344', 'Ana Souza', '654321', 'investidor', 3500.50, 0.50000000, 1.20000000, 150.00000000),
    ('22233344455', 'Carlos Silva', '111222', 'investidor', 15000.00, 2.10000000, 0.50000000, 500.00000000),
    ('33344455566', 'Mariana Oliveira', '333444', 'investidor', 850.25, 0.00000000, 0.15000000, 75.50000000),
    ('44455566677', 'Lucas Mendes', '999888', 'investidor', 50000.00, 5.00000000, 10.00000000, 1000.00000000),
    ('12345678901', 'Caue', '123456', 'investidor', 2000.00, 1.00000000, 2.00000000, 3.00000000),
    ('12345678900', 'Teste', '123456', 'investidor', 1000.00, 0.00000000, 0.00000000, 0.00000000);

-- Verificação final
SELECT * FROM cotacao;
SELECT * FROM investidor;