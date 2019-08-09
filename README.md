# shtp

后台基于SpringCloud微服务架构实现，前端基于vue。

启动顺序：eureka-> zuul-> product-> search-> askbuy-> shtp-web

前端web项目启动前需要本地先安装vue项目所需的各种工具包：npm install
新建数据库shtp，然后执行shtp.sql语句，必须先使数据库中存在数据，否则启动zuul会报错。

用户名：admin   密码：123   （管理员可以随意增删改）
libai
liuzongyuan
