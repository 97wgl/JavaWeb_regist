>�����������javawebӦ�ã��Ͼ�Ҳ�����֮������java����ʦ����·�������߲��ߵ�ͨ�Ժ���˵�ɡ����ã�����nodejs�Ļ��������ֻ���ͦ��ģ������ڹ�����Ҳ�����˲��ٵĿӡ�����������е�ʱ�����˸�ע�Ṧ�ܣ����������伤���˺š�

## ׼������

### �½�java web��Ŀ
�����õ���eclipse for j2ee,�ҽ�����һ��Dynamic Web Project
Ȼ�󴴽�����package��
- utils�� ����˼�壬���ǹ��ߣ������������һЩ�����ࣻ
- dao: ���ݽ���㣬˵���˾������������ݿ�����ģ�
- domain: ֻ���ʵ���࣬ÿһ�����Ӧһ��ʵ�壬����һ�����ݿ������
- servlet����ʵ���Ƿ���˵�java������ϰ��ֻдһЩ�������߼����룬�����ʵ�ֽ���service��ȥ��ɣ�
- service��ҵ��㣬��servlet�㽻�е���ȥ����ʵ�֣����ĵ��߼�������һ��

�������˿�����ô���ļ��е㷱����������һ��ע�Ṧ������ʵ��������Ŀ�ܣ�֮�����ҵ������Щ�ļ��С��м仹��һЩ��������ӿڱ�̵�˼�룬�����ں��������ܽ��ˡ�


### ����jar��
�����Ǽ���jar����`mail.jar`����Ǳ���ģ����ʼ�һ����������jar����Ȼ�����`mysql-connector-java-5.0.4-bin.jar`,��������mysql�õģ�mysql����webӦ�������̫���ʲ����ˡ��پ���Ϊ�˸�Ч��ҲΪ�˺��ڵ���չ��ά����ʹ��`c3p0`��`jdbcutils`���߰������ݿ������ԭʼ��jdbcҲ���ⲻ�󣬵���ε��ص㲻���⣬���Ծ�͵�˸�����

### ����ݿ�
���ݿⲻ��˵�ˣ����������ʲô���ݿⶼ�У�����ֻ�ǽ�һ���û����������mysql����Ϊ��ϰ���ˡ�

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

## ��������
��ʵ��һ��ע�ᣬ���ǱȽϼ򵥵ġ�
- 1�����ȣ��û�����ע����棬��д������Ϣ����ʱ����ֱ����ǰ���ж���Ϣ�Ƿ�Ϸ������������ʽ�����볤��֮��ģ���
- 2���û����ע�ᰴť����ʱҵ��㽫�û���д����Ϣ����DAO�㣬DAO���������ݿ��ж��û���Ϣ�Ƿ��ظ�������ֻ��Ҫ�����䣩�������ظ������ظ�ǰ̨��ʾ���ظ���Ϣ����
- 3��ȷ�������DAO��ʵ�ֲ��뷽�����û����ݴ浽���ݿ��У����û�ע��ɹ�����ʱservice�㷢��һ���ʼ���ע�����䡣ע�⿴������û���status�������û�״̬�Ƿ񱻼�����û�ע��ɹ���Ĭ�ϵ�״̬Ϊ0����δ����״̬��Ȼ��ҵ���ͨ��UUID��������64λ����룬��ӵ�code�ֶΣ������Ϊ����ļ���������׼����
- 4���û��յ��������䣬������뼴�ɼ���ɹ�����ʱ���û���״̬��0��Ϊ1���������code��