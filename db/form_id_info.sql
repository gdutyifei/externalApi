DROP TABLE IF EXISTS `form_id_info`;
CREATE TABLE `form_id_info` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `created_date` DATETIME NULL DEFAULT NULL,
    `updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `updated_date` DATETIME NULL DEFAULT NULL,
    `openid` VARCHAR(50) NULL DEFAULT NULL COMMENT '微信openid（默认环信id和密码即为openid）' COLLATE 'utf8mb4_unicode_ci',
    `form_id` VARCHAR(50) NULL DEFAULT NULL COMMENT 'formId' COLLATE 'utf8mb4_unicode_ci',
    `isused` VARCHAR(10) NULL DEFAULT "N" COMMENT '是否已使用' COLLATE 'utf8mb4_unicode_ci',
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
