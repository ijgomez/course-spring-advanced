ALTER TABLE ACOUNT DROP CONSTRAINT FK_ACOUNT_CLIENT_ID
DROP TABLE CLIENT
DROP TABLE ACOUNT
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
