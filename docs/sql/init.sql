CREATE DATABASE IF NOT EXISTS `seed_log`;

USE `seed_log`;

CREATE TABLE IF NOT EXISTS `user_info` (
	`user_id` VARCHAR(20) PRIMARY KEY,
    `password` VARCHAR(255) NOT NULL,
    `nickname` VARCHAR(20) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `phone` VARCHAR(15) NOT NULL,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `last_login_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `status` BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS `user_image` (
	`user_id` VARCHAR(20) PRIMARY KEY,
    `profile_image` VARCHAR(255),
    `background_image` VARCHAR(255),
    FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`)
);

CREATE TABLE IF NOT EXISTS `main_category` (
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS `sub_category` (
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `main_category_id` BIGINT,
    `name` VARCHAR(255),
    FOREIGN KEY (`main_category_id`) REFERENCES `main_category`(`id`)
);

CREATE TABLE IF NOT EXISTS `post` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `user_id` VARCHAR(20) NOT NULL,
    `main_category_id` BIGINT NOT NULL,
    `sub_category_id` BIGINT,
    `title` VARCHAR(255) NOT NULL,
    `content` LONGTEXT,
    `is_deleted` BOOLEAN DEFAULT FALSE,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`),
    FOREIGN KEY (`main_category_id`) REFERENCES `main_category`(`id`),
    FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category`(`id`)
);

CREATE TABLE IF NOT EXISTS `tag` (
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS `post_tag` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
	`post_id` BIGINT NOT NULL,
    `tag_id` BIGINT NOT NULL,
    UNIQUE KEY `unique_post_tag` (`post_id`, `tag_id`),
    FOREIGN KEY (`post_id`) REFERENCES `post`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`tag_id`) REFERENCES `tag`(`id`) ON DELETE CASCADE
);