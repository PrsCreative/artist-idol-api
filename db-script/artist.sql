-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2021 at 11:41 AM
-- Server version: 8.0.25
-- PHP Version: 7.3.24-(to be removed in future macOS)

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artist`
--

-- --------------------------------------------------------

--
-- Table structure for table `IDOL`
--

CREATE TABLE `IDOL` (
  `id` bigint NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `DATE_OF_BIRTH` date NOT NULL,
  `BAND_NAME` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

--
-- Dumping data for table `IDOL`
--

INSERT INTO `IDOL` (`id`, `name`, `DATE_OF_BIRTH`, `BAND_NAME`) VALUES
(3, 'PUP', '2021-09-01', 'POTATO'),
(4, 'BANK', '2021-09-01', 'CLASH'),
(5, 'WIN', '2021-08-10', 'POTATO');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `IDOL`
--
ALTER TABLE `IDOL`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `IDOL`
--
ALTER TABLE `IDOL`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
