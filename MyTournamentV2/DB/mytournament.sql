-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mytournament
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mytournament
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mytournament` DEFAULT CHARACTER SET utf8 ;
USE `mytournament` ;

-- -----------------------------------------------------
-- Table `mytournament`.`UsersStatuts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`UsersStatuts` (
  `idUsersStatus` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsersStatus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Users` (
  `idUsers` INT NOT NULL AUTO_INCREMENT,
  `pseudo` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phoneNumber` VARCHAR(45) NOT NULL,
  `dob` DATE NOT NULL,
  `creationDate` DATETIME NOT NULL,
  `idUsersStatus` INT NOT NULL,
  PRIMARY KEY (`idUsers`),
  INDEX `fk_Users_UsersStatuts1_idx` (`idUsersStatus` ASC),
  CONSTRAINT `fk_Users_UsersStatuts1`
    FOREIGN KEY (`idUsersStatus`)
    REFERENCES `mytournament`.`UsersStatuts` (`idUsersStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`WebRef`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`WebRef` (
  `idWebRef` INT NOT NULL AUTO_INCREMENT,
  `logo` VARCHAR(100) NULL,
  `locationWeb` VARCHAR(100) NULL,
  PRIMARY KEY (`idWebRef`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Games` (
  `idGames` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `idWebRef` INT NULL,
  PRIMARY KEY (`idGames`),
  INDEX `fk_Games_WebRef1_idx` (`idWebRef` ASC),
  CONSTRAINT `fk_Games_WebRef1`
    FOREIGN KEY (`idWebRef`)
    REFERENCES `mytournament`.`WebRef` (`idWebRef`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Locations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Locations` (
  `idLocations` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `town` VARCHAR(45) NOT NULL,
  `zipCode` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLocations`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`TypeOfTournaments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`TypeOfTournaments` (
  `idTypeOfTournaments` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTypeOfTournaments`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`FormatTournaments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`FormatTournaments` (
  `idFormatTournaments` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFormatTournaments`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Tournaments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Tournaments` (
  `idTournaments` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `online` TINYINT(1) NOT NULL,
  `maxPlayers` INT NOT NULL,
  `creationDate` DATETIME NOT NULL,
  `modificationDate` DATETIME NULL,
  `startDate` DATETIME NOT NULL,
  `endDate` DATETIME NOT NULL,
  `hours` TIME NOT NULL,
  `price` FLOAT NULL,
  `idGames` INT NOT NULL,
  `idLocations` INT NULL,
  `idTypeOfTournaments` INT NOT NULL,
  `idFormatTournaments` INT NOT NULL,
  PRIMARY KEY (`idTournaments`),
  INDEX `fk_Tournaments_Games1_idx` (`idGames` ASC),
  INDEX `fk_Tournaments_Locations1_idx` (`idLocations` ASC),
  INDEX `fk_Tournaments_TypeOfTournaments1_idx` (`idTypeOfTournaments` ASC),
  INDEX `fk_Tournaments_FormatTournaments1_idx` (`idFormatTournaments` ASC),
  CONSTRAINT `fk_Tournaments_Games1`
    FOREIGN KEY (`idGames`)
    REFERENCES `mytournament`.`Games` (`idGames`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournaments_Locations1`
    FOREIGN KEY (`idLocations`)
    REFERENCES `mytournament`.`Locations` (`idLocations`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournaments_TypeOfTournaments1`
    FOREIGN KEY (`idTypeOfTournaments`)
    REFERENCES `mytournament`.`TypeOfTournaments` (`idTypeOfTournaments`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournaments_FormatTournaments1`
    FOREIGN KEY (`idFormatTournaments`)
    REFERENCES `mytournament`.`FormatTournaments` (`idFormatTournaments`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Clan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Clan` (
  `idClan` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `idWebRef` INT NULL,
  `creationDate` DATETIME NOT NULL,
  PRIMARY KEY (`idClan`),
  INDEX `fk_Clan_WebRef1_idx` (`idWebRef` ASC),
  CONSTRAINT `fk_Clan_WebRef1`
    FOREIGN KEY (`idWebRef`)
    REFERENCES `mytournament`.`WebRef` (`idWebRef`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Selections`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Selections` (
  `idSelections` INT NOT NULL AUTO_INCREMENT,
  `idClan` INT NULL,
  `idUsers` INT NOT NULL,
  `idTournaments` INT NOT NULL,
  `confirmation` TINYINT(1) NOT NULL,
  `validation` TINYINT(1) NOT NULL,
  `creationDate` DATETIME NOT NULL,
  PRIMARY KEY (`idSelections`),
  INDEX `fk_Selections_Clan1_idx` (`idClan` ASC),
  INDEX `fk_Selections_Users1_idx` (`idUsers` ASC),
  INDEX `fk_Selections_Tournaments1_idx` (`idTournaments` ASC),
  UNIQUE INDEX `idUsers_UNIQUE` (`idUsers` ASC),
  UNIQUE INDEX `idTournaments_UNIQUE` (`idTournaments` ASC),
  CONSTRAINT `fk_Selections_Clan1`
    FOREIGN KEY (`idClan`)
    REFERENCES `mytournament`.`Clan` (`idClan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Selections_Users1`
    FOREIGN KEY (`idUsers`)
    REFERENCES `mytournament`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Selections_Tournaments1`
    FOREIGN KEY (`idTournaments`)
    REFERENCES `mytournament`.`Tournaments` (`idTournaments`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`TypeGameAccounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`TypeGameAccounts` (
  `idTypeGameAccounts` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTypeGameAccounts`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`GameAccounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`GameAccounts` (
  `idGameAccounts` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `idUsers` INT NOT NULL,
  `idTypeGameAccounts` INT NOT NULL,
  PRIMARY KEY (`idGameAccounts`),
  INDEX `fk_GameAccounts_Users1_idx` (`idUsers` ASC),
  INDEX `fk_GameAccounts_TypeGameAccounts1_idx` (`idTypeGameAccounts` ASC),
  CONSTRAINT `fk_GameAccounts_Users1`
    FOREIGN KEY (`idUsers`)
    REFERENCES `mytournament`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GameAccounts_TypeGameAccounts1`
    FOREIGN KEY (`idTypeGameAccounts`)
    REFERENCES `mytournament`.`TypeGameAccounts` (`idTypeGameAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`TypeOfRewards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`TypeOfRewards` (
  `idTypeOfRewards` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTypeOfRewards`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Rewards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Rewards` (
  `idRewards` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `idTournaments` INT NOT NULL,
  `idTypeOfRewards` INT NOT NULL,
  PRIMARY KEY (`idRewards`),
  INDEX `fk_Rewards_Tournaments1_idx` (`idTournaments` ASC),
  INDEX `fk_Rewards_TypeOfRewards1_idx` (`idTypeOfRewards` ASC),
  CONSTRAINT `fk_Rewards_Tournaments1`
    FOREIGN KEY (`idTournaments`)
    REFERENCES `mytournament`.`Tournaments` (`idTournaments`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rewards_TypeOfRewards1`
    FOREIGN KEY (`idTypeOfRewards`)
    REFERENCES `mytournament`.`TypeOfRewards` (`idTypeOfRewards`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Sponsors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Sponsors` (
  `idSponsors` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `idLocations` INT NULL,
  `idWebRef` INT NULL,
  PRIMARY KEY (`idSponsors`),
  INDEX `fk_Sponsors_Locations1_idx` (`idLocations` ASC),
  INDEX `fk_Sponsors_WebRef1_idx` (`idWebRef` ASC),
  CONSTRAINT `fk_Sponsors_Locations1`
    FOREIGN KEY (`idLocations`)
    REFERENCES `mytournament`.`Locations` (`idLocations`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sponsors_WebRef1`
    FOREIGN KEY (`idWebRef`)
    REFERENCES `mytournament`.`WebRef` (`idWebRef`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`Unavailabilities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`Unavailabilities` (
  `idUnavailabilities` INT NOT NULL AUTO_INCREMENT,
  `day` INT NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `idUsers` INT NOT NULL,
  PRIMARY KEY (`idUnavailabilities`),
  INDEX `fk_Unavailabilities_Users1_idx` (`idUsers` ASC),
  CONSTRAINT `fk_Unavailabilities_Users1`
    FOREIGN KEY (`idUsers`)
    REFERENCES `mytournament`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`UsersClan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`UsersClan` (
  `idUsers` INT NOT NULL,
  `idClan` INT NOT NULL,
  PRIMARY KEY (`idUsers`, `idClan`),
  INDEX `fk_Users_has_Clan_Clan1_idx` (`idClan` ASC),
  INDEX `fk_Users_has_Clan_Users1_idx` (`idUsers` ASC),
  CONSTRAINT `fk_Users_has_Clan_Users1`
    FOREIGN KEY (`idUsers`)
    REFERENCES `mytournament`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Clan_Clan1`
    FOREIGN KEY (`idClan`)
    REFERENCES `mytournament`.`Clan` (`idClan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`GameAccountsGames`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`GameAccountsGames` (
  `idGameAccounts` INT NOT NULL,
  `idGames` INT NOT NULL,
  PRIMARY KEY (`idGameAccounts`, `idGames`),
  INDEX `fk_GameAccounts_has_Games_Games1_idx` (`idGames` ASC),
  INDEX `fk_GameAccounts_has_Games_GameAccounts1_idx` (`idGameAccounts` ASC),
  CONSTRAINT `fk_GameAccounts_has_Games_GameAccounts1`
    FOREIGN KEY (`idGameAccounts`)
    REFERENCES `mytournament`.`GameAccounts` (`idGameAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GameAccounts_has_Games_Games1`
    FOREIGN KEY (`idGames`)
    REFERENCES `mytournament`.`Games` (`idGames`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mytournament`.`TournamentsSponsors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytournament`.`TournamentsSponsors` (
  `idTournaments` INT NOT NULL,
  `idSponsors` INT NOT NULL,
  PRIMARY KEY (`idTournaments`, `idSponsors`),
  INDEX `fk_Tournaments_has_Sponsors_Sponsors1_idx` (`idSponsors` ASC),
  INDEX `fk_Tournaments_has_Sponsors_Tournaments1_idx` (`idTournaments` ASC),
  CONSTRAINT `fk_Tournaments_has_Sponsors_Tournaments1`
    FOREIGN KEY (`idTournaments`)
    REFERENCES `mytournament`.`Tournaments` (`idTournaments`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournaments_has_Sponsors_Sponsors1`
    FOREIGN KEY (`idSponsors`)
    REFERENCES `mytournament`.`Sponsors` (`idSponsors`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
