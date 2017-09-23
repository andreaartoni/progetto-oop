CREATE TABLE IF NOT EXISTS `Utente` (
  `username` varchar(25) NOT NULL,
  `password` varchar(40) NOT NULL,
  `nome` varchar(15),
  `cognome` varchar(20),
  `sesso` varchar(5) NOT NULL,
  `peso` int NOT NULL,
  `altezza` int NOT NULL,
  `attività` varchar(30),
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`),
  UNIQUE KEY `isbn_2` (`isbn`)
);