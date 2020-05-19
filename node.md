# SSM整合步骤
1. 创建Maven项目，配置pom.xml文件，把SSM整合需要用的依赖添加完毕，项目基本的设置配置完毕
    * pom主要分为三大部分
        * 项目基本信息配置（项目的GAV坐标、项目的打包方式、项目的jdk版本、自定义版本等）
        * 依赖信息（项目所需的所有jar）
        * 插件配置（例如maven的tomcat插件）
2. 搭建项目架构
    * 可以通过easycode或者其他的代码生成器生成项目基本的分层结构中使用的类与配置文件
    * 项目的基本结构如下
        * controller层 springmvc的控制器，用于接收请求，并做出响应
        * service层 业务逻辑层，用于编写业务逻辑、事务控制、日志记录等等，通过spring管理的
        * dao层 数据访问层，使用mybatsis实现数据库的crud操作，整合了spring之后不需要实现类，只需通过配置文件即可实现dao层类的对象的创建
        * entity 实体类 用于分层结构中数据的传递
        * util 放一些工具类
        * commons 放一些通用的代码
    * resource 项目的配置文件
        * mapper mybatis的sql映射文件，用于编写所有的sql语句，要与mapper接口（dao接口）对应
        * spring的配置文件,可以分层多个配置文件，方便与管理
            * applicationContext-bean.xml （用于配置基本的bean的创建）
            * applicationContext-datasource.xml （用于配置数据库操作、整合mybatis、事务配置）
            * applicationContext-shiro.xml (用于配置权限控制)
            * applicationContext-email.xml (用于配置邮件发送)
        * springmvc配置文件 (视图解析器、注解映射、上传文件、数据绑定等等)
        * jdbc.properties 数据库连接信息
        * log4j.properties 日志配置文件
    * webapp 视图层（jsp、静态文件等等、其中最重要的就是web.xml）
3. 编写基本的配置文件
    * mapper映射文件用于编写sql语句
    * applicationContext-bean.xml
        * 由于目前项目没有什么特别的bean需要创建，都是使用注解创建的，所以只需要添加扫描注解的代码即可
    * applicationContext-datasource.xml 
        * 创建数据源
        ```xml
         <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
            <!--${}获取spring读取的配置信息-->
            <bean id="datasource" class="com.alibaba.druid.pool.DruidDataSource">
                <property name="url" value="${jdbc.mysql.url}"></property>
                <property name="username" value="${jdbc.mysql.username}"></property>
                <property name="password" value="${jdbc.mysql.password}"></property>
                <property name="initialSize" value="10"></property>
                <property name="maxActive" value="50"></property>
                <property name="minIdle" value="5"></property>
                <property name="maxWait" value="60000"></property>
            </bean>
        ```
         * 创建sqlsessionfactorybean spring封装的mybatis的session工厂，可以替代mybatis的配置文件
         ```xml
            <bean class="org.mybatis.spring.SqlSessionFactoryBean">
                    <!--指定数据源-->
                    <property name="dataSource" ref="datasource"></property>
                    <!--指定mapper映射文件的路径-->
                    <property name="mapperLocations" value="classpath:mapper/*.xml"></property>
                    <!--添加一些mybatis的其他配置-->
                    <!--1、直接引用mybatsi的配置文件-->
                    <!--<property name="configLocation" value="classpath:mybatisconfig.xml"></property>-->
                    <!--2、自定义配置类设置-->
                    <property name="configuration">
                        <bean class="org.apache.ibatis.session.Configuration">
                            <property name="mapUnderscoreToCamelCase" value="true"></property>
                        </bean>
                    </property>
                    <!--设置别名-->
                    <property name="typeAliasesPackage" value="com.entity"></property>
                </bean>
         ```
         * 创建mapper接口映射类(将dao接口与mapper映射文件对应，生成对应的bean，service层需要直接注入即可)
         ```xml
         <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
                <!--指定mapper接口的位置-->
                <property name="basePackage" value="com.dao"></property>
            </bean>
        ```
    * springmvc.xml
       ```xml
         <!--注解扫描-->
            <context:component-scan base-package="com.controller"></context:component-scan>
            <!--启用注解映射-->
            <mvc:annotation-driven/>
        
            <!--静态资源过滤-->
            <mvc:default-servlet-handler></mvc:default-servlet-handler>
        
            <!--配置视图解析器-->
            <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                <property name="prefix" value="/WEB-INF/jsp/"></property>
                <property name="suffix" value=".jsp"></property>
            </bean>
        ```
    * web.xml
        * 配置spring的监听器，用于读取spring的配置文件
        ```xml
         <!--
           spring整合web需要配置1、监听器  2、上下文参数  主要就是为了在服务器启动时读取spring的配置文件
           -->
            <listener>
                <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
            </listener>
            <context-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:applicationContext-*.xml</param-value>
            </context-param>
        ```
        * 配置springmvc的servlet，用于读取springmvc的配置文件  
        ```xml
         <!--springmvc配置-->
            <servlet>
                <servlet-name>springmvc</servlet-name>
                <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                <!--指定springmvc配置文件的路径，不然默认读取web-inf里的配置文件-->
                <init-param>
                    <param-name>contextConfigLocation</param-name>
                    <param-value>classpath:springmvc.xml</param-value>
                </init-param>
                <!--由于servlet是在第一次访问时才初始化，需要提前初始化读取配置文件-->
                <load-on-startup>1</load-on-startup>
            </servlet>
            <servlet-mapping>
                <servlet-name>springmvc</servlet-name>
                <url-pattern>/</url-pattern>
            </servlet-mapping>
        ```
    * 视图层的编写，编写页面，发送请求访问服务端进行交互 
        
        