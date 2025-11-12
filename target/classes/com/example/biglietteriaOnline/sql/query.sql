USE Biglietteria;

INSERT INTO Teatri (COD_TEATRO, NOME, INDIRIZZO, CITTA, PROVINCIA, TELEFONO, POSTI)
VALUES
('T001', 'Teatro Carignano', 'Piazza Carignano 6', 'Torino', 'TO', '011/3456759', 875),
('T002', 'Teatro Regio', 'Piazza Castello 2', 'Torino', 'TO', '011/9870654', 1592),
('T003', 'Teatro Alfieri', 'Piazza Solferino 4', 'Torino', 'TO', '011/6574895', 1500);

INSERT INTO Spettacoli (COD_SPETTACOLO, TITOLO, AUTORE, REGISTA, PREZZO, COD_TEATRO)
VALUES
('S001', 'film sulla lotta di classe', 'Ascanio Celestini', 'Ascanio Celestini', 20.00, 'T001'),
('S002', 'Il birraio di Preston', 'Andrea Camilleri', 'Giuseppe Dipasquale', 20.00, 'T001'),
('S003', 'La Traviata', 'Giuseppe Verdi', 'Laurent Pelly', 40.00, 'T002'),
('S004', 'La Bohème', 'Giacomo Puccini', 'Giuseppe Patroni Griffi', 40.00, 'T002'),
('S005', 'Poveri, ma belli', 'Gianni Togni', 'Massimo Ranieri', 25.00, 'T003'),
('S006', 'Il sogno del piccolo imperatore', 'Gian Mesturino', 'Alberto Barbi', 25.00, 'T003');

INSERT INTO Repliche (COD_REPLICA, COD_SPETTACOLO, DATA_REPLICA)
VALUES
('R001', 'S001', '2018-10-05'),
('R002', 'S001', '2018-10-06'),
('R003', 'S001', '2018-10-07'),
('R004', 'S001', '2018-10-08'),
('R005', 'S001', '2018-10-09'),
('R006', 'S002', '2018-11-12'),
('R007', 'S002', '2018-11-13'),
('R008', 'S002', '2018-11-14'),
('R009', 'S002', '2018-11-15'),
('R010', 'S002', '2018-11-16'),
('R011', 'S003', '2019-01-05'),
('R012', 'S003', '2019-01-06'),
('R013', 'S003', '2019-01-07'),
('R014', 'S003', '2019-01-08'),
('R015', 'S003', '2019-01-09'),
('R016', 'S004', '2019-01-12'),
('R017', 'S004', '2019-01-13'),
('R018', 'S004', '2019-01-14'),
('R019', 'S004', '2019-01-15'),
('R020', 'S004', '2019-01-16'),
('R021', 'S005', '2018-11-05'),
('R022', 'S005', '2018-11-06'),
('R023', 'S005', '2018-11-07'),
('R024', 'S005', '2018-11-08'),
('R025', 'S005', '2018-11-09'),
('R026', 'S006', '2018-12-12'),
('R027', 'S006', '2018-12-13'),
('R028', 'S006', '2018-12-14'),
('R029', 'S006', '2018-12-15'),
('R030', 'S006', '2018-12-16');

INSERT INTO Clienti (COD_CLIENTE, COGNOME, NOME, TELEFONO, EMAIL)
VALUES
(1, 'Alfieri', 'Valeria', '011/4328346', 'alf@libero.it'),
(2, 'Bellotti', 'Cinzia', '011/7987658', 'bel@tin.it'),
(3, 'Morgeri', 'Giuseppe', '011/76547648', 'dig@email.it'),
(4, 'Bastioni', 'Gianluca', '011/8566548', 'fai@virgilio.it'),
(5, 'Francini', 'Massimiliano', '011/543325655', 'fra@libero.it'),
(6, 'Mattone', 'Fabrizio', '011/98765762', 'gat@tin.it'),
(7, 'Maistoni', 'Ivan', '011/5483678', 'mai@email.it'),
(8, 'Parenti', 'Michele', '011/5367548', 'mik@tin.it'),
(9, 'Morrini', 'Marco', '011/53645872', 'mor@libero.it'),
(10, 'Pagini', 'Giuliana', '011/78363459', 'pag@yahoo.it'),
(11, 'Picati', 'Annamaria', '011/67598721', 'pic@email.it'),
(12, 'Rugliese', 'Antonio', '011/3678465', 'pug@email.it'),
(13, 'Romanotti', 'Davide', '011/34254367', 'rom@libero.it'),
(14, 'Straniti', 'Annamaria', '011/845673865', 'str@libero.it');
