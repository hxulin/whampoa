-- Mysql


-- 创建库
CREATE DATABASE mp;

-- 使用库
USE mp;

-- 创建表
DROP TABLE IF EXISTS user;
CREATE TABLE t_employee(
   id INT PRIMARY KEY AUTO_INCREMENT,
   first_name VARCHAR(50),
   email VARCHAR(50),
   gender CHAR(1),
   age INT
);

-- 初始化测试数据
DELETE FROM t_employee;
INSERT INTO t_employee (first_name, email, gender, age) VALUES
('Jone', 'test1@huangxulin.cn',1, 18),
('Jack', 'test2@huangxulin.cn', 1, 20),
('Tom', 'test3@huangxulin.cn', 1, 28),
('Sandy', 'test4@huangxulin.cn', 0, 21),
('Billie', 'test5@huangxulin.cn', 0, 24);