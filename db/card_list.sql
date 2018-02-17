DROP TABLE IF EXISTS `card_list`;
CREATE TABLE `card_list` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `created_date` DATETIME NULL DEFAULT NULL,
    `updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `updated_date` DATETIME NULL DEFAULT NULL,
    `follow_date` DATETIME NULL DEFAULT NULL COMMENT '操作时间',
    `openid` VARCHAR(50) NULL DEFAULT NULL COMMENT '微信openid' COLLATE 'utf8mb4_unicode_ci',
    `sales_id` BIGINT(20) NOT NULL COMMENT '店员id',
    `way` VARCHAR(10) NULL DEFAULT NULL COMMENT '名片来源（扫码/转发）' COLLATE 'utf8mb4_unicode_ci',
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
