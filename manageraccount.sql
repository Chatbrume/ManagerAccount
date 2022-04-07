-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 07 avr. 2022 à 13:47
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de données : `manageraccount`
--
CREATE DATABASE IF NOT EXISTS `manageraccount` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `manageraccount`;

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `discount` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Tronquer la table avant d'insérer `account`
--

TRUNCATE TABLE `account`;
--
-- Déchargement des données de la table `account`
--

INSERT IGNORE INTO `account` (`id`, `creation_date`, `discount`, `type`) VALUES
(1, '2022-04-06', 0, 'CURRENT'),
(2, '2022-04-06', 500, 'SPARE');
COMMIT;