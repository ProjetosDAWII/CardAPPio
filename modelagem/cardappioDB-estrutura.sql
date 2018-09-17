-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cardappioDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cardappioDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cardappioDB` DEFAULT CHARACTER SET utf8 ;
USE `cardappioDB` ;

-- -----------------------------------------------------
-- Table `cardappioDB`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cardappioDB`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `categoriaNm` VARCHAR(45) NOT NULL,
  `categoriaDesc` LONGTEXT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cardappioDB`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cardappioDB`.`produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `produtoNm` VARCHAR(200) NOT NULL,
  `produtoDesc` LONGTEXT NULL,
  `idCategoria` INT NOT NULL,
  `idFornecedor` INT NULL,
  PRIMARY KEY (`idProduto`),
  INDEX `fk_produto_categoria_idx` (`idCategoria` ASC),
  CONSTRAINT `fk_produto_categoria`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `cardappioDB`.`categoria` (`idCategoria`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cardappioDB`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cardappioDB`.`fornecedor` (
  `idFornecedor` INT NOT NULL AUTO_INCREMENT,
  `fornecedorNm` VARCHAR(100) NULL,
  `fornecedorEnd` VARCHAR(200) NULL,
  `fornecedorTel` VARCHAR(45) NULL,
  PRIMARY KEY (`idFornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cardappioDB`.`ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cardappioDB`.`ingrediente` (
  `idIngrediente` INT NOT NULL AUTO_INCREMENT,
  `ingredienteNm` VARCHAR(45) NOT NULL,
  `ingredienteDesc` LONGTEXT NULL,
  `idFornecedor` INT NOT NULL,
  PRIMARY KEY (`idIngrediente`),
  INDEX `fk_ingrediente_fornecedor1_idx` (`idFornecedor` ASC),
  CONSTRAINT `fk_ingrediente_fornecedor1`
    FOREIGN KEY (`idFornecedor`)
    REFERENCES `cardappioDB`.`fornecedor` (`idFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cardappioDB`.`notaFiscal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cardappioDB`.`notaFiscal` (
  `idNotaFiscal` INT NOT NULL AUTO_INCREMENT,
  `tpNF` ENUM('Entrada', 'Saída') NOT NULL,
  `data` DATE NULL,
  PRIMARY KEY (`idNotaFiscal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cardappioDB`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cardappioDB`.`estoque` (
  `idEstoque` INT NOT NULL AUTO_INCREMENT,
  `notaFiscal_idNotaFiscal` INT NOT NULL,
  `idIngrediente` INT NULL COMMENT 'se for estoque de ingrediente, preenche\n',
  `quantidade` INT NOT NULL,
  `dataFab` DATE NULL COMMENT 'data de fabricação produto/ingrediente',
  `dataVenc` DATE NULL COMMENT 'data vencimento do produto/ingrediente',
  `lote` VARCHAR(45) NULL COMMENT 'lote produto',
  `unidade` ENUM('gr', 'kg', 'ml', 'litro', 'caixa', 'fardo', 'garrafa', 'xícara', 'saco', 'und', 'outro') NULL COMMENT 'unidade de medida',
  `idProduto` INT NULL,
  PRIMARY KEY (`idEstoque`),
  INDEX `fk_estoque_notaFiscal1_idx` (`notaFiscal_idNotaFiscal` ASC),
  CONSTRAINT `fk_estoque_notaFiscal1`
    FOREIGN KEY (`notaFiscal_idNotaFiscal`)
    REFERENCES `cardappioDB`.`notaFiscal` (`idNotaFiscal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cardappioDB`.`ingrediente_has_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cardappioDB`.`ingrediente_has_produto` (
  `produto_idProduto` INT NOT NULL,
  `estoque_idEstoque` INT NOT NULL,
  `quantidade` INT NULL,
  `unidade` ENUM('gr', 'kg', 'ml', 'litro', 'caixa', 'fardo', 'garrafa', 'xícara', 'saco', 'und', 'outro') NULL COMMENT 'unidade de medida',
  PRIMARY KEY (`produto_idProduto`, `estoque_idEstoque`),
  INDEX `fk_ingrediente_has_produto_produto1_idx` (`produto_idProduto` ASC),
  INDEX `fk_ingrediente_has_produto_estoque1_idx` (`estoque_idEstoque` ASC),
  CONSTRAINT `fk_ingrediente_has_produto_produto1`
    FOREIGN KEY (`produto_idProduto`)
    REFERENCES `cardappioDB`.`produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingrediente_has_produto_estoque1`
    FOREIGN KEY (`estoque_idEstoque`)
    REFERENCES `cardappioDB`.`estoque` (`idEstoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
