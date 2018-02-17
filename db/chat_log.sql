DROP TABLE IF EXISTS `chat_log`;
CREATE TABLE `chat_log` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`msg_id` VARCHAR(80) NULL DEFAULT NULL COMMENT '消息id' COLLATE 'utf8mb4_unicode_ci',
	`created_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
	`created_date` DATETIME NULL DEFAULT NULL,
	`updated_by` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
	`updated_date` DATETIME NULL DEFAULT NULL,
	`chat_date` VARCHAR(10) NULL DEFAULT NULL COMMENT '消息时间' COLLATE 'utf8mb4_unicode_ci',
	`to_openid` VARCHAR(50) NULL DEFAULT NULL COMMENT '发送者openid（环信id）' COLLATE 'utf8mb4_unicode_ci',
	`from_openid` VARCHAR(50) NULL DEFAULT NULL COMMENT '接收者openid（环信id）' COLLATE 'utf8mb4_unicode_ci',
	`content` VARCHAR(500) NULL DEFAULT NULL COMMENT '消息内容' COLLATE 'utf8mb4_unicode_ci',
	`msg_type` VARCHAR(10) NULL DEFAULT NULL COMMENT '消息类型' COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
