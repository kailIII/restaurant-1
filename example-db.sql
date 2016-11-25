-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Lis 2016, 20:38
-- Wersja serwera: 10.1.16-MariaDB
-- Wersja PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `admin-bazy`
--
CREATE DATABASE IF NOT EXISTS `admin-bazy` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `admin-bazy`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pytania`
--

CREATE TABLE `pytania` (
  `id` int(11) NOT NULL,
  `tresc` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `odpa` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `odpb` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `odpc` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `odpd` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `answer` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `kategoria` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `rok` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Zrzut danych tabeli `pytania`
--

INSERT INTO `pytania` (`id`, `tresc`, `odpa`, `odpb`, `odpc`, `odpd`, `answer`, `kategoria`, `rok`) VALUES
(1, 'Wypisanie na ekranie zawartości zmiennej char s = "To jest tylko test" zostanie wykonane w języku C++ za pomocą instrukcji', 'cin&lt;&lt;s', 'cout&gt;&gt;s', 'cout&lt;&lt;s', 'cin&gt;&gt;s', 'c', 'programowanie', 2012),
(2, 'Destruktor w języku C++ to metoda', 'wywoływana w momencie usuwania obiektu', 'wywoływana w momencie tworzenia obiektu', 'zwalniająca pamięć przydzieloną dynamicznie w obiekcie', 'porządkująca pamięć operacyjną po usuniętych obiektach', 'a', 'programowanie', 2009),
(3, 'Dziedziczenie w programowaniu obiektowym pozwala na', 'łączenie obiektów', 'kopiowanie cech jednego obiektu do innego', 'usunięcie z istniejącej klasy zbędnych elementów.', 'tworzenie nowej klasy na podstawie jednej lub kilku już istniejących klas', 'd', 'programowanie', 2008),
(4, 'Złącze AGP służy do podłączenia', 'szybkich pamięci dyskowych', 'urządzeń wejścia/wyjścia', 'kart graficznych', 'modemu', 'c', 'urządzenia techniki komp.', 2007),
(5, 'Do którego wyprowadzenia należy podłączyć głośniki aktywne w karcie dźwiękowej, której schemat funkcjonalny przedstawia rysunek?', 'Mic in', 'Line in', 'Line out', 'Speaker out', 'c', 'urządzenia techniki komp.', 2006),
(6, 'Który blok karty dźwiękowej służy do cyfrowego przetwarzania sygnałów?', 'Przetwornik A/D', 'Procesor DSP', 'Syntezator', 'Mikser', 'b', 'urządzenia techniki komp.', 2011),
(7, 'Warunkiem niezbędnym przy archiwizacji danych jest', 'kompresja danych', 'kopiowanie danych', 'kompresja i kopiowanie danych', 'kompresja i kopiowanie danych z jednoczesnym ich szyfrowaniem', 'b', 'systemy operacyjne i sieci', 2006),
(8, 'Która warstwa modelu ISO/OSI jest związana z protokołem IP?', 'Sieciowa', 'Fizyczna', 'Transportowa', 'Łącza danych', 'a', 'systemy operacyjne i sieci', 2010),
(9, 'Ile komórek pamięci można zaadresować bezpośrednio w 64 bitowym procesorze, który ma 32 bitową szynę adresową?', '2 do potęgi 32', '2 do potęgi 64', '32 do potęgi 2', '64 do potęgi 2', 'a', 'urządzenia techniki komp.', 2006),
(10, 'Co oznacza zwrot "wykonanie backupu systemu"?', 'Zamknięcie systemu', 'Ponowne uruchomienie systemu', 'Wykonanie aktualizacji systemu', 'Wykonanie kopii zapasowej systemu', 'd', 'systemy operacyjne i sieci', 2012),
(11, 'Klaster komputerowy to', 'komputer z macierzą dyskową', 'komputer z wieloma procesorami', 'grupa komputerów pracujących współbieżnie tak, jakby był to jeden komputer', 'komputer zapasowy, na którym co pewien czas wykonywana jest kopia systemu głównego', 'c', 'urządzenia techniki komp.', 2007),
(12, 'Jaką ilość rzeczywistych danych można przesłać w czasie 1 s przez łącze synchroniczne o przepustowości 512 kbps, bez sprzętowej i programowej kompresji?', 'Około 5 kB', 'Około 55 kB', 'Ponad 64 kB', 'Ponad 500 kB', 'b', 'systemy operacyjne i sieci', 2012),
(13, 'Jakiej liczbie kolorów odpowiada kolor zakodowany na 16 bitach?', '16 kolorom', 'około 64 tysiącom kolorów', 'około 65 tysiącom kolorów', 'około 16 milionom kolorów', 'c', 'multimedia i grafika', 2008),
(14, 'Pamięć oznaczona symbolem PC3200 nie może współpracować z magistralą', '300 MHz', '333 MHz', '400 MHz', '533 MHz', 'd', 'urządzenia techniki komp.', 2006),
(15, 'Co oznacza jednostka dpi podawana w parametrach katalogowych skanerów i drukarek?', 'Punkty na cal', 'Gęstość optyczną', 'Punkty na milimetr', 'Punkty na centymetr', 'a', 'urządzenia techniki komp.', 2009),
(16, 'Jaka jest maksymalna prędkość odczytu płyt CD-R w napędzie oznaczonym x48?', '480 kB/s', '4800 kB/s', '7200 kB/s', '10000 kB/s', 'c', 'urządzenia techniki komp.', 2006),
(17, 'Funkcje różnych kategorii (daty i czasu, finansowe, tekstowe, matematyczne, statystyczne) są elementem składowym', 'edytora tekstu', 'przeglądarki internetowej', 'arkusza kalkulacyjnego', 'programów do tworzenia prezentacji multimedialnych', 'c', 'oprogramowanie biurowe', 2010),
(18, 'Który z podanych języków programowania nie jest językiem webowym?', 'HTML5', 'JavaScript', 'PHP', 'C++', 'd', 'programowanie', 2012),
(19, 'W języku C++ różnica między funkcją a procedurą polega na tym, że', 'funkcja zwraca wartość, a procedura nie', 'do funkcji jako parametr można przekazywać zmienną, a do procedur tylko wartość', 'do procedury jako parametr można przekazywać zmienną, a do funkcji tylko wartość', 'funkcja może być zdefiniowana z tylko jednym parametrem, a procedura z wieloma', 'a', 'programowanie', 2006),
(20, 'Jaki jest kod koloru w języku HTML, jeśli kolor ten ma składowe w zapisie dziesiętnym: czerwony = 27, zielony = 90 i niebieski = 104?', '#279004', '#1B5A68', '#1C9D4A', '#5A681B', 'b', 'multimedia i grafika', 2010);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `pytania`
--
ALTER TABLE `pytania`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `pytania`
--
ALTER TABLE `pytania`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;--
-- Baza danych: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(11) NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Zrzut danych tabeli `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{"db":"restaurantdb","table":"reservation"},{"db":"restaurantdb","table":"message"},{"db":"restaurantdb","table":"food"},{"db":"admin-bazy","table":"pytania"},{"db":"restaurantdb","table":"authorities"},{"db":"restaurantdb","table":"users"},{"db":"restaurantdb","table":"imageview"}]');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float UNSIGNED NOT NULL DEFAULT '0',
  `y` float UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

