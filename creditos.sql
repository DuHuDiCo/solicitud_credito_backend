-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-10-2022 a las 20:51:56
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `creditos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `analisis_credito`
--

CREATE TABLE `analisis_credito` (
  `id` bigint(20) NOT NULL,
  `observaciones` varchar(10000) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `analisis_credito`
--

INSERT INTO `analisis_credito` (`id`, `observaciones`, `usuario_id`) VALUES
(1, 'vcxzbvadsferew', 2),
(2, 'La cedula de ciudadania del cliente no corresponde con la foto del mismo, por favor realizar el cambio', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivo`
--

CREATE TABLE `archivo` (
  `id_archivo` bigint(20) NOT NULL,
  `fecha` datetime NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `ruta` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cedula_ciudadania_cliente`
--

CREATE TABLE `cedula_ciudadania_cliente` (
  `id` bigint(20) NOT NULL,
  `frente_cedula` varchar(255) DEFAULT NULL,
  `respaldo_cedula` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cedula_ciudadania_cliente`
--

INSERT INTO `cedula_ciudadania_cliente` (`id`, `frente_cedula`, `respaldo_cedula`) VALUES
(1, 'file_1664228793103.png', 'file_1664228793117.png'),
(2, 'file_1664662464373.png', 'file_1664662464392.png'),
(3, 'file_1664822015372.png', 'file_1664822015410.png'),
(4, 'file_1664823022849.png', 'file_1664823022869.png'),
(5, 'file_1664834448106.jpeg', 'file_1664834448217.jpeg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cedula_ciudadania_codeudor`
--

CREATE TABLE `cedula_ciudadania_codeudor` (
  `id` bigint(20) NOT NULL,
  `frente_cedula` varchar(255) DEFAULT NULL,
  `respaldo_cedula` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cedula_ciudadania_codeudor`
--

INSERT INTO `cedula_ciudadania_codeudor` (`id`, `frente_cedula`, `respaldo_cedula`) VALUES
(1, 'file_1664228793126.png', 'file_1664228793133.png'),
(2, 'file_1664662464408.png', 'file_1664662464418.png'),
(3, 'file_1664822015436.png', 'file_1664822015443.png'),
(4, 'file_1664823022878.png', 'file_1664823022898.png'),
(5, 'file_1664834448439.jpeg', 'file_1664834448488.jpeg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `cedula` varchar(20) DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `direccion_empresa` varchar(50) DEFAULT NULL,
  `direccion_pariente` varchar(50) DEFAULT NULL,
  `direccion_trabajo_conyuge` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `estado_civil` varchar(10) DEFAULT NULL,
  `nombre_conyuge` varchar(150) DEFAULT NULL,
  `nombre_pariente` varchar(100) DEFAULT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `otros_ingresos` varchar(255) DEFAULT NULL,
  `propietario` varchar(100) DEFAULT NULL,
  `salario` float NOT NULL,
  `telefono_casa` varchar(50) DEFAULT NULL,
  `telefono_pariente` varchar(20) DEFAULT NULL,
  `telefono_trabajo_conyuge` varchar(50) DEFAULT NULL,
  `tiempo_servicio` varchar(50) DEFAULT NULL,
  `tipo_casa` varchar(20) DEFAULT NULL,
  `trabajo_conyuge` varchar(50) DEFAULT NULL,
  `valor_alquiler` float NOT NULL,
  `valor_otros_ingresos` float NOT NULL,
  `cedula_id` bigint(20) DEFAULT NULL,
  `observaciones` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `apellidos`, `cargo`, `cedula`, `celular`, `direccion`, `direccion_empresa`, `direccion_pariente`, `direccion_trabajo_conyuge`, `email`, `empresa`, `estado_civil`, `nombre_conyuge`, `nombre_pariente`, `nombres`, `otros_ingresos`, `propietario`, `salario`, `telefono_casa`, `telefono_pariente`, `telefono_trabajo_conyuge`, `tiempo_servicio`, `tipo_casa`, `trabajo_conyuge`, `valor_alquiler`, `valor_otros_ingresos`, `cedula_id`, `observaciones`) VALUES
(1, 'rewrwer', 'fadsfasdf', '24344324', '42323423', 'dsafadsf', '', 'fasdfasdf', '', 'dudicodiaz@gmail.com', 'adsfasdfasd', 'soltero', '', 'asdfasdfasd', 'afdasfsda', '', '', 324432000000, '', 'asdfasdf', '', 'adfasdf', 'propia', '', 0, 0, 1, NULL),
(2, 'asfdasfda', 'dfsafds', '42432', '342432', 'fdasfadfs', '', 'fdsafdsa', '', 'dudicodiaz@gmail.com', 'fdsafadfs', 'soltero', '', 'dsafdsa', 'dfadfsdfsadffd', '', '', 432342000, '', 'dfasdfas', '', 'fdsafads', 'propia', '', 0, 0, 2, NULL),
(3, 'dfsasdfa', 'dsafads', '32423423', 'dfasfadsfa', 'dfsafasdf', '', 'adfdfaa', '', 'dudicodiaz@gmail.com', 'fdasadsf', 'soltero', '', 'fdasfa', 'asfasdfa', '', '', 324234000, '', 'dfsfdas', '', 'dafsafdfas', 'propia', '', 0, 0, 3, NULL),
(4, 'safadsf', 'dsaffasdf', '32423423', 'r3242343', 'fdsafsa', '', 'fdsafdsa', '', 'dudicodiaz@gmail.comf', 'dsafsda', 'soltero', '', 'fdsafasfd', 'dfasdfasdffd', '', '', 3242420, '', 'dafsfasd', '', '324234', 'propia', '', 0, 0, 4, NULL),
(5, 'Nsbsdbsb', 'Nsbsvsvs', '1313121', '67979787', 'VVshhs', '', 'Bsbsvsvs', '', 'dudicodiaz@gmail.com', 'Zbvsussh', 'soltero', '', 'Jsjsvdhs', 'Jaja svs', '', '', 31548800, '', '34548748', '', '12', 'propia', '', 0, 0, 5, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_referencias_comerciales`
--

CREATE TABLE `cliente_referencias_comerciales` (
  `cliente_id` bigint(20) NOT NULL,
  `referencias_comerciales_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente_referencias_comerciales`
--

INSERT INTO `cliente_referencias_comerciales` (`cliente_id`, `referencias_comerciales_id`) VALUES
(1, 1),
(2, 3),
(3, 5),
(4, 7),
(5, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_referencias_personales`
--

CREATE TABLE `cliente_referencias_personales` (
  `cliente_id` bigint(20) NOT NULL,
  `referencias_personales_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente_referencias_personales`
--

INSERT INTO `cliente_referencias_personales` (`cliente_id`, `referencias_personales_id`) VALUES
(1, 1),
(2, 3),
(3, 5),
(4, 7),
(5, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `codeudor`
--

CREATE TABLE `codeudor` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `cedula` varchar(20) DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `direccion_empresa` varchar(50) DEFAULT NULL,
  `direccion_pariente` varchar(50) DEFAULT NULL,
  `direccion_trabajo_conyuge` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `estado_civil` varchar(10) DEFAULT NULL,
  `nombre_conyuge` varchar(150) DEFAULT NULL,
  `nombre_pariente` varchar(100) DEFAULT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `otros_ingresos` varchar(255) DEFAULT NULL,
  `propietario` varchar(100) DEFAULT NULL,
  `salario` float NOT NULL,
  `telefono_casa` varchar(50) DEFAULT NULL,
  `telefono_pariente` varchar(20) DEFAULT NULL,
  `telefono_trabajo_conyuge` varchar(50) DEFAULT NULL,
  `tiempo_servicio` varchar(50) DEFAULT NULL,
  `tipo_casa` varchar(20) DEFAULT NULL,
  `trabajo_conyuge` varchar(50) DEFAULT NULL,
  `valor_alquiler` float NOT NULL,
  `valor_otros_ingresos` float NOT NULL,
  `cedula_id` bigint(20) DEFAULT NULL,
  `observaciones` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `codeudor`
--

INSERT INTO `codeudor` (`id`, `apellidos`, `cargo`, `cedula`, `celular`, `direccion`, `direccion_empresa`, `direccion_pariente`, `direccion_trabajo_conyuge`, `email`, `empresa`, `estado_civil`, `nombre_conyuge`, `nombre_pariente`, `nombres`, `otros_ingresos`, `propietario`, `salario`, `telefono_casa`, `telefono_pariente`, `telefono_trabajo_conyuge`, `tiempo_servicio`, `tipo_casa`, `trabajo_conyuge`, `valor_alquiler`, `valor_otros_ingresos`, `cedula_id`, `observaciones`) VALUES
(1, 'sadfasdfasd', 'adfdfsadf', '324234234', '234523423', 'fdasfasdf', '', 'fasdfasdf', '', 'dudicodiaz@gmail.com', 'dsfasdfasdf', 'soltero', '', 'dafsasdfads', 'adsfasdf', '', '', 3423420, '', 'asdfasdf', '', '3423432', 'propia', '', 0, 0, 1, NULL),
(2, 'fdasfdasdfas', 'dasfdsa', '32434342', '3424423', 'safdafd', 'fadsfsadffdasf', 'fdfadsfads', '', 'dudicodiaz@gmail.com', 'fdsafasdf', 'soltero', '', 'fdasfdasadf', 'ddfafdsadfs', '', '', 432342000, '', 'dfasdfas', '', 'dfasfdadfs', 'propia', '', 0, 0, 2, NULL),
(3, 'dsfasdf', 'dsfasdf', '2342342', 'adfasd3r', 'dsaffd', '', 'sdfasdfa', '', 'dudicodiaz@gmail.com', 'fdsafdasa', 'soltero', '', 'dfsafdsaa', 'fadsfasdfa', '', '', 423423, '', 'dfsadfs', '', '342342', 'propia', '', 0, 0, 3, NULL),
(4, 'adsfasdf', 'adfadsf', '324234', '4322342', 'dsafasdf', '', 'adfsadsf', '', 'dudicodiaz@gmail.com', 'dfsafdadsf', 'soltero', '', 'fsafdsa', 'adsfasdff', '', '', 34223400, '', 'dfadsf', '', '3423432', 'propia', '', 0, 0, 4, NULL),
(5, 'Hshsvsvs', 'Jshsvsvs', '34578445', '21346784', 'Hsbsbaba', '', 'Hssbsv', '', 'dudicodiaz@gmail.com', 'Hsvsvsvs', 'soltero', '', 'Hsbqjabs', 'Jsvddausjvs', '', '', 61646500, '', '648454', '', '24', 'propia', '', 0, 0, 5, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `codeudor_referencias_comerciales`
--

CREATE TABLE `codeudor_referencias_comerciales` (
  `codeudor_id` bigint(20) NOT NULL,
  `referencias_comerciales_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `codeudor_referencias_comerciales`
--

INSERT INTO `codeudor_referencias_comerciales` (`codeudor_id`, `referencias_comerciales_id`) VALUES
(1, 2),
(2, 4),
(3, 6),
(4, 8),
(5, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `codeudor_referencias_personales`
--

CREATE TABLE `codeudor_referencias_personales` (
  `codeudor_id` bigint(20) NOT NULL,
  `referencias_personales_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `codeudor_referencias_personales`
--

INSERT INTO `codeudor_referencias_personales` (`codeudor_id`, `referencias_personales_id`) VALUES
(1, 2),
(2, 4),
(3, 6),
(4, 8),
(5, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `data_credito`
--

CREATE TABLE `data_credito` (
  `id` bigint(20) NOT NULL,
  `autorizacion` bit(1) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `data_credito`
--

INSERT INTO `data_credito` (`id`, `autorizacion`, `fecha`) VALUES
(1, b'1', '2022-09-26 16:46:33'),
(2, b'1', '2022-10-01 17:14:24'),
(3, b'1', '2022-10-03 13:33:35'),
(4, b'1', '2022-10-03 13:50:22'),
(5, b'1', '2022-10-03 17:00:48');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_personales`
--

CREATE TABLE `datos_personales` (
  `id` bigint(20) NOT NULL,
  `autorizacion` bit(1) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datos_personales`
--

INSERT INTO `datos_personales` (`id`, `autorizacion`, `fecha`) VALUES
(1, b'1', '2022-09-26 16:46:33'),
(2, b'1', '2022-10-01 17:14:24'),
(3, b'1', '2022-10-03 13:33:35'),
(4, b'1', '2022-10-03 13:50:22'),
(5, b'1', '2022-10-03 17:00:48');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documentos`
--

CREATE TABLE `documentos` (
  `id` bigint(20) NOT NULL,
  `data_credito_id` bigint(20) DEFAULT NULL,
  `datos_personales_id` bigint(20) DEFAULT NULL,
  `foto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `documentos`
--

INSERT INTO `documentos` (`id`, `data_credito_id`, `datos_personales_id`, `foto_id`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 2),
(3, 3, 3, 3),
(4, 4, 4, 4),
(5, 5, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `foto`
--

CREATE TABLE `foto` (
  `id` bigint(20) NOT NULL,
  `foto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `foto`
--

INSERT INTO `foto` (`id`, `foto`) VALUES
(1, 'file_1664228793171.png'),
(2, 'file_1664662464446.png'),
(3, 'file_1664822015465.png'),
(4, 'file_1664823022908.png'),
(5, 'file_1664834448563.jpeg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencias_comerciales`
--

CREATE TABLE `referencias_comerciales` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `referencia` varchar(255) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `referencias_comerciales`
--

INSERT INTO `referencias_comerciales` (`id`, `nombre`, `referencia`, `telefono`) VALUES
(1, 'javier hernandez', 'fasdfadsfa', '3134916425'),
(2, 'javier hernandez', 'fdasvdfds', '3134916425'),
(3, 'fdasfdasdf', NULL, '423432342'),
(4, 'ddfsafda', NULL, '423342234'),
(5, 'duvan', NULL, '3134916425'),
(6, 'javier hernandez', NULL, '342432342'),
(7, 'fasdfasdf', 'fdasfafds', '32423423'),
(8, '3rdsafadf', 'fadsfadsf', '324432'),
(9, 'duvan', NULL, '467848'),
(10, 'Jdvsshsh', NULL, '615454');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencias_personales`
--

CREATE TABLE `referencias_personales` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `referencia` varchar(255) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `referencias_personales`
--

INSERT INTO `referencias_personales` (`id`, `nombre`, `referencia`, `telefono`) VALUES
(1, 'javier hernandez', 'fdasbffds', '3134916425'),
(2, 'duvan', 'adfeasdf', '3129762334'),
(3, 'javier hernandez', NULL, '432432432'),
(4, 'ejemplo', NULL, '34243234'),
(5, 'fdsafa32', NULL, '4432423'),
(6, 'adfadsf43', NULL, '242423'),
(7, 'dsfads', 'fadsfasdf', '324234234'),
(8, 'fdsafasdf', 'fdasfasdf', '324234'),
(9, 'Jssvshs', NULL, '494948'),
(10, 'Jdvabsv', NULL, '649484');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(1, 'ROL_ADMIN'),
(2, 'ROL_ANALISTA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud_credito`
--

CREATE TABLE `solicitud_credito` (
  `id` bigint(20) NOT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `codeudor_id` bigint(20) DEFAULT NULL,
  `documentos_id` bigint(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `analisis_credito_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `solicitud_credito`
--

INSERT INTO `solicitud_credito` (`id`, `cliente_id`, `codeudor_id`, `documentos_id`, `estado`, `fecha`, `analisis_credito_id`) VALUES
(1, 1, 1, 1, 'pre-aprobado', '2022-10-01 11:12:27', 1),
(2, 2, 2, 2, 'EN ESTUDIO', '2022-10-01 17:14:24', NULL),
(3, 3, 3, 3, 'EN ESTUDIO', '2022-10-03 13:33:35', NULL),
(4, 4, 4, 4, 'datos-incompletos', '2022-10-03 15:49:20', 2),
(5, 5, 5, 5, 'EN ESTUDIO', '2022-10-03 17:00:48', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud_credito_ventas`
--

CREATE TABLE `solicitud_credito_ventas` (
  `solicitud_credito_id` bigint(20) NOT NULL,
  `ventas_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `solicitud_credito_ventas`
--

INSERT INTO `solicitud_credito_ventas` (`solicitud_credito_id`, `ventas_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `apellido`, `email`, `nombre`, `password`, `username`) VALUES
(1, 'diaz', 'dudicodiaz@gmail.com', 'duvan', '$2a$10$SbGGed0k.MwBkfB2qc0wI..Ge3mIt/aWvdXcFKZyftvLdjKa23NcC', 'dudico'),
(2, 'claudia', 'claudia@gmail.com', 'claudia', '$2a$10$J44qX.nb1sMnWXE1/QyIu.E5yXUccQYJj//NEpEPY2B.uHJF5HTAa', 'claudia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_roles`
--

CREATE TABLE `usuario_roles` (
  `usuario_id` bigint(20) NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_roles`
--

INSERT INTO `usuario_roles` (`usuario_id`, `rol_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id` bigint(20) NOT NULL,
  `cuotas` int(11) NOT NULL,
  `pago_inicial` float NOT NULL,
  `producto` varchar(100) DEFAULT NULL,
  `referencia` varchar(50) DEFAULT NULL,
  `valor_producto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id`, `cuotas`, `pago_inicial`, `producto`, `referencia`, `valor_producto`) VALUES
(1, 12, 0, 'lavadora', 'HM6011GWAI0', 12231300000),
(2, 5, 0, 'Nevera', 'HM6011GWAI0', 124234000),
(3, 12, 0, 'Nevera', 'HM6011GWAI0', 312313000),
(4, 21, 0, 'lavadora', 'HM6011GWAI0', 1234210000),
(5, 12, 0, 'Lavadora', 'Haywejzbwh28', 1000000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `analisis_credito`
--
ALTER TABLE `analisis_credito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcru3rkx7i9fhpiqo5clmxf81i` (`usuario_id`);

--
-- Indices de la tabla `archivo`
--
ALTER TABLE `archivo`
  ADD PRIMARY KEY (`id_archivo`),
  ADD UNIQUE KEY `UKb3veq5n06wphtppm7k2un31i3` (`nombre`);

--
-- Indices de la tabla `cedula_ciudadania_cliente`
--
ALTER TABLE `cedula_ciudadania_cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cedula_ciudadania_codeudor`
--
ALTER TABLE `cedula_ciudadania_codeudor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKuwe8bkgdkanpp68iq51fd5wq` (`cedula_id`);

--
-- Indices de la tabla `cliente_referencias_comerciales`
--
ALTER TABLE `cliente_referencias_comerciales`
  ADD KEY `FKpavnmn9mvgn8nptp9pjke4xp0` (`referencias_comerciales_id`),
  ADD KEY `FK5wrg3vpw9rybytlhr2fk2aylr` (`cliente_id`);

--
-- Indices de la tabla `cliente_referencias_personales`
--
ALTER TABLE `cliente_referencias_personales`
  ADD KEY `FKscbbdhdingu4rx7lyqwaepphm` (`referencias_personales_id`),
  ADD KEY `FKc7hcs94wp27ufq0wc4kstm8tl` (`cliente_id`);

--
-- Indices de la tabla `codeudor`
--
ALTER TABLE `codeudor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK125ibsonon1568yoxwqsvjcqb` (`cedula_id`);

--
-- Indices de la tabla `codeudor_referencias_comerciales`
--
ALTER TABLE `codeudor_referencias_comerciales`
  ADD PRIMARY KEY (`codeudor_id`,`referencias_comerciales_id`),
  ADD KEY `FKc9qg5ukfml54p3aqgrrv8qx2d` (`referencias_comerciales_id`);

--
-- Indices de la tabla `codeudor_referencias_personales`
--
ALTER TABLE `codeudor_referencias_personales`
  ADD PRIMARY KEY (`codeudor_id`,`referencias_personales_id`),
  ADD KEY `FK73lui637gto0sg29unofs5b66` (`referencias_personales_id`);

--
-- Indices de la tabla `data_credito`
--
ALTER TABLE `data_credito`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `datos_personales`
--
ALTER TABLE `datos_personales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `documentos`
--
ALTER TABLE `documentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrsy9i3os71tv2s0goiuqtd1rw` (`data_credito_id`),
  ADD KEY `FKa6oycg2vrmyucp76wow27ioah` (`datos_personales_id`),
  ADD KEY `FKlkh1potsq90vkjcx06d6uxw3m` (`foto_id`);

--
-- Indices de la tabla `foto`
--
ALTER TABLE `foto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `referencias_comerciales`
--
ALTER TABLE `referencias_comerciales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `referencias_personales`
--
ALTER TABLE `referencias_personales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `solicitud_credito`
--
ALTER TABLE `solicitud_credito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1gvft11dkm8ragueh344m7b8b` (`cliente_id`),
  ADD KEY `FKnn551q4dj0nfco90parxoni6g` (`codeudor_id`),
  ADD KEY `FK3g3qrrltspkscrci4nulel5wr` (`documentos_id`),
  ADD KEY `FKk6c06pept0dq6og46ugj1wm86` (`analisis_credito_id`);

--
-- Indices de la tabla `solicitud_credito_ventas`
--
ALTER TABLE `solicitud_credito_ventas`
  ADD KEY `FKan9nyiwj8nq09mmchedyvwdit` (`ventas_id`),
  ADD KEY `FK7phmc60955e19gt2akdndreww` (`solicitud_credito_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKm2dvbwfge291euvmk6vkkocao` (`username`),
  ADD UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`);

--
-- Indices de la tabla `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD PRIMARY KEY (`usuario_id`,`rol_id`),
  ADD KEY `FKbt9i9yrb9ug88xnh82n9m60pr` (`rol_id`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `analisis_credito`
--
ALTER TABLE `analisis_credito`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cedula_ciudadania_cliente`
--
ALTER TABLE `cedula_ciudadania_cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cedula_ciudadania_codeudor`
--
ALTER TABLE `cedula_ciudadania_codeudor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `codeudor`
--
ALTER TABLE `codeudor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `data_credito`
--
ALTER TABLE `data_credito`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `datos_personales`
--
ALTER TABLE `datos_personales`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `documentos`
--
ALTER TABLE `documentos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `foto`
--
ALTER TABLE `foto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `referencias_comerciales`
--
ALTER TABLE `referencias_comerciales`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `referencias_personales`
--
ALTER TABLE `referencias_personales`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `solicitud_credito`
--
ALTER TABLE `solicitud_credito`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `analisis_credito`
--
ALTER TABLE `analisis_credito`
  ADD CONSTRAINT `FKcru3rkx7i9fhpiqo5clmxf81i` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FKuwe8bkgdkanpp68iq51fd5wq` FOREIGN KEY (`cedula_id`) REFERENCES `cedula_ciudadania_cliente` (`id`);

--
-- Filtros para la tabla `cliente_referencias_comerciales`
--
ALTER TABLE `cliente_referencias_comerciales`
  ADD CONSTRAINT `FK5wrg3vpw9rybytlhr2fk2aylr` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKpavnmn9mvgn8nptp9pjke4xp0` FOREIGN KEY (`referencias_comerciales_id`) REFERENCES `referencias_comerciales` (`id`);

--
-- Filtros para la tabla `cliente_referencias_personales`
--
ALTER TABLE `cliente_referencias_personales`
  ADD CONSTRAINT `FKc7hcs94wp27ufq0wc4kstm8tl` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKscbbdhdingu4rx7lyqwaepphm` FOREIGN KEY (`referencias_personales_id`) REFERENCES `referencias_personales` (`id`);

--
-- Filtros para la tabla `codeudor`
--
ALTER TABLE `codeudor`
  ADD CONSTRAINT `FK125ibsonon1568yoxwqsvjcqb` FOREIGN KEY (`cedula_id`) REFERENCES `cedula_ciudadania_codeudor` (`id`);

--
-- Filtros para la tabla `codeudor_referencias_comerciales`
--
ALTER TABLE `codeudor_referencias_comerciales`
  ADD CONSTRAINT `FKc9qg5ukfml54p3aqgrrv8qx2d` FOREIGN KEY (`referencias_comerciales_id`) REFERENCES `referencias_comerciales` (`id`),
  ADD CONSTRAINT `FKqhqd82u4lin66slmtinir70ax` FOREIGN KEY (`codeudor_id`) REFERENCES `codeudor` (`id`);

--
-- Filtros para la tabla `codeudor_referencias_personales`
--
ALTER TABLE `codeudor_referencias_personales`
  ADD CONSTRAINT `FK73lui637gto0sg29unofs5b66` FOREIGN KEY (`referencias_personales_id`) REFERENCES `referencias_personales` (`id`),
  ADD CONSTRAINT `FKlseyt1mlmjrshrkh5ir8iixhx` FOREIGN KEY (`codeudor_id`) REFERENCES `codeudor` (`id`);

--
-- Filtros para la tabla `documentos`
--
ALTER TABLE `documentos`
  ADD CONSTRAINT `FKa6oycg2vrmyucp76wow27ioah` FOREIGN KEY (`datos_personales_id`) REFERENCES `datos_personales` (`id`),
  ADD CONSTRAINT `FKlkh1potsq90vkjcx06d6uxw3m` FOREIGN KEY (`foto_id`) REFERENCES `foto` (`id`),
  ADD CONSTRAINT `FKrsy9i3os71tv2s0goiuqtd1rw` FOREIGN KEY (`data_credito_id`) REFERENCES `data_credito` (`id`);

--
-- Filtros para la tabla `solicitud_credito`
--
ALTER TABLE `solicitud_credito`
  ADD CONSTRAINT `FK1gvft11dkm8ragueh344m7b8b` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK3g3qrrltspkscrci4nulel5wr` FOREIGN KEY (`documentos_id`) REFERENCES `documentos` (`id`),
  ADD CONSTRAINT `FKk6c06pept0dq6og46ugj1wm86` FOREIGN KEY (`analisis_credito_id`) REFERENCES `analisis_credito` (`id`),
  ADD CONSTRAINT `FKnn551q4dj0nfco90parxoni6g` FOREIGN KEY (`codeudor_id`) REFERENCES `codeudor` (`id`);

--
-- Filtros para la tabla `solicitud_credito_ventas`
--
ALTER TABLE `solicitud_credito_ventas`
  ADD CONSTRAINT `FK7phmc60955e19gt2akdndreww` FOREIGN KEY (`solicitud_credito_id`) REFERENCES `solicitud_credito` (`id`),
  ADD CONSTRAINT `FKan9nyiwj8nq09mmchedyvwdit` FOREIGN KEY (`ventas_id`) REFERENCES `venta` (`id`);

--
-- Filtros para la tabla `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD CONSTRAINT `FKbt9i9yrb9ug88xnh82n9m60pr` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKuu9tea04xb29m2km5lwe46ua` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
