统一定时任务调度中心

目标：
  1. 任务部署及控制接口
    * 提供接口，通过http post部署,更新,删除,任务
  1. 任务控制
    * 手工触发，暂停/启动
  1. 调度方式
    * 通过URL定时调度
  1. 任务检测
    * 检测任务(如检测端口)是否可用
  1. 报警
    * 邮件报警
    * QQ
  1. 消息时效性
    * 消息从发送到接收处理，能容忍的最大时间跨度
  1. 消息可靠性
    * 指发送端，与接收端的消息一致性，即发送成功就一定能收到，或者发送不成功发送端业务一定能回滚掉
  1. 集群


URL调度:
```
  url: http://localhost:/job/weekjob(URL是否也可以作为ID）
  cron: 10 1 1 * * *
  descrption: 定时报表生成任务
  category: xxx系统(考虑是否可选)
  job-name: 唯一性ID(考虑是否可选)
```
调度时增加Http Header: X-Rapid-Cron: true

任务部署:
  1. http://jobserver/rapid-scheduler/newjob?url=xxx&cron=xxxx&description=xxxx
  1. xml
```
<jobs>
  <job>
    <url>http://localhost:/job/weekjob</url>
    <cron>10 1 1 * * *</cron>
    <description></description>
  </job>
</jobs>
```<jobs>
  <job>
    <url>http://localhost:/job/weekjob</url>
    <cron>10 1 1 * * *</cron>
    <description></description>
  </job>
</jobs>
}}}


子项目:scheduler-client-agent
通过这个agent运行命令行的命令，实现分布式job调用.
```