## Spring boot JPA 学习

## 包版本信息 
包 | 版本
------- |  ----
Spring boot|  2.1.0.RELEASE  
JPA |  2.1.2.RELEASE  
swagger2 | 2.7.0
JWT | 3.4.0
com.alibaba.fastjson | 1.2.47
Redis | 2.1.2.RELEASE  
shiro | 1.3.2
commons-lang3 | 3.7
## 功能实现
参数名称 | 说明
------- |  ----
2018-11-29 | 实现标准增删改API 集成*swagger2*
2018-11-30 | 多表查询 *通过创建一个结果集接收多表查询结果 单元测试UserInfoRepositoryTests类* 加入log4j2
2018-12-02 | 集成JWT实现token验证 [参考](https://www.jianshu.com/p/e88d3f8151db)  引入com.alibaba.fastjson
2018-12-03 | 集成Redis [参考](https://www.jianshu.com/p/19628db2e7ef)
2018-12-05 | 增加Twitter分布式自增ID算法snowflake
2018-12-08 | 通过注解GeneratedValue实现自定义ID生成
2018-12-09 | 集成Shiro
***
### 联系方式：182443947@qq.com 
