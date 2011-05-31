-- phpMyAdmin SQL Dump
-- version 3.2.5
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- GÃ©nÃ©rÃ© le : Mar 31 Mai 2011 Ã  16:07
-- Version du serveur: 5.1.44
-- Version de PHP: 5.3.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de donnÃ©es: `safedrivingbdd`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `voie` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `codePostal` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient les adresses' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `adresse`
--


-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FK_adresse` int(11) NOT NULL COMMENT 'Foreign key vers la table adresse',
  `telephone` varchar(12) NOT NULL,
  `FK_agence` int(11) NOT NULL COMMENT 'Foreign key vers la table lieu',
  `FK_utilisateur` int(11) NOT NULL COMMENT 'Foreign vers la table utilisateur',
  PRIMARY KEY (`id`),
  KEY `FKAF12F3CBC022F5C2` (`FK_utilisateur`),
  KEY `FKAF12F3CB815B3122` (`FK_agence`),
  KEY `FKAF12F3CBED1AE1A` (`FK_adresse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient les clients de l''agence' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `client`
--


-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE `examen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FK_typeExamen` int(11) NOT NULL COMMENT 'Foreign key vers la table type_examen',
  `dateDePassage` date NOT NULL,
  `aObtenu` tinyint(1) NOT NULL,
  `FK_client` int(11) NOT NULL COMMENT 'Foreign key vers la table client',
  `obtenu` bit(1) NOT NULL,
  `FK_type_examen` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB32239088C48135A` (`FK_client`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient tous les examens (réussi ou non) par les clients' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `examen`
--


-- --------------------------------------------------------

--
-- Structure de la table `examen_prefecture`
--

CREATE TABLE `examen_prefecture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FK_typeExamen` int(5) NOT NULL COMMENT 'Foreign key vers la table type_examen',
  `nombrePlaces` tinyint(4) NOT NULL,
  `date` datetime NOT NULL,
  `FK_lieu` int(11) NOT NULL COMMENT 'Foreign key vers la table lieu',
  `FK_type_examen` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK180BF18C85E7AA9E` (`FK_lieu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient les dates d''examens donné par la prefecture' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `examen_prefecture`
--


-- --------------------------------------------------------

--
-- Structure de la table `examen_prefecture_vers_vehicule`
--

CREATE TABLE `examen_prefecture_vers_vehicule` (
  `FK_examenPrefecture` int(5) NOT NULL COMMENT 'Foreign key vers la table examen_prefecture',
  `FK_vehicule` int(5) NOT NULL COMMENT 'Foreign key vers la table vehicule',
  `examensPrefecture_id` bigint(20) NOT NULL,
  `vehicules_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Table intermédiaire entre la table examen_prefecture et la t';

--
-- Contenu de la table `examen_prefecture_vers_vehicule`
--


-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

CREATE TABLE `formateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estCommercial` tinyint(1) NOT NULL,
  `utilisateur` int(11) NOT NULL COMMENT 'Foreign key vers la table utilisateur',
  `FK_utilisateur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient la liste des formateurs de l''auto école' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `formateur`
--


-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `id` int(11) NOT NULL,
  `prix` decimal(4,3) NOT NULL,
  `duree` time NOT NULL,
  `nom` varchar(100) NOT NULL,
  `nombrePlaces` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient les formations dispensées par l''auto école';

--
-- Contenu de la table `formation`
--


-- --------------------------------------------------------

--
-- Structure de la table `indisponibilite`
--

CREATE TABLE `indisponibilite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commentaire` varchar(250) DEFAULT NULL,
  `dateDebut` datetime NOT NULL,
  `dateFin` datetime NOT NULL,
  `FK_formateur` int(11) NOT NULL COMMENT 'Foreign Key vers formateur',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `indisponibilite`
--


-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

CREATE TABLE `lieu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FK_adresse` int(11) NOT NULL COMMENT 'Foreign vers la table adresse',
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32AEEDED1AE1A` (`FK_adresse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient tous les lieux (les agences, les sessions de format' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `lieu`
--


-- --------------------------------------------------------

--
-- Structure de la table `session_formation`
--

CREATE TABLE `session_formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` datetime NOT NULL,
  `dateFin` datetime NOT NULL,
  `FK_formateur` int(5) NOT NULL COMMENT 'Foreign  key vers la table formateur',
  `FK_lieu` int(5) NOT NULL COMMENT 'Foreign  key vers la table lieu',
  `FK_formation` int(5) NOT NULL COMMENT 'Foreign key vers la table formation',
  `note` tinyint(2) NOT NULL,
  `commentaire` varchar(250) DEFAULT NULL,
  `FK_client` int(5) NOT NULL COMMENT 'Foreign key vers la table client',
  `nbPlace` tinyint(2) NOT NULL,
  `debut` datetime DEFAULT NULL,
  `fin` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4652424885E7AA9E` (`FK_lieu`),
  KEY `FK4652424872780292` (`FK_formateur`),
  KEY `FK4652424872781F1E` (`FK_formation`),
  KEY `FK465242488C48135A` (`FK_client`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `session_formation`
--


-- --------------------------------------------------------

--
-- Structure de la table `session_formation_vers_vehicule`
--

CREATE TABLE `session_formation_vers_vehicule` (
  `FK_sessionFormation` int(5) NOT NULL COMMENT 'Foreign key vers la table session de formation',
  `FK_vehicule` int(5) NOT NULL COMMENT 'Foreign key vers la table vehicule',
  `sessionsFormation_id` bigint(20) NOT NULL,
  `vehicules_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Table de relation entre session_formation et vehicule';

--
-- Contenu de la table `session_formation_vers_vehicule`
--


-- --------------------------------------------------------

--
-- Structure de la table `type_examen`
--

CREATE TABLE `type_examen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient tous les types d''examen proposés par l''auto école' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `type_examen`
--


-- --------------------------------------------------------

--
-- Structure de la table `type_vehicule`
--

CREATE TABLE `type_vehicule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient tous les types de véhicules de l''auto école' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `type_vehicule`
--


-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(40) NOT NULL,
  `mdp` varchar(40) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `sexe` tinyint(1) DEFAULT NULL,
  `mail` varchar(100) NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `dateNaissance` date NOT NULL,
  `dateInscription` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Contient tous les utilisateurs de l''auto école (utilisateur ' AUTO_INCREMENT=2 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` VALUES(1, 'toto', 'fuck', 'Mahe', 'Simon', NULL, 'zfhgjhsfkghsk', NULL, '2011-05-18', '2011-05-18');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FK_typeVehicule` int(11) NOT NULL COMMENT 'Foreign vers la table type_vehicule',
  `immatriculation` varchar(20) NOT NULL,
  `FK_agence` int(11) NOT NULL COMMENT 'Foreign key vers la table lieu',
  PRIMARY KEY (`id`),
  KEY `FK780E795B815B3122` (`FK_agence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contient tous les véhicules de l''auto école' AUTO_INCREMENT=1 ;

--
-- Contenu de la table `vehicule`
--


--
-- Contraintes pour les tables exportÃ©es
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKAF12F3CB815B3122` FOREIGN KEY (`FK_agence`) REFERENCES `lieu` (`id`),
  ADD CONSTRAINT `FKAF12F3CBC022F5C2` FOREIGN KEY (`FK_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKAF12F3CBED1AE1A` FOREIGN KEY (`FK_adresse`) REFERENCES `adresse` (`id`);

--
-- Contraintes pour la table `examen`
--
ALTER TABLE `examen`
  ADD CONSTRAINT `FKB32239088C48135A` FOREIGN KEY (`FK_client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `examen_prefecture`
--
ALTER TABLE `examen_prefecture`
  ADD CONSTRAINT `FK180BF18C85E7AA9E` FOREIGN KEY (`FK_lieu`) REFERENCES `lieu` (`id`);

--
-- Contraintes pour la table `lieu`
--
ALTER TABLE `lieu`
  ADD CONSTRAINT `FK32AEEDED1AE1A` FOREIGN KEY (`FK_adresse`) REFERENCES `adresse` (`id`);

--
-- Contraintes pour la table `session_formation`
--
ALTER TABLE `session_formation`
  ADD CONSTRAINT `FK4652424872780292` FOREIGN KEY (`FK_formateur`) REFERENCES `formateur` (`id`),
  ADD CONSTRAINT `FK4652424872781F1E` FOREIGN KEY (`FK_formation`) REFERENCES `formation` (`id`),
  ADD CONSTRAINT `FK4652424885E7AA9E` FOREIGN KEY (`FK_lieu`) REFERENCES `lieu` (`id`),
  ADD CONSTRAINT `FK465242488C48135A` FOREIGN KEY (`FK_client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `FK780E795B815B3122` FOREIGN KEY (`FK_agence`) REFERENCES `lieu` (`id`);
