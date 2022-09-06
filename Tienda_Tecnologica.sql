-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.10.1-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para tienda_tecnologia
CREATE DATABASE IF NOT EXISTS `tienda_tecnologia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tienda_tecnologia`;

-- Volcando estructura para tabla tienda_tecnologia.alquiler
CREATE TABLE IF NOT EXISTS `alquiler` (
  `id_alquiler` int(20) NOT NULL,
  `username` varchar(100) NOT NULL,
  `fecha_servicio` datetime NOT NULL,
  PRIMARY KEY (`id_alquiler`,`username`,`fecha_servicio`) USING BTREE,
  KEY `FK_usuarios` (`username`),
  CONSTRAINT `FK_articulo` FOREIGN KEY (`id_alquiler`) REFERENCES `articulo` (`id_articulo`),
  CONSTRAINT `FK_usuarios` FOREIGN KEY (`username`) REFERENCES `usuarios` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla tienda_tecnologia.alquiler: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_tecnologia.articulo
CREATE TABLE IF NOT EXISTS `articulo` (
  `id_articulo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `servicio` varchar(100) DEFAULT NULL,
  `fecha_adquisicion` datetime DEFAULT NULL,
  PRIMARY KEY (`id_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla tienda_tecnologia.articulo: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` (`id_articulo`, `nombre`, `categoria`, `tipo`, `servicio`, `fecha_adquisicion`) VALUES
	(10, 'Teclado WIFI', 'Perifericos', 'Hardware', 'Contado', '2019-03-10 02:55:05'),
	(11, 'Pantalla', 'Perifericos', 'Hardware', 'Contado', '2022-08-31 02:55:05'),
	(12, 'Windows 11', 'Sistema operativo', 'Software', 'Credito', '2022-07-30 02:55:05'),
	(13, 'Windows 10', 'Sistema operativo', 'Software', 'Contado', '2021-10-08 02:55:05');
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_tecnologia.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `username` varchar(100) NOT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tipo_cliente` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla tienda_tecnologia.usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
