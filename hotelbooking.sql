-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2022 at 06:37 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotelbooking`
--

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE `feedbacks` (
  `feedback_id` int(11) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `message` varchar(255) NOT NULL,
  `review` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedbacks`
--

INSERT INTO `feedbacks` (`feedback_id`, `subject`, `name`, `email`, `message`, `review`) VALUES
(1, 'sdfsdf', 'Sanetha Thisun', 's@gmail.com', 'sadasdsadsad', 'neutral'),
(2, 'sdfsdf', 'Sanetha Thisun', 's@gmail.com', 'Yeh it is better expirincejh dsck cekg', 'excellent'),
(3, '', 'Kaveen', 'kaveen@gmail.com', 'room looks good', 'good'),
(4, 'bad service', 'Kaveen', 'kaveen@gmail.com', 'this is the worst experience I ever had.', 'poor');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int(11) NOT NULL,
  `room_type` varchar(50) NOT NULL,
  `room_number` varchar(50) NOT NULL,
  `room_description` varchar(50) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`room_id`, `room_type`, `room_number`, `room_description`, `price`) VALUES
(1, 'Luxury', '15', 'King bed with a good mattress, high-quality sheets', 5500),
(2, 'Luxury', '16', 'King bed with a good mattress, high-quality sheets', 5500),
(3, 'Luxury', '17', 'King bed with a good mattress, high-quality sheets', 5500),
(4, 'Luxury', '18', 'King bed with a good mattress, high-quality sheets', 5500),
(5, 'Luxury', '19', 'King bed with a good mattress, high-quality sheets', 5500),
(6, 'Deluxe', '20', 'Deluxe Rooms are modern and offer essential facili', 8500),
(7, 'Deluxe', '21', 'Deluxe Rooms are modern and offer essential facili', 8500),
(8, 'Deluxe', '22', 'Deluxe Rooms are modern and offer essential facili', 8500),
(9, 'Deluxe', '23', 'Deluxe Rooms are modern and offer essential facili', 8500),
(10, 'Deluxe', '24', 'Deluxe Rooms are modern and offer essential facili', 8500),
(11, 'Signature', '25', 'Signature rooms with attached bathroom are our lar', 10000),
(12, 'Signature', '26', 'Signature rooms with attached bathroom are our lar', 10000),
(13, 'Signature', '27', 'Signature rooms with attached bathroom are our lar', 10000),
(14, 'Signature', '28', 'Signature rooms with attached bathroom are our lar', 10000),
(15, 'Signature', '29', 'Signature rooms with attached bathroom are our lar', 10000),
(16, 'Couple', '30', 'Double King Beds Equipped with heater and air. The', 6000),
(17, 'Couple', '31', 'Double King Beds Equipped with heater and air. The', 6000),
(18, 'Couple', '32', 'Double King Beds Equipped with heater and air. The', 6000),
(19, 'Couple', '33', 'Double King Beds Equipped with heater and air. The', 6000);

-- --------------------------------------------------------

--
-- Table structure for table `room_book`
--

CREATE TABLE `room_book` (
  `room_book_id` int(11) NOT NULL,
  `checkin` date NOT NULL,
  `checkout` date NOT NULL,
  `room_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact_no` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `category` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `full_name`, `email`, `contact_no`, `gender`, `password`, `category`) VALUES
(6, 'Kaveen Rupasinghe', 'kaveen@gmail.com', 773711560, 'Male', '1234', 'User'),
(2, 'Ranidu Vishwa', 'ranidume@gmail.com', 760927434, 'Male', '12345', 'Admin'),
(7, 'Thashiya Perera', 'thashiya@gmail.com', 765254125, 'female', '123456', 'User'),
(8, 'tharumini Sahabandu', 'tharumini@gmail.com', 763260325, 'female', 'tharumini123', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`feedback_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`,`room_number`);

--
-- Indexes for table `room_book`
--
ALTER TABLE `room_book`
  ADD PRIMARY KEY (`room_book_id`),
  ADD KEY `fk_roombook` (`room_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `room_book`
--
ALTER TABLE `room_book`
  MODIFY `room_book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
