DROP TABLE IF EXISTS `consult_info`;
CREATE TABLE `consult_info` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `created_date` DATETIME NULL DEFAULT NULL,
    `updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `updated_date` DATETIME NULL DEFAULT NULL,
    `openid` VARCHAR(50) NULL DEFAULT NULL COMMENT '微信openid（默认环信id和密码即为openid）' COLLATE 'utf8mb4_unicode_ci',
    `openid_sales` VARCHAR(50) NULL DEFAULT NULL COMMENT '被询问者的openid' COLLATE 'utf8mb4_unicode_ci',
    `product_id` BIGINT(20) DEFAULT NULL COMMENT '产品id',
    `name` VARCHAR(10) NULL DEFAULT NULL COMMENT '咨询者姓名' COLLATE 'utf8mb4_unicode_ci',
    `telphone` VARCHAR(20) NULL DEFAULT NULL COMMENT '咨询者手机号' COLLATE 'utf8mb4_unicode_ci',
    `content` VARCHAR(200) NULL DEFAULT NULL COMMENT '询问内容' COLLATE 'utf8mb4_unicode_ci',
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
