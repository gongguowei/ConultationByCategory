## 技术选型

> API文档: /swagger-ui.html

### 后端主要使用技术
- JDK1.8

- Redis

- lombok

- Swagger2

- MybatisPlus

- SpringSecurity

- Springframework

- 数据库MySQL 版本号8.0.13 （经测试，部署到线上可以使用 5.7.17 版本）

请注意，项目结构细节请参考[《阿里巴巴Java开发手册》](https://github.com/alibaba/p3c)
### 项目结构

```
Consultation_by_category
		|--src
		|--main
		|--java
			|--com.aircos
				|--aop 切面实现
				|--config 配置
				|--constant 常用构造器
				|--controller 项目接口入口
				|--core 核心
				|--entity 实体
				|--enums 枚举
				|--manager 第三方接口
				|--mapper 持久层
				|--service 业务层
				|--task 定时器
				|--util 工具类

		|--resources
				|--mybatis.mapper Xml
				|--application.yml配置文件
```

### 项目已完成的接口
#### 一、Web管理员端

- 首页轮播图 					AdminActivityController
- 预测模块问题与答案设置 		AdminForecastController
- 招生头条 					AdminHeadlineController
- 专业分类					AdminProfessionController
- 学校管理 					AdminSchoolController
- 培训信息 					AdminTrainController
- 用户 						AdminUserController

#### 二、用户端

- 首页轮播图					ActivityController
- 专业分类					CategoryController
- 专业倾向测评				EvaluationControler
- 招生头条					HeadlineController
- 专业大全					ProfessionController
- 爱校园模块					SchoolController
- 培训信息					TrainController
- 用户						UserController
- 用户会员					UserMemberLogController

#### 三、第三方SDK
- 云片短信服务

请注意：该项目使用了`SpringSecurity` 安全权限控制框架，因此登录你可以直接通过 `post` 请求访问 `/login`

 
###项目未完成的接口
	与第三方支付，回调接口已完成（UserMemberLogController）
	公告通知模块
	问题反馈模块

###本地运行

1. 执行sql目录下的sql文件（结构+测试数据），或许你想知道数据库的字符集或排序规则，它们分别是utf8、utf8_general_ci
2. application.yml文件修改Redis的Host
3. application.yml 文件修改 Mysql 的 url、username、password
4. 请注意是否安装`lombak`插件
5. 可以试试看运行它了

请注意：任何请求都需要请求头中携带Token，如果该请求不需要Token，你可以在项目目录config -> security -> BrowserSecurityConfig 中去放行这个请求路径。目前携带Token的请求应该是这样的。
 


### 关于服务器运行

> 基于Linux进行部署

```
#请在服务器上安装Nginx（如果你是想用反向代理的话）

#请安装Redis

#打包后直接使用命令
nohup java -jar 你的jar包全称> catalina.out  2>&1 &

放心，并没有设置任何JVM虚拟机启动参数
```

###联系方式
如果有什么我能帮忙的地方，请联系我。