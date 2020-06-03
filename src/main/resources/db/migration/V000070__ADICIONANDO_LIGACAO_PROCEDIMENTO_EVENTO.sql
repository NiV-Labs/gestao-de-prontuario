ALTER TABLE `VISITA_EVENTO` 
DROP FOREIGN KEY `fk_VISITA_EVENTO_PACIENT`;
ALTER TABLE `VISITA_EVENTO` 
CHANGE COLUMN `ID_SETOR` `ID_SETOR` BIGINT(20) NULL DEFAULT NULL AFTER `ID_DOCUMENTO_DIGITAL`,
ADD COLUMN `ID_PROCEDIMENTO` BIGINT(20) NULL AFTER `ID_SETOR`,
ADD INDEX `fk_VISITA_PROCEDIMENTO_idx` (`ID_PROCEDIMENTO` ASC),
DROP INDEX `fk_VISITA_EVENTO_PACIENT_idx` ;
ALTER TABLE `VISITA_EVENTO` 
ADD CONSTRAINT `fk_VISITA_PROCEDIMENTO`
  FOREIGN KEY (`ID_PROCEDIMENTO`)
  REFERENCES `PROCEDIMENTO` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `TIPO_EVENTO` 
ADD COLUMN `PROCEDIMENTO_EQ_ID` BIGINT(20) NULL AFTER `DESCRICAO`,
ADD UNIQUE INDEX `CBHPM_EQUIVALENTE_UNIQUE` (`PROCEDIMENTO_EQ_ID` ASC);
ALTER TABLE `TIPO_EVENTO` 
ADD CONSTRAINT `fk_TIPO_EVENTO_PROC`
  FOREIGN KEY (`PROCEDIMENTO_EQ_ID`)
  REFERENCES `PROCEDIMENTO` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
