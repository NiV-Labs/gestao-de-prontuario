ALTER TABLE CAB_LANC_FIN DROP KEY UUID_FORNECEDOR_UNIQUE;
ALTER TABLE CAB_LANC_FIN DROP COLUMN UUID;
ALTER TABLE CAB_LANC_FIN MODIFY COLUMN ID VARCHAR(50) NOT NULL;
ALTER TABLE FORNECEDOR MODIFY COLUMN ID varchar(50) NOT NULL;
