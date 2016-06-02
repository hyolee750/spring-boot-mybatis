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
     
    