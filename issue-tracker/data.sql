-- data.sql
USE issue_tracker;

INSERT INTO issue (title, description, status) VALUES
                                                   ('测试工单', '这是第一条测试数据', '已处理'),
                                                   ('服务器宕机', '生产环境服务器CPU飙升至100%', '待处理'),
                                                   ('登录接口报错', '用户反馈登录时提示500错误', '待处理');