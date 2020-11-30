DROP DATABASE IF EXISTS time;
CREATE DATABASE time;
use time;


CREATE TABLE time(
    id     INT AUTO_INCREMENT NOT NULL,
    escudo      VARCHAR(75),
    fundacao    DATE,
    nome        VARCHAR(30),
    patrimonio  DOUBLE,

    PRIMARY KEY (id)
);

-- INSERT INTO time (escudo, fundacao, nome, patrimonio ) VALUES ('testeEscudo', '1997-09-21', 'art', '20');

-- SELECT * FROM time;
