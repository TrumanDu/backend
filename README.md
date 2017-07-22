# App Backend Framework

## What is Backend?
Backend is a App Backend Server Framework

## How to use?
Backend is a maven project,so you must install maven,the same to reason
you should install jdk.

```
mvn spring-boot:run
```
## Feature
1. 基于Spring Boot框架搭建的APP后台，一个最最基础的框架；
2. 一个标准的Maven项目；
3. 内置H2数据库，无需创建外部数据库表数据源；
4. 一键部署，无需其他闲杂操作即可运行项目；
5. 对于初学者而言，这是一个非常不错的学习框架；
6. API提交与返回数据全部采用json数据格式交换；
7. 后台管理功能：用户列表，新闻管理，HTTP错误页管理；
8. 在线API手册，不再需要编写API手册给前端工程师；
9. 无XML配置文件，全部采用java config实现；
10. MVC结构清晰，java包划分明确，很容易找到功能点；
12. 支持restful，支持json，控制权限灵活
13. 采用thymeleaf实现html页面，不需要jsp
14. 配套移动APP，完美结合
15. 支持iOS平台
16. 支持Android平台

## TODO
1. 移植登录与权限模块
2. 支付接口
3. 推送接口
4. 发短信接口
5. token验证机制