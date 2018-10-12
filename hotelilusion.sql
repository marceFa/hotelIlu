-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-10-2018 a las 21:59:58
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotelilusion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id_habitacion` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `caracteristicas` varchar(50) DEFAULT NULL,
  `cantidad_personas` int(11) NOT NULL,
  `cantidad_camas` int(11) DEFAULT NULL,
  `precio_diario` double NOT NULL,
  `id_tipohabitacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `id_huesped` int(11) NOT NULL,
  `nombre_apellido` varchar(50) NOT NULL,
  `numero_documento` int(11) NOT NULL,
  `dirección` varchar(50) DEFAULT NULL,
  `telefono` int(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`id_huesped`, `nombre_apellido`, `numero_documento`, `dirección`, `telefono`, `email`) VALUES
(1, 'Agustin Ligorria', 44058111, 'Jacinto Suarez 222', 26641212, 'agus@gmai.com'),
(2, 'Margarita Ordoñez', 6881322, 'Los Palachos 123', 4567890, 'margarita23@hotmail.com'),
(3, 'Mauricio Molina', 26345987, 'Catamarca 15 Mendoza', 1134564, 'quepasara@argentina.com'),
(4, 'Mario Jara', 22345889, 'Cerro Colorado S/N', 11332212, 'mariojara@gmail.com'),
(6, 'Catalina Sosa Paez', 49765432, 'San Miguel 676 Tucumán', 234199808, 'catas@hotmail.com'),
(8, 'Florencia Quiroga', 17564998, 'Junin 23 Córdoba', 43535362, 'flor@yahoo.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `id_habitacion` int(11) DEFAULT NULL,
  `id_huesped` int(11) DEFAULT NULL,
  `tipo_reserva` varchar(20) NOT NULL,
  `fecha_ingreso` datetime DEFAULT NULL,
  `fecha_egreso` datetime DEFAULT NULL,
  `cantidad_personas` int(11) DEFAULT NULL,
  `observacion` varchar(50) NOT NULL,
  `costo_alojamiento` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_habitacion`
--

CREATE TABLE `tipo_habitacion` (
  `id_tipoHabitacion` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_habitacion`
--

INSERT INTO `tipo_habitacion` (`id_tipoHabitacion`, `descripcion`) VALUES
(0, '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id_habitacion`),
  ADD KEY `fk_habitacion_tipohabitacion` (`id_tipohabitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`id_huesped`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD UNIQUE KEY `cantidad_personas_3` (`cantidad_personas`),
  ADD KEY `id_huesped` (`id_huesped`),
  ADD KEY `id_habitacion` (`id_habitacion`),
  ADD KEY `cantidad_personas` (`cantidad_personas`),
  ADD KEY `cantidad_personas_2` (`cantidad_personas`);

--
-- Indices de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD PRIMARY KEY (`id_tipoHabitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `id_habitacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `id_huesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `fk_habitacion_tipohabitacion` FOREIGN KEY (`id_tipohabitacion`) REFERENCES `tipo_habitacion` (`id_tipoHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_habitacion` FOREIGN KEY (`id_reserva`) REFERENCES `habitacion` (`id_habitacion`),
  ADD CONSTRAINT `reserva_huesped` FOREIGN KEY (`id_habitacion`) REFERENCES `huesped` (`id_huesped`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
