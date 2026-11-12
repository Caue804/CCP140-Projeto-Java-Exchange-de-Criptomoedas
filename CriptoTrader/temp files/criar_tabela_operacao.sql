-- Execute no banco CriptoTrader_db (pgAdmin > Query Tool)
CREATE TABLE IF NOT EXISTS operacao (
    id              SERIAL PRIMARY KEY,
    cpf             VARCHAR(11)    NOT NULL,   -- mesmo tipo da coluna cpf de investidor
    data_hora       TIMESTAMP      NOT NULL DEFAULT NOW(),
    sinal           CHAR(1)        NOT NULL CHECK (sinal IN ('+', '-')),
    moeda           VARCHAR(4)     NOT NULL CHECK (moeda IN ('REAL', 'BTC', 'ETH', 'XRP')),
    valor           NUMERIC(18, 8) NOT NULL,
    cotacao         NUMERIC(18, 8) NOT NULL DEFAULT 0,
    taxa            NUMERIC(18, 8) NOT NULL DEFAULT 0,
    saldo_reais     NUMERIC(18, 2) NOT NULL,
    saldo_bitcoin   NUMERIC(18, 8) NOT NULL,
    saldo_ethereum  NUMERIC(18, 8) NOT NULL,
    saldo_ripple    NUMERIC(18, 8) NOT NULL
);
