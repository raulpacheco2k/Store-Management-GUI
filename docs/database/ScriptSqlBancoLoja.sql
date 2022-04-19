-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bancoLoja
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bancoLoja
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bancoLoja` DEFAULT CHARACTER SET utf8 ;
USE `bancoLoja` ;

-- -----------------------------------------------------
-- Table `bancoLoja`.`bairro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`bairro` (
  `idbairro` INT NOT NULL AUTO_INCREMENT,
  `descricaoBairro` VARCHAR(45) NULL,
  PRIMARY KEY (`idbairro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`cidade` (
  `idcidade` INT NOT NULL AUTO_INCREMENT,
  `descricaoCidade` VARCHAR(45) NOT NULL,
  `ufCidade` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idcidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`endereco` (
  `idcep` INT NOT NULL AUTO_INCREMENT,
  `cepCep` VARCHAR(10) NOT NULL,
  `logradouroCep` VARCHAR(100) NULL,
  `bairro_idbairro` INT NOT NULL,
  `cidade_idcidade` INT NOT NULL,
  PRIMARY KEY (`idcep`),
  CONSTRAINT `fk_cep_bairro1`
    FOREIGN KEY (`bairro_idbairro`)
    REFERENCES `bancoLoja`.`bairro` (`idbairro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cep_cidade1`
    FOREIGN KEY (`cidade_idcidade`)
    REFERENCES `bancoLoja`.`cidade` (`idcidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(100) NOT NULL,
  `dtNasCliente` DATE NOT NULL,
  `cpfCliente` VARCHAR(14) NOT NULL,
  `rgCliente` VARCHAR(12) NULL,
  `foneCliente` VARCHAR(14) NOT NULL,
  `fone2Cliente` VARCHAR(14) NULL,
  `emailCliente` VARCHAR(100) NULL,
  `compleEnderecoCliente` VARCHAR(100) NOT NULL,
  `endereco_idcep` INT NOT NULL,
  PRIMARY KEY (`idcliente`),
    CONSTRAINT `fk_cliente_endereco1`
    FOREIGN KEY (`endereco_idcep`)
    REFERENCES `bancoLoja`.`endereco` (`idcep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`fornecedor` (
  `idfornecedor` INT NOT NULL AUTO_INCREMENT,
  `razaoSocialFornecedor` VARCHAR(100) NOT NULL,
  `nomeFantasiaFornecedor` VARCHAR(100) NOT NULL,
  `cnpjFornecedor` VARCHAR(18) NOT NULL,
  `inscEstadualFornecedor` VARCHAR(14) NOT NULL,
  `emailFornecedor` VARCHAR(100) NULL,
  `compleEnderecofornecedor` VARCHAR(45) NULL,
  `endereco_idcep` INT NOT NULL,
  PRIMARY KEY (`idfornecedor`),
    CONSTRAINT `fk_fornecedor_cep1`
    FOREIGN KEY (`endereco_idcep`)
    REFERENCES `bancoLoja`.`endereco` (`idcep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
PACK_KEYS = DEFAULT;


-- -----------------------------------------------------
-- Table `bancoLoja`.`vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`vendedor` (
  `idvendedor` INT NOT NULL AUTO_INCREMENT,
  `nomeVendedor` VARCHAR(100) NOT NULL,
  `cpfVendedor` VARCHAR(14) NOT NULL,
  `emailVendedor` VARCHAR(100) NULL,
  `foneVendedor` VARCHAR(14) NOT NULL,
  `fone2Vendedor` VARCHAR(14) NULL,
  `percentComissaoVenda` FLOAT NOT NULL,
  `percentComissaoRecebto` FLOAT NOT NULL,
  `compleEnderecoVendedor` VARCHAR(100) NOT NULL,
  `endereco_idcep` INT NOT NULL,
  PRIMARY KEY (`idvendedor`),
   CONSTRAINT `fk_vendedor_cep1`
    FOREIGN KEY (`endereco_idcep`)
    REFERENCES `bancoLoja`.`endereco` (`idcep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`marca` (
  `idmarca` INT NOT NULL AUTO_INCREMENT,
  `descricaoMarca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`tipoProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`tipoProduto` (
  `idtipoProduto` INT NOT NULL AUTO_INCREMENT,
  `descricaoTipoProduto` VARCHAR(45) NULL,
  PRIMARY KEY (`idtipoProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`tamanho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`tamanho` (
  `idtamanho` INT NOT NULL AUTO_INCREMENT,
  `descricaoTamanho` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtamanho`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`produto` (
  `idproduto` INT NOT NULL AUTO_INCREMENT,
  `descricaoProduto` VARCHAR(100) NOT NULL,
  `valProduto` FLOAT NOT NULL,
  `marca_idmarca` INT NOT NULL,
  `tipoProduto_idtipoProduto` INT NOT NULL,
  `tamanho_idtamanho` INT NOT NULL,
  PRIMARY KEY (`idproduto`),
   CONSTRAINT `fk_produto_marca1`
    FOREIGN KEY (`marca_idmarca`)
    REFERENCES `bancoLoja`.`marca` (`idmarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_tipoProduto1`
    FOREIGN KEY (`tipoProduto_idtipoProduto`)
    REFERENCES `bancoLoja`.`tipoProduto` (`idtipoProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_tamanho1`
    FOREIGN KEY (`tamanho_idtamanho`)
    REFERENCES `bancoLoja`.`tamanho` (`idtamanho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`condicaoPagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`condicaoPagamento` (
  `idcondicaoPagamento` INT NOT NULL AUTO_INCREMENT,
  `descricaoCondicaoPagamento` VARCHAR(100) NOT NULL,
  `numDiasAtePrimeiraParcela` INT NOT NULL,
  `numDiasEntreParcelas` INT NOT NULL,
  PRIMARY KEY (`idcondicaoPagamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`venda` (
  `idvenda` INT NOT NULL AUTO_INCREMENT,
  `serieVenda` VARCHAR(5) NOT NULL,
  `dtVenda` DATE NULL,
  `hrVenda` VARCHAR(45) NULL,
  `valDescontoVenda` FLOAT NULL,
  `valTotalVenda` FLOAT NULL,
  `cliente_idcliente` INT NOT NULL,
  `condicaoPagamento_idcondicaoPagamento` INT NOT NULL,
  `diaVencimentoParcela` INT NULL,
  `vendedor_idvendedor` INT NOT NULL,
  PRIMARY KEY (`idvenda`),
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `bancoLoja`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_condicaoPagamento1`
    FOREIGN KEY (`condicaoPagamento_idcondicaoPagamento`)
    REFERENCES `bancoLoja`.`condicaoPagamento` (`idcondicaoPagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_vendedor1`
    FOREIGN KEY (`vendedor_idvendedor`)
    REFERENCES `bancoLoja`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`foneFornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`foneFornecedor` (
  `foneFornecedor` VARCHAR(14) NOT NULL,
  `fornecedor_idfornecedor` INT NOT NULL,
  PRIMARY KEY (`foneFornecedor`, `fornecedor_idfornecedor`),
    CONSTRAINT `fk_foneFornecedor_fornecedor`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `bancoLoja`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`cor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`cor` (
  `idcor` INT NOT NULL AUTO_INCREMENT,
  `descricaoCor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`caracteristicaProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`caracteristicaProduto` (
  `idCaracterisitcaProduto` INT NOT NULL AUTO_INCREMENT,
  `produto_idproduto` INT NOT NULL,
  `cor_idcor` INT NOT NULL,
  `tamanhoProduto` VARCHAR(3) NOT NULL,
  `barraProduto` VARCHAR(13) NOT NULL,
  `qtdEstoqueProduto` FLOAT NOT NULL,
   PRIMARY KEY (`idCaracterisitcaProduto`),
  CONSTRAINT `fk_caracteristicaProduto_produto1`
    FOREIGN KEY (`produto_idproduto`)
    REFERENCES `bancoLoja`.`produto` (`idproduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_caracteristicaProduto_cor1`
    FOREIGN KEY (`cor_idcor`)
    REFERENCES `bancoLoja`.`cor` (`idcor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`ItensVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`ItensVenda` (
  `idItensVenda` INT NOT NULL,
  `venda_idvenda` INT NOT NULL,
  `caracteristicaProduto_idCaracterisitcaProduto` INT NOT NULL,
  `valUnitarioProduto` FLOAT NOT NULL,
  `qtdProduto` FLOAT NOT NULL,
  PRIMARY KEY (`idItensVenda`),
   CONSTRAINT `fk_ItensVenda_venda1`
    FOREIGN KEY (`venda_idvenda`)
    REFERENCES `bancoLoja`.`venda` (`idvenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItensVenda_caracteristicaProduto1`
    FOREIGN KEY (`caracteristicaProduto_idCaracterisitcaProduto`)
    REFERENCES `bancoLoja`.`caracteristicaProduto` (`idCaracterisitcaProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`receber`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`receber` (
  `idreceber` INT NOT NULL AUTO_INCREMENT,
  `venda_idvenda` INT NOT NULL,
  `dtHrEmissaoRec` DATETIME NOT NULL,
  `valEmissaoRec` FLOAT NOT NULL,
  `dtVencimentoRec` DATE NOT NULL,
  `dtPgtoRec` DATE NULL,
  `acrescimeRec` FLOAT NOT NULL,
  `descontoRec` FLOAT NOT NULL,
  `valPagoRec` FLOAT NOT NULL,
  `statusRec` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idreceber`),
    CONSTRAINT `fk_receber_venda1`
    FOREIGN KEY (`venda_idvenda`)
    REFERENCES `bancoLoja`.`venda` (`idvenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`compra` (
  `idcompra` INT NOT NULL AUTO_INCREMENT,
  `fornecedor_idfornecedor` INT NOT NULL,
  `condicaoPagamento_idcondicaoPagamento` INT NOT NULL,
  `numNFCompra` INT NOT NULL,
  `serieNFCompra` VARCHAR(5) NOT NULL,
  `dtHrCompra` DATETIME NOT NULL,
  `descontoCompra` FLOAT NULL,
  `valorTotalCompra` FLOAT NOT NULL,
  PRIMARY KEY (`idcompra`),
   CONSTRAINT `fk_compra_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `bancoLoja`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_condicaoPagamento1`
    FOREIGN KEY (`condicaoPagamento_idcondicaoPagamento`)
    REFERENCES `bancoLoja`.`condicaoPagamento` (`idcondicaoPagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`itensCompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`itensCompra` (
  `iditensCompra` INT NOT NULL AUTO_INCREMENT,
  `compra_idcompra` INT NOT NULL,
  `caracteristicaProduto_idCaracterisitcaProduto` INT NOT NULL,
  `qtdProduto` FLOAT NOT NULL,
  `valunitarioProduto` FLOAT NULL,
  PRIMARY KEY (`iditensCompra`),
   CONSTRAINT `fk_itensCompra_compra1`
    FOREIGN KEY (`compra_idcompra`)
    REFERENCES `bancoLoja`.`compra` (`idcompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itensCompra_caracteristicaProduto1`
    FOREIGN KEY (`caracteristicaProduto_idCaracterisitcaProduto`)
    REFERENCES `bancoLoja`.`caracteristicaProduto` (`idCaracterisitcaProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoLoja`.`pagar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoLoja`.`pagar` (
  `idpagar` INT NOT NULL AUTO_INCREMENT,
  `compra_idcompra` INT NOT NULL,
  `dtHrEmissaoPagar` DATETIME NOT NULL,
  `dtVencimentoPagar` DATE NOT NULL,
  `valemitidoPagar` FLOAT NOT NULL,
  `acrescimoPagar` FLOAT NULL,
  `descontoPagar` FLOAT NULL,
  `dtHrPgtoPagar` DATETIME NOT NULL,
  `valPagoPagar` FLOAT NULL,
  `statusPagar` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idpagar`),
   CONSTRAINT `fk_pagar_compra1`
    FOREIGN KEY (`compra_idcompra`)
    REFERENCES `bancoLoja`.`compra` (`idcompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
