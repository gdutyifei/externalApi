DROP TABLE IF EXISTS `chat_log`;
CREATE TABLE `chat_log` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
	`created_date` DATETIME NULL DEFAULT NULL,
	`updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
	`updated_date` DATETIME NULL DEFAULT NULL,
	`from` VARCHAR(50) NULL DEFAULT NULL COMMENT '发送者openid（环信id）' COLLATE 'utf8mb4_unicode_ci',
	`to` VARCHAR(50) NULL DEFAULT NULL COMMENT '接收者openid（环信id）' COLLATE 'utf8mb4_unicode_ci',
	`data` MEDIUMTEXT COLLATE utf8mb4_unicode_ci COMMENT  '消息内容',
	`time` DATETIME NULL DEFAULT NULL,
	`mid` VARCHAR(30) NULL DEFAULT NULL COMMENT '消息id' COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
