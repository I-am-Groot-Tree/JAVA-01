-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `user_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户编号',
  `order_no` varchar(50) NOT NULL DEFAULT '' COMMENT '订单编号',
  `order_status` tinyint(4) NOT NULL DEFAULT '' COMMENT '订单状态',
  `product_count` int(10) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `product_price` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '商品单价',
  `pay_channel` varchar(50) NOT NULL DEFAULT '' COMMENT '支付渠道',
  `pay_no` varchar(50) NOT NULL DEFAULT '' COMMENT '支付订单号',
  `total_amount` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '订单总金额',
  `address` varchar(1000) NOT NULL DEFAULT '' COMMENT '收货地址',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标记0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_or_on`(`order_no`) USING BTREE,
  INDEX `idx_or_ui`(`user_id`) USING BTREE,
  INDEX `idx_or_pn`(`pay_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单信息表' ROW_FORMAT = Compact;

