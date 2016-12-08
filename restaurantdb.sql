-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 08 Gru 2016, 01:21
-- Wersja serwera: 10.1.16-MariaDB
-- Wersja PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `restaurantdb`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `authorities`
--

CREATE TABLE `authorities` (
  `authority` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `authorities`
--

INSERT INTO `authorities` (`authority`, `role`, `username`) VALUES
(1, 'ROLE_ADMIN', 'root'),
(2, 'ROLE_MODERATOR', 'user1');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `cat` varchar(255) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `food`
--

INSERT INTO `food` (`id`, `cat`, `description`, `name`) VALUES
(1, 'main', 'Aliquam varius nec nunc id lacinia. Mauris scelerisque libero sed vehicula fringilla. Fusce commodo tempor sodales. Vestibulum ornare, massa at mattis bibendum, lacus mauris auctor sapien, ut convallis tellus urna ut dui. Curabitur ornare, elit vel elementum dictum, mauris neque maximus nisi, nec rutrum ligula dolor id ex. Mauris vitae odio lectus. Morbi nec egestas est.', 'vitae'),
(2, 'main', 'In vitae lacus non mi auctor convallis in non enim. Mauris sit amet pellentesque nulla. Integer ac justo felis. Maecenas rhoncus at nibh in bibendum. Sed ornare condimentum malesuada. Sed facilisis arcu nisi, eu tempor justo feugiat dapibus. Etiam at posuere metus, non venenatis mi. Quisque malesuada turpis eu lectus vestibulum, vel porta lacus ultricies. Nulla at tellus iaculis, tempor sem sed, pharetra quam. Suspendisse consequat finibus est, eget tristique lacus pretium commodo. Fusce rutrum convallis posuere. Fusce tincidunt magna nec lorem eleifend, a venenatis augue pharetra. Vestibulum blandit lectus quis arcu semper, non dictum diam fermentum. Proin molestie congue purus. Aenean fermentum dapibus nisi, sed tincidunt dui dapibus vitae. Pellentesque lacinia ornare felis non ultrices.', 'felis'),
(3, 'deserts', 'Proin vulputate mattis nisi et ornare. Integer molestie sollicitudin est, et gravida ante. Proin eu pellentesque enim. Nam arcu metus, bibendum ac euismod sit amet, molestie non ex. Phasellus sagittis arcu et venenatis faucibus. Integer eget quam vel magna imperdiet eleifend. Praesent vestibulum convallis tortor, ultrices ultrices ex faucibus et. Nam sapien enim, eleifend non massa eget, ornare vulputate felis. Curabitur maximus erat in pulvinar viverra. Nulla facilisis diam in ex interdum, at ullamcorper mauris luctus.', 'proin'),
(4, 'deserts', 'Cras maximus, dui ut vulputate cursus, augue felis molestie tellus, sed venenatis tortor libero et nunc. Donec mollis nibh congue magna commodo, quis vehicula nisl auctor. Nullam mollis est at ligula ornare sodales. Nunc vestibulum lectus quis gravida posuere. Vivamus convallis, nulla in convallis tincidunt, magna lacus consequat justo, in pretium arcu eros sit amet ipsum. Pellentesque sed blandit quam. Proin lobortis est ac magna mattis porta. Nunc placerat fermentum imperdiet. In congue erat sit amet felis suscipit, sed aliquam felis maximus. Morbi sit amet tellus at nisl hendrerit dignissim quis eget nunc. Quisque dolor lorem, semper in pulvinar sit amet, lobortis non lacus. Mauris sagittis diam suscipit odio ultrices convallis. Suspendisse ultrices feugiat erat quis fringilla.', 'cras'),
(5, 'beverages', 'Morbi porta augue auctor, ullamcorper nunc id, consectetur magna. Morbi pulvinar est ac cursus ullamcorper. Duis accumsan, libero eget suscipit aliquet, tellus eros tempor purus, eget tincidunt mi tellus ut arcu. Curabitur sit amet porta nisi, ac pulvinar ligula. Proin at dictum neque, quis ultricies orci. Donec aliquam tempus sem eget rutrum. Nam rhoncus ac magna at blandit. Etiam eu lorem id quam condimentum sodales. Praesent euismod euismod sem. Praesent dignissim condimentum mattis. Duis non velit nec dui iaculis facilisis. Phasellus non mi pharetra, accumsan risus vel, eleifend ante. Nulla quis ex vel lectus ornare convallis. Nullam in magna felis. Etiam nec ipsum iaculis eros auctor molestie.', 'morbi'),
(6, 'beverages', 'Vivamus varius vitae augue quis auctor. Cras enim ex, malesuada eu ultricies ac, venenatis ut nibh. Phasellus commodo erat at mauris porttitor, in posuere lorem efficitur. Sed at porttitor enim, id facilisis libero. Aenean nec leo ut sem porta imperdiet ut quis metus. Proin varius magna purus, volutpat dignissim purus lacinia at. Duis ullamcorper ornare tellus, sed tincidunt libero tristique vitae. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'vivamus');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `imageview`
--

CREATE TABLE `imageview` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `message` longtext,
  `target` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `message`
--

INSERT INTO `message` (`id`, `message`, `target`) VALUES
(55, 'fine street, new city, new country', 'address'),
(60, '23', 'closeTime'),
(64, 'Sushi Way', 'restaurantName'),
(70, '00 123 123 321', 'phone'),
(73, '9', 'openTime'),
(82, 'Your description', 'description'),
(85, '<h1 style="text-align: center;">Your Topic</h1><h1 style="text-align: center;"><div style="font-size: 13.3333px; font-weight: normal;"><span style="font-size: 10pt;">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris molestie tristique est eget scelerisque. Nulla in nisl sed magna pulvinar hendrerit sed non metus. In cursus bibendum odio, ac posuere ligula. Vestibulum ipsum lacus, dictum a nisl a, hendrerit gravida est. Nam ut nisl congue, porta ipsum vel, porta tellus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Integer placerat lorem at eros rhoncus vulputate. Sed tellus urna, tincidunt quis ipsum non, vestibulum placerat dolor. Nam neque mi, feugiat a turpis ut, iaculis imperdiet urna. Donec sit amet tempor lectus, vitae scelerisque lectus. Pellentesque viverra cursus tincidunt. Maecenas laoreet enim nec vulputate blandit.&nbsp;</span></div><div style="font-size: 13.3333px; font-weight: normal;"><span style="font-size: 10pt;"><br></span></div><div style="font-size: 13.3333px; font-weight: normal;"><span style="font-size: 10pt;">Nullam elementum vitae lorem ac commodo. Donec accumsan tincidunt mattis. Donec ex diam, ornare vitae mollis a, gravida porttitor dui. Proin rhoncus egestas nisl. Quisque malesuada dolor vel ante eleifend ultrices. Proin sodales sem sit amet cursus feugiat. Aliquam id tempor diam. Nullam pellentesque accumsan velit sed dapibus. Vivamus pellentesque ipsum ut erat eleifend, quis efficitur lectus consequat. Vestibulum lobortis quis enim ut finibus. Aenean quis tristique ligula. Aliquam id nisl ultricies, molestie magna egestas, blandit justo. Donec suscipit mattis turpis ut faucibus. Sed accumsan ex vel erat pharetra venenatis. In consequat blandit lectus, non ultricies risus. Vivamus dignissim nulla a vehicula molestie. Maecenas ullamcorper leo at risus tempus, semper aliquet orci sodales. Donec vitae fermentum justo. Maecenas interdum blandit lectus sit amet facilisis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras vestibulum molestie ante pretium blandit.</span></div></h1>', 'about'),
(87, 'editable footer info for you', 'footerInfo'),
(89, 'myEmail@gmail.com', 'email'),
(91, 'Your Title', 'title'),
(93, '/resources/img/sw.png', 'logoUrl');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `numericmessage`
--

CREATE TABLE `numericmessage` (
  `id` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `numericmessage`
--

INSERT INTO `numericmessage` (`id`, `number`, `target`) VALUES
(9, 12, 'tablesFor6'),
(11, 7, 'tablesFor2');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reservation`
--

CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstTime` time DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `people` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `secondTime` time DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `reservation`
--

INSERT INTO `reservation` (`id`, `date`, `email`, `firstTime`, `firstname`, `people`, `phone`, `secondTime`, `surname`) VALUES
(5, '2016-12-31 12:00:00', 'John@Doe.com', '09:00:00', 'John', '6', '543897765', '11:00:00', 'Doe'),
(6, '2016-12-31 12:00:00', 'Sue@sue.com', '09:00:00', 'Mia', '6', '654987345', '12:15:00', 'Sue'),
(7, '2016-12-31 12:00:00', 'Peter@White.com', '17:15:00', 'Peter', '2', '543765765', '20:15:00', 'White'),
(8, '2016-12-31 12:00:00', 'Melody@Clark.com', '16:30:00', 'Melody', '6', '654987098', '20:00:00', 'Clark'),
(9, '2016-12-31 12:00:00', 'Melody@Clark.com', '18:30:00', 'Ruby', '6', '654987098', '22:00:00', 'Yang'),
(10, '2016-12-31 12:00:00', 'Stephany@Lee.com', '18:30:00', 'Stephany', '6', '654987098', '22:00:00', 'Lee'),
(11, '2016-12-31 12:00:00', 'Bob@Smith.com', '18:30:00', 'Bob', '6', '342678987', '22:00:00', 'Smith'),
(12, '2016-12-31 12:00:00', 'Jeff@Bezos.com', '10:00:00', 'Jeff', '6', '354768970', '14:00:00', 'Bezos'),
(13, '2016-12-31 12:00:00', 'Mark@Sandberg.com', '10:00:00', 'Mark', '6', '345234231', '14:00:00', 'Sandberg'),
(14, '2016-12-31 12:00:00', 'Brand@Feld.com', '10:00:00', 'Brand', '6', '234654890', '14:00:00', 'Feld'),
(15, '2016-12-31 12:00:00', 'Marissa@Mayer.com', '09:15:00', 'Marissa', '6', '654980345', '11:00:00', 'Mayer'),
(16, '2016-12-31 12:00:00', 'Tom@Taylor.com', '17:30:00', 'Tom', '6', '659034563', '19:00:00', 'Taylor'),
(17, '2016-12-31 12:00:00', 'Obmar@Wood.com', '17:30:00', 'Obmar', '6', '232345456', '19:00:00', 'Wood'),
(18, '2016-12-31 12:00:00', 'Steve@Jobs.com', '12:15:00', 'Steve', '2', '123567897', '14:00:00', 'Jobs'),
(19, '2016-12-31 12:00:00', 'Ruby@Bawn.com', '11:15:00', 'Ruby', '2', '676745342', '14:00:00', 'Bawn'),
(20, '2016-12-31 12:00:00', 'Richard@Cornell.com', '09:15:00', 'Richard', '2', '123678098', '13:00:00', 'Cornell'),
(21, '2016-12-31 12:00:00', 'Angela@Hill.com', '21:15:00', 'Angela', '2', '123654321', '22:45:00', 'Hill');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`username`, `enabled`, `password`) VALUES
('root', b'1', '123'),
('user1', b'1', 'password');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`authority`),
  ADD KEY `FKhjuy9y4fd8v5m3klig05ktofg` (`username`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `imageview`
--
ALTER TABLE `imageview`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `numericmessage`
--
ALTER TABLE `numericmessage`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `authorities`
--
ALTER TABLE `authorities`
  MODIFY `authority` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT dla tabeli `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT dla tabeli `imageview`
--
ALTER TABLE `imageview`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;
--
-- AUTO_INCREMENT dla tabeli `numericmessage`
--
ALTER TABLE `numericmessage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT dla tabeli `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `FKhjuy9y4fd8v5m3klig05ktofg` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
