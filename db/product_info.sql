DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `created_date` DATETIME NULL DEFAULT NULL,
    `updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `updated_date` DATETIME NULL DEFAULT NULL,
    `supp_id` INT(11) NOT NULL DEFAULT 0 COMMENT '对应的管理员id，默认为0',
    `openid` VARCHAR(50) NULL DEFAULT NULL COMMENT 'B端小程序微信openid（默认环信id和密码即为openid）' COLLATE 'utf8mb4_unicode_ci',
    `product_name` VARCHAR(30) NULL DEFAULT NULL COMMENT '产品名' COLLATE 'utf8mb4_unicode_ci',
    `product_price` VARCHAR(20) NULL DEFAULT NULL COMMENT '产品价格' COLLATE 'utf8mb4_unicode_ci',
    `product_detail` MEDIUMTEXT COLLATE utf8mb4_unicode_ci COMMENT '产品详情',
    `cover_url` VARCHAR(300) NULL DEFAULT NULL COMMENT '产品封面' COLLATE 'utf8mb4_unicode_ci',
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
