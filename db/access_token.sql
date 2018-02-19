DROP TABLE IF EXISTS `access_token`;
CREATE TABLE `access_token` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `created_date` DATETIME NULL DEFAULT NULL,
    `updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `updated_date` DATETIME NULL DEFAULT NULL,
    `access_token` VARCHAR(520) NULL DEFAULT NULL COMMENT 'access_token' COLLATE 'utf8mb4_unicode_ci',
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
