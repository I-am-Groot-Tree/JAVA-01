-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `product_id` varchar(50) NOT NULL DEFAULT '' COMMENT '商品编号',
  `brand` varchar(200) NOT NULL DEFAULT '' COMMENT '品牌',
  `category` varchar(200) NOT NULL DEFAULT '' COMMENT '类目',
  `base_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '销售价, 单位元',
  `market_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '吊牌价, 单位元',
  `currency` varchar(3) NOT NULL DEFAULT '' COMMENT '标准货币类型，USD/CNY等，默认CNY',
  `area_output` varchar(200) NOT NULL DEFAULT '' COMMENT '产地',
  `unit` int(11) NOT NULL DEFAULT '0' COMMENT '商品单位',
  `product_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '商品类别;0:普通商品,1:赠品',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标记0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pd_pi`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Compact;

