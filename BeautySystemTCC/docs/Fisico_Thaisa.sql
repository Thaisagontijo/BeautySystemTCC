SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `BEAUTY SYSTEM` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `BEAUTY SYSTEM` ;

-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`Funcao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`Funcao` (
  `idFuncao` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `ativo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idFuncao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`Produto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `qtdEstoque` INT NOT NULL ,
  `valorUnidadeVenda` FLOAT NOT NULL ,
  `valorUnidadeCompra` FLOAT NOT NULL ,
  `descricao` TEXT NULL ,
  `ativo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idProduto`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`Servico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`Servico` (
  `idServico` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `descricao` TEXT NULL ,
  `preco` FLOAT NOT NULL ,
  `ativo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idServico`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`FormasPagamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`FormasPagamento` (
  `idFormasPagamento` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `ativo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idFormasPagamento`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`Pessoa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `cpf` INT NOT NULL ,
  `Rua` VARCHAR(100) NOT NULL ,
  `bairro` VARCHAR(50) NOT NULL ,
  `numero` INT NOT NULL ,
  `complemento` VARCHAR(100) NULL ,
  `telefone` VARCHAR(50) NOT NULL ,
  `dataNascimento` DATE NOT NULL ,
  `ativo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idPessoa`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`Cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT ,
  `dataCadastro` DATE NOT NULL ,
  `ativo` TINYINT(1) NOT NULL ,
  `idPessoa` INT NOT NULL ,
  PRIMARY KEY (`idCliente`) ,
  INDEX `fk_Cliente_Pessoa_idx` (`idPessoa` ASC) ,
  CONSTRAINT `fk_Cliente_Pessoa`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `BEAUTY SYSTEM`.`Pessoa` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`AgendamentosCliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`AgendamentosCliente` (
  `idAgendamentoClientes` INT NOT NULL AUTO_INCREMENT ,
  `dataHora` DATETIME NOT NULL ,
  `observacao` TEXT NULL ,
  `ativo` TINYINT(1) NOT NULL ,
  `idCliente` INT NOT NULL ,
  PRIMARY KEY (`idAgendamentoClientes`) ,
  INDEX `fk_AgendamentosCliente_Cliente1_idx` (`idCliente` ASC) ,
  CONSTRAINT `fk_AgendamentosCliente_Cliente1`
    FOREIGN KEY (`idCliente` )
    REFERENCES `BEAUTY SYSTEM`.`Cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`Funcionario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`Funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT ,
  `dataAdmissao` DATE NOT NULL ,
  `salario` FLOAT NOT NULL ,
  `ativo` TINYINT(1) NOT NULL ,
  `idPessoa` INT NOT NULL ,
  `idFuncao` INT NOT NULL ,
  PRIMARY KEY (`idFuncionario`) ,
  INDEX `fk_Funcionario_Pessoa1_idx` (`idPessoa` ASC) ,
  INDEX `fk_Funcionario_Funcao1_idx` (`idFuncao` ASC) ,
  CONSTRAINT `fk_Funcionario_Pessoa1`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `BEAUTY SYSTEM`.`Pessoa` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Funcao1`
    FOREIGN KEY (`idFuncao` )
    REFERENCES `BEAUTY SYSTEM`.`Funcao` (`idFuncao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`AgendamentosCliente_Servico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`AgendamentosCliente_Servico` (
  `AgendamentosCliente_idAgendamentoClientes` INT NOT NULL ,
  `Servico_idServico` INT NOT NULL ,
  PRIMARY KEY (`AgendamentosCliente_idAgendamentoClientes`, `Servico_idServico`) ,
  INDEX `fk_AgendamentosCliente_has_Servico_Servico1_idx` (`Servico_idServico` ASC) ,
  INDEX `fk_AgendamentosCliente_has_Servico_AgendamentosCliente1_idx` (`AgendamentosCliente_idAgendamentoClientes` ASC) ,
  CONSTRAINT `fk_AgendamentosCliente_has_Servico_AgendamentosCliente1`
    FOREIGN KEY (`AgendamentosCliente_idAgendamentoClientes` )
    REFERENCES `BEAUTY SYSTEM`.`AgendamentosCliente` (`idAgendamentoClientes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AgendamentosCliente_has_Servico_Servico1`
    FOREIGN KEY (`Servico_idServico` )
    REFERENCES `BEAUTY SYSTEM`.`Servico` (`idServico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`Atendimento_venda`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`Atendimento_venda` (
  `idAtendimento_venda` INT NOT NULL AUTO_INCREMENT ,
  `dataHora` DATETIME NOT NULL ,
  `idFuncionario` INT NOT NULL ,
  `idCliente` INT NOT NULL ,
  `idFormasPagamento` INT NOT NULL ,
  PRIMARY KEY (`idAtendimento_venda`) ,
  INDEX `fk_Atendimento_venda_Funcionario1_idx` (`idFuncionario` ASC) ,
  INDEX `fk_Atendimento_venda_Cliente1_idx` (`idCliente` ASC) ,
  INDEX `fk_Atendimento_venda_FormasPagamento1_idx` (`idFormasPagamento` ASC) ,
  CONSTRAINT `fk_Atendimento_venda_Funcionario1`
    FOREIGN KEY (`idFuncionario` )
    REFERENCES `BEAUTY SYSTEM`.`Funcionario` (`idFuncionario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atendimento_venda_Cliente1`
    FOREIGN KEY (`idCliente` )
    REFERENCES `BEAUTY SYSTEM`.`Cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atendimento_venda_FormasPagamento1`
    FOREIGN KEY (`idFormasPagamento` )
    REFERENCES `BEAUTY SYSTEM`.`FormasPagamento` (`idFormasPagamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`ItemVenda`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`ItemVenda` (
  `idItemVenda` INT NOT NULL AUTO_INCREMENT ,
  `qtd` INT NOT NULL ,
  `idProduto` INT NOT NULL ,
  `idAtendimento_venda` INT NOT NULL ,
  PRIMARY KEY (`idItemVenda`) ,
  INDEX `fk_ItemVenda_Produto1_idx` (`idProduto` ASC) ,
  INDEX `fk_ItemVenda_Atendimento_venda1_idx` (`idAtendimento_venda` ASC) ,
  CONSTRAINT `fk_ItemVenda_Produto1`
    FOREIGN KEY (`idProduto` )
    REFERENCES `BEAUTY SYSTEM`.`Produto` (`idProduto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemVenda_Atendimento_venda1`
    FOREIGN KEY (`idAtendimento_venda` )
    REFERENCES `BEAUTY SYSTEM`.`Atendimento_venda` (`idAtendimento_venda` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEAUTY SYSTEM`.`Atendimento_venda_Servico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BEAUTY SYSTEM`.`Atendimento_venda_Servico` (
  `Atendimento_venda_idAtendimento_venda` INT NOT NULL ,
  `Servico_idServico` INT NOT NULL ,
  PRIMARY KEY (`Atendimento_venda_idAtendimento_venda`, `Servico_idServico`) ,
  INDEX `fk_Atendimento_venda_has_Servico_Servico1_idx` (`Servico_idServico` ASC) ,
  INDEX `fk_Atendimento_venda_has_Servico_Atendimento_venda1_idx` (`Atendimento_venda_idAtendimento_venda` ASC) ,
  CONSTRAINT `fk_Atendimento_venda_has_Servico_Atendimento_venda1`
    FOREIGN KEY (`Atendimento_venda_idAtendimento_venda` )
    REFERENCES `BEAUTY SYSTEM`.`Atendimento_venda` (`idAtendimento_venda` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atendimento_venda_has_Servico_Servico1`
    FOREIGN KEY (`Servico_idServico` )
    REFERENCES `BEAUTY SYSTEM`.`Servico` (`idServico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `BEAUTY SYSTEM` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
