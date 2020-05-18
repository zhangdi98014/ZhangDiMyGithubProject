CREATE DATABASE IF NOT EXISTS `tdd_sys` default charset utf8 COLLATE utf8_general_ci;

USE `tdd_sys`;
drop TABLE if EXISTS `admin_info`;
CREATE TABLE IF NOT EXISTS `admin_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `pass_word` varchar(255) DEFAULT NULL COMMENT '登录密码',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='管理员';


drop TABLE if EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `pass_word` varchar(255) DEFAULT NULL COMMENT '登录密码',
 `contact_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
 `contact_cel_phone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
 `contact_city` varchar(30) DEFAULT NULL COMMENT '所在城市',
 `detail_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户';


drop TABLE if EXISTS `tz_info`;
CREATE TABLE IF NOT EXISTS `tz_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `pass_word` varchar(255) DEFAULT NULL COMMENT '登录密码',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='团长';


drop TABLE if EXISTS `pro_info`;
CREATE TABLE IF NOT EXISTS `pro_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `pro_img` varchar(200) DEFAULT NULL COMMENT '商品大图',
 `title` varchar(255) DEFAULT NULL COMMENT '商品标题',
 `pro_type_id` int(11) DEFAULT NULL COMMENT '商品类型',
 `pro_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
 `sctock_num` int(11) DEFAULT NULL COMMENT '商品库存',
 `sale_num` int(11) DEFAULT NULL COMMENT '销量',
 `pro_detail` text  COLLATE utf8_bin DEFAULT NULL COMMENT '商品详情',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品';


drop TABLE if EXISTS `pro_type_info`;
CREATE TABLE IF NOT EXISTS `pro_type_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `name` varchar(255) DEFAULT NULL COMMENT '类型名',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品类型';


drop TABLE if EXISTS `tg_info`;
CREATE TABLE IF NOT EXISTS `tg_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `pro_id` int(11) DEFAULT NULL COMMENT '原商品',
 `pro_price` double(10,2) DEFAULT NULL COMMENT '原商品价格',
 `tg_img` varchar(200) DEFAULT NULL COMMENT '团购宣传图',
 `tg_title` varchar(255) DEFAULT NULL COMMENT '团购标题',
 `tg_price` double(10,2) DEFAULT NULL COMMENT '团购价格',
 `tg_num` int(11) DEFAULT NULL COMMENT '团购数量',
 `tg_start_time` varchar(30) DEFAULT NULL COMMENT '团购开始时间',
 `tg_end_time` varchar(30) DEFAULT NULL COMMENT '团购结束时间',
 `tg_status` int(11) DEFAULT NULL COMMENT '团购状态',
 `tz_id` int(11) DEFAULT NULL COMMENT '团长',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='团购活动';


drop TABLE if EXISTS `pro_order_info`;
CREATE TABLE IF NOT EXISTS `pro_order_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `order_no` varchar(255) DEFAULT NULL COMMENT '订单编号',
 `pro_id` int(11) DEFAULT NULL COMMENT '商品id',
 `pro_name` varchar(255) DEFAULT NULL COMMENT '商品名',
 `pro_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
 `num` int(11) DEFAULT NULL COMMENT '购买数量',
 `total_amount` double(10,2) DEFAULT NULL COMMENT '总金额',
 `order_status` int(11) DEFAULT NULL COMMENT '订单状态',
 `train_msg` varchar(255) DEFAULT NULL COMMENT '物流信息',
 `eval_star` int(11) DEFAULT NULL COMMENT '评价星级',
 `eval_detail` varchar(255) DEFAULT NULL COMMENT '评价详情',
 `user_id` int(11) DEFAULT NULL COMMENT '购买用户',
 `contact_name` varchar(255) DEFAULT NULL COMMENT '收货人',
 `contact_tel` varchar(255) DEFAULT NULL COMMENT '联系人电话',
 `contact_city` varchar(30) DEFAULT NULL COMMENT '所在城市',
 `detail_address` varchar(30) DEFAULT NULL COMMENT '详细地址',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='普通商品订单';


drop TABLE if EXISTS `tg_order_info`;
CREATE TABLE IF NOT EXISTS `tg_order_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `order_no` varchar(255) DEFAULT NULL COMMENT '订单编号',
 `tg_id` int(11) DEFAULT NULL COMMENT '团购活动',
 `tg_title` varchar(255) DEFAULT NULL COMMENT '团购标题',
 `tg_price` double(10,2) DEFAULT NULL COMMENT '团购价格',
 `num` int(11) DEFAULT NULL COMMENT '团购数量',
 `total_amount` double(10,2) DEFAULT NULL COMMENT '总金额',
 `tg_order_status` int(11) DEFAULT NULL COMMENT '团购订单状态',
 `train_msg` varchar(255) DEFAULT NULL COMMENT '发货物流',
 `user_id` int(11) DEFAULT NULL COMMENT '购买用户',
 `user_contact_name` varchar(255) DEFAULT NULL COMMENT '收货人',
 `contact_cel` varchar(255) DEFAULT NULL COMMENT '收货人手机号',
 `contact_city` varchar(30) DEFAULT NULL COMMENT '收货人城市',
 `contact_address` varchar(255) DEFAULT NULL COMMENT '收货人地址',
 `tz_id` int(11) DEFAULT NULL COMMENT '团长',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='团购订单';



