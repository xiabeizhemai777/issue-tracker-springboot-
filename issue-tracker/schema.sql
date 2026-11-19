-- 创建数据库
CREATE DATABASE IF NOT EXISTS issue_tracker CHARACTER SET utf8mb4;
USE issue_tracker;

-- 创建工单表
CREATE TABLE IF NOT EXISTS issue (
                                     id INT PRIMARY KEY AUTO_INCREMENT,
                                     title VARCHAR(100) NOT NULL COMMENT '工单标题',
    description TEXT COMMENT '工单描述',
    status VARCHAR(20) DEFAULT '待处理' COMMENT '状态',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
    );