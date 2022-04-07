-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 07 avr. 2022 à 16:47
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

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `discount` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

--
-- Tronquer la table avant d'insérer `account`
--

TRUNCATE TABLE `account`;
--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`id`, `creation_date`, `discount`, `type`) VALUES
(1, '2022-04-06', 0, 'CURRENT'),
(2, '2022-04-06', 500, 'SPARE');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Tronquer la table avant d'insérer `user`
--

TRUNCATE TABLE `user`;
--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES
(1, '$2a$10$1u/iLrtbfeGz4rBON4rrk.2oKoERc5YHp1mk5ZrbjdsRJx3Vfo4Yy', 'ADMIN', 'Admin'),
(2, '$2a$10$SOLRryhqG6aunSFm7psljudG0cibSehaq.yzXvTE8/IiTbi2fbozy', 'USER', 'Toto');
COMMIT;
