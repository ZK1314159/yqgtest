CREATE TABLE `order` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `orderName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `type` int(11) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;