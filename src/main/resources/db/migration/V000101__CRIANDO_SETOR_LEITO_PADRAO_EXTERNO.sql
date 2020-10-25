INSERT INTO SETOR (ID, DESCRICAO, DATA_CRIACAO)
SELECT * FROM (SELECT 1 AS ID, 'ATENDIMENTO' AS DESCRICAO, SYSDATE() AS DATA_CRIACAO) AS tmp
WHERE NOT EXISTS (
    SELECT ID FROM SETOR WHERE ID = 1
) LIMIT 1;

INSERT INTO SALA_LEITO (ID, NOME, TIPO, SECTOR_ID)
SELECT * FROM (SELECT 1 AS ID, 'EXTERNO' AS NOME, 'ROOM' AS TIPO, 1) AS tmp
WHERE NOT EXISTS (
    SELECT ID FROM SALA_LEITO WHERE ID = 1
) LIMIT 1;