第一次提交
采用spring boot 集成mybatis 
注意的点
    1.导入mysql驱动
      <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
      </dependency>
    2.导入mybatis和spring boot集成的包
    <dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.1.1</version>
	</dependency>
    
    3.mybatis的配置
     spring.datasource.driver-class-name=com.mysql.jdbc.Driver
     spring.datasource.url=jdbc:mysql://localhost:3306/springboot
     spring.datasource.username=root
     spring.datasource.password=123   
     
     注意的点：当需要使用模型对象类名简写的形式，需要使用下面的配置
     mybatis.config-location=classpath:mybatis-config.xml
     这个配置好像不起作用，还会报错
     #mybatis.type-aliases-package=com.hyolee.user.domain
     这个配置也有问题
     #logging.level.root=WARN
     这个配置需要，可以在控制台上打印sql语句，便于调试
     logging.level.com.hyolee.user.mapper=TRACE
     
     在Mapper接口上使用@Mapper，会自动扫描Mapper.xml文件
     Mapper.xml文件的放置位置在resources/xx/xx/mapper/*.xml 注意xml文件的路径要和接口的路径保持一致
     
     注意着几点，就可以成功搭建spring-boot和mybatis的集成环境了

 异常处理
 首先自定义异常，继承RuntimeException
 其次在自定义异常类上添加注解@ResponseStatus(HttpStatus.NOT_FOUND)
 表明当一个该自定义异常发生时，404 not found 应该被用于响应体中
返回一个ResponseEntity，包含以下内容
{
  "timestamp": 1464955338982,
  "status": 404,
  "error": "Not Found",
  "exception": "com.hyolee.user.exception.ResourceNotFoundException",
  "message": "User with id 100 not found",
  "path": "/users/100"
}

可以自定义异常类
也可以继承ResponseEntityExceptionHandler抽象类，覆盖其中想要覆盖的方法
关于springmvc的书籍，可以查看详细的异常处理

<h1>有什么用啊</h1>
     
    