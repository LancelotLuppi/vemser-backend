-- HOMEWORK 2
SELECT * FROM VEM_SER.PAIS ORDER BY NOME DESC;
SELECT LOGRADOURO, CEP FROM VEM_SER.ENDERECO WHERE UPPER(LOGRADOURO) LIKE 'A%';
SELECT * FROM VEM_SER.ENDERECO WHERE CEP LIKE '%0';
SELECT * FROM VEM_SER.ENDERECO WHERE NUMERO >= 1 AND NUMERO <= 100;
SELECT * FROM VEM_SER.ENDERECO WHERE UPPER(LOGRADOURO ) LIKE 'RUA%' ORDER BY CEP DESC;
SELECT COUNT(ID_ENDERECO) AS QNT_REGISTROS_ENDERECO FROM VEM_SER.ENDERECO;
SELECT COUNT(ID_ENDERECO) AS ENDERECO_POR_CIDADE FROM VEM_SER.ENDERECO GROUP BY ID_CIDADE;