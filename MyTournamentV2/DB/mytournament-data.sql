-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 10 Août 2016 à 14:06
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mytournament`
--

-- --------------------------------------------------------

--
-- Structure de la table `clans`
--

CREATE TABLE `clans` (
  `idClan` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `idWebRef` int(11) DEFAULT NULL,
  `creationDate` datetime NOT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `formatoftournaments`
--

CREATE TABLE `formatoftournaments` (
  `idFormatTournaments` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `formatoftournaments`
--

INSERT INTO `formatoftournaments` (`idFormatTournaments`, `name`, `active`) VALUES
(1, '1 vs 1', 1),
(2, '2 vs 2', 1),
(3, '3 vs 3', 1),
(4, '4 vs 4', 1),
(5, '5 vs 5', 1);

-- --------------------------------------------------------

--
-- Structure de la table `gameaccounts`
--

CREATE TABLE `gameaccounts` (
  `idGameAccounts` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `idUsers` int(11) NOT NULL,
  `idPlatforms` int(11) NOT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `gameaccountsgames`
--

CREATE TABLE `gameaccountsgames` (
  `idGameAccounts` int(11) NOT NULL,
  `idGames` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `games`
--

CREATE TABLE `games` (
  `idGames` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `idWebRef` int(11) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `idPlatforms` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `games`
--

INSERT INTO `games` (`idGames`, `name`, `idWebRef`, `active`, `idPlatforms`) VALUES
(1, 'Counter Strike Global Offensive', NULL, 1, 1),
(2, 'Diablo', NULL, 1, 2),
(3, 'Ark : Survival Evolved', NULL, 1, 1),
(4, 'Overwatch', NULL, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `locations`
--

CREATE TABLE `locations` (
  `idLocations` int(11) NOT NULL,
  `street` varchar(45) NOT NULL,
  `town` varchar(45) NOT NULL,
  `zipCode` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `platforms`
--

CREATE TABLE `platforms` (
  `idPlatforms` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `platforms`
--

INSERT INTO `platforms` (`idPlatforms`, `name`, `active`) VALUES
(1, 'Steam', NULL),
(2, 'Blizzard', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `registrations`
--

CREATE TABLE `registrations` (
  `idRegistration` int(11) NOT NULL,
  `idClan` int(11) DEFAULT NULL,
  `idUsers` int(11) NOT NULL,
  `idTournaments` int(11) NOT NULL,
  `userConfirmation` tinyint(1) NOT NULL,
  `clanLeaderValidation` tinyint(1) NOT NULL,
  `creationDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `rewards`
--

