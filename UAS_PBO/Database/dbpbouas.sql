-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2023 at 08:17 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpbouas`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbsepatu`
--

CREATE TABLE `tbsepatu` (
  `idsepatu` int(11) NOT NULL,
  `NamaSepatu` varchar(255) NOT NULL,
  `HargaSepatu` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL,
  `JenisSepatu` varchar(255) NOT NULL,
  `GenderSepatu` varchar(255) NOT NULL,
  `UkuranSepatu` int(11) NOT NULL,
  `WarnaSepatu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbsepatu`
--

INSERT INTO `tbsepatu` (`idsepatu`, `NamaSepatu`, `HargaSepatu`, `Keterangan`, `JenisSepatu`, `GenderSepatu`, `UkuranSepatu`, `WarnaSepatu`) VALUES
(1, 'Nike 1920', 4200000, 'Free Style', 'Denim', 'Wanita', 40, 'Putih'),
(2, 'Nike Sillyman', 1300000, 'Sport Style', 'Karet', 'Wanita', 38, 'Putih'),
(3, 'NewBalance Code 0', 3200000, 'Revolution Shoes', 'Denim', 'Wanita', 42, 'Coklat'),
(4, 'Kirin Adidas x Vans', 5200000, 'Collab Shoes', 'Canvas', 'Pria', 43, 'Hitam');

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `iduser` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`iduser`, `username`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbsepatu`
--
ALTER TABLE `tbsepatu`
  ADD PRIMARY KEY (`idsepatu`);

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbsepatu`
--
ALTER TABLE `tbsepatu`
  MODIFY `idsepatu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbuser`
--
ALTER TABLE `tbuser`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
