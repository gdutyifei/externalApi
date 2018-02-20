DROP TABLE IF EXISTS `sales_info`;
CREATE TABLE `sales_info` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `created_date` DATETIME NULL DEFAULT NULL,
    `updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `updated_date` DATETIME NULL DEFAULT NULL,
    `supp_id` INT(11) NOT NULL DEFAULT 0 COMMENT '对应的管理员id，默认为0',
    `name` VARCHAR(10) NULL DEFAULT NULL COMMENT '店员名' COLLATE 'utf8mb4_unicode_ci',
    `job` VARCHAR(10) NULL DEFAULT NULL COMMENT '职位' COLLATE 'utf8mb4_unicode_ci',
    `store` VARCHAR(80) NULL DEFAULT NULL COMMENT '门店' COLLATE 'utf8mb4_unicode_ci',
    `tel` VARCHAR(20) NULL DEFAULT NULL COMMENT '手机号码' COLLATE 'utf8mb4_unicode_ci',
    `wechat` VARCHAR(20) NULL DEFAULT NULL COMMENT '微信号' COLLATE 'utf8mb4_unicode_ci',
    `email` VARCHAR(50) NULL DEFAULT NULL COMMENT 'email' COLLATE 'utf8mb4_unicode_ci',
    `location` VARCHAR(50) NULL DEFAULT NULL COMMENT '店址' COLLATE 'utf8mb4_unicode_ci',
    `cover_url` VARCHAR(300) NULL DEFAULT NULL COMMENT '头像url' COLLATE 'utf8mb4_unicode_ci',
    `photos` MEDIUMTEXT COLLATE utf8mb4_unicode_ci COMMENT '图片url（以,隔开）',
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
