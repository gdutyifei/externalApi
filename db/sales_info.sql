DROP TABLE IF EXISTS `sales_info`;
CREATE TABLE `sales_info` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `created_date` DATETIME NULL DEFAULT NULL,
    `updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `updated_date` DATETIME NULL DEFAULT NULL,
    `name` VARCHAR(10) NULL DEFAULT NULL COMMENT '店员名' COLLATE 'utf8mb4_unicode_ci',
    `job` VARCHAR(10) NULL DEFAULT NULL COMMENT '职位' COLLATE 'utf8mb4_unicode_ci',
    `store` VARCHAR(80) NULL DEFAULT NULL COMMENT '门店' COLLATE 'utf8mb4_unicode_ci',
    `tel` VARCHAR(20) NULL DEFAULT NULL COMMENT '手机号码' COLLATE 'utf8mb4_unicode_ci',
    `wechat` VARCHAR(20) NULL DEFAULT NULL COMMENT '微信号' COLLATE 'utf8mb4_unicode_ci',
    `location` VARCHAR(50) NULL DEFAULT NULL COMMENT '店址' COLLATE 'utf8mb4_unicode_ci',
    `cover_url` VARCHAR(300) NULL DEFAULT NULL COMMENT '头像' COLLATE 'utf8mb4_unicode_ci',
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
