-- Criando a tabela ESTUDANTE
CREATE TABLE VEM_SER.ESTUDANTE(
	id NUMBER NOT NULL,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) UNIQUE NOT NULL,
	ativo CHAR(1),
	PRIMARY KEY(id)
);

-- Criando a sequence do id
CREATE SEQUENCE VEM_SER.SEQ_ID_ESTUDANTE
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;


-- INSERTS:

-- 1°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Gabriel Luppi', TO_DATE('08/12/2003', 'DD/MM/YYYY'), 1234567890, 'S');

-- 2°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Heloisa Luppi', TO_DATE('20/03/2005', 'DD/MM/YYYY'), 1233211234, 'S');

-- 3°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Bennett Genshi', TO_DATE('29/02/2004', 'DD/MM/YYYY'), 7171717171, 'N');

-- 4°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Luke Skywalker', TO_DATE('04/05/1999', 'DD/MM/YYYY'), 1232453675, 'N');

-- 5°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Tony Stark', TO_DATE('29/05/1970', 'DD/MM/YYYY'), 0112358132, 'S');

-- 6°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Dipper Pines', TO_DATE('31/08/1999', 'DD/MM/YYYY'), 1234432112, 'S');

-- 7°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Percy Jackson', TO_DATE('18/08/1993', 'DD/MM/YYYY'), 0988901234, 'N');

-- 8°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Anya Forger', TO_DATE('03/03/2016', 'DD/MM/YYYY'), 1111122222, 'S');

-- 9°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Kushina Uzumaki', TO_DATE('10/07/1993', 'DD/MM/YYYY'), 0987654321, 'S');

-- 10°:
INSERT INTO VEM_SER.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ID_ESTUDANTE.nextVal, 'Gwen Stacy', TO_DATE('16/02/2001', 'DD/MM/YYYY'), 5252525252, 'S');

SELECT * FROM VEM_SER.ESTUDANTE;
