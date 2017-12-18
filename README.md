>最近试着做做javaweb应用，毕竟也想好了之后先走java工程师这条路，至于走不走的通以后再说吧。还好，有着nodejs的基础，上手还是挺快的，但是在过程中也碰到了不少的坑。就这两天空闲的时候做了个注册功能，并且用邮箱激活账号。

## 准备工作

### 新建java web项目
这里用的是eclipse for j2ee,我建的是一个Dynamic Web Project
然后创建几个package：
- utils： 顾名思义，就是工具，这个包用来放一些工具类；
- dao: 数据接入层，说白了就是用来做数据库操作的；
- domain: 只存放实体类，每一个类对应一个实体，或者一张数据库基本表；
- servlet：其实就是服务端的java，但我习惯只写一些基本的逻辑代码，具体的实现交给service层去完成；
- service：业务层，将servlet层交托的事去具体实现，核心的逻辑都在这一层

可能有人看着这么多文件有点繁琐，不就是一个注册功能吗？其实这是整体的框架，之后添加业务还是这些文件夹。中间还有一些关于面向接口编程的思想，可能在后续慢慢总结了。


### 引入jar包
首先是几个jar包，`mail.jar`这个是必须的，发邮件一般就是用这个jar包，然后就是`mysql-connector-java-5.0.4-bin.jar`,这是连接mysql用的，mysql开发web应用真的是太合适不过了。再就是为了高效，也为了后期的拓展和维护，使用`c3p0`和`jdbcutils`工具包，数据库操作用原始的jdbc也问题不大，但这次的重点不在这，所以就偷了个懒。

### 搭建数据库
数据库不用说了，反正随便用什么数据库都行，而且只是建一个用户表。这里就用mysql，因为用习惯了。

```sql
/*
Navicat MySQL Data Transfer

Source Server         : wgl_mysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : registdemo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

## 具体流程
其实就一个注册，还是比较简单的。
- 1、首先，用户进入注册界面，填写个人信息，这时可以直接在前端判断信息是否合法（比如邮箱格式，密码长度之类的）；
- 2、用户点击注册按钮，这时业务层将用户填写的信息传给DAO层，DAO层连接数据库判断用户信息是否重复（这里只需要看邮箱），若有重复，返回给前台提示“重复信息”；
- 3、确认无误后，DAO层实现插入方法将用户数据存到数据库中，即用户注册成功，这时service层发送一封邮件给注册邮箱。注意看上面的用户表，status属性是用户状态是否被激活，在用户注册成功后默认的状态为0，即未激活状态，然后业务层通过UUID方法生成64位随机码，添加到code字段，这就是为后面的激活链接做准备。
- 4、用户收到激活邮箱，点击进入即可激活成功。此时将用户的状态由0改为1，并且清空code。