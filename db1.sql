-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2023 at 05:59 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db1`
--

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `nip` varchar(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `divisi` varchar(255) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`nip`, `nama`, `jenis_kelamin`, `divisi`, `tgl_lahir`, `alamat`) VALUES
('202201', 'Raka', 'LAKI-LAKI', 'Networking Dev', '1990-05-23', 'Jakarta'),
('202202', 'Raisa', 'PEREMPUAN', 'Operation Division', '2000-04-16', 'Bekasi'),
('202203', 'Jaka', 'LAKI-LAKI', 'Networking Dev', '1988-12-13', 'Kalimantan'),
('202204', 'Farah', 'PEREMPUAN', 'Networking Operator ', '2000-06-05', 'Balikpapan'),
('202205', 'Paul', 'LAKI-LAKI', 'Operation Division', '1998-05-11', 'Surabaya'),
('202206', 'Lisa', 'PEREMPUAN', 'Networking Dev', '1990-12-14', 'Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `shift`
--

CREATE TABLE `shift` (
  `no` int(100) NOT NULL,
  `nip` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `divisi` varchar(100) NOT NULL,
  `bulan` varchar(100) NOT NULL,
  `minggu` varchar(100) NOT NULL,
  `shift` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shift`
--

INSERT INTO `shift` (`no`, `nip`, `nama`, `divisi`, `bulan`, `minggu`, `shift`) VALUES
(33, '202202', 'Raisa', 'Operation Division', 'Mei', '3', 'Normal (09.00-17.00)'),
(35, '202203', 'Jaka', 'Networking Dev', 'April', '3', 'Siang (15.00-23.00)'),
(36, '202201', 'Raka', 'Supporting Division', 'Maret', '2', 'Malam (23.00-07.00)'),
(37, '202203', 'Jaka', 'Networking Dev', 'Mei', '3', 'Malam (23.00-07.00)'),
(38, '202202', 'Raisa', 'Operation Division', 'Mei', '4', 'Siang (15.00-23.00)'),
(39, '202204', 'Farah', 'Networking Operator ', 'Maret', '2', 'Siang (15.00-23.00)'),
(40, '202205', 'Paul', 'Operation Division', 'April', '1', 'Malam (23.00-07.00)');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `shift`
--
ALTER TABLE `shift`
  ADD PRIMARY KEY (`no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `shift`
--
ALTER TABLE `shift`
  MODIFY `no` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
