/*
MySQL Data Transfer
Source Host: localhost
Source Database: partymember
Target Host: localhost
Target Database: partymember
Date: 2019/6/26 10:41:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_appendix
-- ----------------------------
CREATE TABLE `t_appendix` (
  `appendixId` char(100) NOT NULL DEFAULT '',
  `appendName` char(100) DEFAULT NULL,
  `appendType` char(100) DEFAULT NULL,
  `appendixAddress` char(100) DEFAULT NULL,
  `operName` char(100) DEFAULT NULL,
  `operTime` datetime DEFAULT NULL,
  `remake1` char(200) DEFAULT NULL,
  `remake2` char(200) DEFAULT NULL,
  PRIMARY KEY (`appendixId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_common
-- ----------------------------
CREATE TABLE `t_common` (
  `id` char(100) NOT NULL DEFAULT '',
  `type` char(50) DEFAULT NULL,
  `typeName` char(200) DEFAULT NULL,
  `valueId` char(200) DEFAULT NULL,
  `valueName` char(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
CREATE TABLE `t_department` (
  `departmentId` char(100) NOT NULL,
  `departmentName` char(255) DEFAULT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_party
-- ----------------------------
CREATE TABLE `t_party` (
  `partyId` char(100) NOT NULL DEFAULT '',
  `partyName` char(255) DEFAULT NULL,
  `partyTime` datetime DEFAULT NULL,
  `partyAdress` char(200) DEFAULT NULL,
  `partyPlayers` text,
  `partyDescribe` longtext,
  `oper` char(50) DEFAULT NULL,
  `operTime` datetime DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `remake1` char(200) DEFAULT NULL,
  `remake2` char(200) DEFAULT NULL,
  PRIMARY KEY (`partyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_party_record
-- ----------------------------
CREATE TABLE `t_party_record` (
  `recordId` char(50) NOT NULL DEFAULT '',
  `recordName` char(200) DEFAULT NULL,
  `partyMemberId` char(50) DEFAULT NULL,
  `partyId` char(50) DEFAULT NULL,
  `picUrl` char(200) DEFAULT NULL,
  `PicIp` char(20) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `remake1` char(50) DEFAULT NULL,
  `remake2` char(50) DEFAULT NULL,
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_partymember_family
-- ----------------------------
CREATE TABLE `t_partymember_family` (
  `familyMemberId` char(100) NOT NULL,
  `partyMemberId` char(100) DEFAULT NULL,
  `relation` char(50) DEFAULT NULL,
  `name` char(100) DEFAULT NULL,
  `zhengZhiMianMao` char(50) DEFAULT NULL,
  `work` char(255) DEFAULT NULL,
  `tel` char(10) DEFAULT NULL,
  `remake1` char(255) DEFAULT NULL,
  `remake2` char(255) DEFAULT NULL,
  PRIMARY KEY (`familyMemberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_partymember_message
-- ----------------------------
CREATE TABLE `t_partymember_message` (
  `parytMemberId` char(100) NOT NULL,
  `name` char(50) DEFAULT NULL,
  `isLeader` char(20) DEFAULT NULL,
  `partyMemberGroup` char(20) DEFAULT NULL,
  `departmentId` char(100) DEFAULT NULL,
  `sex` char(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `ethnicGroup` char(50) DEFAULT NULL,
  `birthPlace` char(200) DEFAULT NULL,
  `Marry` char(10) DEFAULT NULL,
  `education` char(200) DEFAULT NULL,
  `school` char(200) DEFAULT NULL,
  `joinPartyTime` date DEFAULT NULL,
  `realJoinPartyTime` date DEFAULT NULL,
  `partyMemberJob` char(200) DEFAULT NULL,
  `workTime` date DEFAULT NULL,
  `workJob` char(255) DEFAULT NULL,
  `hujiAddress` char(255) DEFAULT NULL,
  `cardNum` char(100) DEFAULT NULL,
  `address` char(255) DEFAULT NULL,
  `tel` char(20) DEFAULT NULL,
  `remarks` char(255) DEFAULT NULL,
  `picUrl` char(255) DEFAULT NULL,
  `remake1` char(255) DEFAULT NULL,
  `remale2` char(255) DEFAULT NULL,
  PRIMARY KEY (`parytMemberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_partymember_score
-- ----------------------------
CREATE TABLE `t_partymember_score` (
  `partMemberscoreId` char(100) NOT NULL DEFAULT '',
  `partymemberId` char(100) DEFAULT NULL,
  `score` char(20) DEFAULT NULL,
  `year` date DEFAULT NULL,
  PRIMARY KEY (`partMemberscoreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_partymember_score_detil
-- ----------------------------
CREATE TABLE `t_partymember_score_detil` (
  `scoreDetilId` char(100) NOT NULL,
  `partymemberId` char(100) DEFAULT NULL,
  `pipId` char(20) DEFAULT NULL,
  `year` date DEFAULT NULL,
  `operator` char(100) DEFAULT NULL,
  `operatorTime` time DEFAULT NULL,
  `remake` char(255) DEFAULT NULL,
  `remake1` char(100) DEFAULT NULL,
  `remake2` char(100) DEFAULT NULL,
  PRIMARY KEY (`scoreDetilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_partymember_score_pip
-- ----------------------------
CREATE TABLE `t_partymember_score_pip` (
  `scoreId` char(100) NOT NULL,
  `isAdd` char(20) DEFAULT NULL,
  `name` char(100) DEFAULT NULL,
  `pip` char(255) DEFAULT NULL,
  `score` char(20) DEFAULT NULL,
  `remake1` char(255) DEFAULT NULL,
  `remake2` char(255) DEFAULT NULL,
  PRIMARY KEY (`scoreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sys_auth
-- ----------------------------
CREATE TABLE `t_sys_auth` (
  `id` varchar(32) NOT NULL,
  `auth_name` varchar(64) NOT NULL COMMENT '权限名称',
  `auth_url` varchar(64) NOT NULL COMMENT '资源路径',
  `auth_permission` varchar(64) NOT NULL COMMENT '权限字符串',
  `auth_type` varchar(1) NOT NULL COMMENT '权限类型\n0：菜单\n1：按钮',
  `auth_status` varchar(1) NOT NULL COMMENT '权限状态\n0：未启用\n1：启用',
  `auth_description` varchar(256) DEFAULT NULL COMMENT '权限描述',
  `auth_parent_id` varchar(32) DEFAULT NULL,
  `auth_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sys_company
-- ----------------------------
CREATE TABLE `t_sys_company` (
  `id` varchar(32) NOT NULL,
  `company_name` varchar(64) NOT NULL,
  `company_phone` varchar(32) DEFAULT NULL,
  `company_description` varchar(256) DEFAULT NULL,
  `company_status` varchar(1) NOT NULL,
  `company_parent_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
CREATE TABLE `t_sys_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(128) NOT NULL COMMENT '角色名称',
  `role_description` varchar(128) DEFAULT NULL COMMENT '角色描述',
  `role_status` varchar(1) NOT NULL COMMENT '状态\n0：未启用\n1：启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sys_role_auth
-- ----------------------------
CREATE TABLE `t_sys_role_auth` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `auth_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sys_role_user
-- ----------------------------
CREATE TABLE `t_sys_role_user` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
CREATE TABLE `t_sys_user` (
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `name` varchar(64) NOT NULL COMMENT '真实姓名',
  `password` varchar(256) NOT NULL COMMENT '用户密码',
  `phone` varchar(22) DEFAULT NULL,
  `salt` varchar(128) NOT NULL COMMENT '加密',
  `user_status` varchar(1) NOT NULL COMMENT '状态\n0：正常',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sys_user_company
-- ----------------------------
CREATE TABLE `t_sys_user_company` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `company_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_appendix` VALUES ('9b40040217f946a5a7b9f7c205433dce', 'libpri.dll', '30', 'http://39.106.34.165/M00/00/2F/rBE2SF0R4JyASk2fAAcQAMB77AQ631.dll', 'admin', '2019-06-25 16:51:46', '456.5kb', null);
INSERT INTO `t_appendix` VALUES ('a2a0e594a99240258304322ac9f04f6b', 'libeay32.dll', '30', 'http://39.106.34.165/M00/00/2F/rBE2SF0R4JyAVX2IAAzgAKRpgSY928.dll', 'admin', '2019-06-25 16:51:46', '832.1kb', null);
INSERT INTO `t_common` VALUES ('1', '01', '活动展示', '001', '党员大会');
INSERT INTO `t_common` VALUES ('10', '01', '活动展示', '010', '专题研讨');
INSERT INTO `t_common` VALUES ('11', '01', '活动展示', '011', '个人自学');
INSERT INTO `t_common` VALUES ('12', '01', '活动展示', '012', '谈心谈话');
INSERT INTO `t_common` VALUES ('13', '01', '活动展示', '013', '思想工作学习等汇报');
INSERT INTO `t_common` VALUES ('14', '01', '活动展示', '014', '其他');
INSERT INTO `t_common` VALUES ('15', '02', '分组', '001', '一组');
INSERT INTO `t_common` VALUES ('16', '02', '分组', '002', '二组');
INSERT INTO `t_common` VALUES ('17', '02', '分组', '003', '三组');
INSERT INTO `t_common` VALUES ('18', '02', '分组', '004', 'admin');
INSERT INTO `t_common` VALUES ('2', '01', '活动展示', '002', '支部委员会');
INSERT INTO `t_common` VALUES ('3', '01', '活动展示', '003', '党小组会');
INSERT INTO `t_common` VALUES ('30', '03', '文件类型', '001', '集团相关文件');
INSERT INTO `t_common` VALUES ('31', '03', '文件类型', '002', '研究院文件');
INSERT INTO `t_common` VALUES ('32', '03', '文件类型', '003', '院文件制度');
INSERT INTO `t_common` VALUES ('33', '03', '文件类型', '004', '党支部文件');
INSERT INTO `t_common` VALUES ('4', '01', '活动展示', '004', '党课');
INSERT INTO `t_common` VALUES ('5', '01', '活动展示', '005', '民主生活会');
INSERT INTO `t_common` VALUES ('6', '01', '活动展示', '006', '组织生活会');
INSERT INTO `t_common` VALUES ('7', '01', '活动展示', '007', '民主评议党员');
INSERT INTO `t_common` VALUES ('8', '01', '活动展示', '008', '主题党日');
INSERT INTO `t_common` VALUES ('9', '01', '活动展示', '009', '集中学习');
INSERT INTO `t_department` VALUES ('1', '智能信息');
INSERT INTO `t_department` VALUES ('10', '造型室');
INSERT INTO `t_department` VALUES ('11', '副院长');
INSERT INTO `t_department` VALUES ('12', '整车工程部');
INSERT INTO `t_department` VALUES ('13', '车身工程部');
INSERT INTO `t_department` VALUES ('14', '综合管理部（项目管理部）');
INSERT INTO `t_department` VALUES ('15', '试验验证中心');
INSERT INTO `t_department` VALUES ('16', '项目管理部');
INSERT INTO `t_department` VALUES ('17', '技术管理部');
INSERT INTO `t_department` VALUES ('18', '试验验证中心');
INSERT INTO `t_department` VALUES ('19', '项目总监');
INSERT INTO `t_department` VALUES ('2', '新能源');
INSERT INTO `t_department` VALUES ('3', '动力底盘部');
INSERT INTO `t_department` VALUES ('4', '院长、党支部书记');
INSERT INTO `t_department` VALUES ('5', '技术总监');
INSERT INTO `t_department` VALUES ('6', '动力底盘部\r\n');
INSERT INTO `t_department` VALUES ('7', '电子电器部');
INSERT INTO `t_department` VALUES ('8', '新能源部');
INSERT INTO `t_department` VALUES ('9', '智能信息部');
INSERT INTO `t_party` VALUES ('42bf26477b2f487c8d7e021a0bb2d598', '123', '2019-06-24 00:00:00', '121222', '185f17fb1483493fada122cd4a4e1d98_1,1c0af12a7dce43f8bd3392f662331468_1,1f0ac9e8c78c4d58afb28d3233916a7e_1,262953cf18344967a9d0e3ad714ee880_1,2f81ae0c669b4e8fa4025bf9e5b44289_1,3347df2672e6400d8d803457921cc2ba_1,3fe733eabfd54f8fa83c586abfa84887_1,88b0dd13c90d496eb8e2e830dd86906b_1,c167e21b506e49bdaafc87c890640177_1,c745a093cf1a414bbba57a89b3e6d9b0_1,cecba33907584798b33fb28be8ab8d35_1,d574596e779f450398238881fd9ea4fd_1,d6b178b615984c92b91ba19836a22deb_1,ed7c56ca484d4437afa5019bc6467d6c_1,ef99de2cb82e4e3384ebcd8908019853_1,36a6684a03dc47cf937f34d0e6a7e847_2,862a40937f6142708bb671bd7b45d0ba_2,8c89e0eec8234a988d84981f73e9078d_2,c841fec4b47f47e28d43f5de930d3858_2,d0c2d8bc7344471597a9617cb3c1617c_2,d2ae7492c5784f86b3d0bc88c107829f_2,db8c31f5ff93433da1d25e232194fe00_2,dd22254f45ed4eb78e38af8a5d938394_2,faf277de33d24195867bab2252f18107_2,ff31f8da7c334643b33550a8278c8275_2,2d51d8dfbe55414cbb4d61798d6a6c38_3,34b965b97884481bbdafc58fedcab0f6_3,637895530c924c95981242fcb181c3c1_3,947a4ba2ecd84978b360127b68fd891d_3,96faf4a6aaa348faba162c980d818fdc_3,9bfbb00e81f14f738a0d50ba4021e702_3,a717b00324504b378d66cd576a1d8afe_3,c32f4d887fa34c949c905d3dca55a425_3,d0cccfb901204e5b9cc7a543303c0c45_3,fedf3473c47f49039b87ff9ac433e2f1_3,', null, 'admin', '2019-06-24 08:44:09', '1', null, null);
INSERT INTO `t_party_record` VALUES ('0ad3fc138ba144da92bcd3a02291f822', '1', 'admin', '42bf26477b2f487c8d7e021a0bb2d598', '/M00/00/2F/rBE2SF0QLhKALfAXAAArNKsHkRw051.png', 'http://39.106.34.165', '2019-06-24 09:57:39', null, null);
INSERT INTO `t_party_record` VALUES ('4d76837a7c9844aa83c0443ea6585f39', '2', 'admin', '42bf26477b2f487c8d7e021a0bb2d598', '/M00/00/2F/rBE2SF0QKfWAVW-rAAArNKsHkRw558.png', 'http://39.106.34.165', '2019-06-24 00:00:00', null, null);
INSERT INTO `t_partymember_message` VALUES ('185f17fb1483493fada122cd4a4e1d98', '彭江', '2', '15', '4', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'c20c3d2ebb4848038515bf074170ccd8', null);
INSERT INTO `t_partymember_message` VALUES ('1c0af12a7dce43f8bd3392f662331468', '赫连晓会', '0', '15', '7', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '260fb0d5792842f49ca699a16a98af45', null);
INSERT INTO `t_partymember_message` VALUES ('1f0ac9e8c78c4d58afb28d3233916a7e', '郭佳', '0', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'c8184d95fc5a45bdb0642319fdac6ccf', null);
INSERT INTO `t_partymember_message` VALUES ('262953cf18344967a9d0e3ad714ee880', '伍建成', '2', '15', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'e76d753045a44b3e8e15aa9238418c27', null);
INSERT INTO `t_partymember_message` VALUES ('2d51d8dfbe55414cbb4d61798d6a6c38', '李英平', '0', '17', '15', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '734a135bf362419082d4225456f2d7e0', null);
INSERT INTO `t_partymember_message` VALUES ('2f81ae0c669b4e8fa4025bf9e5b44289', '张子玉', '0', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '7f30f888f9b04af2b1fac9071f51456f', null);
INSERT INTO `t_partymember_message` VALUES ('3347df2672e6400d8d803457921cc2ba', '李仁元', '0', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'ce475e96fb2f440481fc2fb8cd72c3ae', null);
INSERT INTO `t_partymember_message` VALUES ('34b965b97884481bbdafc58fedcab0f6', '吴渊', '0', '17', '15', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '77c4f32f1a5e4cf1b46c9293c4fc37de', null);
INSERT INTO `t_partymember_message` VALUES ('36a6684a03dc47cf937f34d0e6a7e847', '郭鹏', '0', '16', '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '38606dbc7c564da0b6ff1bbd76b6e551', null);
INSERT INTO `t_partymember_message` VALUES ('3fe733eabfd54f8fa83c586abfa84887', '李冯利', '2', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'e1c604ae6d2b43dd9b5160b1e0045c41', null);
INSERT INTO `t_partymember_message` VALUES ('637895530c924c95981242fcb181c3c1', '崔宇', '0', '17', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89b284b9116b49e7be7e336999eae2b7', null);
INSERT INTO `t_partymember_message` VALUES ('862a40937f6142708bb671bd7b45d0ba', '秦宝忠', '0', '16', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '88904cd6eb154d63a2c69b188d93c678', null);
INSERT INTO `t_partymember_message` VALUES ('88b0dd13c90d496eb8e2e830dd86906b', '翟慎涛', '0', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '773d57d7d1344cb9bad803b082e5eb26', null);
INSERT INTO `t_partymember_message` VALUES ('8c89e0eec8234a988d84981f73e9078d', '吴小燕', '2', '16', '11', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '8763a650f074429f89bbb9a94d7693cb', null);
INSERT INTO `t_partymember_message` VALUES ('947a4ba2ecd84978b360127b68fd891d', '于林涛', '0', '17', '15', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'c66cdd2c79d74009bd9ee1737340de50', null);
INSERT INTO `t_partymember_message` VALUES ('96faf4a6aaa348faba162c980d818fdc', '雷长清', '2', '17', '19', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'b8eb366c631a40099a4add609779ea28', null);
INSERT INTO `t_partymember_message` VALUES ('9bfbb00e81f14f738a0d50ba4021e702', '邱莉', '0', '17', '17', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '7bed5f5aa13d4b7586b7d31acaaeccd6', null);
INSERT INTO `t_partymember_message` VALUES ('a626bfce0c304ced89fae362f989dd8c', 'admin', '2', '18', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '5404de7ea1164dbeafdc3a7f52ebe791', null);
INSERT INTO `t_partymember_message` VALUES ('a717b00324504b378d66cd576a1d8afe', '王少文', '0', '17', '15', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'e329cd9bde7648758c8275915383907a', null);
INSERT INTO `t_partymember_message` VALUES ('c167e21b506e49bdaafc87c890640177', '汪世赓', '0', '15', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '758198e2ed9f4c33ba4554f05ec75649', null);
INSERT INTO `t_partymember_message` VALUES ('c32f4d887fa34c949c905d3dca55a425', '向青青', '0', '17', '17', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '7c2ef747ee2c4c6ab4f3aa362de294f7', null);
INSERT INTO `t_partymember_message` VALUES ('c745a093cf1a414bbba57a89b3e6d9b0', '万学东', '0', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0fa7a867f96c42e38d429d9789c25a08', null);
INSERT INTO `t_partymember_message` VALUES ('c841fec4b47f47e28d43f5de930d3858', '武文杰', '0', '16', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '8ef77aa34cf9473d8a2dee35c7c767a5', null);
INSERT INTO `t_partymember_message` VALUES ('cecba33907584798b33fb28be8ab8d35', '孟焕', '0', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'a2fad702f1534cfa8545c0b9cacf95ed', null);
INSERT INTO `t_partymember_message` VALUES ('d0c2d8bc7344471597a9617cb3c1617c', '郭晓峰', '0', '16', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3c8fdcbb85614ef888df992dadb7e90f', null);
INSERT INTO `t_partymember_message` VALUES ('d0cccfb901204e5b9cc7a543303c0c45', '戈丽敏', '1', '17', '15', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'e76ca717463e4d95aac60c16b14a4bf5', null);
INSERT INTO `t_partymember_message` VALUES ('d2ae7492c5784f86b3d0bc88c107829f', '刘毅', '0', '16', '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4b33815180594e6497d21540a6a46d90', null);
INSERT INTO `t_partymember_message` VALUES ('d574596e779f450398238881fd9ea4fd', '解哲', '0', '15', '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '7cb3566d455e40f1a64fde935a5a19ce', null);
INSERT INTO `t_partymember_message` VALUES ('d6b178b615984c92b91ba19836a22deb', '高凯', '0', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '8d10d6cf38204ab49b74174f2afc407d', null);
INSERT INTO `t_partymember_message` VALUES ('db8c31f5ff93433da1d25e232194fe00', '吕振广', '0', '16', '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '58cc3412bafc4525a22c82e41f73c1ad', null);
INSERT INTO `t_partymember_message` VALUES ('dd22254f45ed4eb78e38af8a5d938394', '徐鹏翱', '0', '16', '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '756f83d5763249758d4d616167d9d432', null);
INSERT INTO `t_partymember_message` VALUES ('ed7c56ca484d4437afa5019bc6467d6c', '张猛', '0', '15', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'b73eef327073491f94e0cefde3bab895', null);
INSERT INTO `t_partymember_message` VALUES ('ef99de2cb82e4e3384ebcd8908019853', '熊健', '0', '15', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '35dfef8aa9b44004b8dac7d8d2796699', null);
INSERT INTO `t_partymember_message` VALUES ('faf277de33d24195867bab2252f18107', '徐勤芳', '1', '16', '10', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '9424c06b7444466c866bfe60a5d9087b', null);
INSERT INTO `t_partymember_message` VALUES ('fedf3473c47f49039b87ff9ac433e2f1', '饶大可', '2', '17', '11', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'c7050304138a4b47a22209a9dec5a6d1', null);
INSERT INTO `t_partymember_message` VALUES ('ff31f8da7c334643b33550a8278c8275', '庄严', '0', '16', '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'bf3b3baaf3854d17874d5d639b362f96', null);
INSERT INTO `t_partymember_score` VALUES ('0bdbc849ca11462b8ab3bae43efc30c2', 'c167e21b506e49bdaafc87c890640177', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('0c7394c43a964272bb9434a913590a89', '34b965b97884481bbdafc58fedcab0f6', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('166654ff7e124c4b99bcd0d95daa204e', 'd0c2d8bc7344471597a9617cb3c1617c', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('1903328130ca45498b416180d9c76f62', '1c0af12a7dce43f8bd3392f662331468', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('1cb030e19023419d8a1753391499f88b', '88b0dd13c90d496eb8e2e830dd86906b', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('26f2411d163a426a9c46c6125aedef7c', '3347df2672e6400d8d803457921cc2ba', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('3993a121145642438e165cfc148150ed', 'ed7c56ca484d4437afa5019bc6467d6c', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('3d002434c0b0436fb5774ac37796a498', '2f81ae0c669b4e8fa4025bf9e5b44289', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('3dfc23d070994369bf65de0ebbb55942', 'a717b00324504b378d66cd576a1d8afe', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('3ebbab7eacf947e3ba23d45713adb795', 'ff31f8da7c334643b33550a8278c8275', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('417db7e3a7a448558facd3d15592c0fe', '862a40937f6142708bb671bd7b45d0ba', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('520ac7040e7f47ae81328b85d11d8778', 'd0cccfb901204e5b9cc7a543303c0c45', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('59764931bcdf4170ba9bff4671ce7c14', 'c841fec4b47f47e28d43f5de930d3858', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('5bb01ac101754a5e8e620080f5c50c99', '36a6684a03dc47cf937f34d0e6a7e847', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('764d2c1e7c5f43f5a613284b6d597e79', 'c32f4d887fa34c949c905d3dca55a425', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('794da7cb85f24cda884a7eb6feccfd30', '2d51d8dfbe55414cbb4d61798d6a6c38', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('80bba2e9eb39493b9c731c6742b01ed8', '947a4ba2ecd84978b360127b68fd891d', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('82b93008d5fb4f5f92de4b2188d748b8', 'd2ae7492c5784f86b3d0bc88c107829f', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('840143f3d56747ce88b5c221cf99dd92', '637895530c924c95981242fcb181c3c1', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('940adbcc092a47ed99ec66a098325eec', '9bfbb00e81f14f738a0d50ba4021e702', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('a8fbd1a0b84f445b9c74ce14d76e310f', 'd574596e779f450398238881fd9ea4fd', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('be81982655f144f289fd50838cb7f044', 'c745a093cf1a414bbba57a89b3e6d9b0', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('c48aa3dc0dc04e9ab4d455624f4e28c9', '1f0ac9e8c78c4d58afb28d3233916a7e', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('d3f80cf09f9f4e468c9bde9f23371df5', 'cecba33907584798b33fb28be8ab8d35', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('dcd91672a5714aa89abc4ba50193d627', 'ef99de2cb82e4e3384ebcd8908019853', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('dd21eab32a574c0e8cb1c263a77a4c4f', 'd6b178b615984c92b91ba19836a22deb', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('ddcd21462b814a319d0b135ce8264f9c', 'dd22254f45ed4eb78e38af8a5d938394', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('e2125c0f9a62487590b24b9c501829b2', 'db8c31f5ff93433da1d25e232194fe00', '100', '2019-01-01');
INSERT INTO `t_partymember_score` VALUES ('e6fc8ee54ae44f12a64ab3d76cccc1cb', 'faf277de33d24195867bab2252f18107', '100', '2019-01-01');
INSERT INTO `t_partymember_score_pip` VALUES ('1', '1', '主动讲党课', '加5分/人次', '5', '5', null);
INSERT INTO `t_partymember_score_pip` VALUES ('10', '0', '党员责任区活动', '未按要求完成扣2分/人次', '5', '2', null);
INSERT INTO `t_partymember_score_pip` VALUES ('11', '0', '党支部安排的其他任务', '未按时完成扣2分/人次', '5', '2', null);
INSERT INTO `t_partymember_score_pip` VALUES ('2', '1', '在党组织的会议中发言', '加2分/人次', '6', '2', null);
INSERT INTO `t_partymember_score_pip` VALUES ('3', '1', '谈心谈话', '加1分/人次', '4', '1', null);
INSERT INTO `t_partymember_score_pip` VALUES ('4', '1', '提交学习体会、心得等文章', '加3分/人次', '5', '3', null);
INSERT INTO `t_partymember_score_pip` VALUES ('5', '1', '提交学习体会、心得等文章', '公开发表5分', '5', '5', null);
INSERT INTO `t_partymember_score_pip` VALUES ('6', '0', '三会课', '无故缺席扣3分/人次', '5', '3', null);
INSERT INTO `t_partymember_score_pip` VALUES ('7', '0', '主题党日活动', '无故缺席扣3分/人次', '5', '3', null);
INSERT INTO `t_partymember_score_pip` VALUES ('8', '0', '缴纳党费', '无故为按月足额缴纳扣5分/人次', '5', '5', null);
INSERT INTO `t_partymember_score_pip` VALUES ('9', '0', '党员记录本', '未按要求填写扣1分/人次', '5', '1', null);
INSERT INTO `t_sys_auth` VALUES ('0fb6bf4eba364fb9bf7ecc036bce6dcd', '个人生活记录查询', '/partyList/list', '/partyList/list', '0', '1', '个人生活记录查询', 'dfaa96f1b110477689e5cb34e21e568f', '3');
INSERT INTO `t_sys_auth` VALUES ('359a8f79547f4cb9bfccb7c644edf82c', '党员列表', 'partyMember/list', 'partyMember/list', '0', '1', '党员列表', '5c4966eeb52b4b1e96798c5035cc4432', '1');
INSERT INTO `t_sys_auth` VALUES ('581f4cd0c8944d2aa3dfbda7c6154cf4', '资料上传', 'appendix/list', 'appendix/list', '0', '1', '资料上传', 'dfaa96f1b110477689e5cb34e21e568f', '3');
INSERT INTO `t_sys_auth` VALUES ('5c4966eeb52b4b1e96798c5035cc4432', '党员信息', 'partyMember', 'partyMember', '0', '1', '党员信息', '0', '3');
INSERT INTO `t_sys_auth` VALUES ('70360a0e8d1e41718c9bcdbf3150b87b', '权限管理', 'auth/list', 'auth_list', '0', '1', '权限管理', 'b47b7b2e95c8499b8567f811738e5869', '10');
INSERT INTO `t_sys_auth` VALUES ('b47b7b2e95c8499b8567f811738e5869', '管理员管理', 'manager', 'manager', '0', '1', '管理员管理', '0', '2');
INSERT INTO `t_sys_auth` VALUES ('b6002bb4a2614055aa8bcabaf4e8b9d3', '政治生活记录', 'party/meeting', 'party/meeting', '0', '1', '政治生活记录', 'dfaa96f1b110477689e5cb34e21e568f', '2');
INSERT INTO `t_sys_auth` VALUES ('d0ee74a1e1fe47d2a72b2321234ac4ad', '角色管理', 'role/list', 'role_list', '0', '1', '角色管理', 'b47b7b2e95c8499b8567f811738e5869', '30');
INSERT INTO `t_sys_auth` VALUES ('d1265b39dfda42b6bc01b3cf75794b00', '人员管理', 'user/list', 'user_list', '0', '1', '人员管理', 'b47b7b2e95c8499b8567f811738e5869', '20');
INSERT INTO `t_sys_auth` VALUES ('dfaa96f1b110477689e5cb34e21e568f', '组织活动记录', 'huodong', 'huodong', '0', '1', '组织活动记录', '0', '1');
INSERT INTO `t_sys_auth` VALUES ('eee1c31148d4449283c70781093831b1', '党员积分查询', 'partyMemberScore/list', 'partyMemberScore/list', '0', '1', '党员积分查询', '5c4966eeb52b4b1e96798c5035cc4432', '2');
INSERT INTO `t_sys_company` VALUES ('1', '仓库①', '15082339870', null, '1', '0');
INSERT INTO `t_sys_company` VALUES ('6fa65e386e344442ab3e4be91f1367e4', '仓库②', '15501255941', null, '1', '0');
INSERT INTO `t_sys_role` VALUES ('3842e8a9e3134bb89378104904c98e65', 'manager', '管理员', '1');
INSERT INTO `t_sys_role` VALUES ('73fb9dc2a643434ea1eb24b95bf04850', '普通党员', '普通党员', '1');
INSERT INTO `t_sys_role` VALUES ('7dd7df736919464dbaea9f3a333b6974', '支部委员', '支部委员', '1');
INSERT INTO `t_sys_role` VALUES ('dd97d3713b304484ab815e56cad7b70c', '小组长', '小组长', '1');
INSERT INTO `t_sys_role_auth` VALUES ('052e4ab4e31741a1ba905caaf3b02550', '7dd7df736919464dbaea9f3a333b6974', '359a8f79547f4cb9bfccb7c644edf82c');
INSERT INTO `t_sys_role_auth` VALUES ('08d8e2c0c8dc40ef8c70af5ea69c9b75', '7dd7df736919464dbaea9f3a333b6974', 'b47b7b2e95c8499b8567f811738e5869');
INSERT INTO `t_sys_role_auth` VALUES ('0e4be4281ea84f308943a494786a80e2', '7dd7df736919464dbaea9f3a333b6974', 'd0ee74a1e1fe47d2a72b2321234ac4ad');
INSERT INTO `t_sys_role_auth` VALUES ('1eef33348f1f4b998f76c568b24aa58a', '73fb9dc2a643434ea1eb24b95bf04850', '5c4966eeb52b4b1e96798c5035cc4432');
INSERT INTO `t_sys_role_auth` VALUES ('24bd871ab5294c24882cbd68fc236918', '7dd7df736919464dbaea9f3a333b6974', 'b6002bb4a2614055aa8bcabaf4e8b9d3');
INSERT INTO `t_sys_role_auth` VALUES ('2c69a166080b43c0841347f0bb1629cd', '3842e8a9e3134bb89378104904c98e65', 'b47b7b2e95c8499b8567f811738e5869');
INSERT INTO `t_sys_role_auth` VALUES ('3426bc54a50840e5aec68f3d21d813db', '3842e8a9e3134bb89378104904c98e65', 'd0ee74a1e1fe47d2a72b2321234ac4ad');
INSERT INTO `t_sys_role_auth` VALUES ('38aedf2e84b948d4953c7e38a4dacd10', 'dd97d3713b304484ab815e56cad7b70c', '359a8f79547f4cb9bfccb7c644edf82c');
INSERT INTO `t_sys_role_auth` VALUES ('3b8fed6063dc46a3bc2356f86405d54b', 'dd97d3713b304484ab815e56cad7b70c', '581f4cd0c8944d2aa3dfbda7c6154cf4');
INSERT INTO `t_sys_role_auth` VALUES ('3e9d917ac14c47978332f0355c5c0034', '7dd7df736919464dbaea9f3a333b6974', '70360a0e8d1e41718c9bcdbf3150b87b');
INSERT INTO `t_sys_role_auth` VALUES ('4158f7eab6e34f2d9f71be54e9af007e', '3842e8a9e3134bb89378104904c98e65', '0fb6bf4eba364fb9bf7ecc036bce6dcd');
INSERT INTO `t_sys_role_auth` VALUES ('489797be7cb44878a8465345aa55743e', 'dd97d3713b304484ab815e56cad7b70c', 'd0ee74a1e1fe47d2a72b2321234ac4ad');
INSERT INTO `t_sys_role_auth` VALUES ('498d430fd6984b5990ea9ba6ee4b4e26', '3842e8a9e3134bb89378104904c98e65', '581f4cd0c8944d2aa3dfbda7c6154cf4');
INSERT INTO `t_sys_role_auth` VALUES ('5905decdbc5f42a995c466fb379be90e', '73fb9dc2a643434ea1eb24b95bf04850', 'dfaa96f1b110477689e5cb34e21e568f');
INSERT INTO `t_sys_role_auth` VALUES ('60ff7547e5014cd79e10d895140f6f64', '7dd7df736919464dbaea9f3a333b6974', '0fb6bf4eba364fb9bf7ecc036bce6dcd');
INSERT INTO `t_sys_role_auth` VALUES ('67cfcd19111247c8b337b543413291dd', '7dd7df736919464dbaea9f3a333b6974', 'eee1c31148d4449283c70781093831b1');
INSERT INTO `t_sys_role_auth` VALUES ('681c75dca74946e0855a45786d5cc8a4', 'dd97d3713b304484ab815e56cad7b70c', 'dfaa96f1b110477689e5cb34e21e568f');
INSERT INTO `t_sys_role_auth` VALUES ('6e97680192ad476ca6d025b2ca7f8923', '73fb9dc2a643434ea1eb24b95bf04850', 'b6002bb4a2614055aa8bcabaf4e8b9d3');
INSERT INTO `t_sys_role_auth` VALUES ('73ee5ca39d774e819d37f47e7efa2c63', '73fb9dc2a643434ea1eb24b95bf04850', '359a8f79547f4cb9bfccb7c644edf82c');
INSERT INTO `t_sys_role_auth` VALUES ('8c6fa0c0c7044ad2a3ea76fbe4e34074', 'dd97d3713b304484ab815e56cad7b70c', 'd1265b39dfda42b6bc01b3cf75794b00');
INSERT INTO `t_sys_role_auth` VALUES ('8d8441d93fee41ca8e8b2eee5bef12d3', 'dd97d3713b304484ab815e56cad7b70c', 'eee1c31148d4449283c70781093831b1');
INSERT INTO `t_sys_role_auth` VALUES ('98385c7e9ce0477fa684ea3f8774cc59', '3842e8a9e3134bb89378104904c98e65', '70360a0e8d1e41718c9bcdbf3150b87b');
INSERT INTO `t_sys_role_auth` VALUES ('99f9d72d84a24a03b0c2a2279cdfa2ec', '3842e8a9e3134bb89378104904c98e65', '5c4966eeb52b4b1e96798c5035cc4432');
INSERT INTO `t_sys_role_auth` VALUES ('a335b936d34940a6b340e9b30f0bd304', '73fb9dc2a643434ea1eb24b95bf04850', 'eee1c31148d4449283c70781093831b1');
INSERT INTO `t_sys_role_auth` VALUES ('a5597c41ccc94a5aa68d445cd2bed49d', 'dd97d3713b304484ab815e56cad7b70c', '0fb6bf4eba364fb9bf7ecc036bce6dcd');
INSERT INTO `t_sys_role_auth` VALUES ('af3bc44356ff4aef882d3df5ec4ed4ed', 'dd97d3713b304484ab815e56cad7b70c', '5c4966eeb52b4b1e96798c5035cc4432');
INSERT INTO `t_sys_role_auth` VALUES ('b3cde87aaacd451485b8f06424b4b169', '3842e8a9e3134bb89378104904c98e65', 'eee1c31148d4449283c70781093831b1');
INSERT INTO `t_sys_role_auth` VALUES ('b3ee028bbb7044669d9bf21ebe7b65e3', '3842e8a9e3134bb89378104904c98e65', 'd1265b39dfda42b6bc01b3cf75794b00');
INSERT INTO `t_sys_role_auth` VALUES ('c0087b163ac44fe5b1def8acbcf30cd3', '73fb9dc2a643434ea1eb24b95bf04850', '581f4cd0c8944d2aa3dfbda7c6154cf4');
INSERT INTO `t_sys_role_auth` VALUES ('c6735613cb734eee8f1df49076e0ef46', 'dd97d3713b304484ab815e56cad7b70c', 'b47b7b2e95c8499b8567f811738e5869');
INSERT INTO `t_sys_role_auth` VALUES ('cad29e41ff304e02af48d0199fd755e6', 'dd97d3713b304484ab815e56cad7b70c', 'b6002bb4a2614055aa8bcabaf4e8b9d3');
INSERT INTO `t_sys_role_auth` VALUES ('cea7d311eddd4dc1934ef3151f72e351', '3842e8a9e3134bb89378104904c98e65', 'b6002bb4a2614055aa8bcabaf4e8b9d3');
INSERT INTO `t_sys_role_auth` VALUES ('d55055c03a0c47379591a59142123b00', '7dd7df736919464dbaea9f3a333b6974', 'd1265b39dfda42b6bc01b3cf75794b00');
INSERT INTO `t_sys_role_auth` VALUES ('d6eebf7b06964363aebb4604e8305e33', '3842e8a9e3134bb89378104904c98e65', 'dfaa96f1b110477689e5cb34e21e568f');
INSERT INTO `t_sys_role_auth` VALUES ('dda75e6d24bc4c988b8d3427e9257537', '7dd7df736919464dbaea9f3a333b6974', '5c4966eeb52b4b1e96798c5035cc4432');
INSERT INTO `t_sys_role_auth` VALUES ('de4f9bf625d74083b21a1e678ef48d15', '73fb9dc2a643434ea1eb24b95bf04850', '0fb6bf4eba364fb9bf7ecc036bce6dcd');
INSERT INTO `t_sys_role_auth` VALUES ('deb01b5fdb0b4c4e9c0b33df6a1a1869', '3842e8a9e3134bb89378104904c98e65', '359a8f79547f4cb9bfccb7c644edf82c');
INSERT INTO `t_sys_role_auth` VALUES ('fd1664585e8047cba24d2ac68c9137ce', '7dd7df736919464dbaea9f3a333b6974', 'dfaa96f1b110477689e5cb34e21e568f');
INSERT INTO `t_sys_role_auth` VALUES ('fed225b8ad1846e9be1931c7214e498f', '7dd7df736919464dbaea9f3a333b6974', '581f4cd0c8944d2aa3dfbda7c6154cf4');
INSERT INTO `t_sys_role_user` VALUES ('011db1a97a5448379234595235cc656e', '3842e8a9e3134bb89378104904c98e65', '7bed5f5aa13d4b7586b7d31acaaeccd6');
INSERT INTO `t_sys_role_user` VALUES ('0f968c5e4f434258aa856be068f92727', '7dd7df736919464dbaea9f3a333b6974', 'c20c3d2ebb4848038515bf074170ccd8');
INSERT INTO `t_sys_role_user` VALUES ('18fd4fbf60254f90b15d85c9402ea4e6', '73fb9dc2a643434ea1eb24b95bf04850', '734a135bf362419082d4225456f2d7e0');
INSERT INTO `t_sys_role_user` VALUES ('242df8b56d014804aff2734a7b6a1484', '73fb9dc2a643434ea1eb24b95bf04850', 'ce475e96fb2f440481fc2fb8cd72c3ae');
INSERT INTO `t_sys_role_user` VALUES ('289a54d62cf34cb7afd81f4c8eb39296', '73fb9dc2a643434ea1eb24b95bf04850', '58cc3412bafc4525a22c82e41f73c1ad');
INSERT INTO `t_sys_role_user` VALUES ('2a5b07506e654a1b90ff66466a540048', '73fb9dc2a643434ea1eb24b95bf04850', '3c8fdcbb85614ef888df992dadb7e90f');
INSERT INTO `t_sys_role_user` VALUES ('3420abcd744341988db5a8b65fa1e1ec', '73fb9dc2a643434ea1eb24b95bf04850', '89b284b9116b49e7be7e336999eae2b7');
INSERT INTO `t_sys_role_user` VALUES ('381bef7fd6a7439d857c7c7a5c5577b7', '73fb9dc2a643434ea1eb24b95bf04850', '773d57d7d1344cb9bad803b082e5eb26');
INSERT INTO `t_sys_role_user` VALUES ('57a1c4d5388c4107840aa929be7297e6', '73fb9dc2a643434ea1eb24b95bf04850', '8ef77aa34cf9473d8a2dee35c7c767a5');
INSERT INTO `t_sys_role_user` VALUES ('5c3d849225ac480a9509824ab33f4180', 'dd97d3713b304484ab815e56cad7b70c', 'e76ca717463e4d95aac60c16b14a4bf5');
INSERT INTO `t_sys_role_user` VALUES ('655fb1ae6db84502bd1f7911a8699e9c', '73fb9dc2a643434ea1eb24b95bf04850', '35dfef8aa9b44004b8dac7d8d2796699');
INSERT INTO `t_sys_role_user` VALUES ('6f0ed61aaf5e424cb933b3e4593c6b0f', '7dd7df736919464dbaea9f3a333b6974', 'e76d753045a44b3e8e15aa9238418c27');
INSERT INTO `t_sys_role_user` VALUES ('71d55d12b8ca41059fe30863f6917e59', '73fb9dc2a643434ea1eb24b95bf04850', '38606dbc7c564da0b6ff1bbd76b6e551');
INSERT INTO `t_sys_role_user` VALUES ('7c1e51be0981489988208fe5ff850414', '73fb9dc2a643434ea1eb24b95bf04850', 'e329cd9bde7648758c8275915383907a');
INSERT INTO `t_sys_role_user` VALUES ('7e8882c0f0284c3a9b6e4dc1d541a23b', '73fb9dc2a643434ea1eb24b95bf04850', '260fb0d5792842f49ca699a16a98af45');
INSERT INTO `t_sys_role_user` VALUES ('89e6669b915e4c9693caad30ce5bff28', 'dd97d3713b304484ab815e56cad7b70c', 'e1c604ae6d2b43dd9b5160b1e0045c41');
INSERT INTO `t_sys_role_user` VALUES ('8ac504a179c543a3a00dd7b3846a0406', '73fb9dc2a643434ea1eb24b95bf04850', 'c66cdd2c79d74009bd9ee1737340de50');
INSERT INTO `t_sys_role_user` VALUES ('958f29a0777e4140842b8af6737e0862', '73fb9dc2a643434ea1eb24b95bf04850', '4b33815180594e6497d21540a6a46d90');
INSERT INTO `t_sys_role_user` VALUES ('97bd99c707554314a8f35b4ec895bf57', '73fb9dc2a643434ea1eb24b95bf04850', '8d10d6cf38204ab49b74174f2afc407d');
INSERT INTO `t_sys_role_user` VALUES ('9e7073733e01428ea79fb043ec720f93', '7dd7df736919464dbaea9f3a333b6974', 'b8eb366c631a40099a4add609779ea28');
INSERT INTO `t_sys_role_user` VALUES ('acbedae9a19e46e894d9013beba7f2d2', '7dd7df736919464dbaea9f3a333b6974', 'c7050304138a4b47a22209a9dec5a6d1');
INSERT INTO `t_sys_role_user` VALUES ('ad53e343203346358cea075c2e6ba3e6', '7dd7df736919464dbaea9f3a333b6974', '8763a650f074429f89bbb9a94d7693cb');
INSERT INTO `t_sys_role_user` VALUES ('bdfd014fba664ba6aeaee15497a39713', '73fb9dc2a643434ea1eb24b95bf04850', '77c4f32f1a5e4cf1b46c9293c4fc37de');
INSERT INTO `t_sys_role_user` VALUES ('bf30c1109d32465e94171b1ee8f22fa3', '73fb9dc2a643434ea1eb24b95bf04850', 'b73eef327073491f94e0cefde3bab895');
INSERT INTO `t_sys_role_user` VALUES ('c141afb213244572bec94e0fe38a0e72', '73fb9dc2a643434ea1eb24b95bf04850', '0fa7a867f96c42e38d429d9789c25a08');
INSERT INTO `t_sys_role_user` VALUES ('cb737b025a0e44dda02d0cfdcc43a289', '73fb9dc2a643434ea1eb24b95bf04850', 'c8184d95fc5a45bdb0642319fdac6ccf');
INSERT INTO `t_sys_role_user` VALUES ('d0a8c323deb2406d988a0b3472a9c3ea', 'dd97d3713b304484ab815e56cad7b70c', '9424c06b7444466c866bfe60a5d9087b');
INSERT INTO `t_sys_role_user` VALUES ('d135256418db4bbdbc6b983805df14dd', '73fb9dc2a643434ea1eb24b95bf04850', '758198e2ed9f4c33ba4554f05ec75649');
INSERT INTO `t_sys_role_user` VALUES ('d52b27876c404f3abe98286226dc1f40', '3842e8a9e3134bb89378104904c98e65', '5404de7ea1164dbeafdc3a7f52ebe791');
INSERT INTO `t_sys_role_user` VALUES ('d90e9344dc104e0f98e705d0c0200bb7', '73fb9dc2a643434ea1eb24b95bf04850', 'bf3b3baaf3854d17874d5d639b362f96');
INSERT INTO `t_sys_role_user` VALUES ('e5574fd5f3f64c8a8c0580a45fd6279c', '73fb9dc2a643434ea1eb24b95bf04850', '7c2ef747ee2c4c6ab4f3aa362de294f7');
INSERT INTO `t_sys_role_user` VALUES ('e77b004d5c884055aabf3ff4482e0e23', '73fb9dc2a643434ea1eb24b95bf04850', '88904cd6eb154d63a2c69b188d93c678');
INSERT INTO `t_sys_role_user` VALUES ('ea26e9ab39c3477289c21c285f7ed13d', '73fb9dc2a643434ea1eb24b95bf04850', '7f30f888f9b04af2b1fac9071f51456f');
INSERT INTO `t_sys_role_user` VALUES ('ee1c33174e1a4c01ac5540a099d4727c', '73fb9dc2a643434ea1eb24b95bf04850', '7cb3566d455e40f1a64fde935a5a19ce');
INSERT INTO `t_sys_role_user` VALUES ('fb289215e1774c7ea9d98a36edb703f6', '73fb9dc2a643434ea1eb24b95bf04850', 'a2fad702f1534cfa8545c0b9cacf95ed');
INSERT INTO `t_sys_role_user` VALUES ('fe28e085847048919480bef7d46dfb47', '73fb9dc2a643434ea1eb24b95bf04850', '756f83d5763249758d4d616167d9d432');
INSERT INTO `t_sys_user` VALUES ('0fa7a867f96c42e38d429d9789c25a08', '万学东', '万学东', 'E10ADC3949BA59ABBE56E057F20F883E', null, '万学东', '0', null);
INSERT INTO `t_sys_user` VALUES ('260fb0d5792842f49ca699a16a98af45', '赫连晓会', '赫连晓会', 'E10ADC3949BA59ABBE56E057F20F883E', null, '赫连晓会', '0', null);
INSERT INTO `t_sys_user` VALUES ('35dfef8aa9b44004b8dac7d8d2796699', '熊健', '熊健', 'E10ADC3949BA59ABBE56E057F20F883E', null, '熊健', '0', null);
INSERT INTO `t_sys_user` VALUES ('38606dbc7c564da0b6ff1bbd76b6e551', '郭鹏', '郭鹏', 'E10ADC3949BA59ABBE56E057F20F883E', null, '郭鹏', '0', null);
INSERT INTO `t_sys_user` VALUES ('3c8fdcbb85614ef888df992dadb7e90f', '郭晓峰', '郭晓峰', 'E10ADC3949BA59ABBE56E057F20F883E', null, '郭晓峰', '0', null);
INSERT INTO `t_sys_user` VALUES ('4b33815180594e6497d21540a6a46d90', '刘毅', '刘毅', 'E10ADC3949BA59ABBE56E057F20F883E', null, '刘毅', '0', null);
INSERT INTO `t_sys_user` VALUES ('5404de7ea1164dbeafdc3a7f52ebe791', 'admin', 'admin', 'C33367701511B4F6020EC61DED352059', null, 'admin', '0', null);
INSERT INTO `t_sys_user` VALUES ('58cc3412bafc4525a22c82e41f73c1ad', '吕振广', '吕振广', 'E10ADC3949BA59ABBE56E057F20F883E', null, '吕振广', '0', null);
INSERT INTO `t_sys_user` VALUES ('734a135bf362419082d4225456f2d7e0', '李英平', '李英平', 'E10ADC3949BA59ABBE56E057F20F883E', null, '李英平', '0', null);
INSERT INTO `t_sys_user` VALUES ('756f83d5763249758d4d616167d9d432', '徐鹏翱', '徐鹏翱', 'E10ADC3949BA59ABBE56E057F20F883E', null, '徐鹏翱', '0', null);
INSERT INTO `t_sys_user` VALUES ('758198e2ed9f4c33ba4554f05ec75649', '汪世赓', '汪世赓', 'E10ADC3949BA59ABBE56E057F20F883E', null, '汪世赓', '0', null);
INSERT INTO `t_sys_user` VALUES ('773d57d7d1344cb9bad803b082e5eb26', '翟慎涛', '翟慎涛', 'E10ADC3949BA59ABBE56E057F20F883E', null, '翟慎涛', '0', null);
INSERT INTO `t_sys_user` VALUES ('77c4f32f1a5e4cf1b46c9293c4fc37de', '吴渊', '吴渊', 'E10ADC3949BA59ABBE56E057F20F883E', null, '吴渊', '0', null);
INSERT INTO `t_sys_user` VALUES ('7bed5f5aa13d4b7586b7d31acaaeccd6', '邱莉', '邱莉', 'E10ADC3949BA59ABBE56E057F20F883E', null, '邱莉', '0', null);
INSERT INTO `t_sys_user` VALUES ('7c2ef747ee2c4c6ab4f3aa362de294f7', '向青青', '向青青', 'E10ADC3949BA59ABBE56E057F20F883E', null, '向青青', '0', null);
INSERT INTO `t_sys_user` VALUES ('7cb3566d455e40f1a64fde935a5a19ce', '解哲', '解哲', 'E10ADC3949BA59ABBE56E057F20F883E', null, '解哲', '0', null);
INSERT INTO `t_sys_user` VALUES ('7f30f888f9b04af2b1fac9071f51456f', '张子玉', '张子玉', 'E10ADC3949BA59ABBE56E057F20F883E', null, '张子玉', '0', null);
INSERT INTO `t_sys_user` VALUES ('8763a650f074429f89bbb9a94d7693cb', '吴小燕', '吴小燕', 'E10ADC3949BA59ABBE56E057F20F883E', null, '吴小燕', '0', null);
INSERT INTO `t_sys_user` VALUES ('88904cd6eb154d63a2c69b188d93c678', '秦宝忠', '秦宝忠', 'E10ADC3949BA59ABBE56E057F20F883E', null, '秦宝忠', '0', null);
INSERT INTO `t_sys_user` VALUES ('89b284b9116b49e7be7e336999eae2b7', '崔宇', '崔宇', 'E10ADC3949BA59ABBE56E057F20F883E', null, '崔宇', '0', null);
INSERT INTO `t_sys_user` VALUES ('8d10d6cf38204ab49b74174f2afc407d', '高凯', '高凯', 'E10ADC3949BA59ABBE56E057F20F883E', null, '高凯', '0', null);
INSERT INTO `t_sys_user` VALUES ('8ef77aa34cf9473d8a2dee35c7c767a5', '武文杰', '武文杰', 'E10ADC3949BA59ABBE56E057F20F883E', null, '武文杰', '0', null);
INSERT INTO `t_sys_user` VALUES ('9424c06b7444466c866bfe60a5d9087b', '徐勤芳', '徐勤芳', 'E10ADC3949BA59ABBE56E057F20F883E', null, '徐勤芳', '0', null);
INSERT INTO `t_sys_user` VALUES ('a2fad702f1534cfa8545c0b9cacf95ed', '孟焕', '孟焕', 'E10ADC3949BA59ABBE56E057F20F883E', null, '孟焕', '0', null);
INSERT INTO `t_sys_user` VALUES ('b73eef327073491f94e0cefde3bab895', '张猛', '张猛', 'E10ADC3949BA59ABBE56E057F20F883E', null, '张猛', '0', null);
INSERT INTO `t_sys_user` VALUES ('b8eb366c631a40099a4add609779ea28', '雷长清', '雷长清', 'E10ADC3949BA59ABBE56E057F20F883E', null, '雷长清', '0', null);
INSERT INTO `t_sys_user` VALUES ('bf3b3baaf3854d17874d5d639b362f96', '庄严', '庄严', 'E10ADC3949BA59ABBE56E057F20F883E', null, '庄严', '0', null);
INSERT INTO `t_sys_user` VALUES ('c20c3d2ebb4848038515bf074170ccd8', '彭江', '彭江', 'E10ADC3949BA59ABBE56E057F20F883E', null, '彭江', '0', null);
INSERT INTO `t_sys_user` VALUES ('c66cdd2c79d74009bd9ee1737340de50', '于林涛', '于林涛', 'E10ADC3949BA59ABBE56E057F20F883E', null, '于林涛', '0', null);
INSERT INTO `t_sys_user` VALUES ('c7050304138a4b47a22209a9dec5a6d1', '饶大可', '饶大可', 'E10ADC3949BA59ABBE56E057F20F883E', null, '饶大可', '0', null);
INSERT INTO `t_sys_user` VALUES ('c8184d95fc5a45bdb0642319fdac6ccf', '郭佳', '郭佳', 'E10ADC3949BA59ABBE56E057F20F883E', null, '郭佳', '0', null);
INSERT INTO `t_sys_user` VALUES ('ce475e96fb2f440481fc2fb8cd72c3ae', '李仁元', '李仁元', 'E10ADC3949BA59ABBE56E057F20F883E', null, '李仁元', '0', null);
INSERT INTO `t_sys_user` VALUES ('e1c604ae6d2b43dd9b5160b1e0045c41', '李冯利', '李冯利', 'E10ADC3949BA59ABBE56E057F20F883E', null, '李冯利', '0', null);
INSERT INTO `t_sys_user` VALUES ('e329cd9bde7648758c8275915383907a', '王少文', '王少文', 'E10ADC3949BA59ABBE56E057F20F883E', null, '王少文', '0', null);
INSERT INTO `t_sys_user` VALUES ('e76ca717463e4d95aac60c16b14a4bf5', '戈丽敏', '戈丽敏', 'E10ADC3949BA59ABBE56E057F20F883E', null, '戈丽敏', '0', null);
INSERT INTO `t_sys_user` VALUES ('e76d753045a44b3e8e15aa9238418c27', '伍建成', '伍建成', 'E10ADC3949BA59ABBE56E057F20F883E', null, '伍建成', '0', null);
INSERT INTO `t_sys_user_company` VALUES ('00eeff7bb91d4bacbaffb75924868c4a', '600395da7530495eb7e5106f593778a0', '1');
INSERT INTO `t_sys_user_company` VALUES ('1d159bf01cbd499ca40c991644e6572a', '19cf30fc419e454b80139433de3de13a', '1');
INSERT INTO `t_sys_user_company` VALUES ('1dab223c7f934ab5840ef0623a6690c3', '111aa65d92334b2eba1419049b94eb32', '1');
INSERT INTO `t_sys_user_company` VALUES ('4f45e42f2b03404baf51fdc27832b42e', '600395da7530495eb7e5106f593778a0', '6fa65e386e344442ab3e4be91f1367e4');
INSERT INTO `t_sys_user_company` VALUES ('7f4f9231ab6a4198b68c7e29bb29f73d', '4576004590b34e4dbc641ba7151e0bbd', '1');
INSERT INTO `t_sys_user_company` VALUES ('bec31950a80c490389eb0d28bb55b05b', 'faa116ec1ed740d8837c9f17438bee93', '6fa65e386e344442ab3e4be91f1367e4');
INSERT INTO `t_sys_user_company` VALUES ('c7edf174ab5a45c1a636d1c35eb6b362', 'faa116ec1ed740d8837c9f17438bee93', '1');
INSERT INTO `t_sys_user_company` VALUES ('fad992c6f81145e6b68fa82e869cb807', '4576004590b34e4dbc641ba7151e0bbd', '6fa65e386e344442ab3e4be91f1367e4');