INSERT INTO `tdd_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('1','admin','123','2020-04-11 10:12:56');
INSERT INTO `tdd_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('2','admin1','123','2020-03-14 03:12:56');
INSERT INTO `tdd_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('3','admin2','123','2020-04-07 06:12:56');
INSERT INTO `tdd_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('4','admin3','123','2020-04-09 10:12:56');
INSERT INTO `tdd_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('5','admin4','123','2020-03-31 10:12:56');
INSERT INTO `tdd_sys`.`user_info` (`id`,`name`,`pass_word`,`contact_name`,`contact_cel_phone`,`contact_city`,`detail_address`,`create_time`)  VALUES('1','user','123','收货人姓名0','收货人电话0','广东 广州','详细地址0','2020-03-28 01:12:56');
INSERT INTO `tdd_sys`.`user_info` (`id`,`name`,`pass_word`,`contact_name`,`contact_cel_phone`,`contact_city`,`detail_address`,`create_time`)  VALUES('2','user1','123','收货人姓名1','收货人电话1','广东 广州','详细地址1','2020-03-19 12:12:56');
INSERT INTO `tdd_sys`.`user_info` (`id`,`name`,`pass_word`,`contact_name`,`contact_cel_phone`,`contact_city`,`detail_address`,`create_time`)  VALUES('3','user2','123','收货人姓名2','收货人电话2','广东 广州','详细地址2','2020-04-01 02:12:56');
INSERT INTO `tdd_sys`.`user_info` (`id`,`name`,`pass_word`,`contact_name`,`contact_cel_phone`,`contact_city`,`detail_address`,`create_time`)  VALUES('4','user3','123','收货人姓名3','收货人电话3','广东 广州','详细地址3','2020-03-14 16:12:56');
INSERT INTO `tdd_sys`.`user_info` (`id`,`name`,`pass_word`,`contact_name`,`contact_cel_phone`,`contact_city`,`detail_address`,`create_time`)  VALUES('5','user4','123','收货人姓名4','收货人电话4','广东 广州','详细地址4','2020-03-14 01:12:56');
INSERT INTO `tdd_sys`.`tz_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('1','tz','123','2020-04-01 01:12:56');
INSERT INTO `tdd_sys`.`tz_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('2','tz1','123','2020-03-31 23:12:56');
INSERT INTO `tdd_sys`.`tz_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('3','tz2','123','2020-03-22 09:12:56');
INSERT INTO `tdd_sys`.`tz_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('4','tz3','123','2020-04-07 15:12:56');
INSERT INTO `tdd_sys`.`tz_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('5','tz4','123','2020-03-18 19:12:56');
INSERT INTO `tdd_sys`.`pro_info` (`id`,`pro_img`,`title`,`pro_type_id`,`pro_price`,`sctock_num`,`sale_num`,`pro_detail`,`create_time`)  VALUES('1','http://122.51.88.71/example_img/example4.jpg','商品标题0','5','75.9','79','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2020-03-24 22:12:56');
INSERT INTO `tdd_sys`.`pro_info` (`id`,`pro_img`,`title`,`pro_type_id`,`pro_price`,`sctock_num`,`sale_num`,`pro_detail`,`create_time`)  VALUES('2','http://122.51.88.71/example_img/example10.jpg','商品标题1','4','57.9','89','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2020-04-06 14:12:56');
INSERT INTO `tdd_sys`.`pro_info` (`id`,`pro_img`,`title`,`pro_type_id`,`pro_price`,`sctock_num`,`sale_num`,`pro_detail`,`create_time`)  VALUES('3','http://122.51.88.71/example_img/example10.jpg','商品标题2','1','6.6','93','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2020-03-23 00:12:56');
INSERT INTO `tdd_sys`.`pro_info` (`id`,`pro_img`,`title`,`pro_type_id`,`pro_price`,`sctock_num`,`sale_num`,`pro_detail`,`create_time`)  VALUES('4','http://122.51.88.71/example_img/example7.jpg','商品标题3','5','58.8','90','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2020-04-10 10:12:56');
INSERT INTO `tdd_sys`.`pro_info` (`id`,`pro_img`,`title`,`pro_type_id`,`pro_price`,`sctock_num`,`sale_num`,`pro_detail`,`create_time`)  VALUES('5','http://122.51.88.71/example_img/example1.jpg','商品标题4','3','86.6','95','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2020-04-10 19:12:56');
INSERT INTO `tdd_sys`.`pro_type_info` (`id`,`name`,`create_time`)  VALUES('1','类型名0','2020-03-14 00:12:56');
INSERT INTO `tdd_sys`.`pro_type_info` (`id`,`name`,`create_time`)  VALUES('2','类型名1','2020-03-29 22:12:56');
INSERT INTO `tdd_sys`.`pro_type_info` (`id`,`name`,`create_time`)  VALUES('3','类型名2','2020-04-02 11:12:56');
INSERT INTO `tdd_sys`.`pro_type_info` (`id`,`name`,`create_time`)  VALUES('4','类型名3','2020-03-27 01:12:56');
INSERT INTO `tdd_sys`.`pro_type_info` (`id`,`name`,`create_time`)  VALUES('5','类型名4','2020-03-20 03:12:56');
INSERT INTO `tdd_sys`.`tg_info` (`id`,`pro_id`,`pro_price`,`tg_img`,`tg_title`,`tg_price`,`tg_num`,`tg_start_time`,`tg_end_time`,`tg_status`,`tz_id`,`create_time`)  VALUES('1','1','75.9','http://122.51.88.71/example_img/example6.jpg','团购标题0','21.6','18','2020-04-07 06:12:57','2020-04-02 05:12:57','4','4','2020-03-14 00:12:56');
INSERT INTO `tdd_sys`.`tg_info` (`id`,`pro_id`,`pro_price`,`tg_img`,`tg_title`,`tg_price`,`tg_num`,`tg_start_time`,`tg_end_time`,`tg_status`,`tz_id`,`create_time`)  VALUES('2','1','75.9','http://122.51.88.71/example_img/example5.jpg','团购标题1','5.6','83','2020-03-19 00:12:57','2020-04-11 02:12:57','4','5','2020-03-17 06:12:57');
INSERT INTO `tdd_sys`.`tg_info` (`id`,`pro_id`,`pro_price`,`tg_img`,`tg_title`,`tg_price`,`tg_num`,`tg_start_time`,`tg_end_time`,`tg_status`,`tz_id`,`create_time`)  VALUES('3','3','6.6','http://122.51.88.71/example_img/example2.jpg','团购标题2','14.4','39','2020-03-23 08:12:57','2020-03-31 08:12:57','4','5','2020-03-22 15:12:57');
INSERT INTO `tdd_sys`.`tg_info` (`id`,`pro_id`,`pro_price`,`tg_img`,`tg_title`,`tg_price`,`tg_num`,`tg_start_time`,`tg_end_time`,`tg_status`,`tz_id`,`create_time`)  VALUES('4','2','57.9','http://122.51.88.71/example_img/example9.jpg','团购标题3','87.2','16','2020-03-22 12:12:57','2020-03-18 17:12:57','6','3','2020-04-11 04:12:57');
INSERT INTO `tdd_sys`.`tg_info` (`id`,`pro_id`,`pro_price`,`tg_img`,`tg_title`,`tg_price`,`tg_num`,`tg_start_time`,`tg_end_time`,`tg_status`,`tz_id`,`create_time`)  VALUES('5','2','57.9','http://122.51.88.71/example_img/example3.jpg','团购标题4','97.7','48','2020-04-08 00:12:57','2020-03-25 23:12:57','4','5','2020-03-19 19:12:57');
INSERT INTO `tdd_sys`.`pro_order_info` (`id`,`order_no`,`pro_id`,`pro_name`,`pro_price`,`num`,`total_amount`,`order_status`,`train_msg`,`eval_star`,`eval_detail`,`user_id`,`contact_name`,`contact_tel`,`contact_city`,`detail_address`,`create_time`)  VALUES('1','20200411121257286530','3','商品标题2','6.6','13','59.8','3','物流信息0','3','评价详情0','4','收货人姓名3','收货人电话3','广东 广州','详细地址3','2020-04-01 12:12:57');
INSERT INTO `tdd_sys`.`pro_order_info` (`id`,`order_no`,`pro_id`,`pro_name`,`pro_price`,`num`,`total_amount`,`order_status`,`train_msg`,`eval_star`,`eval_detail`,`user_id`,`contact_name`,`contact_tel`,`contact_city`,`detail_address`,`create_time`)  VALUES('2','20200411121257606725','1','商品标题0','75.9','51','24.2','2','物流信息1','2','评价详情1','4','收货人姓名3','收货人电话3','广东 广州','详细地址3','2020-04-03 18:12:57');
INSERT INTO `tdd_sys`.`pro_order_info` (`id`,`order_no`,`pro_id`,`pro_name`,`pro_price`,`num`,`total_amount`,`order_status`,`train_msg`,`eval_star`,`eval_detail`,`user_id`,`contact_name`,`contact_tel`,`contact_city`,`detail_address`,`create_time`)  VALUES('3','20200411121257162887','5','商品标题4','86.6','87','30.7','5','物流信息2','1','评价详情2','4','收货人姓名3','收货人电话3','广东 广州','详细地址3','2020-04-02 09:12:57');
INSERT INTO `tdd_sys`.`pro_order_info` (`id`,`order_no`,`pro_id`,`pro_name`,`pro_price`,`num`,`total_amount`,`order_status`,`train_msg`,`eval_star`,`eval_detail`,`user_id`,`contact_name`,`contact_tel`,`contact_city`,`detail_address`,`create_time`)  VALUES('4','20200411121257109148','5','商品标题4','86.6','92','55.0','5','物流信息3','1','评价详情3','3','收货人姓名2','收货人电话2','广东 广州','详细地址2','2020-03-20 01:12:57');
INSERT INTO `tdd_sys`.`pro_order_info` (`id`,`order_no`,`pro_id`,`pro_name`,`pro_price`,`num`,`total_amount`,`order_status`,`train_msg`,`eval_star`,`eval_detail`,`user_id`,`contact_name`,`contact_tel`,`contact_city`,`detail_address`,`create_time`)  VALUES('5','20200411121257840645','2','商品标题1','57.9','34','11.9','4','物流信息4','4','评价详情4','5','收货人姓名4','收货人电话4','广东 广州','详细地址4','2020-03-19 12:12:57');
INSERT INTO `tdd_sys`.`tg_order_info` (`id`,`order_no`,`tg_id`,`tg_title`,`tg_price`,`num`,`total_amount`,`tg_order_status`,`train_msg`,`user_id`,`user_contact_name`,`contact_cel`,`contact_city`,`contact_address`,`tz_id`,`create_time`)  VALUES('1','20200411121257602385','4','团购标题3','87.2','77','35.4','5','发货物流0','5','收货人姓名4','收货人电话4','广东 广州','详细地址4','3','2020-03-16 09:12:57');
INSERT INTO `tdd_sys`.`tg_order_info` (`id`,`order_no`,`tg_id`,`tg_title`,`tg_price`,`num`,`total_amount`,`tg_order_status`,`train_msg`,`user_id`,`user_contact_name`,`contact_cel`,`contact_city`,`contact_address`,`tz_id`,`create_time`)  VALUES('2','20200411121257057205','3','团购标题2','14.4','71','49.2','4','发货物流1','5','收货人姓名4','收货人电话4','广东 广州','详细地址4','5','2020-03-19 19:12:57');
INSERT INTO `tdd_sys`.`tg_order_info` (`id`,`order_no`,`tg_id`,`tg_title`,`tg_price`,`num`,`total_amount`,`tg_order_status`,`train_msg`,`user_id`,`user_contact_name`,`contact_cel`,`contact_city`,`contact_address`,`tz_id`,`create_time`)  VALUES('3','20200411121257226005','5','团购标题4','97.7','91','60.3','1','发货物流2','1','收货人姓名0','收货人电话0','广东 广州','详细地址0','5','2020-03-19 01:12:57');
INSERT INTO `tdd_sys`.`tg_order_info` (`id`,`order_no`,`tg_id`,`tg_title`,`tg_price`,`num`,`total_amount`,`tg_order_status`,`train_msg`,`user_id`,`user_contact_name`,`contact_cel`,`contact_city`,`contact_address`,`tz_id`,`create_time`)  VALUES('4','20200411121257650744','5','团购标题4','97.7','83','11.5','2','发货物流3','5','收货人姓名4','收货人电话4','广东 广州','详细地址4','5','2020-03-30 04:12:57');
INSERT INTO `tdd_sys`.`tg_order_info` (`id`,`order_no`,`tg_id`,`tg_title`,`tg_price`,`num`,`total_amount`,`tg_order_status`,`train_msg`,`user_id`,`user_contact_name`,`contact_cel`,`contact_city`,`contact_address`,`tz_id`,`create_time`)  VALUES('5','20200411121257437447','5','团购标题4','97.7','0','92.2','1','发货物流4','5','收货人姓名4','收货人电话4','广东 广州','详细地址4','5','2020-04-03 10:12:57');