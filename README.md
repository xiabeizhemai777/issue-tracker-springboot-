# 工单追踪系统 (Issue Tracker)

## 📖 项目简介
这是一个基于 Spring Boot 开发的轻量级工单追踪系统。主要解决团队内部任务流转、缺陷跟进的问题。项目采用前后端分离架构（后端），实现了工单的创建、查询、状态流转等核心业务，并加入了企业级的统一返回和全局异常处理机制。

## 🛠️ 技术栈
- **后端框架**：Spring Boot 3.4.x
- **持久层框架**：MyBatis
- **数据库**：MySQL 8.0
- **分页插件**：PageHelper
- **接口测试**：Apifox / Postman
- **开发工具**：IntelliJ IDEA, Maven

##  核心功能
1. **工单管理**：支持新建工单（默认状态为“待处理”）。
2. **工单查询**：支持分页查询所有工单列表（按创建时间倒序）。
3. **状态流转**：支持将工单状态从“待处理”流转为“已处理”（核心业务逻辑）。
4. **全局异常处理**：统一拦截业务异常，返回规范格式的 JSON。
5. **统一返回格式**：封装统一的 Result 对象，方便前端解析。

##  快速启动
1. 克隆项目到本地
2. 在 MySQL 中创建数据库 `issue_tracker`
3. 导入根目录下的 `schema.sql` 建表脚本（见附件）
4. 修改 `application.properties` 中的数据库账号密码
5. 运行 `IssueTrackerApplication` 主类
6. 访问接口：`http://localhost:8081/issue/list`

##  接口文档
- `POST /issue/add` : 新增工单
- `GET /issue/list?pageNum=1&pageSize=10` : 分页查询工单
- `POST /issue/process/{id}` : 处理工单