--
-- Zrzut danych tabeli `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'restaurantdb', 'message', '{"CREATE_TIME":"2016-11-05 01:38:53","col_visib":["1","1","1"]}', '2016-11-20 13:38:33'),
('root', 'restaurantdb', 'reservation', '{"sorted_col":"`reservation`.`people`  DESC"}', '2016-11-20 17:49:09');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin,
  `data_sql` longtext COLLATE utf8_bin,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Zrzut danych tabeli `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2016-10-30 20:11:49', '{"lang":"pl","collation_connection":"utf8mb4_unicode_ci"}');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indexes for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indexes for table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indexes for table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indexes for table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indexes for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indexes for table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indexes for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indexes for table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indexes for table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indexes for table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indexes for table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indexes for table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;--
-- Baza danych: `restaurantdb`
--
CREATE DATABASE IF NOT EXISTS `restaurantdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `restaurantdb`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('root', 'ADMIN'),
('root', 'ROLE_ADMIN');

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
(17, '<h1 style="text-align: center;">Your Topic</h1><div style="text-align: center;"><span style="font-size: 10pt;">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris molestie tristique est eget scelerisque. Nulla in nisl sed magna pulvinar hendrerit sed non metus. In cursus bibendum odio, ac posuere ligula. Vestibulum ipsum lacus, dictum a nisl a, hendrerit gravida est. Nam ut nisl congue, porta ipsum vel, porta tellus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Integer placerat lorem at eros rhoncus vulputate. Sed tellus urna, tincidunt quis ipsum non, vestibulum placerat dolor. Nam neque mi, feugiat a turpis ut, iaculis imperdiet urna.\r\n\r\nDonec sit amet tempor lectus, vitae scelerisque lectus. Pellentesque viverra cursus tincidunt. Maecenas laoreet enim nec vulputate blandit.&nbsp;</span></div><div style="text-align: center;"><span style="font-size: 10pt;"><br></span></div><div style="text-align: center;"><span style="font-size: 10pt;">Nullam elementum vitae lorem ac commodo. Donec accumsan tincidunt mattis. Donec ex diam, ornare vitae mollis a, gravida porttitor dui. Proin rhoncus egestas nisl. Quisque malesuada dolor vel ante eleifend ultrices. Proin sodales sem sit amet cursus feugiat. Aliquam id tempor diam. Nullam pellentesque accumsan velit sed dapibus. Vivamus pellentesque ipsum ut erat eleifend, quis efficitur lectus consequat. Vestibulum lobortis quis enim ut finibus. Aenean quis tristique ligula. Aliquam id nisl ultricies, molestie magna egestas, blandit justo.\r\n\r\nDonec suscipit mattis turpis ut faucibus. Sed accumsan ex vel erat pharetra venenatis. In consequat blandit lectus, non ultricies risus. Vivamus dignissim nulla a vehicula molestie. Maecenas ullamcorper leo at risus tempus, semper aliquet orci sodales. Donec vitae fermentum justo. Maecenas interdum blandit lectus sit amet facilisis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras vestibulum molestie ante pretium blandit.</span></div>', 'about');

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
(2, '2016-11-18 23:00:00', 'qwe', '11:00:00', 'qwe', '2', 'ewq', '11:00:00', 'ewq'),
(3, '2016-11-18 23:00:00', '', '13:00:00', '', '2', '', '13:15:00', ''),
(4, '2016-11-18 23:00:00', '', '13:00:00', '', '2', '', '13:15:00', ''),
(5, '2016-11-18 23:00:00', '', '13:00:00', '', '2', '', '13:15:00', ''),
(6, '2016-11-20 23:00:00', '', '13:00:00', '', '2', '', '13:15:00', ''),
(7, '2016-11-19 23:00:00', '', '13:00:00', '', '2', '', '13:15:00', ''),
(8, '2016-11-19 23:00:00', '', '14:00:00', '', '2', '', '13:15:00', ''),
(9, '2016-11-21 23:00:00', '', '11:00:00', '', '2', '', '11:00:00', ''),
(10, '2016-11-21 23:00:00', '', '11:00:00', '', '2', '', '11:00:00', ''),
(11, '2016-11-20 23:00:00', '', '11:00:00', '', '2', '', '11:00:00', ''),
(12, '2016-11-19 23:00:00', '', '12:00:00', '', '2', '', '10:00:00', ''),
(13, '2016-11-20 00:00:00', '', '14:00:00', '', '2', '', '14:00:00', ''),
(14, '2016-11-24 00:00:00', '', '12:00:00', '', '2', '', '12:00:00', ''),
(15, '2016-11-22 00:00:43', 'qweqweqweqwe', '16:15:00', 'qwe', '2', 'qweqweqwe', '17:00:00', 'qweqwe'),
(16, '2016-11-20 00:00:43', '', '12:00:00', '', '6', '', '12:00:00', ''),
(17, '2016-11-20 00:00:43', '', '19:00:00', '', '2', '', '20:00:00', ''),
(18, '2016-11-20 00:00:43', 'qweqweqweqwe', '20:15:00', 'qwe', '2', 'qweqweqwe', '21:00:00', 'qweqwe'),
(19, '2016-11-20 00:00:43', 'qweqweqweqwe', '22:00:00', 'qwe', '2', 'qweqweqwe', '22:00:00', 'qweqwe'),
(20, '2016-11-20 00:00:43', 'qweqweqweqwe', '15:00:00', 'qwe', '2', 'qweqweqwe', '16:00:00', 'qweqwe'),
(21, '2016-11-23 12:00:00', 'e', '12:00:00', 'qwe', '2', 'weqw', '12:01:00', 'qweq'),
(22, '2016-11-23 12:00:00', 'e', '13:00:00', 'qwe', '2', 'weqw', '14:01:00', 'qweq'),
(23, '2016-11-30 12:00:00', '', '13:00:00', '', '2', '', '13:30:00', ''),
(24, '2016-11-30 12:00:00', '', '13:45:00', '', '6', '', '16:15:00', ''),
(25, '2016-11-29 12:00:00', '', '12:00:00', '', '2', '', '12:00:00', ''),
(27, '2016-11-27 12:00:00', '', '12:00:00', '', '2', '', '12:15:00', ''),
(29, '2016-11-24 12:00:00', 'qwe', '23:00:00', 'qwe', '2', 'qwe', '23:30:00', 'qwe'),
(30, '2016-11-27 12:00:00', 'qwe', '10:00:00', 'qweeeee', '2', 'qwee', '11:00:00', 'wqeee'),
(31, '2016-11-20 12:00:00', '', '09:00:00', '', '2', '', '09:15:00', ''),
(32, '2016-11-15 12:00:00', '', '05:00:00', '', '6', '', '06:00:00', '');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('root', '123', 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD KEY `fk_authorities_users` (`username`);

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
-- AUTO_INCREMENT dla tabeli `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT dla tabeli `imageview`
--
ALTER TABLE `imageview`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT dla tabeli `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
--
-- Baza danych: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
