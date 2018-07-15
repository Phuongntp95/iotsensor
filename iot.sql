-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 15, 2018 lúc 12:22 PM
-- Phiên bản máy phục vụ: 10.1.33-MariaDB
-- Phiên bản PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `iot`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `userid` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(8) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`userid`, `password`) VALUES
('abc', '123'),
('fhj', 'cjk'),
('hi', 'hi'),
('phuong', '123'),
('string', 'string'),
('test', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bomnuoc`
--

CREATE TABLE `bomnuoc` (
  `id` int(255) NOT NULL,
  `switchnuoc` int(1) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bomnuoc`
--

INSERT INTO `bomnuoc` (`id`, `switchnuoc`, `date`) VALUES
(1, 1, '2018-07-14 20:01:24'),
(2, 1, '2018-07-14 20:01:24'),
(3, 0, '2018-07-13 14:22:00'),
(4, 1, '2018-07-14 20:01:24'),
(5, 1, '2018-07-14 20:01:24'),
(6, 1, '2018-07-14 20:56:07'),
(7, 0, '2018-07-14 20:56:25'),
(8, 1, '2018-07-15 14:34:42');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sensor`
--

CREATE TABLE `sensor` (
  `id` int(255) NOT NULL,
  `date` datetime NOT NULL,
  `temperature` int(11) NOT NULL,
  `humidity` int(11) NOT NULL,
  `doamdat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sensor`
--

INSERT INTO `sensor` (`id`, `date`, `temperature`, `humidity`, `doamdat`) VALUES
(1, '2018-07-13 22:24:47', 28, 60, 100),
(2, '2018-07-13 13:53:38', 29, 67, 70),
(3, '2018-07-02 04:16:14', 31, 55, 20),
(4, '2018-07-14 19:36:10', 0, 0, 0),
(5, '2018-07-14 19:36:10', 0, 0, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`userid`);

--
-- Chỉ mục cho bảng `bomnuoc`
--
ALTER TABLE `bomnuoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bomnuoc`
--
ALTER TABLE `bomnuoc`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `sensor`
--
ALTER TABLE `sensor`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
