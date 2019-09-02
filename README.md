# eureka-server
erueka注册中心

> * 1、开启安全认证说明

>   >  具体可以查看 application.yml 配置文件中有对应的配置说明

> * 2、认证账号、密码，可以在环境变量中设定；
```
erueka.user
erueka.password
```


> * 3、关闭安全认证配置

>   > 需要在application.yml  配置文件中，修改defaultZone 的地址，具体修改如下：
```
 defaultZone: "http://localhost:${server.port}/eureka/"
```

> * 4、去除安全认证配置

>   > 需要在application.yml  配置文件中，修改一配置：
```
 1、修改注册中心地址：
 
     defaultZone: "http://localhost:${server.port}/eureka/"
     
 2、注释以下配置信息
 
   #spring:
   #  security:
   #    user:
   #      name: ${erueka.user:admin}
   #      password: ${erueka.password:admin001} 
   
 3、pom 文件中 spring-boot-starter-security 依赖去除
 4、对WebSecurityConfig 类进行删除
```

##################################

【注】：WebSecurityConfig 类在开启了 安全认证，必须存在，不然会出现client 无法注册上来的情况，启动会出现以下错误信息；

com.netflix.discovery.shared.transport.TransportException: Cannot execute request on any known server
	at com.netflix.discovery.shared.transport.decorator.RetryableEurekaHttpClient.execute(RetryableEurekaHttpClient.java:112) ~[eureka-client-1.9.3.jar:1.9.3]
	at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator.register(EurekaHttpClientDecorator.java:56) ~[eureka-client-1.9.3.jar:1.9.3]
	at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator$1.execute(EurekaHttpClientDecorator.java:59) ~[eureka-client-1.9.3.jar:1.9.3]
	at com.netflix.discovery.shared.transport.decorator.SessionedEurekaHttpClient.execute(SessionedEurekaHttpClient.java:77) ~[eureka-client-1.9.3.jar:1.9.3]
	at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator.register(EurekaHttpClientDecorator.java:56) ~[eureka-client-1.9.3.jar:1.9.3]
	at com.netflix.discovery.DiscoveryClient.register(DiscoveryClient.java:829) ~[eureka-client-1.9.3.jar:1.9.3]
	at com.netflix.discovery.InstanceInfoReplicator.run(InstanceInfoReplicator.java:121) [eureka-client-1.9.3.jar:1.9.3]
	at com.netflix.discovery.InstanceInfoReplicator$1.run(InstanceInfoReplicator.java:101) [eureka-client-1.9.3.jar:1.9.3]
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) [na:1.8.0_171]
	at java.util.concurrent.FutureTask.run$$$capture(FutureTask.java:266) [na:1.8.0_171]
	at java.util.concurrent.FutureTask.run(FutureTask.java) [na:1.8.0_171]
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180) [na:1.8.0_171]
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293) [na:1.8.0_171]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [na:1.8.0_171]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [na:1.8.0_171]
	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_171]
 
2018-09-03 21:12:02.126  WARN 5968 --- [nfoReplicator-0] c.n.discovery.InstanceInfoReplicator     : There was a problem with the instance info replicator