CREATE TABLE `rewards` (
  `idRewards` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `idTypeOfRewards` int(11) NOT NULL,
  `Tournaments_idTournaments` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sponsors`
--

CREATE TABLE `sponsors` (
  `idSponsors` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `idLocations` int(11) DEFAULT NULL,
  `idWebRef` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tournaments`
--

CREATE TABLE `tournaments` (
  `idTournaments` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `online` tinyint(1) NOT NULL,
  `maxPlayers` int(11) NOT NULL,
  `creationDate` datetime NOT NULL,
  `modificationDate` datetime DEFAULT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `price` float DEFAULT NULL,
  `idGames` int(11) NOT NULL,
  `idLocations` int(11) DEFAULT NULL,
  `idTypeOfTournaments` int(11) NOT NULL,
  `idFormatTournaments` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tournamentsponsor`
--

CREATE TABLE `tournamentsponsor` (
  `idSponsors` int(11) NOT NULL,
  `idTournaments` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `typeofrewards`
--

CREATE TABLE `typeofrewards` (
  `idTypeOfRewards` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `typeoftournaments`
--

CREATE TABLE `typeoftournaments` (
  `idTypeOfTournaments` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `typeoftournaments`
--

INSERT INTO `typeoftournaments` (`idTypeOfTournaments`, `name`, `active`) VALUES
(1, 'Single player', 1),
(2, 'Clan', 1);

-- --------------------------------------------------------

--
-- Structure de la table `unavailabilities`
--

CREATE TABLE `unavailabilities` (
  `idUnavailabilities` int(11) NOT NULL,
  `day` int(11) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `idUsers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `userroles`
--

CREATE TABLE `userroles` (
  `idUserRoles` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `userroles`
--

INSERT INTO `userroles` (`idUserRoles`, `name`) VALUES
(1, 'admin'),
(2, 'player');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `idUsers` int(11) NOT NULL,
  `pseudo` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `creationDate` datetime NOT NULL,
  `idUserRoles` int(11) NOT NULL,
  `password` char(128) NOT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`idUsers`, `pseudo`, `name`, `firstname`, `email`, `phoneNumber`, `dob`, `creationDate`, `idUserRoles`, `password`, `active`) VALUES
(1, 'dim1', 'Krasucki', 'Dimitri', 'dimitri.krasucki@gmail.com', '0484/572-666', '2016-08-10', '2016-08-10 13:43:52', 1, '5555489390e0f492c15723881fd2b005fad9138930e0e9338c5849813a3b33ec40d1e5a9dc488471f203d92b7bb52b7cd0b0575402c0275ca25ee87eb3906725', 1);

-- --------------------------------------------------------

--
-- Structure de la table `usersclans`
--

CREATE TABLE `usersclans` (
  `idUsers` int(11) NOT NULL,
  `idClan` int(11) NOT NULL,
  `addedDateTime` datetime NOT NULL,
  `removedDateTime` datetime DEFAULT NULL,
  `idUsersClans` int(11) NOT NULL,
  `clanLeader` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `webref`
--

CREATE TABLE `webref` (
  `idWebRef` int(11) NOT NULL,
  `logo` varchar(100) DEFAULT NULL,
  `locationWeb` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `clans`
--
ALTER TABLE `clans`
  ADD PRIMARY KEY (`idClan`),
  ADD KEY `fk_Clan_WebRef1_idx` (`idWebRef`);

--
-- Index pour la table `formatoftournaments`
--
ALTER TABLE `formatoftournaments`
  ADD PRIMARY KEY (`idFormatTournaments`);

--
-- Index pour la table `gameaccounts`
--
ALTER TABLE `gameaccounts`
  ADD PRIMARY KEY (`idGameAccounts`),
  ADD KEY `fk_GameAccounts_Users1_idx` (`idUsers`),
  ADD KEY `fk_GameAccounts_TypeGameAccounts1_idx` (`idPlatforms`);

--
-- Index pour la table `gameaccountsgames`
--
ALTER TABLE `gameaccountsgames`
  ADD PRIMARY KEY (`idGameAccounts`,`idGames`),
  ADD KEY `fk_GameAccounts_has_Games_Games1_idx` (`idGames`),
  ADD KEY `fk_GameAccounts_has_Games_GameAccounts1_idx` (`idGameAccounts`);

--
-- Index pour la table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`idGames`),
  ADD KEY `fk_Games_WebRef1_idx` (`idWebRef`),
  ADD KEY `fk_Games_GameAccountPlatforms1_idx` (`idPlatforms`);

--
-- Index pour la table `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`idLocations`);

--
-- Index pour la table `platforms`
--
ALTER TABLE `platforms`
  ADD PRIMARY KEY (`idPlatforms`);

--
-- Index pour la table `registrations`
--
ALTER TABLE `registrations`
  ADD PRIMARY KEY (`idRegistration`),
  ADD UNIQUE KEY `idUsers_UNIQUE` (`idUsers`),
  ADD UNIQUE KEY `idTournaments_UNIQUE` (`idTournaments`),
  ADD KEY `fk_Selections_Clan1_idx` (`idClan`),
  ADD KEY `fk_Selections_Users1_idx` (`idUsers`),
  ADD KEY `fk_Selections_Tournaments1_idx` (`idTournaments`);

--
-- Index pour la table `rewards`
--
ALTER TABLE `rewards`
  ADD PRIMARY KEY (`idRewards`),
  ADD KEY `fk_Rewards_TypeOfRewards1_idx` (`idTypeOfRewards`),
  ADD KEY `fk_Rewards_Tournaments1_idx` (`Tournaments_idTournaments`);

--
-- Index pour la table `sponsors`
--
ALTER TABLE `sponsors`
  ADD PRIMARY KEY (`idSponsors`),
  ADD KEY `fk_Sponsors_Locations1_idx` (`idLocations`),
  ADD KEY `fk_Sponsors_WebRef1_idx` (`idWebRef`);

--
-- Index pour la table `tournaments`
--
ALTER TABLE `tournaments`
  ADD PRIMARY KEY (`idTournaments`),
  ADD KEY `fk_Tournaments_Games1_idx` (`idGames`),
  ADD KEY `fk_Tournaments_Locations1_idx` (`idLocations`),
  ADD KEY `fk_Tournaments_TypeOfTournaments1_idx` (`idTypeOfTournaments`),
  ADD KEY `fk_Tournaments_FormatTournaments1_idx` (`idFormatTournaments`);

--
-- Index pour la table `tournamentsponsor`
--
ALTER TABLE `tournamentsponsor`
  ADD PRIMARY KEY (`idSponsors`,`idTournaments`),
  ADD KEY `fk_Sponsors_has_Tournaments_Tournaments1_idx` (`idTournaments`),
  ADD KEY `fk_Sponsors_has_Tournaments_Sponsors1_idx` (`idSponsors`);

--
-- Index pour la table `typeofrewards`
--
ALTER TABLE `typeofrewards`
  ADD PRIMARY KEY (`idTypeOfRewards`);

--
-- Index pour la table `typeoftournaments`
--
ALTER TABLE `typeoftournaments`
  ADD PRIMARY KEY (`idTypeOfTournaments`);

--
-- Index pour la table `unavailabilities`
--
ALTER TABLE `unavailabilities`
  ADD PRIMARY KEY (`idUnavailabilities`),
  ADD KEY `fk_Unavailabilities_Users1_idx` (`idUsers`);

--
-- Index pour la table `userroles`
--
ALTER TABLE `userroles`
  ADD PRIMARY KEY (`idUserRoles`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idUsers`),
  ADD KEY `fk_Users_UsersStatuts1_idx` (`idUserRoles`);

--
-- Index pour la table `usersclans`
--
ALTER TABLE `usersclans`
  ADD PRIMARY KEY (`idUsersClans`),
  ADD UNIQUE KEY `idUsers_UNIQUE` (`idUsers`),
  ADD UNIQUE KEY `idClan_UNIQUE` (`idClan`),
  ADD KEY `fk_UsersClans_Users1_idx` (`idUsers`),
  ADD KEY `fk_UsersClans_Clans1_idx` (`idClan`);

--
-- Index pour la table `webref`
--
ALTER TABLE `webref`
  ADD PRIMARY KEY (`idWebRef`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `clans`
--
ALTER TABLE `clans`
  MODIFY `idClan` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `formatoftournaments`
--
ALTER TABLE `formatoftournaments`
  MODIFY `idFormatTournaments` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `gameaccounts`
--
ALTER TABLE `gameaccounts`
  MODIFY `idGameAccounts` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `games`
--
ALTER TABLE `games`
  MODIFY `idGames` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `locations`
--
ALTER TABLE `locations`
  MODIFY `idLocations` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `platforms`
--
ALTER TABLE `platforms`
  MODIFY `idPlatforms` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `registrations`
--
ALTER TABLE `registrations`
  MODIFY `idRegistration` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `rewards`
--
ALTER TABLE `rewards`
  MODIFY `idRewards` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `sponsors`
--
ALTER TABLE `sponsors`
  MODIFY `idSponsors` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `tournaments`
--
ALTER TABLE `tournaments`
  MODIFY `idTournaments` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typeofrewards`
--
ALTER TABLE `typeofrewards`
  MODIFY `idTypeOfRewards` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typeoftournaments`
--
ALTER TABLE `typeoftournaments`
  MODIFY `idTypeOfTournaments` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `unavailabilities`
--
ALTER TABLE `unavailabilities`
  MODIFY `idUnavailabilities` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `userroles`
--
ALTER TABLE `userroles`
  MODIFY `idUserRoles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `idUsers` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `usersclans`
--
ALTER TABLE `usersclans`
  MODIFY `idUsersClans` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `webref`
--
ALTER TABLE `webref`
  MODIFY `idWebRef` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `clans`
--
ALTER TABLE `clans`
  ADD CONSTRAINT `fk_Clan_WebRef1` FOREIGN KEY (`idWebRef`) REFERENCES `webref` (`idWebRef`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `gameaccounts`
--
ALTER TABLE `gameaccounts`
  ADD CONSTRAINT `fk_GameAccounts_TypeGameAccounts1` FOREIGN KEY (`idPlatforms`) REFERENCES `platforms` (`idPlatforms`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_GameAccounts_Users1` FOREIGN KEY (`idUsers`) REFERENCES `users` (`idUsers`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `gameaccountsgames`
--
ALTER TABLE `gameaccountsgames`
  ADD CONSTRAINT `fk_GameAccounts_has_Games_GameAccounts1` FOREIGN KEY (`idGameAccounts`) REFERENCES `gameaccounts` (`idGameAccounts`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_GameAccounts_has_Games_Games1` FOREIGN KEY (`idGames`) REFERENCES `games` (`idGames`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `games`
--
ALTER TABLE `games`
  ADD CONSTRAINT `fk_Games_GameAccountPlatforms1` FOREIGN KEY (`idPlatforms`) REFERENCES `platforms` (`idPlatforms`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Games_WebRef1` FOREIGN KEY (`idWebRef`) REFERENCES `webref` (`idWebRef`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `registrations`
--
ALTER TABLE `registrations`
  ADD CONSTRAINT `fk_Selections_Clan1` FOREIGN KEY (`idClan`) REFERENCES `clans` (`idClan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Selections_Tournaments1` FOREIGN KEY (`idTournaments`) REFERENCES `tournaments` (`idTournaments`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Selections_Users1` FOREIGN KEY (`idUsers`) REFERENCES `users` (`idUsers`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `rewards`
--
ALTER TABLE `rewards`
  ADD CONSTRAINT `fk_Rewards_Tournaments1` FOREIGN KEY (`Tournaments_idTournaments`) REFERENCES `tournaments` (`idTournaments`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Rewards_TypeOfRewards1` FOREIGN KEY (`idTypeOfRewards`) REFERENCES `typeofrewards` (`idTypeOfRewards`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `sponsors`
--
ALTER TABLE `sponsors`
  ADD CONSTRAINT `fk_Sponsors_Locations1` FOREIGN KEY (`idLocations`) REFERENCES `locations` (`idLocations`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Sponsors_WebRef1` FOREIGN KEY (`idWebRef`) REFERENCES `webref` (`idWebRef`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `tournaments`
--
ALTER TABLE `tournaments`
  ADD CONSTRAINT `fk_Tournaments_FormatTournaments1` FOREIGN KEY (`idFormatTournaments`) REFERENCES `formatoftournaments` (`idFormatTournaments`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Tournaments_Games1` FOREIGN KEY (`idGames`) REFERENCES `games` (`idGames`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Tournaments_Locations1` FOREIGN KEY (`idLocations`) REFERENCES `locations` (`idLocations`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Tournaments_TypeOfTournaments1` FOREIGN KEY (`idTypeOfTournaments`) REFERENCES `typeoftournaments` (`idTypeOfTournaments`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `tournamentsponsor`
--
ALTER TABLE `tournamentsponsor`
  ADD CONSTRAINT `fk_Sponsors_has_Tournaments_Sponsors1` FOREIGN KEY (`idSponsors`) REFERENCES `sponsors` (`idSponsors`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Sponsors_has_Tournaments_Tournaments1` FOREIGN KEY (`idTournaments`) REFERENCES `tournaments` (`idTournaments`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `unavailabilities`
--
ALTER TABLE `unavailabilities`
  ADD CONSTRAINT `fk_Unavailabilities_Users1` FOREIGN KEY (`idUsers`) REFERENCES `users` (`idUsers`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_Users_UsersStatuts1` FOREIGN KEY (`idUserRoles`) REFERENCES `userroles` (`idUserRoles`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `usersclans`
--
ALTER TABLE `usersclans`
  ADD CONSTRAINT `fk_UsersClans_Clans1` FOREIGN KEY (`idClan`) REFERENCES `clans` (`idClan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_UsersClans_Users1` FOREIGN KEY (`idUsers`) REFERENCES `users` (`idUsers`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
