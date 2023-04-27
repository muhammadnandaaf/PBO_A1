-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 27, 2023 at 04:01 PM
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
-- Database: `dbpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbbayar`
--

CREATE TABLE `tbbayar` (
  `idTransaksi` int(11) NOT NULL,
  `pesananId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `totalBayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbbayar`
--

INSERT INTO `tbbayar` (`idTransaksi`, `pesananId`, `userId`, `totalBayar`) VALUES
(1, 1, 2, 6200000),
(2, 10, 3, 460000000);

-- --------------------------------------------------------

--
-- Table structure for table `tbperhiasan`
--

CREATE TABLE `tbperhiasan` (
  `kodePerhiasan` varchar(5) NOT NULL,
  `namaPerhiasan` varchar(255) NOT NULL,
  `jenisPerhiasan` varchar(255) NOT NULL,
  `berat` varchar(100) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbperhiasan`
--

INSERT INTO `tbperhiasan` (`kodePerhiasan`, `namaPerhiasan`, `jenisPerhiasan`, `berat`, `harga`) VALUES
('E01', 'Emas Kalimantan', 'Logam Mulia', '3 gram', 3100000),
('P01', 'Perak Australia', 'Logam Mulia', '2 Kg', 23000000),
('R01', 'Ruby Burma', 'Batu Mulia', '2 gram', 142000000);

-- --------------------------------------------------------

--
-- Table structure for table `tbpesanan`
--

CREATE TABLE `tbpesanan` (
  `idPesanan` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `perhiasanId` varchar(255) NOT NULL,
  `jumlahPesanan` int(11) NOT NULL,
  `totalHarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbpesanan`
--

INSERT INTO `tbpesanan` (`idPesanan`, `userId`, `perhiasanId`, `jumlahPesanan`, `totalHarga`) VALUES
(1, 2, 'E01', 2, 6200000),
(2, 1, 'P01', 3, 69000000),
(3, 2, 'R01', 2, 284000000),
(4, 4, 'P01', 3, 69000000),
(5, 4, 'R01', 1, 142000000),
(6, 1, 'E01', 1, 3100000),
(8, 2, 'P01', 1, 23000000),
(9, 2, 'R01', 2, 284000000),
(10, 3, 'P01', 2, 46000000);

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `idUser` int(50) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`idUser`, `username`, `email`, `phone`, `address`, `password`) VALUES
(1, 'nandz', 'nandz@gmail.com', '081354309827', 'Sempaja', 'nandz123'),
(2, 'nanda', 'nanda@gmail.com', '082347562833', 'Bengkuring', 'nanda123'),
(3, 'Dimas', 'dimas@gmail.com', '08574523456', 'Biawan', 'dimas123'),
(4, 'bram', 'bram@gmail.com', '085643431', 'AWS', 'bram123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbbayar`
--
ALTER TABLE `tbbayar`
  ADD PRIMARY KEY (`idTransaksi`),
  ADD KEY `pesananId` (`pesananId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `tbperhiasan`
--
ALTER TABLE `tbperhiasan`
  ADD PRIMARY KEY (`kodePerhiasan`);

--
-- Indexes for table `tbpesanan`
--
ALTER TABLE `tbpesanan`
  ADD PRIMARY KEY (`idPesanan`),
  ADD KEY `perhiasanId` (`perhiasanId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbbayar`
--
ALTER TABLE `tbbayar`
  MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbpesanan`
--
ALTER TABLE `tbpesanan`
  MODIFY `idPesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbuser`
--
ALTER TABLE `tbuser`
  MODIFY `idUser` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbbayar`
--
ALTER TABLE `tbbayar`
  ADD CONSTRAINT `tbbayar_ibfk_1` FOREIGN KEY (`pesananId`) REFERENCES `tbpesanan` (`idPesanan`),
  ADD CONSTRAINT `tbbayar_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `tbuser` (`idUser`);

--
-- Constraints for table `tbpesanan`
--
ALTER TABLE `tbpesanan`
  ADD CONSTRAINT `tbpesanan_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tbuser` (`idUser`),
  ADD CONSTRAINT `tbpesanan_ibfk_2` FOREIGN KEY (`perhiasanId`) REFERENCES `tbperhiasan` (`kodePerhiasan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
