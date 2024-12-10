SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "-05:00";

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clients` (
  `dni` varchar(20) PRIMARY KEY,
  `name` text NOT NULL,
  `email` varchar(256) NOT NULL,
  `phone` varchar(9) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `products` (
  `id` int(8) PRIMARY KEY AUTO_INCREMENT,
  `name` text NOT NULL,
  `image` text,
  `price` decimal(10,2) NOT NULL,
  `stock` int(8) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenes`
--

CREATE TABLE `orders` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `client_id` varchar(20) NOT NULL,
  `date` timestamp DEFAULT current_timestamp(),
  `total` decimal(10,2) NOT NULL,
  `status` varchar(8),
  FOREIGN KEY (`client_id`) REFERENCES `clients` (`dni`)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_orden`
--

CREATE TABLE `order_details` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `product_id` int(8) NOT NULL,
  `quantity` int(8) NOT NULL,
  `unit_price` decimal(10,2) NOT NULL,
  FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
);

-- --------------------------------------------------------
    
--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `products`
  MODIFY `id` int(8) AUTO_INCREMENT, AUTO_INCREMENT=10000000;

COMMIT;