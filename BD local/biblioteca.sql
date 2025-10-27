-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2025 a las 03:48:42
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventariolaptops`
--

CREATE TABLE `inventariolaptops` (
  `numerodeserie` varchar(50) NOT NULL,
  `ID` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `inventariolaptops`
--

INSERT INTO `inventariolaptops` (`numerodeserie`, `ID`) VALUES
('222', 321),
('222', 3333);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventariolibros`
--

CREATE TABLE `inventariolibros` (
  `Titulo` varchar(50) NOT NULL,
  `Autor` varchar(50) NOT NULL,
  `Año` varchar(45) NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  `Genero` varchar(45) DEFAULT NULL,
  `ISBN` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `inventariolibros`
--

INSERT INTO `inventariolibros` (`Titulo`, `Autor`, `Año`, `Tipo`, `Genero`, `ISBN`) VALUES
('aaa', 'aaa', '213', 'Estudio', 'wwww', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembros`
--

CREATE TABLE `miembros` (
  `CI` int(11) NOT NULL,
  `NombreEstudiante` varchar(45) NOT NULL,
  `Grupo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `miembros`
--

INSERT INTO `miembros` (`CI`, `NombreEstudiante`, `Grupo`) VALUES
(333, 'gaspar', '2do'),
(56557162, 'Emiliano', '1ero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `idPrestamo` int(45) NOT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  `CI` int(11) DEFAULT NULL,
  `FechaPrestamo` date NOT NULL,
  `FechaDevolucion` date NOT NULL,
  `Estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamolaptop`
--

CREATE TABLE `prestamolaptop` (
  `idPrestamoLaptop` int(11) NOT NULL,
  `ci` int(11) NOT NULL,
  `FechaPrestamo` date NOT NULL,
  `FechaDevolucion` date NOT NULL,
  `idlaptop` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventariolaptops`
--
ALTER TABLE `inventariolaptops`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `inventariolibros`
--
ALTER TABLE `inventariolibros`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indices de la tabla `miembros`
--
ALTER TABLE `miembros`
  ADD PRIMARY KEY (`CI`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `fkisbn_idx` (`isbn`),
  ADD KEY `fkcedula_idx` (`CI`);

--
-- Indices de la tabla `prestamolaptop`
--
ALTER TABLE `prestamolaptop`
  ADD PRIMARY KEY (`idPrestamoLaptop`),
  ADD KEY `fk_prestamo_ci` (`ci`),
  ADD KEY `fkid` (`idlaptop`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3478918;

--
-- AUTO_INCREMENT de la tabla `prestamolaptop`
--
ALTER TABLE `prestamolaptop`
  MODIFY `idPrestamoLaptop` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `fkCi` FOREIGN KEY (`CI`) REFERENCES `miembros` (`CI`),
  ADD CONSTRAINT `fkisbn` FOREIGN KEY (`isbn`) REFERENCES `inventariolibros` (`ISBN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamolaptop`
--
ALTER TABLE `prestamolaptop`
  ADD CONSTRAINT `fk_prestamo_ci` FOREIGN KEY (`ci`) REFERENCES `miembros` (`CI`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fkid` FOREIGN KEY (`idlaptop`) REFERENCES `inventariolaptops` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
