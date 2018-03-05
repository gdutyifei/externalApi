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
    `way` int(11) NULL DEFAULT 0 COMMENT '名片来源（0: 扫码/1: 转发）' COLLATE 'utf8mb4_unicode_ci',
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

ALTER TABLE `card_list` ADD relay_name VARCHAR(10) DEFAULT NULL COMMENT '转发者微信名' COLLATE 'utf8mb4_unicode_ci' ;