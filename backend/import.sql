-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 13-10-2021 a las 11:24:30
-- Versión del servidor: 8.0.26-0ubuntu0.20.04.3
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Common`
--
CREATE DATABASE Common;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employees`
--

CREATE TABLE `employees` (
  `employee_id` int NOT NULL,
  `imageurl` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) NOT NULL,
  `job` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `employees`
--

INSERT INTO `employees` (`employee_id`, `imageurl`, `name`, `job`) VALUES
(4, 'https://images.pexels.com/photos/2726111/pexels-photo-2726111.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'Andrea Martínez', 'Directora de Proyectos'),
(5, 'https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Alberto Gómez', 'Director comercial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `product_id` int NOT NULL,
  `name` varchar(200) NOT NULL,
  `imageurl` varchar(2000) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `price` float NOT NULL,
  `categoria` varchar(500) NOT NULL,
  `subcategoria` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`product_id`, `name`, `imageurl`, `description`, `price`, `categoria`, `subcategoria`) VALUES
(1, 'Cámara Kodak', 'https://images.pexels.com/photos/90946/pexels-photo-90946.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Camara de uso profesional', 625, 'Electrónica', 'Cámaras'),
(3, 'Leche Natural', 'https://images.pexels.com/photos/248412/pexels-photo-248412.jpeg?cs=srgb&dl=pexels-pixabay-248412.jpg&fm=jpg', 'Leche natural directa de la vaca', 3.5, 'Alimentación', 'Lácteos'),
(4, 'Reloj despertador', 'https://images.pexels.com/photos/36351/the-eleventh-hour-disaster-alarm-clock-clock.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'Reloj despertador con diferentes sonidos', 15, 'Electrónica', 'Relojes'),
(5, 'Portátil gaming MSI Intel i9', 'https://assets.mmsrg.com/isr/166325/c1/-/pixelboxx-mss-81304396/fee_786_587_png', 'Laptop gaming MSI de alto rendimiento. Procesador i9, Nvidia gtx 3010Ti ', 1699.9, 'Electrónica', 'Portátiles'),
(6, 'HUAWEI Watch GT2', 'https://img01.huaweifile.com/eu/es/huawei/pms/product/6901443320080/800_800_542DBFA46777EB3A9DF03BBCCAA3C81375B32AC530BECBE8mp.png', 'HUAWEI Watch GT2 Marrón 46mm', 139, 'Electrónica', 'Relojes'),
(7, 'Optimum Nutrition Proteína', 'https://cdn3.bulevip.com/1177873/optimum-nutrition-100-whey-gold-standard-5-lbs-227-kg.jpg', 'Optimum Nutrition Proteína On 100% Whey Gold Standard 5 Lbs (2,27 Kg)', 59.99, 'Alimentación', 'Suplementos'),
(8, 'Mars Mesa Gaming', 'https://thumb.pccomponentes.com/w-530-530/articles/33/335300/1307-mars-gaming-mgd-rgb-mesa-gaming.jpg', 'Mars Gaming MGD RGB Mesa Gaming', 165.9, 'Hogar', 'Periféricos'),
(9, 'APPLE Watch 7', 'https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/MKU83_VW_34FR+watch-41-alum-midnight-nc-7s_VW_34FR_WF_CO?wid=1400&hei=1400&trim=1,0&fmt=p-jpg&qlt=95&.v=1632171038000,1631661171000', 'Apple Watch\r\nCaja de aluminio en color medianoche - Correa deportiva', 429.9, 'Electrónica', 'Relojes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product_tags`
--

CREATE TABLE `product_tags` (
  `product_id` int NOT NULL,
  `tag` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Users`
--

CREATE TABLE `Users` (
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `access` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Users`
--

INSERT INTO `Users` (`email`, `name`, `password`, `access`) VALUES
('ruben@ruben.com', 'Ruben', '1234', 'admin'),
('test2@test.com', 'test2', '1234', 'user');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indices de la tabla `product_tags`
--
ALTER TABLE `product_tags`
  ADD PRIMARY KEY (`product_id`,`tag`);

--
-- Indices de la tabla `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `product_tags`
--
ALTER TABLE `product_tags`
  ADD CONSTRAINT `product_tags_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
