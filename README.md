# propertyManagementSystem
Java文件夹:  
Dao:与数据库交互底层   
Entity:放实体类  
Service:处理Dao层模块  
**Servlet:与前端交互 改页面同时注意改这里**  

JDBCUtils:JDBC工具类 数据库相关配置  
**部署时注意修改JDBCUtils的第23行 数据库名,账号,密码**

webapp文件夹:这里放主页和管理页面   
login.jsp:登录页面  
在web.xml里配置进入的第一个页面  

