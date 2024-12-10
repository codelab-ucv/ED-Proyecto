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



-- --------------------------------------------------------
    
--
-- Carga los productos de prueba
--
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Arroz Costeño','paqarrozbells.jpeg',25,30);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Azúcar Blanca Bells','paqazucarbells.jpeg',24.5,20);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Aceite de cocina Sao','botdeaceitesao.jpeg',7,15);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Salchicha San Fernando','paqdesalchicha.jpeg',8.5,13);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Frijol Canario Bells','paqdefrijolcanariobells.jpeg',7,15);
INSERT INTO products(name, image, price, stock) VALUES ('Caja de Leche Gloria','cajadelechegloria.jpeg',21.9,30);
INSERT INTO products(name, image, price, stock) VALUES ('Fras. de Mermelada Gloria','frascodemermelada.jpeg',6.6,16);
INSERT INTO products(name, image, price, stock) VALUES ('Fras. de Café Nescafé','frascocafe.jpeg',24.7,19);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Sopa instantánea Marucham','paqdemaruchan.jpeg',4,17);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Galletas Oreo','paqdegalletasoreo.jpeg',16,18);
INSERT INTO products(name, image, price, stock) VALUES ('Lata de Papas Pringles','papaspringles.jpeg',8,13);
INSERT INTO products(name, image, price, stock) VALUES ('Bolsa de Pan Bimbo','bolsadepanbimbo.jpeg',10.5,16);
INSERT INTO products(name, image, price, stock) VALUES ('Pote de Mantequilla Laive','potemantequillalaive.jpeg',13,20);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Yogurt Gloria','botyogurtgloria.jpeg',9.9,20);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Queso Philadelphia','mantequillapiladelhia.jpeg',10,21);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Jugo de frutas Del Valle','botdelvalle.jpeg',7,22);
INSERT INTO products(name, image, price, stock) VALUES ('Agua emb. Cielo','botaguacielo.jpeg',3.7,25);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Detergente en polvo Ariel','detergenteariel.jpeg',10,27);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Pap. Higiénico Suave','paqdepapelsuave.jpeg',25.5,29);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Salsa picante Tabasco','salsapicantetabasco.jpeg',16,27);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Arroz Faraon','paqarrozfaraon.jpeg',23.9,24);
INSERT INTO products(name, image, price, stock) VALUES ('Sazonador Maggi','sazmaggi.jpeg',3,18);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Fideos Bells','paqdefideosbells.jpeg',5,20);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Galletas Morochas','paqgalletasmorochas.jpeg',14,14);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Chocolate Sublime','paqsublime.jpeg',2,13);
INSERT INTO products(name, image, price, stock) VALUES ('Caja de Cereal Cochapic','cajcerealchocapic.jpeg',22,25);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Salsa de Soya Kikko','botsoyakikko.jpeg',4.2,24);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Leche Laive','lechelaive.jpeg',27.5,25);
INSERT INTO products(name, image, price, stock) VALUES ('Doypack Mostaza B&D','mostazaB&D.jpeg',9,20);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Sal Marina Emsal','paqsalmarina.jpeg',4,26);
INSERT INTO products(name, image, price, stock) VALUES ('Sazonador Ají-No-Mo-To','sazajinomoto.jpeg',3,25);
INSERT INTO products(name, image, price, stock) VALUES ('Pote de Mermelada Gloria','mermeladagloria.jpeg',5.9,28);
INSERT INTO products(name, image, price, stock) VALUES ('Doypack Salsa de tomate Pomarola','pomarola.jpeg',4,24);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Vinagre Blanco Venturo','vinagreventuro.jpeg',6.9,24);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Gaseosa Inca Kola','incakola.jpeg',3,25);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Arveja partida Costeño','alberjacosteño.jpeg',6.7,26);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Lentejas Costeño','paqlentejascosteño.jpeg',8.9,22);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Quinua Bells','quinuabells.jpeg',7,22);
INSERT INTO products(name, image, price, stock) VALUES ('Caja de Cereal Zucosos','cerealzucosos.jpeg',22.5,21);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Avena Quaker','avenaquaker.jpeg',11.9,23);
INSERT INTO products(name, image, price, stock) VALUES ('Lata de Cebada Instantánea Ecco','cebadaecco.jpeg',10.9,24);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Arándanos El Frutero','arandanos.jpeg',21.9,28);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Espinaca Bells','espinacas.jpeg',5.5,29);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Rábanos Bells','rabanos.jpeg',4.9,28);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Tomate Bells','tomates.jpeg',6.5,29);
INSERT INTO products(name, image, price, stock) VALUES ('Caja de Frugos de Durazno Del Valle','cajadefrugosdurazno.jpeg',8.9,27);
INSERT INTO products(name, image, price, stock) VALUES ('Caja de Frugos de Maracuyá Gloria','frugosmaracuya.jpeg',7.9,23);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Refresco Tampico','tampico.jpeg',7,23);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Refresco Cifrut','botcifrus.jpeg',8,27);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Aceite Primor','aceiteprimor.jpeg',9.5,26);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Azúcar Rubia Bells','azucarrubiabells.jpeg',20.5,27);
INSERT INTO products(name, image, price, stock) VALUES ('Pote de Stevia en polvo Bells','stevia.jpeg',18.2,29);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Wafer Cua Cua','wafercuacua.jpeg',4.2,26);
INSERT INTO products(name, image, price, stock) VALUES ('Bot. de Aceite Cocinero','aceitecocinero.jpeg',8,25);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Wafer Nik','wafernik.jpeg',3.5,24);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Galleta Chips Ahoy!','galletaschips.jpeg',7.1,23);
INSERT INTO products(name, image, price, stock) VALUES ('Paq. de Galleta Tentación','galletastentacion.jpeg',6.1,20);

-- --------------------------------------------------------
    
--
-- Carga los clientes de prueba
--

INSERT INTO `clients`(`dni`, `name`, `email`) VALUES ('60826128','Pedro Alejandro Lucas Avendaño','pelucasavu01@ucvvirtual.edu.pe');
INSERT INTO `clients`(`dni`, `name`, `email`) VALUES ('75809068','Roberto Sebastian Aguayo Grandez','robertsag30@gmail.com');
INSERT INTO `clients`(`dni`, `name`, `email`) VALUES ('74779738','Madgen Adrian Del Castillo Choqque','madgen.delcastillo@gmail.com');

COMMIT;