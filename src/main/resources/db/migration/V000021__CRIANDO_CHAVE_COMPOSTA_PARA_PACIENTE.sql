ALTER TABLE `PACIENTE` ADD UNIQUE INDEX `UK_PACIENTE`
(
   `ID` ASC,
   `ID_PESSOA` ASC
);
ALTER TABLE `PACIENTE` ADD UNIQUE INDEX `ID_PESSOA_UNIQUE`
(
   `ID_PESSOA` ASC
);