/*
 Navicat Premium Data Transfer

 Source Server         : 自己的数据库
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : consultation_by_category

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 03/02/2020 10:00:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aircos_activity
-- ----------------------------
DROP TABLE IF EXISTS `aircos_activity`;
CREATE TABLE `aircos_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `seq` int(3) DEFAULT NULL COMMENT '排序',
  `create_id` int(11) DEFAULT NULL COMMENT '创建者ID',
  `use` tinyint(1) DEFAULT '1' COMMENT '是否启用 0 启用 1 不启用',
  `show_name` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示名称 0 显示 1 不显示',
  `rel_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '轮播图关联地址',
  `name` varchar(32) DEFAULT NULL COMMENT '活动名称',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='首页轮播图';

-- ----------------------------
-- Records of aircos_activity
-- ----------------------------
BEGIN;
INSERT INTO `aircos_activity` VALUES (1, 1, 5, 1, 1, '广告A跳转地址', '广告A', '广告A图片地址', '2020-02-02 16:34:16', '2020-02-02 16:34:16');
INSERT INTO `aircos_activity` VALUES (2, 2, 5, 1, 1, '广告B跳转地址', '广告B', '广告B跳转地址', '2020-02-02 16:34:59', '2020-02-02 16:34:59');
INSERT INTO `aircos_activity` VALUES (4, 3, 5, 1, 1, '广告C的关联地址', '广告C', '广告C的图片地址', '2020-02-02 17:18:10', '2020-02-02 17:18:10');
INSERT INTO `aircos_activity` VALUES (5, 6, 5, 1, 1, '广告D的关联地址', '广告D', '广告D的图片地址', '2020-02-02 17:18:38', '2020-02-02 17:18:38');
COMMIT;

-- ----------------------------
-- Table structure for aircos_answer
-- ----------------------------
DROP TABLE IF EXISTS `aircos_answer`;
CREATE TABLE `aircos_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `answer` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答案',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='答案表';

-- ----------------------------
-- Records of aircos_answer
-- ----------------------------
BEGIN;
INSERT INTO `aircos_answer` VALUES (1, 'ABA', '2020-01-28 11:09:58', '2020-01-28 11:09:58');
INSERT INTO `aircos_answer` VALUES (2, 'ABB', '2020-01-28 14:41:21', '2020-01-28 14:41:21');
COMMIT;

-- ----------------------------
-- Table structure for aircos_category
-- ----------------------------
DROP TABLE IF EXISTS `aircos_category`;
CREATE TABLE `aircos_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `level` int(1) DEFAULT NULL COMMENT '品类分级',
  `create_uid` int(11) NOT NULL COMMENT '创建者用户ID',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否删除 0：已删除 1：未删除',
  `category_name` varchar(64) NOT NULL COMMENT '分类名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='专业分类表';

-- ----------------------------
-- Records of aircos_category
-- ----------------------------
BEGIN;
INSERT INTO `aircos_category` VALUES (1, NULL, 1, 5, 1, '医药卫生大类', '2020-02-02 18:12:20', '2020-02-02 18:12:20');
INSERT INTO `aircos_category` VALUES (2, 1, 2, 5, 1, '健康管理与促进类', '2020-02-02 18:16:11', '2020-02-02 18:16:11');
INSERT INTO `aircos_category` VALUES (3, 2, 3, 5, 1, '中医养生保健', '2020-02-02 18:17:13', '2020-02-02 20:41:00');
INSERT INTO `aircos_category` VALUES (4, NULL, 1, 5, 1, '公安与司法大类', '2020-02-02 19:17:08', '2020-02-02 19:17:08');
INSERT INTO `aircos_category` VALUES (5, 4, 2, 5, 0, '公安司法二类', '2020-02-02 19:18:31', '2020-02-02 20:48:35');
INSERT INTO `aircos_category` VALUES (6, 2, 3, 5, 1, '医药健康', '2020-02-02 20:41:57', '2020-02-02 20:41:57');
COMMIT;

-- ----------------------------
-- Table structure for aircos_headline
-- ----------------------------
DROP TABLE IF EXISTS `aircos_headline`;
CREATE TABLE `aircos_headline` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_uid` int(11) NOT NULL COMMENT '创建用户ID',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `picture_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `body` longtext NOT NULL COMMENT '正文',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招聘头条';

-- ----------------------------
-- Table structure for aircos_profession
-- ----------------------------
DROP TABLE IF EXISTS `aircos_profession`;
CREATE TABLE `aircos_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_uid` int(11) NOT NULL COMMENT '创建用户主键',
  `name` varchar(32) NOT NULL COMMENT '专业名称',
  `need` varchar(255) DEFAULT NULL COMMENT '特殊要求',
  `scale_as` varchar(32) DEFAULT NULL COMMENT '比例 左文右理 使用“:”分割 ',
  `scale_sex` varchar(32) DEFAULT NULL COMMENT '比例 左男右女 使用“:”分割 ',
  `work_detail` longtext COMMENT '对口职业',
  `profession_detail` longtext COMMENT '专业介绍',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='专业表';

-- ----------------------------
-- Records of aircos_profession
-- ----------------------------
BEGIN;
INSERT INTO `aircos_profession` VALUES (1, 5, '计算机专业', '特殊要求：计算机专业', '6:4', '8:2', '计算机专业的就业方向主要有管理岗位、技术岗位、科研测试与研发研究岗位、销售及服务类岗位等。计算机专业毕业可以做工程师，可以考研、考公务员，还可以做项目经理或项目主管等', '本专业是计算机硬件与软件相结合、面向系统、侧重应用的宽口径专业。通过基础教学与专业训练，培养基础知识扎实、知识面宽、工程实践能力强，具有开拓创新意识，在计算机科学与技术领域从事科学研究、教育、开发和应用的高级人才。计算机学科的特色主要体现在：理论性强，实践性强，发展迅速按一级学科培养基础扎实的宽口径人才，体现在重视数学、逻辑、数据结构、算法、电子设计、计算机体系结构和系统软件等方面的理论基础和专业技术基础，前两年半注重自然科学基础课程和专业基础课程，拓宽面向。后一年半主要是专业课程的设置，增加可选性、多样性、灵活性和方向性，突出学科方向特色，体现最新技术发展动向。', '2020-01-27 13:51:43', '2020-02-03 00:24:10');
INSERT INTO `aircos_profession` VALUES (2, 5, '会计专业', '特殊要求：会计专业', '5:5', '5:5', '会计学专业就业方向主要在各大企业、银行、酒店、学校等财务部门从事税收、公司会计、管理会计、财务管理、破产清算、法务会计、预算制定、商业咨询等工作。', '会计专业是研究企业在一定的营业周期内如何确认收入和资产的学问,培养较高水平从事会计及相关工作的应用型专门人才,其目的是以更加开放、灵活的教育形式培养相关行业的应用型专门人才。', '2020-01-27 13:51:52', '2020-02-03 00:24:15');
INSERT INTO `aircos_profession` VALUES (3, 5, '海洋学专业', '特殊要求：海洋学专业', '5:5', '5:5', '海洋科学主要有前景的就业方向有：海洋环境保护方向、物理学科研方向、渔业方向。', '海洋科学专业培养具备海洋科学的基本理论、基础知识和基本技能，能在海洋科学及相关领域从事科研、教学、管理及技术工作的高级专门人才。\n\n海洋科学专业培养具备海洋科学的基本理论、基础知识和基本技能，能在海洋科学及相关领域从事科研、教学、管理及技术工作的高级专门人才。\n\n海洋科学专业培养具备海洋科学的基本理论、基础知识和基本技能，能在海洋科学及相关领域从事科研、教学、管理及技术工作的高级专门人才。', '2020-01-27 13:51:58', '2020-02-03 00:24:21');
INSERT INTO `aircos_profession` VALUES (4, 5, '数学专业', '特殊要求：数学专业', '2:8', '8:2', '数学与应用数学专业属于基础学科专业，毕业生未来的就业范围还是比较广的，在当前信息化、网络化的时代背景下，该专业也有较好的发展前景。', '数学源自于古希腊语，是研究数量、结构、变化以及空间模型等概念的一门学科。透过抽象化和逻辑推理的使用，由计数、计算、量度和对物体形状及运动的观察中产生。数学的基本要素是：逻辑和直观、分析和推理、共性和个性。', '2020-01-27 13:52:17', '2020-02-03 00:24:26');
COMMIT;

-- ----------------------------
-- Table structure for aircos_school
-- ----------------------------
DROP TABLE IF EXISTS `aircos_school`;
CREATE TABLE `aircos_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `source_min` int(3) NOT NULL COMMENT '最低录取分数',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校名称',
  `school_address` varchar(64) DEFAULT NULL COMMENT '学校地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='院校表';

-- ----------------------------
-- Records of aircos_school
-- ----------------------------
BEGIN;
INSERT INTO `aircos_school` VALUES (1, 300, '复旦大学', '上海市杨浦区邯郸路220号', '2020-01-27 13:50:29', '2020-02-03 00:09:15');
INSERT INTO `aircos_school` VALUES (2, 400, '同济大学', '上海市杨浦区四平路1239号', '2020-01-27 13:50:48', '2020-02-03 00:09:29');
INSERT INTO `aircos_school` VALUES (3, 500, '清华大学', '北京市海淀区双清路30号', '2020-01-27 13:50:54', '2020-02-03 00:09:42');
INSERT INTO `aircos_school` VALUES (4, 600, '贵州大学', '贵阳市花溪区花溪大道南段2708号', '2020-01-27 13:51:01', '2020-02-03 00:09:43');
INSERT INTO `aircos_school` VALUES (5, 700, '北京大学', '北京市海淀区颐和园路5号', '2020-01-27 13:51:09', '2020-02-03 00:10:03');
COMMIT;

-- ----------------------------
-- Table structure for aircos_train
-- ----------------------------
DROP TABLE IF EXISTS `aircos_train`;
CREATE TABLE `aircos_train` (
  `id` int(11) NOT NULL COMMENT '主键',
  `apply_status` int(2) NOT NULL COMMENT '报名状态 0-未开始 1-进行中 2-已结束',
  `profession_id` int(11) DEFAULT NULL COMMENT 'aircos_profession表主键',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除表示 0:未删除；1:删除 ',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `label` varchar(64) DEFAULT NULL COMMENT '标签',
  `product_id` varchar(64) NOT NULL COMMENT '商品编码',
  `area_name` varchar(32) NOT NULL COMMENT '地区名称',
  `picture_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `start_time` datetime NOT NULL COMMENT '开始报名时间',
  `end_time` datetime NOT NULL COMMENT '结束报名时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训信息表';

-- ----------------------------
-- Records of aircos_train
-- ----------------------------
BEGIN;
INSERT INTO `aircos_train` VALUES (1, 1, 1, 0, 4000.00, '计算机专业值得你学习，专科名校直通班', '极高通关率|不过包退', '23', '贵州', '图片地址A', '2019-12-30 00:00:00', '2020-01-05 00:00:00', '2020-02-03 00:38:11', '2020-02-03 00:38:11');
COMMIT;

-- ----------------------------
-- Table structure for aircos_user
-- ----------------------------
DROP TABLE IF EXISTS `aircos_user`;
CREATE TABLE `aircos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `study_out` int(1) DEFAULT NULL COMMENT '留学意向 1：有 2：没有3：考虑中',
  `qq_number` int(20) DEFAULT NULL COMMENT 'QQ号',
  `expert_service` int(1) DEFAULT NULL COMMENT '考虑专家服务 1：有考虑 2：没有考虑 3：其他',
  `source_chinese` int(3) DEFAULT NULL COMMENT '语文成绩',
  `source_mathematics` int(3) DEFAULT NULL COMMENT '数学成绩',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nick_name` varchar(32) NOT NULL COMMENT '真实姓名',
  `school_name` varchar(32) NOT NULL COMMENT '就读学校',
  `study_subject` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '就读科目',
  `phone_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of aircos_user
-- ----------------------------
BEGIN;
INSERT INTO `aircos_user` VALUES (5, NULL, NULL, NULL, 200, 400, NULL, '$2a$10$GbuKlVbtALhVWNzkg2asiO8kp4Gox573FQ/E47fmQC/HJDqJCUcPu', '龚国玮', '大方二中', '理科', '15285722820', '2020-01-30 14:36:25', '2020-01-30 14:49:38');
COMMIT;

-- ----------------------------
-- Table structure for log_profession
-- ----------------------------
DROP TABLE IF EXISTS `log_profession`;
CREATE TABLE `log_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `param` varchar(64) DEFAULT NULL COMMENT '请求参数',
  `time` varchar(64) DEFAULT NULL COMMENT '请求耗时',
  `method` varchar(64) DEFAULT NULL COMMENT '方法名',
  `request_ip` varchar(64) DEFAULT NULL COMMENT '请求IP',
  `description` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='日志记录-专业搜索';

-- ----------------------------
-- Records of log_profession
-- ----------------------------
BEGIN;
INSERT INTO `log_profession` VALUES (3, 5, '计算机  1  5', NULL, NULL, '127.0.0.1', '搜索专业信息', '2020-02-03 09:58:17', '2020-02-03 09:58:17');
INSERT INTO `log_profession` VALUES (4, 5, '计算机  1  5', NULL, NULL, '127.0.0.1', '搜索专业信息', '2020-02-03 09:59:29', '2020-02-03 09:59:29');
COMMIT;

-- ----------------------------
-- Table structure for relation_answer_profession
-- ----------------------------
DROP TABLE IF EXISTS `relation_answer_profession`;
CREATE TABLE `relation_answer_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `match` int(11) NOT NULL COMMENT '匹配指数',
  `answer_id` int(11) NOT NULL COMMENT 'aircos_answer表主键',
  `profession_id` int(11) NOT NULL COMMENT 'aicos_profession表主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='关系表-答案与专业';

-- ----------------------------
-- Records of relation_answer_profession
-- ----------------------------
BEGIN;
INSERT INTO `relation_answer_profession` VALUES (1, 95, 1, 1, '2020-01-27 13:59:08', '2020-01-27 13:59:08');
INSERT INTO `relation_answer_profession` VALUES (2, 90, 1, 2, '2020-01-27 14:01:26', '2020-01-27 14:01:26');
INSERT INTO `relation_answer_profession` VALUES (3, 85, 1, 3, '2020-01-27 14:02:32', '2020-01-27 14:02:32');
INSERT INTO `relation_answer_profession` VALUES (4, 80, 1, 4, '2020-01-27 14:02:45', '2020-01-27 14:02:45');
INSERT INTO `relation_answer_profession` VALUES (5, 90, 2, 1, '2020-01-27 14:04:27', '2020-01-27 14:04:27');
INSERT INTO `relation_answer_profession` VALUES (6, 90, 2, 2, '2020-01-27 14:04:37', '2020-01-27 14:04:37');
INSERT INTO `relation_answer_profession` VALUES (7, 95, 2, 3, '2020-01-27 14:04:51', '2020-01-27 14:04:51');
INSERT INTO `relation_answer_profession` VALUES (8, 85, 2, 4, '2020-01-27 14:05:02', '2020-01-27 14:05:02');
COMMIT;

-- ----------------------------
-- Table structure for relation_answer_school
-- ----------------------------
DROP TABLE IF EXISTS `relation_answer_school`;
CREATE TABLE `relation_answer_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match` int(3) NOT NULL COMMENT '匹配指数',
  `school_id` int(11) NOT NULL COMMENT 'aircos_school表主键',
  `answer_id` int(11) NOT NULL COMMENT 'aircos_answer表主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='关系表-答案与院校';

-- ----------------------------
-- Records of relation_answer_school
-- ----------------------------
BEGIN;
INSERT INTO `relation_answer_school` VALUES (1, 95, 1, 1, '2020-01-28 14:41:03', '2020-01-28 14:41:03');
INSERT INTO `relation_answer_school` VALUES (2, 90, 2, 1, '2020-01-28 14:41:35', '2020-01-28 14:41:35');
COMMIT;

-- ----------------------------
-- Table structure for relation_school_profession
-- ----------------------------
DROP TABLE IF EXISTS `relation_school_profession`;
CREATE TABLE `relation_school_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `school_id` int(11) NOT NULL COMMENT 'aircos_school表主键',
  `profession_id` int(11) NOT NULL COMMENT 'aircos_profession表主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='关系表-院校与专业';

-- ----------------------------
-- Records of relation_school_profession
-- ----------------------------
BEGIN;
INSERT INTO `relation_school_profession` VALUES (1, 1, 1, '2020-02-02 23:53:10', '2020-02-02 23:53:10');
INSERT INTO `relation_school_profession` VALUES (2, 2, 1, '2020-02-03 00:07:43', '2020-02-03 00:07:43');
COMMIT;

-- ----------------------------
-- Table structure for user_member_log
-- ----------------------------
DROP TABLE IF EXISTS `user_member_log`;
CREATE TABLE `user_member_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `start_time` datetime NOT NULL COMMENT '生效时间',
  `end_time` datetime NOT NULL COMMENT '失效时间',
  `type` varchar(255) DEFAULT NULL COMMENT '充值类型-偏移的月',
  `money` varchar(255) NOT NULL COMMENT '钱 单位分',
  `del_flag` varchar(255) NOT NULL DEFAULT '0' COMMENT '删除标识 0,null不是删除，1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='会员充值记录';

-- ----------------------------
-- Records of user_member_log
-- ----------------------------
BEGIN;
INSERT INTO `user_member_log` VALUES (1, 4, '2020-01-28 17:52:07', '2020-02-28 17:52:07', '1', '30', '1');
INSERT INTO `user_member_log` VALUES (2, 4, '2020-01-28 17:52:07', '2020-03-28 17:52:07', '1', '30', '1');
INSERT INTO `user_member_log` VALUES (3, 4, '2020-01-28 17:52:07', '2020-04-28 17:52:07', '1', '30', '0');
COMMIT;

-- ----------------------------
-- Table structure for user_member_money
-- ----------------------------
DROP TABLE IF EXISTS `user_member_money`;
CREATE TABLE `user_member_money` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `money` int(9) DEFAULT NULL COMMENT '总的充值金额 单位分',
  `is_member` int(1) DEFAULT NULL COMMENT '是否是会员， 0-否，1-是',
  `last_time` datetime DEFAULT NULL COMMENT '最后一次充值的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户会员充值金额';

-- ----------------------------
-- Records of user_member_money
-- ----------------------------
BEGIN;
INSERT INTO `user_member_money` VALUES (4, 90, 1, '2020-01-28 17:58:29');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
