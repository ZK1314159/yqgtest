CREATE TABLE `student` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                           `hobby` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;