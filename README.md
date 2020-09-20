# spring-cloud-demo
springcloud矿建核心组件搭建案例学习



数据库划分

用户库

```mysql
CREATE TABLE `hc_user_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(300) DEFAULT NULL COMMENT '加密密码',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(1) DEFAULT '0' COMMENT '状态:0可用,1禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
```

管理系统库

```mysql
-- 管理员列表
CREATE TABLE `hc_admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(300) DEFAULT NULL COMMENT '加密密码',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(1) DEFAULT '0' COMMENT '状态:0可用,1禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理用户表';

-- 角色和权限列表
CREATE TABLE `hc_role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_auth` varchar(64) DEFAULT NULL COMMENT '角色权限',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- 定时器列表
CREATE TABLE `schedule_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务';
```

数据库分析表

```mysql
-- 书籍搜索记录
CREATE TABLE `hc_search_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `book_id` int(11) DEFAULT NULL COMMENT '书籍ID',
  `book_name` varchar(100) DEFAULT NULL COMMENT '书籍名称',
  `search_time` datetime DEFAULT NULL COMMENT '搜索时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='书籍被搜索记录';

-- 关键词搜索记录
CREATE TABLE `hc_search_key_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `key_word` varchar(50) DEFAULT NULL COMMENT '关键词',
  `search_num` int(11) DEFAULT NULL COMMENT '搜索次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关键词搜索记录';
```

书籍搜索相关表

```mysql
-- 书籍搜索信息表
CREATE TABLE `hc_book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `book_name` varchar(100) DEFAULT NULL COMMENT '书籍名称',
  `book_author` varchar(100) NOT NULL DEFAULT '0' COMMENT '作者',
  `book_desc` varchar(200) DEFAULT NULL COMMENT '简介',
  `book_press` varchar(100) NOT NULL DEFAULT '0' COMMENT '出版社',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(1) DEFAULT '0' COMMENT '状态：0可用,1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍信息表';
```

