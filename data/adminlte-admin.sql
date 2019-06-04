/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : adminlte-admin

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-04 15:10:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_blog`
-- ----------------------------
DROP TABLE IF EXISTS `app_blog`;
CREATE TABLE `app_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `catalog_id` bigint(20) DEFAULT NULL,
  `title` varchar(50) NOT NULL COMMENT '标题',
  `content` longtext NOT NULL COMMENT '内容',
  `summary` varchar(300) NOT NULL COMMENT '简介',
  `html_content` longtext NOT NULL,
  `tags` varchar(100) DEFAULT NULL COMMENT '标签',
  `read_size` int(11) DEFAULT NULL COMMENT '浏览数量',
  `comment_size` int(11) DEFAULT NULL COMMENT '评论数量',
  `vote_size` int(11) DEFAULT NULL COMMENT '点赞数量',
  `state` int(11) DEFAULT '1' COMMENT '可用状态 ： 1：可用、0：不可用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `FKefps36p8dyf3t7yjmic1v0jcs` (`catalog_id`),
  KEY `FKpxk2jtysqn41oop7lvxcp6dqq` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_blog
-- ----------------------------
INSERT INTO `app_blog` VALUES ('4', '1', '1', 'Java 测试', 'ES是一个基于Lucene的分布式全文搜索服务器。windows系统下安装教程https://www.cnblogs.com/ljhdo/p/4887557.html\n相关下载链接：//download.csdn.net/download/kikibingo/10430799?utm_source=bbsseo\n\n![](//localhost:8081/view/5cecc76954b4d81df018177a) \n\n![](//localhost:8081/view/5cecc77154b4d81df018177b) \n安装head插件\n为了便于管理ES，使用head插件，即可在浏览器中显示ES集群，索引等信息，十分好用。\n\n下载地址： https://github.com/mobz/elasticsearch-head\nelasticsearch-head介绍：https://mobz.github.io/elasticsearch-head/\n将下载的包解压后上传到elasticsearch安装目录的plugins目录下,本文的地址为\n/usr/local/es/elasticsearch-2.4.4/plugins\n将插件的名字改成head\n访问http://192.168.0.127:9200/_plugin/head/\n即在原来的地址栏上加/_plugin/head/，访问结果如下：(为了服务器安全性，此处将ip模糊掉)\n--------------------- \n作者：我是周小福 \n来源：CSDN \n原文：https://blog.csdn.net/Majker/article/details/83629169 \n版权声明：本文为博主原创文章，转载请附上博文链接！', 'Java测试地方房价高得换个风格和梵蒂冈和刘德华是挂号费过或多付或过多付过或或绿或或或或或 会返回红包红包', '<p>ES是一个基于Lucene的分布式全文搜索服务器。windows系统下安装教程https://www.cnblogs.com/ljhdo/p/4887557.html\n相关下载链接：//download.csdn.net/download/kikibingo/10430799?utm_source=bbsseo</p>\n<p><img src=\"//localhost:8081/view/5cecc76954b4d81df018177a\" alt=\"\" /></p>\n<p><img src=\"//localhost:8081/view/5cecc77154b4d81df018177b\" alt=\"\" />\n安装head插件\n为了便于管理ES，使用head插件，即可在浏览器中显示ES集群，索引等信息，十分好用。</p>\n<p>下载地址： https://github.com/mobz/elasticsearch-head\nelasticsearch-head介绍：https://mobz.github.io/elasticsearch-head/\n将下载的包解压后上传到elasticsearch安装目录的plugins目录下,本文的地址为\n/usr/local/es/elasticsearch-2.4.4/plugins\n将插件的名字改成head\n访问http://192.168.0.127:9200/_plugin/head/</p>\n<h2>即在原来的地址栏上加/_plugin/head/，访问结果如下：(为了服务器安全性，此处将ip模糊掉)</h2>\n<p>作者：我是周小福\n来源：CSDN\n原文：https://blog.csdn.net/Majker/article/details/83629169\n版权声明：本文为博主原创文章，转载请附上博文链接！</p>\n', 'java,测试,es', '3', '0', '0', '1', '2019-05-28 05:31:28', null);
INSERT INTO `app_blog` VALUES ('5', '1', '1', '最值得收藏的java技术博客（Java篇）', '第一个：java_my_life\n\n作者介绍：找不到原作者信息。大概做了翻阅全部是2012年的博客。\n\n博客主要内容：主要内容是关于Java设计模式的一些讲解和学习笔记，在相信对学习设计模式的同学帮助很大。在一望无际的Java博文中有那么一两篇JavaScript文章，就算两篇Javascript的质量不是很高，其它教程也是能很好的帮助到在学习中的朋友。\n\n博客关键词：JAVA与模式、简单工厂模式、工厂方法、抽象工厂、单例、建造、原型、适配器、合成、迭代、观察者、模板方法、策略、不变、桥梁、门面、代理...模式。\n\n第二个：java小强博客  或者（java小强 - ITeye技术网站） \n\n作者介绍：java小强，签名：没有思考，人生的路会越走越难！\n\n博客主要内容：从Java基础到深入解读，从理论到实战。一些开源框架的解读。以及一些其它的内容：PHP、JS、Linux等等。如果你热爱后端，想从事后端开发，这一博客会使一个很好的选择，无论你处于那种学习状态他都可以在一定程度上帮助到你。\n\n博客关键词：java、j2ee、网络编程、数据库、代码、PHP、Javascript、Linux\n\n第三个：java个人博客\n\n作者介绍：毕业于湖南科技大学，到现在从事java相关工作\n\n博客主要内容：该博客主要包括Java技术和Hadoop以及数据结构和算法。\n\n博客关键词：Java、Hadoop、web前台技术、数据结构和算法、Javascript\n\n第四个：ImportNew - 专注Java & Android 技术分享\n\n介绍：Java从基础入门到深入到更深入，汇集了各种关于Java的学习资料。发布以及Java行业最新的资讯。\n\n关键词：Java书籍、Java基础技术、Java教程、架构、Java Web、工具资源\n\n第五个：deepinmind的技术博客\n\n作者介绍：花名有孚，支付宝工程师，个人博客：Java译站的微博\n\n博客介绍：关注发现Java的一些新特性，研究Java某些机制的实现细节。深入解读Java的一些知识点。程序员一生的一些感悟。整理了一些Java的面试鄙视题目，简单介绍了一些Java的安全问题。适合任何阶段朋友阅读。\n\n关键词：Java安全、Java垃圾回收、Java内存、Java新特性\n\n第六个：Java文章列表\n\n作者介绍：85后，出生于东北，毕业于大连理工大学，现为生计漂于北京。96年首次接触个人计算机（微机），用过DOS和Windows3.2 。97年用Logo语言参加全国信息学竞赛。98年首次用IE4接触到互联网。毕业后，参与到创业公司兰亭集势。后奔赴杭州加入阿里巴巴，2012年调岗阿里巴巴集团北京研发部门，目前任职于支付宝钱包开发团队。\n\n博客主要内容：从Java诞生到Java API和JDK的分析，再到对整个Java技术的理解、应用开发过程中的面向对象设计，还有对Java发展的关注等。\n\n关键词：JavaIO、内存管理、HashMap、Java多线程\n\n第七个：HollisChuang\'s Blog-Java干货集散地\n\n作者介绍：微博：Hollis_Chuang的微博\n\n博客主要内容：此博客很适合各个阶段学习Java的朋友，从内容到排版无一不让在朋友在学习过程中享受，一边享受一边学习。丰富的资源、精美的技术干货希望可以帮助在学习之路上的你。\n\n关键词：数据库、Java设计模式、Java框架、Java基础\n\n第八个：智慧演绎，无处不在\n\n博客主要内容：此博客包含内容相当多的内容，从Java（初级、中级、高级、多线程、J2EE）到Linux到数据结构到面试&算法到DB2到spring到Hadoop 。当然以Java资源居多。并且讲解的非常详细有深度。\n\n关键词：J2EE、DB2、Spring、Hadoop\n\n第九个：并发编程网\n\n博客主要内容：此博客长期以来一直受大家追捧。博文主要以翻译为主。内容方便相对来说不适合初学者使用。适合掌握一定知识的程序员阅读。此博客更新频率快、内容较新，如果你对前沿很感兴趣追求卓越一定少不了此博客。\n\n关键词： Scala 、slf4j 、Spark官方文档、多线程、Apache\n\n第十个：码友十八年\n\n博客主要内容：分享Java技术学习文章，包括，java基础，java高阶，ES及Luecen 全文检索的学习文章， 读书心得，redis学习文章整理，RPC框架讲解，Linux命令大全整理500多linux命令等详细讲解等 技术学习分享文章\n\n关键词：java技术分享、Linux命令大全（学习手册）\n![](//localhost:8081/view/5cecc8dc54b4d81df018177c) \n', '作者介绍：找不到原作者信息。大概做了翻阅全部是2012年的博客。\n博客主要内容：主要内容是关于Java设计模式的一些讲解和学习笔记，在相信对学习设计模式的同学帮助很大。在一望无际的Java博文中有那么一两篇JavaScript文章，就算两篇Javascript的质量不是很高，其它教程也是能很好的帮助到在学习中的朋友。\n博客关键词：JAVA与模式、简单工厂模式、工厂方法、抽象工厂、单例、建造、原型、适配器、合成、迭代、观察者、模板方法、策略、不变、桥梁、门面、代理...模式。', '<p>第一个：java<em>my</em>life</p>\n<p>作者介绍：找不到原作者信息。大概做了翻阅全部是2012年的博客。</p>\n<p>博客主要内容：主要内容是关于Java设计模式的一些讲解和学习笔记，在相信对学习设计模式的同学帮助很大。在一望无际的Java博文中有那么一两篇JavaScript文章，就算两篇Javascript的质量不是很高，其它教程也是能很好的帮助到在学习中的朋友。</p>\n<p>博客关键词：JAVA与模式、简单工厂模式、工厂方法、抽象工厂、单例、建造、原型、适配器、合成、迭代、观察者、模板方法、策略、不变、桥梁、门面、代理...模式。</p>\n<p>第二个：java小强博客  或者（java小强 - ITeye技术网站）</p>\n<p>作者介绍：java小强，签名：没有思考，人生的路会越走越难！</p>\n<p>博客主要内容：从Java基础到深入解读，从理论到实战。一些开源框架的解读。以及一些其它的内容：PHP、JS、Linux等等。如果你热爱后端，想从事后端开发，这一博客会使一个很好的选择，无论你处于那种学习状态他都可以在一定程度上帮助到你。</p>\n<p>博客关键词：java、j2ee、网络编程、数据库、代码、PHP、Javascript、Linux</p>\n<p>第三个：java个人博客</p>\n<p>作者介绍：毕业于湖南科技大学，到现在从事java相关工作</p>\n<p>博客主要内容：该博客主要包括Java技术和Hadoop以及数据结构和算法。</p>\n<p>博客关键词：Java、Hadoop、web前台技术、数据结构和算法、Javascript</p>\n<p>第四个：ImportNew - 专注Java &amp; Android 技术分享</p>\n<p>介绍：Java从基础入门到深入到更深入，汇集了各种关于Java的学习资料。发布以及Java行业最新的资讯。</p>\n<p>关键词：Java书籍、Java基础技术、Java教程、架构、Java Web、工具资源</p>\n<p>第五个：deepinmind的技术博客</p>\n<p>作者介绍：花名有孚，支付宝工程师，个人博客：Java译站的微博</p>\n<p>博客介绍：关注发现Java的一些新特性，研究Java某些机制的实现细节。深入解读Java的一些知识点。程序员一生的一些感悟。整理了一些Java的面试鄙视题目，简单介绍了一些Java的安全问题。适合任何阶段朋友阅读。</p>\n<p>关键词：Java安全、Java垃圾回收、Java内存、Java新特性</p>\n<p>第六个：Java文章列表</p>\n<p>作者介绍：85后，出生于东北，毕业于大连理工大学，现为生计漂于北京。96年首次接触个人计算机（微机），用过DOS和Windows3.2 。97年用Logo语言参加全国信息学竞赛。98年首次用IE4接触到互联网。毕业后，参与到创业公司兰亭集势。后奔赴杭州加入阿里巴巴，2012年调岗阿里巴巴集团北京研发部门，目前任职于支付宝钱包开发团队。</p>\n<p>博客主要内容：从Java诞生到Java API和JDK的分析，再到对整个Java技术的理解、应用开发过程中的面向对象设计，还有对Java发展的关注等。</p>\n<p>关键词：JavaIO、内存管理、HashMap、Java多线程</p>\n<p>第七个：HollisChuang\'s Blog-Java干货集散地</p>\n<p>作者介绍：微博：Hollis_Chuang的微博</p>\n<p>博客主要内容：此博客很适合各个阶段学习Java的朋友，从内容到排版无一不让在朋友在学习过程中享受，一边享受一边学习。丰富的资源、精美的技术干货希望可以帮助在学习之路上的你。</p>\n<p>关键词：数据库、Java设计模式、Java框架、Java基础</p>\n<p>第八个：智慧演绎，无处不在</p>\n<p>博客主要内容：此博客包含内容相当多的内容，从Java（初级、中级、高级、多线程、J2EE）到Linux到数据结构到面试&amp;算法到DB2到spring到Hadoop 。当然以Java资源居多。并且讲解的非常详细有深度。</p>\n<p>关键词：J2EE、DB2、Spring、Hadoop</p>\n<p>第九个：并发编程网</p>\n<p>博客主要内容：此博客长期以来一直受大家追捧。博文主要以翻译为主。内容方便相对来说不适合初学者使用。适合掌握一定知识的程序员阅读。此博客更新频率快、内容较新，如果你对前沿很感兴趣追求卓越一定少不了此博客。</p>\n<p>关键词： Scala 、slf4j 、Spark官方文档、多线程、Apache</p>\n<p>第十个：码友十八年</p>\n<p>博客主要内容：分享Java技术学习文章，包括，java基础，java高阶，ES及Luecen 全文检索的学习文章， 读书心得，redis学习文章整理，RPC框架讲解，Linux命令大全整理500多linux命令等详细讲解等 技术学习分享文章</p>\n<p>关键词：java技术分享、Linux命令大全（学习手册）\n<img src=\"//localhost:8081/view/5cecc8dc54b4d81df018177c\" alt=\"\" /></p>\n', 'Java,J2EE,Spring', '13', '1', '1', '1', '2019-05-28 05:36:59', null);

-- ----------------------------
-- Table structure for `app_blog_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `app_blog_catalog`;
CREATE TABLE `app_blog_catalog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '可用状态： 1：可用 、0：不可用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `FKk3mprwb52pe5lfv3l2xpmwj8s` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_blog_catalog
-- ----------------------------
INSERT INTO `app_blog_catalog` VALUES ('1', 'Java', '1', '1', null, null);
INSERT INTO `app_blog_catalog` VALUES ('2', '分布式', '1', '1', null, null);
INSERT INTO `app_blog_catalog` VALUES ('3', 'test', '2', '1', null, null);

-- ----------------------------
-- Table structure for `app_blog_comment`
-- ----------------------------
DROP TABLE IF EXISTS `app_blog_comment`;
CREATE TABLE `app_blog_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID编号',
  `blog_id` bigint(20) NOT NULL COMMENT '博客ID编号',
  `content` varchar(500) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '评论状态： 1：有效， 0：无效（或已被删除）',
  `create_time` datetime DEFAULT NULL COMMENT '评论创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '评论修改时间',
  PRIMARY KEY (`id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_blog_comment
-- ----------------------------
INSERT INTO `app_blog_comment` VALUES ('1', '2', '0', '好文章， 我喜欢', '1', '2019-05-28 06:02:16', null);

-- ----------------------------
-- Table structure for `app_blog_vote`
-- ----------------------------
DROP TABLE IF EXISTS `app_blog_vote`;
CREATE TABLE `app_blog_vote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '点赞状态 1：有效 ， 0：无效（已被删除）',
  `blog_id` bigint(20) NOT NULL COMMENT '博客ID编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID编号',
  `state` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '点赞创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '点赞修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nmdrm82d80oq7pw0ab20pia23` (`user_id`),
  KEY `FKaar8kqti49vaol2nw9e42lgxc` (`blog_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_blog_vote
-- ----------------------------
INSERT INTO `app_blog_vote` VALUES ('1', '5', '1', '0', null, null);

-- ----------------------------
-- Table structure for `app_news`
-- ----------------------------
DROP TABLE IF EXISTS `app_news`;
CREATE TABLE `app_news` (
  `id` varchar(50) NOT NULL COMMENT '新闻唯一编号',
  `title` varchar(100) NOT NULL COMMENT '新闻标题',
  `subtitle` varchar(100) NOT NULL COMMENT '新闻副标题',
  `author_id` varchar(50) NOT NULL COMMENT '新闻编辑者ID',
  `classify_id` varchar(50) NOT NULL COMMENT '新闻分类ID',
  `type_id` varchar(50) NOT NULL COMMENT '新闻类型ID',
  `sammary` varchar(512) DEFAULT NULL COMMENT '新闻简介',
  `content` longtext COMMENT '新闻正文',
  `link` varchar(255) DEFAULT NULL COMMENT '新闻URL地址',
  `cover_image` varchar(255) DEFAULT NULL COMMENT '新闻封面图片URL地址',
  `read_number` int(11) NOT NULL DEFAULT '0' COMMENT '阅读人数',
  `create_time` datetime DEFAULT NULL COMMENT '上传/创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新/编辑时间',
  `top_state` int(11) NOT NULL DEFAULT '1' COMMENT '头条状态: 1: 不是头条新闻 、 2：是头条新闻',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '新闻状态、0 ： 非正常状态、已被删除 ，  1：初始状态、待审核 ， 2 ： 正常状态、已通过了审核 ， 3 ：非正常状态、未通过审核 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='APP新闻表';

-- ----------------------------
-- Records of app_news
-- ----------------------------
INSERT INTO `app_news` VALUES ('20270497d0c848febd3102d00d7e4cf1', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', '撒大声地所多所多所多所hhshshshhshhhhshhhshshhshshshsss', '<p>&nbsp; &nbsp; &nbsp; &nbsp;dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\r\n &nbsp; &nbsp;<img src=\"/file/ueditor/jsp/upload/image/20190215/1550195619670059516.jpg\" title=\"1550195619670059516.jpg\" alt=\"WeChat Image_20190108104045.jpg\"/></p>', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 14:33:46', '2019-02-15 09:54:05', '1', '1');
INSERT INTO `app_news` VALUES ('24198a68b1e94f07947b03b625b453b1', 'Actualite Title', 'Actualite Sous-Titre', 'Dieudonne', '23', '23', 'dsaafdfdfdsfsdfdsfdsfdsfdsfdfdsfdsfdsfdsfdsfdfdsf', '<p style=\"text-align: center;\"><br/></p><p style=\"text-align: center;\"><img src=\"/file/ueditor/jsp/upload/image/20190528/1559027177867049066.jpg\" title=\"1559027177867049066.jpg\"/></p><p style=\"text-align: center;\"><img src=\"/file/ueditor/jsp/upload/image/20190528/1559027177913086922.jpg\" title=\"1559027177913086922.jpg\"/></p><p style=\"text-align: center;\"><img src=\"/file/ueditor/jsp/upload/image/20190528/1559027177920045129.jpg\" title=\"1559027177920045129.jpg\"/></p><p style=\"text-align: center;\">akdsajdaskjadsfjafjadsdfjajdjadjasjdad</p><p style=\"text-align: center;\"><br/></p>', 'www.baidu.com', 'www.img.com', '0', '2019-05-28 15:07:17', '2019-05-28 15:09:56', '1', '1');
INSERT INTO `app_news` VALUES ('27a9b12a60ed4d83b1d3f3165be517b1', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 14:50:40', '2019-01-09 14:50:40', '1', '1');
INSERT INTO `app_news` VALUES ('3e4613786b014d619ee5b4651f49631d', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', 'dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 14:37:08', '2019-01-09 14:37:08', '1', '1');
INSERT INTO `app_news` VALUES ('40c269f565f148bf847b04c029ea08fb', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '', 'www.google.com', 'img.www.google.com', '0', '2019-01-10 11:42:02', '2019-01-10 11:42:02', '1', '1');
INSERT INTO `app_news` VALUES ('42bdc21e0b594884a191afc6aef68d01', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '<p>b</p>', 'www.google.com', 'img.www.google.com', '0', '2019-01-10 11:44:48', '2019-01-10 11:44:48', '1', '1');
INSERT INTO `app_news` VALUES ('43b88d936a054b6e8d0efcff6ef4ba75', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '', 'www.google.com', 'img.www.google.com', '0', '2019-01-10 11:24:48', '2019-01-10 11:24:48', '1', '1');
INSERT INTO `app_news` VALUES ('4febb186c15d46e3a9474ff783189289', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '<p>是的撒大大所大所大所大多发的鬼地方个梵蒂冈股份非官方个电饭锅电饭锅公分高大哥大法官的郭德纲</p>', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 15:04:30', '2019-01-09 15:04:30', '1', '1');
INSERT INTO `app_news` VALUES ('8161328e4dd249518622ed182c3ef8ea', '有图片', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '<p><img src=\"/file/ueditor/jsp/upload/image/20190109/1547017291952039162.jpg\" title=\"1547017291952039162.jpg\" alt=\"WeChat Image_20190108104045.jpg\"/></p>', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 15:01:39', '2019-01-09 15:01:39', '1', '1');
INSERT INTO `app_news` VALUES ('81e6476d325745caafd636998888e32a', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', 'dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 09:57:44', '2019-01-09 09:57:44', '1', '1');
INSERT INTO `app_news` VALUES ('9b33c54c2f2d4d449974c947561229f3', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'hdfhdfhkdfhdhfdsfhhsdfhdshfsfhfhdjhfhfdjjhfhhf', '<p>&nbsp; &nbsp; &nbsp; &nbsp;dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\r\n &nbsp; &nbsp;<img src=\"/file/ueditor/jsp/upload/image/20190215/1550195038422067969.jpg\" title=\"1550195038422067969.jpg\" alt=\"WeChat Image_20190108104045.jpg\"/></p>', 'www.google.com', 'img.www.google.com', '0', '2019-02-15 09:44:19', '2019-02-15 09:44:19', '1', '1');
INSERT INTO `app_news` VALUES ('9ce24973d2824c3c8c4e7152a7198423', 'aaa', 'aaa', '3', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', 'dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 14:35:54', '2019-01-09 14:35:54', '1', '1');
INSERT INTO `app_news` VALUES ('be1b5e3f57074619b5b2a1e9dc73203f', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 14:47:09', '2019-01-09 14:47:09', '1', '1');
INSERT INTO `app_news` VALUES ('be633eece4184967a7bbf0e4f3b768d7', '有图片', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '<p><img src=\"/file/ueditor/jsp/upload/image/20190110/1547091488637039803.jpg\" title=\"1547091488637039803.jpg\" alt=\"WeChat Image_20190108104045.jpg\"/></p>', 'www.google.com', 'img.www.google.com', '0', '2019-01-10 11:38:15', '2019-01-10 11:38:15', '1', '1');
INSERT INTO `app_news` VALUES ('cafabc18b63e487a8e04ffa2f7f072fa', '有图片', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '<p><img src=\"/file/ueditor/jsp/upload/image/20190109/1547017291952039162.jpg\" title=\"1547017291952039162.jpg\" alt=\"WeChat Image_20190108104045.jpg\"/></p>', 'www.google.com', 'img.www.google.com', '0', '2019-01-09 15:01:39', '2019-01-09 15:01:39', '1', '1');
INSERT INTO `app_news` VALUES ('e16dcb7bda1440609f348eb07a9b5d88', 'dafsfdsfds', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '', 'www.google.com', 'img.www.google.com', '0', '2019-01-10 11:08:22', '2019-01-10 11:08:22', '1', '1');
INSERT INTO `app_news` VALUES ('ecbbf93b34974fbfbd526e13803179fc', '有图片', '等我的请问请问', '2', '2', '2', 'dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk', '<p><img src=\"/file/ueditor/jsp/upload/image/20190110/1547091819909034666.jpg\" title=\"1547091819909034666.jpg\" alt=\"WeChat Image_20190108104045.jpg\"/></p>', 'www.google.com', 'img.www.google.com', '0', '2019-01-10 11:43:46', '2019-01-10 11:43:46', '1', '1');
INSERT INTO `app_news` VALUES ('wwewewd3435453454dfddf', 'title', 'subtitle', '1', '1', '1', 'cfdsfdsfdsfdsfdsfdsf', 'sdfdsfdsfdsfdsfdsf', 'baidu.com', 'img.baidu.com', '0', '2019-01-08 16:44:38', '2019-01-08 16:44:42', '1', '1');

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `deptName` varchar(100) NOT NULL COMMENT '部门名称',
  `deptDesc` varchar(300) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('3e7a8ac167b3402b90cbe2db692fd6c4', '产品部1', 'dfdfdsfsdfs额外服务范围');
INSERT INTO `sys_dept` VALUES ('9a329b597d754c4180c6b40cdfb0f565', '产品部', '都是公司股份等十多个');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `userName` varchar(50) NOT NULL COMMENT '用户',
  `title` varchar(300) DEFAULT NULL COMMENT '日志',
  `url` varchar(300) DEFAULT NULL COMMENT '地址',
  `params` text COMMENT '参数',
  `createTime` datetime DEFAULT NULL COMMENT '日志时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('011af64a3ed84bc282c440018b56a2b1', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 14:39:41');
INSERT INTO `sys_log` VALUES ('0223b750963a40da9bbbc2ba38f28f79', 'admin', '更新系统设置', '/system/setting/doSetting', '{\"sysValue\":[\"Dieudo-admin\",\"后台管理系统V1.0\",\"Copyright © 2018 XXX管理有限公司. All rights reserved.\"],\"id\":[\"1\",\"2\",\"3\"]}', '2018-12-04 11:47:10');
INSERT INTO `sys_log` VALUES ('023cb8436b67453fb1dd9cc9f0a59781', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"]}', '2019-01-09 14:37:08');
INSERT INTO `sys_log` VALUES ('04bd565e916d43028ef9962edde46b31', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-08 17:33:00');
INSERT INTO `sys_log` VALUES ('084fd0009d634dfa854b70abcafc124c', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-28 16:56:10');
INSERT INTO `sys_log` VALUES ('08c59d5206db42bb96693e88524db7ea', 'admin', 'Modifier le menu', '/system/menu/doEdit', '{\"code\":[\"080102\"],\"menuname\":[\"Modification de l\\u0027actualite\"],\"resource\":[\"editNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"id\":[\"6218886c12664b69bae31611865fc150\"],\"sort\":[\"4\"]}', '2018-12-20 11:29:31');
INSERT INTO `sys_log` VALUES ('0934f4d5075443d8a17f0e7a710c59d0', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-05 11:13:17');
INSERT INTO `sys_log` VALUES ('0c4988a36efd4904b72af91a9937a697', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"]}', '2019-01-10 11:42:02');
INSERT INTO `sys_log` VALUES ('0cc76c6b63284e3f816b43961525d54b', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 12:23:58');
INSERT INTO `sys_log` VALUES ('141b762bf07a40a0a732cfde03d47237', 'admin', '用户登录成功', '/login/doLogin', '', '2018-11-30 16:50:04');
INSERT INTO `sys_log` VALUES ('173b4a609ca74a9d97cdac073d9fffbb', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-06 17:52:02');
INSERT INTO `sys_log` VALUES ('177c1be614c245b4a5103de03b2bd40b', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 09:56:51');
INSERT INTO `sys_log` VALUES ('17c040b8c58f4afaa0923d5685f6caa5', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003efkghjkfkkhkjkhjkhjk\\u003c/p\\u003e\"]}', '2019-01-10 11:24:48');
INSERT INTO `sys_log` VALUES ('17c0b09206ec4be598659145b0b4316a', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"]}', '2019-01-10 11:08:22');
INSERT INTO `sys_log` VALUES ('17e5e809a24e4392b6ad702de8b1441e', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 11:18:44');
INSERT INTO `sys_log` VALUES ('18e5658caad34e15a7168480a87d9117', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-19 16:49:57');
INSERT INTO `sys_log` VALUES ('1a9127c9e8f9467299859b7a6899da07', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-28 14:59:21');
INSERT INTO `sys_log` VALUES ('1b774e7deae94844949886ec0adb0a66', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-10 16:47:09');
INSERT INTO `sys_log` VALUES ('1c9948374b5743459e08c9ea6e3666e3', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-28 17:13:04');
INSERT INTO `sys_log` VALUES ('1d26b0a7b5ea4611a6c3b6ab1c2af832', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"]}', '2019-01-09 09:57:44');
INSERT INTO `sys_log` VALUES ('22643d5664594356a21f765ff6359576', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-10 11:07:05');
INSERT INTO `sys_log` VALUES ('2284bff4c6974466b068ca50145d857b', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 12:09:36');
INSERT INTO `sys_log` VALUES ('256f638db03c4a8dba890b45195b67a1', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-03 11:32:36');
INSERT INTO `sys_log` VALUES ('259bffe961704ffa979a255b6d444af0', 'admin', 'Création du menu', '/system/menu/doAddMenu', '{\"code\":[\"08-01\"],\"menuname\":[\"Actualites\"],\"icon\":[\"fa-file\"],\"pid\":[\"f417a2a4ead048379a0c60c04ac42012\"],\"sort\":[\"1\"],\"url\":[\"/system/app-news/list/1\"]}', '2018-12-20 09:43:20');
INSERT INTO `sys_log` VALUES ('26a6bf8ac17d4050ae9ba36e4af2abfd', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 09:28:42');
INSERT INTO `sys_log` VALUES ('28aa4898706846d1b61664a5f8122308', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"hdfhdfhkdfhdhfdsfhhsdfhdshfsfhfhdjhfhfdjjhfhhf\"],\"content\":[\"\\u003cp\\u003e\\u0026nbsp; \\u0026nbsp; \\u0026nbsp; \\u0026nbsp;dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\\r\\n \\u0026nbsp; \\u0026nbsp;\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190215/1550195038422067969.jpg\\\" title\\u003d\\\"1550195038422067969.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u0026nbsp; \\u0026nbsp; \\u0026nbsp; \\u0026nbsp;dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\\r\\n \\u0026nbsp; \\u0026nbsp;\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190215/1550195038422067969.jpg\\\" title\\u003d\\\"1550195038422067969.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"]}', '2019-02-15 09:44:19');
INSERT INTO `sys_log` VALUES ('28f35587688b4c46b490bba03ea5dbb6', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 10:34:31');
INSERT INTO `sys_log` VALUES ('2cf16bc1528d4ef28334bbce2762f878', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 10:03:48');
INSERT INTO `sys_log` VALUES ('2cf8279c055b4830bf2369c18ef94eec', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-09 10:03:25');
INSERT INTO `sys_log` VALUES ('2da234a58d074d67a772c0a9e9239b47', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 09:50:51');
INSERT INTO `sys_log` VALUES ('2ef3225d3b84434585da0791a1cb47e3', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-04 10:43:04');
INSERT INTO `sys_log` VALUES ('347d2cf7f369476cb556a86fe02eaa91', 'admin', '用户登录成功', '/login/doLogin', '', '2018-11-30 17:59:17');
INSERT INTO `sys_log` VALUES ('371af6593aff47e9836780f7d2955b0b', 'admin', 'Modifier le menu', '/system/menu/doEdit', '{\"code\":[\"080104\"],\"menuname\":[\"Modification de l\\u0027actualite\"],\"resource\":[\"editNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"id\":[\"6218886c12664b69bae31611865fc150\"],\"sort\":[\"4\"]}', '2018-12-20 11:30:23');
INSERT INTO `sys_log` VALUES ('377df1be5e1c4f3e9d50947d4cf513c1', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"Actualite Title\"],\"subtitle\":[\"Actualite Sous-Titre\"],\"authorId\":[\"Dieudonne\"],\"classifyId\":[\"23\"],\"typeId\":[\"23\"],\"sammary\":[\"dsaafdfdfdsfsdfdsfdsfdsfdsfdfdsfdsfdsfdsfdsfdfdsf\"],\"content\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177867049066.jpg\\\" title\\u003d\\\"1559027177867049066.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177913086922.jpg\\\" title\\u003d\\\"1559027177913086922.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177920045129.jpg\\\" title\\u003d\\\"1559027177920045129.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp\\u003e\\u003cbr/\\u003e\\u003c/p\\u003e\"],\"link\":[\"www.baidu.com\"],\"coverImage\":[\"www.img.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177867049066.jpg\\\" title\\u003d\\\"1559027177867049066.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177913086922.jpg\\\" title\\u003d\\\"1559027177913086922.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177920045129.jpg\\\" title\\u003d\\\"1559027177920045129.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp\\u003e\\u003cbr/\\u003e\\u003c/p\\u003e\"]}', '2019-05-28 15:07:17');
INSERT INTO `sys_log` VALUES ('3835bc51c5fd432c8a9e4bf4b0e673e7', 'admin', '更新系统设置', '/system/setting/doSetting', '{\"sysValue\":[\"Dieudo-admin\",\"后台管理系统V1.03\",\"Copyright © 2018 XXX管理有限公司. All rights reserved.\"],\"id\":[\"1\",\"2\",\"3\"]}', '2018-12-04 12:33:48');
INSERT INTO `sys_log` VALUES ('3a759fbcd82d4418a8a682ef467c390c', 'admin', '用户登录成功', '/login/doLogin', '', '2018-11-26 15:15:15');
INSERT INTO `sys_log` VALUES ('3bfbf07f1ed84000b5782faafceb8973', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"]}', '2019-01-08 17:33:23');
INSERT INTO `sys_log` VALUES ('442b5be6d0b5477ea57cb37d0739c38f', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 09:41:28');
INSERT INTO `sys_log` VALUES ('479af305e36544dc817f84eb9b8fd791', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"aaa\"],\"subtitle\":[\"aaa\"],\"authorId\":[\"3\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"]}', '2019-01-09 14:35:55');
INSERT INTO `sys_log` VALUES ('4822b60b0c304a5c92995973657c58c4', 'admin', 'Nouveau fonctionnel menu', '/system/menu/doAddAction', '{\"code\":[\"080101\"],\"menuname\":[\"Liste de l\\u0027actualite\"],\"resource\":[\"editNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"sort\":[\"4\"]}', '2018-12-20 11:05:52');
INSERT INTO `sys_log` VALUES ('489c6b72adac440f9b61be2cbecaa2f0', 'admin', 'Attribution de l\'autorisation compétences', '/system/role/doAuth', '{\"roleid\":[\"b1f9ce5543a049be9f169a3f5e6b72a8\"],\"mid[]\":[\"1\",\"2\",\"d2bc30feb5474a1bb7e02d48d39a3f8a\",\"a73802e513cc4465883530ec8074abbb\",\"4253190001c1480fb0d631d64d150535\",\"649b484b58414d91aefa5a26143e6557\",\"3\",\"1db9105008404a3485b6fac30dba3c0e\",\"60dda993d87647f5989c15f14f866df9\",\"686630c7cb624cc786dcdc9958971a6b\",\"b4e7232189b14cf3ba160cf7b0d3bf37\",\"a5ebf29168234406939856bc6890c86b\",\"f899f3d3baec4571b1c786717f9906fd\",\"4\",\"488ef1eff57b4827acade7c0744278ce\",\"3f26102ef0e04c3c9328cb97067cc5fa\",\"dc5f478d98ed4297a8ae638fe90df050\",\"0c9b5fc8b44b41d1871a8fc8300247ec\",\"22e38e885f9b40b9aae6a36deb78e89c\",\"4e816a9854714d24b0413d929d637a2b\",\"3fb6a7a5935b4efabf3de82e7e1baeb6\",\"363a778e78a346a68210b2590163a943\",\"79d78b8357174cac8f44abd275dec597\",\"5\",\"5d3dd56c16ff4e32aecae1b3228159c7\",\"10\",\"0818e1c76bbd44eba3a698547ec4e637\",\"915c309ebe5047b68645b3eb777dd8c9\",\"f5a20c82110b4a3ea9e30ca01a038680\",\"42dd5ae31e3a43b3a197440e8ec19a94\",\"476dbef5152040668acffbdb5683d49d\",\"c6bfb8c2d70b4b57a7da69b8b20538a4\",\"3da0154b4b4a4303bfc508f3d7e452db\",\"d9c96546f5c74f87a86c3febed252f4b\",\"f417a2a4ead048379a0c60c04ac42012\",\"3128f549a7d848f091d8bf732140a709\",\"b71a4dc089754301a38783f126e48d3d\",\"02730069f29645548c718eff972546dd\",\"4611d6d618f3439da7a4ceb459009be3\",\"6218886c12664b69bae31611865fc150\",\"6bdc1683d3ad44128f1f80bdbf0580e7\",\"08bc9ae261454d43a3d7c59c7e38507c\",\"f3e3b049dd9d4433a5a8dcaf78f38253\",\"ee54fe93fd0b4255a22fefeb2b6de084\",\"60610d001b0f471da0b1ce1ed14eeec5\",\"2cf4fc34f42b40ed9325489629689f9a\",\"b9cd0a3916fb4c969ecb0157e46be1c0\"]}', '2018-12-20 11:32:25');
INSERT INTO `sys_log` VALUES ('491ebb20a9834476850ef4dde590ef47', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 10:56:28');
INSERT INTO `sys_log` VALUES ('4a598c6759a0488eb0a2a86f7d16a7ab', 'admin', '编辑部门', '/system/dept/doEdit', '{\"id\":[\"9a329b597d754c4180c6b40cdfb0f565\"],\"deptdesc\":[\"都是公司股份等十多个\"],\"deptname\":[\"产品部\"]}', '2018-12-04 14:40:26');
INSERT INTO `sys_log` VALUES ('4bd1790df2f443f28f2fec90e2846cdc', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-02-15 09:42:28');
INSERT INTO `sys_log` VALUES ('4f8f29cce06849a287c0f29d298840eb', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190110/1547091488637039803.jpg\\\" title\\u003d\\\"1547091488637039803.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190110/1547091488637039803.jpg\\\" title\\u003d\\\"1547091488637039803.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"]}', '2019-01-10 11:38:15');
INSERT INTO `sys_log` VALUES ('4fe3b016fcc84421ae2e4c2fb864ce66', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"]}', '2019-01-09 14:33:46');
INSERT INTO `sys_log` VALUES ('4fec32e494844a6c9cc8734eb4e68dcf', 'admin', '用户登录成功', '/login/doLogin', '', '2018-11-30 17:59:17');
INSERT INTO `sys_log` VALUES ('5227bc3afb2740d0a1b362637a8b59e2', 'admin', '编辑部门', '/system/dept/doEdit', '{\"id\":[\"9a329b597d754c4180c6b40cdfb0f565\"],\"deptdesc\":[\"都是公司股份等十多个\"],\"deptname\":[\"产品部1\"]}', '2018-12-04 14:33:49');
INSERT INTO `sys_log` VALUES ('52ea3f947f924bc2907810083caf1285', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-19 16:59:08');
INSERT INTO `sys_log` VALUES ('5485b04a225c44309c2053d19b304a3e', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 10:18:08');
INSERT INTO `sys_log` VALUES ('54c27cea754540aab1d89e03ab6c4a35', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190109/1547016636626022116.jpg\\\" title\\u003d\\\"1547016636626022116.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"]}', '2019-01-09 14:50:40');
INSERT INTO `sys_log` VALUES ('5937f04be52f44659762d2d6fb4725ad', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-09 11:04:58');
INSERT INTO `sys_log` VALUES ('59d13e81b3904efca30fcbd91f17cdaa', 'admin', '用户登录成功', '/login/doLogin', '', '2018-11-30 11:55:30');
INSERT INTO `sys_log` VALUES ('5ac13d3a2349435cbf69ba71e537c476', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-08 16:09:18');
INSERT INTO `sys_log` VALUES ('5b4e074d1de74715806fa660fc17ca86', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 10:32:40');
INSERT INTO `sys_log` VALUES ('5e12f0f18ad745bba84e852cb1d8871b', 'admin', '创建部门', '/system/dept/doAdd', '{\"deptdesc\":[\"dfdfdsfsdfs额外服务范围\"],\"deptname\":[\"产品部1\"]}', '2018-12-04 14:40:08');
INSERT INTO `sys_log` VALUES ('61ee3d9e68f748cbac034ad9a3eabcd6', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 10:51:30');
INSERT INTO `sys_log` VALUES ('6a65288b8c44464b9a021f17bfaa51f7', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-02-15 09:53:23');
INSERT INTO `sys_log` VALUES ('6af9fa9f695c464e911f15df5c5a08c8', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190110/1547091819909034666.jpg\\\" title\\u003d\\\"1547091819909034666.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190110/1547091819909034666.jpg\\\" title\\u003d\\\"1547091819909034666.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"]}', '2019-01-10 11:43:46');
INSERT INTO `sys_log` VALUES ('6e67f897c2f0457aa3c081502c0c3ded', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 10:09:51');
INSERT INTO `sys_log` VALUES ('6ed679b4ff7d4db0919cee0b5e5035bf', 'admin', 'Modifier le menu', '/system/menu/doEdit', '{\"code\":[\"080103\"],\"menuname\":[\"Suppression de l\\u0027actualite\"],\"resource\":[\"deleteNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"id\":[\"4611d6d618f3439da7a4ceb459009be3\"],\"sort\":[\"3\"]}', '2018-12-20 11:30:02');
INSERT INTO `sys_log` VALUES ('7021b44f001f448aae62806726455644', 'admin', 'Création du menu du répertoire', '/system/menu/doAddDir', '{\"code\":[\"09\"],\"menuname\":[\"UEditor\"],\"sort\":[\"9\"],\"icon\":[\"fa-folder\"]}', '2019-01-04 10:54:28');
INSERT INTO `sys_log` VALUES ('719bf82c08aa40bc94d9d2f94a132c2c', 'admin', 'Créer de l\'utilisateur.', '/system/user/doAdd', '{\"userstate\":[\"1\"],\"password\":[\"123456\"],\"deptid\":[\"9a329b597d754c4180c6b40cdfb0f565\"],\"userdesc\":[\"vhghghghgfhfghg\"],\"password2\":[\"123456\"],\"username\":[\"dieudonne\"]}', '2018-12-11 11:19:30');
INSERT INTO `sys_log` VALUES ('71ceb885aa4049d88506cae6762d116a', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-19 17:15:24');
INSERT INTO `sys_log` VALUES ('728f92d4085a44fd96e4cb9d822f65a4', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-09 09:57:05');
INSERT INTO `sys_log` VALUES ('72b078c75743438bb438dd97a32fcf58', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-30 11:53:16');
INSERT INTO `sys_log` VALUES ('74ee9b2ff496458baefde739ba69072c', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-06 16:46:26');
INSERT INTO `sys_log` VALUES ('78bfbfd081e04f75a7723ccc43afd8c9', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-19 17:01:35');
INSERT INTO `sys_log` VALUES ('7923d914751c431aa07f871e1a5c6fcf', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 10:14:41');
INSERT INTO `sys_log` VALUES ('7dfef2e7f7c84d2989d19ed144cd52f4', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-04 10:38:38');
INSERT INTO `sys_log` VALUES ('872238b6d486438086493c809feb3490', 'admin', 'Modifier le News', '/system/app-news/doEdit', '{\"id\":[\"20270497d0c848febd3102d00d7e4cf1\"],\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"撒大声地所多所多所多所hhshshshhshhhhshhhshshhshshshsss\"],\"content\":[\"\\u003cp\\u003e\\u0026nbsp; \\u0026nbsp; \\u0026nbsp; \\u0026nbsp;dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\\r\\n \\u0026nbsp; \\u0026nbsp;\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190215/1550195619670059516.jpg\\\" title\\u003d\\\"1550195619670059516.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u0026nbsp; \\u0026nbsp; \\u0026nbsp; \\u0026nbsp;dasfdsffffffffffffffffffffffffffffffffff查出V型从V型从是许星程是从V型从V型从是从是持续形成需\\r\\n \\u0026nbsp; \\u0026nbsp;\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190215/1550195619670059516.jpg\\\" title\\u003d\\\"1550195619670059516.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"]}', '2019-02-15 09:54:05');
INSERT INTO `sys_log` VALUES ('879453e6903643a0ac26b7bd697c7752', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-05 11:17:31');
INSERT INTO `sys_log` VALUES ('8875144a489b4e92857c8b78155a0ade', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-03 11:11:16');
INSERT INTO `sys_log` VALUES ('8ab76c43499449c2a4f9c084c044d6d6', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-28 17:02:51');
INSERT INTO `sys_log` VALUES ('8debd22146f04f9f9b5a273103af666b', 'admin', '更新系统设置', '/system/setting/doSetting', '{\"sysValue\":[\"ahh-admin\",\"后台管理系统V1.00\",\"Copyright © 2018 XXX管理有限公司. All rights reserved.\"],\"id\":[\"1\",\"2\",\"3\"]}', '2018-12-04 11:48:53');
INSERT INTO `sys_log` VALUES ('8e83ec47c30d4f778a6d68bcf7053f52', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 14:14:10');
INSERT INTO `sys_log` VALUES ('90cfef7bc4ec4815aaa42d5d2cf5df4f', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 11:25:14');
INSERT INTO `sys_log` VALUES ('914b10294ecc47f6a1d9b6e178162e2f', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-03 11:15:25');
INSERT INTO `sys_log` VALUES ('930110254ade4a5baad8e19d08e5026b', 'admin', 'Attribution de l\'autorisation compétences', '/system/role/doAuth', '{\"roleid\":[\"b1f9ce5543a049be9f169a3f5e6b72a8\"],\"mid[]\":[\"1\",\"2\",\"d2bc30feb5474a1bb7e02d48d39a3f8a\",\"a73802e513cc4465883530ec8074abbb\",\"4253190001c1480fb0d631d64d150535\",\"649b484b58414d91aefa5a26143e6557\",\"3\",\"1db9105008404a3485b6fac30dba3c0e\",\"60dda993d87647f5989c15f14f866df9\",\"686630c7cb624cc786dcdc9958971a6b\",\"b4e7232189b14cf3ba160cf7b0d3bf37\",\"a5ebf29168234406939856bc6890c86b\",\"f899f3d3baec4571b1c786717f9906fd\",\"4\",\"488ef1eff57b4827acade7c0744278ce\",\"3f26102ef0e04c3c9328cb97067cc5fa\",\"dc5f478d98ed4297a8ae638fe90df050\",\"0c9b5fc8b44b41d1871a8fc8300247ec\",\"22e38e885f9b40b9aae6a36deb78e89c\",\"4e816a9854714d24b0413d929d637a2b\",\"3fb6a7a5935b4efabf3de82e7e1baeb6\",\"363a778e78a346a68210b2590163a943\",\"79d78b8357174cac8f44abd275dec597\",\"5\",\"5d3dd56c16ff4e32aecae1b3228159c7\",\"10\",\"0818e1c76bbd44eba3a698547ec4e637\",\"915c309ebe5047b68645b3eb777dd8c9\",\"f5a20c82110b4a3ea9e30ca01a038680\",\"42dd5ae31e3a43b3a197440e8ec19a94\",\"476dbef5152040668acffbdb5683d49d\",\"c6bfb8c2d70b4b57a7da69b8b20538a4\",\"3da0154b4b4a4303bfc508f3d7e452db\",\"d9c96546f5c74f87a86c3febed252f4b\",\"f417a2a4ead048379a0c60c04ac42012\",\"3128f549a7d848f091d8bf732140a709\",\"6bdc1683d3ad44128f1f80bdbf0580e7\",\"08bc9ae261454d43a3d7c59c7e38507c\",\"f3e3b049dd9d4433a5a8dcaf78f38253\",\"ee54fe93fd0b4255a22fefeb2b6de084\",\"60610d001b0f471da0b1ce1ed14eeec5\",\"2cf4fc34f42b40ed9325489629689f9a\",\"b9cd0a3916fb4c969ecb0157e46be1c0\"]}', '2018-12-20 10:18:19');
INSERT INTO `sys_log` VALUES ('94245a91e10c4e1a9d7733143864df7b', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 16:00:41');
INSERT INTO `sys_log` VALUES ('9697d459685c417aafcd460138688aba', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 10:04:21');
INSERT INTO `sys_log` VALUES ('97b138c75d18490aac35cfb05369a1e1', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 10:35:37');
INSERT INTO `sys_log` VALUES ('9b450eeb2cbd44899af6d068d834ebdf', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 10:40:54');
INSERT INTO `sys_log` VALUES ('9d0dc37afa2e4bcfb3244f6ac44b038b', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-29 17:56:14');
INSERT INTO `sys_log` VALUES ('9e86a0b7437148b8bab38a4e57ce473d', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 09:48:21');
INSERT INTO `sys_log` VALUES ('a035445f672d49eba81bf1c344b8f699', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-05 10:51:08');
INSERT INTO `sys_log` VALUES ('a1cfd2f7314f4daf944d511ab2ef6616', 'admin', '用户登录成功', '/login/doLogin', '', '2018-11-30 10:52:49');
INSERT INTO `sys_log` VALUES ('a8c7d125adba46ba9ac203c2666428cf', 'admin', 'Modifier le menu', '/system/menu/doEdit', '{\"code\":[\"080102\"],\"menuname\":[\"Nouvel Actiualite\"],\"resource\":[\"addNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"id\":[\"02730069f29645548c718eff972546dd\"],\"sort\":[\"2\"]}', '2018-12-20 11:32:00');
INSERT INTO `sys_log` VALUES ('a8cd7ce2ec684282a62dbf3f47f6d735', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190109/1547017291952039162.jpg\\\" title\\u003d\\\"1547017291952039162.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190109/1547017291952039162.jpg\\\" title\\u003d\\\"1547017291952039162.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"]}', '2019-01-09 15:01:39');
INSERT INTO `sys_log` VALUES ('ac2cbf26d8904d24b207718070443ba1', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-28 16:52:46');
INSERT INTO `sys_log` VALUES ('aca3610976314f9a9abc84f53a108cba', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 10:44:03');
INSERT INTO `sys_log` VALUES ('ae17c318aac6450199433ecf2b73bbd3', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 12:32:08');
INSERT INTO `sys_log` VALUES ('b09c51f3d93840b6ac13d8f2de3a7519', 'admin', '更新系统设置', '/system/setting/doSetting', '{\"sysValue\":[\"ahh-admin\",\"后台管理系统V1.03\",\"Copyright © 2018 XXX管理有限公司. All rights reserved.\"],\"id\":[\"1\",\"2\",\"3\"]}', '2018-12-04 12:33:23');
INSERT INTO `sys_log` VALUES ('b23643b0ab064bfaa05451283acee9ff', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-04 16:45:42');
INSERT INTO `sys_log` VALUES ('b2628b9cc16c4cc599063d60216e5727', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190109/1547016424861082913.jpg\\\" title\\u003d\\\"1547016424861082913.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"]}', '2019-01-09 14:47:09');
INSERT INTO `sys_log` VALUES ('b460395ce6b04b7c9bfcb53fa88a511f', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-29 17:34:43');
INSERT INTO `sys_log` VALUES ('b4a7d8176cb64f2db1d031b7c5443691', 'admin', 'Création du menu du répertoire', '/system/menu/doAddDir', '{\"code\":[\"08\"],\"menuname\":[\"Actualites\"],\"icon\":[\"fa-folder\"],\"sort\":[\"5\"]}', '2018-12-19 17:15:46');
INSERT INTO `sys_log` VALUES ('b4e32d7f660c4295831623a8c94976cd', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-04 16:45:42');
INSERT INTO `sys_log` VALUES ('b6061dd08e244a148a1f2ff767df39d0', 'admin', 'Nouveau fonctionnel menu', '/system/menu/doAddAction', '{\"code\":[\"080101\"],\"menuname\":[\"Liste de l\\u0027actualite\"],\"resource\":[\"deleteNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"sort\":[\"2\"]}', '2018-12-20 11:05:30');
INSERT INTO `sys_log` VALUES ('b6adc7f0824143a6832fd8d97d20fa57', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\\u003cp\\u003eb\\u003c/p\\u003e\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003eb\\u003c/p\\u003e\"]}', '2019-01-10 11:44:48');
INSERT INTO `sys_log` VALUES ('b771dbc2f8134df39e5596ecfc77a63b', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 10:34:01');
INSERT INTO `sys_log` VALUES ('b83f35af0fdd4349b5a7f77a0ae8f813', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-04 16:59:05');
INSERT INTO `sys_log` VALUES ('bbb46fafe9d64e63bb8f3b2de4e6ee6e', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 09:53:20');
INSERT INTO `sys_log` VALUES ('bc78a337544144bfa8526a9c8a64f1f2', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-06 17:56:16');
INSERT INTO `sys_log` VALUES ('bf16d1fd57dd4b999c14daf4e8457c2a', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 11:22:19');
INSERT INTO `sys_log` VALUES ('c225f030a8ac42d9b708ac880c0258f7', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 10:39:35');
INSERT INTO `sys_log` VALUES ('c3c95d3a7bb24ba18f066b05e9d768de', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-06 17:25:39');
INSERT INTO `sys_log` VALUES ('c3dbeed5448741c989561c2bdf5a351b', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-03 10:37:49');
INSERT INTO `sys_log` VALUES ('c63f0e72ffe1450fa7144f3e8a41e163', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 11:04:45');
INSERT INTO `sys_log` VALUES ('c71648a34fce408b882e621fb61a3c8c', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 10:57:20');
INSERT INTO `sys_log` VALUES ('c742a7547e51497b8bd799c175f2db60', 'admin', 'Modifier le News', '/system/app-news/doEdit', '{\"id\":[\"24198a68b1e94f07947b03b625b453b1\"],\"title\":[\"Actualite Title\"],\"subtitle\":[\"Actualite Sous-Titre\"],\"authorId\":[\"Dieudonne\"],\"classifyId\":[\"23\"],\"typeId\":[\"23\"],\"sammary\":[\"dsaafdfdfdsfsdfdsfdsfdsfdsfdfdsfdsfdsfdsfdsfdfdsf\"],\"content\":[\"\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cbr/\\u003e\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177867049066.jpg\\\" title\\u003d\\\"1559027177867049066.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177913086922.jpg\\\" title\\u003d\\\"1559027177913086922.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177920045129.jpg\\\" title\\u003d\\\"1559027177920045129.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003eakdsajdaskjadsfjafjadsdfjajdjadjasjdad\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cbr/\\u003e\\u003c/p\\u003e\"],\"link\":[\"www.baidu.com\"],\"coverImage\":[\"www.img.com\"],\"editorValue\":[\"\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cbr/\\u003e\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177867049066.jpg\\\" title\\u003d\\\"1559027177867049066.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177913086922.jpg\\\" title\\u003d\\\"1559027177913086922.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190528/1559027177920045129.jpg\\\" title\\u003d\\\"1559027177920045129.jpg\\\"/\\u003e\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003eakdsajdaskjadsfjafjadsdfjajdjadjasjdad\\u003c/p\\u003e\\u003cp style\\u003d\\\"text-align: center;\\\"\\u003e\\u003cbr/\\u003e\\u003c/p\\u003e\"]}', '2019-05-28 15:09:56');
INSERT INTO `sys_log` VALUES ('c82f9033f642449c82816f32358c5278', 'admin', 'Attribution de l\'autorisation compétences', '/system/role/doAuth', '{\"roleid\":[\"b1f9ce5543a049be9f169a3f5e6b72a8\"],\"mid[]\":[\"1\",\"2\",\"d2bc30feb5474a1bb7e02d48d39a3f8a\",\"a73802e513cc4465883530ec8074abbb\",\"4253190001c1480fb0d631d64d150535\",\"649b484b58414d91aefa5a26143e6557\",\"3\",\"1db9105008404a3485b6fac30dba3c0e\",\"60dda993d87647f5989c15f14f866df9\",\"686630c7cb624cc786dcdc9958971a6b\",\"b4e7232189b14cf3ba160cf7b0d3bf37\",\"a5ebf29168234406939856bc6890c86b\",\"f899f3d3baec4571b1c786717f9906fd\",\"4\",\"488ef1eff57b4827acade7c0744278ce\",\"3f26102ef0e04c3c9328cb97067cc5fa\",\"dc5f478d98ed4297a8ae638fe90df050\",\"0c9b5fc8b44b41d1871a8fc8300247ec\",\"22e38e885f9b40b9aae6a36deb78e89c\",\"4e816a9854714d24b0413d929d637a2b\",\"3fb6a7a5935b4efabf3de82e7e1baeb6\",\"363a778e78a346a68210b2590163a943\",\"79d78b8357174cac8f44abd275dec597\",\"5\",\"5d3dd56c16ff4e32aecae1b3228159c7\",\"10\",\"0818e1c76bbd44eba3a698547ec4e637\",\"915c309ebe5047b68645b3eb777dd8c9\",\"f5a20c82110b4a3ea9e30ca01a038680\",\"42dd5ae31e3a43b3a197440e8ec19a94\",\"476dbef5152040668acffbdb5683d49d\",\"c6bfb8c2d70b4b57a7da69b8b20538a4\",\"3da0154b4b4a4303bfc508f3d7e452db\",\"d9c96546f5c74f87a86c3febed252f4b\",\"f417a2a4ead048379a0c60c04ac42012\",\"3128f549a7d848f091d8bf732140a709\",\"b71a4dc089754301a38783f126e48d3d\",\"02730069f29645548c718eff972546dd\",\"4611d6d618f3439da7a4ceb459009be3\",\"6218886c12664b69bae31611865fc150\",\"6bdc1683d3ad44128f1f80bdbf0580e7\",\"08bc9ae261454d43a3d7c59c7e38507c\",\"f3e3b049dd9d4433a5a8dcaf78f38253\",\"ee54fe93fd0b4255a22fefeb2b6de084\",\"60610d001b0f471da0b1ce1ed14eeec5\",\"2cf4fc34f42b40ed9325489629689f9a\",\"b9cd0a3916fb4c969ecb0157e46be1c0\",\"cc8d1a5f520e44c294c65f41ac4a37c3\",\"4b61631a329f42fe8ed6acca78f0ce8a\"]}', '2019-01-04 10:56:17');
INSERT INTO `sys_log` VALUES ('c919a2851792408aa7b9938b9c577139', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-06 17:59:31');
INSERT INTO `sys_log` VALUES ('ca014ff1d0894f3b829265bd0036071f', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 09:52:40');
INSERT INTO `sys_log` VALUES ('cb58d9b670a14c70bd73d15e61c25424', 'admin', 'Modifier le menu', '/system/menu/doEdit', '{\"code\":[\"080101\"],\"menuname\":[\"Suppression de l\\u0027actualite\"],\"resource\":[\"deleteNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"id\":[\"4611d6d618f3439da7a4ceb459009be3\"],\"sort\":[\"3\"]}', '2018-12-20 11:12:47');
INSERT INTO `sys_log` VALUES ('ce9c7f35d19f429884da4f76a929691a', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-06 18:12:22');
INSERT INTO `sys_log` VALUES ('cf3056bba006418f8956668fa3d31f56', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 10:41:54');
INSERT INTO `sys_log` VALUES ('d096d7a218c64e668af5b2e7f5911e8a', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-10 14:00:17');
INSERT INTO `sys_log` VALUES ('d2e31a0acfe54518ac0a240e8e7df755', 'admin', 'Modifier le rôle ', '/system/role/doEdit', '{\"roledesc\":[\"Super Administrateur\"],\"rolename\":[\"Super Admin\"],\"rolestate\":[\"1\"],\"id\":[\"b1f9ce5543a049be9f169a3f5e6b72a8\"]}', '2018-12-20 10:56:38');
INSERT INTO `sys_log` VALUES ('d50bddedea7643b8b9ce0256b8bce02c', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-28 16:50:21');
INSERT INTO `sys_log` VALUES ('d5f4c7fd89ac4aaeae92241afbfb6fd0', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-08 16:45:37');
INSERT INTO `sys_log` VALUES ('d7737280e1c944fc84576620a5a8810c', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 10:10:16');
INSERT INTO `sys_log` VALUES ('d92853bf0c3142d993017028d8e476fa', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\\u003cp\\u003e是的撒大大所大所大所大多发的鬼地方个梵蒂冈股份非官方个电饭锅电饭锅公分高大哥大法官的郭德纲\\u003c/p\\u003e\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e是的撒大大所大所大所大多发的鬼地方个梵蒂冈股份非官方个电饭锅电饭锅公分高大哥大法官的郭德纲\\u003c/p\\u003e\"]}', '2019-01-09 15:04:30');
INSERT INTO `sys_log` VALUES ('da456f75cf9d4f29b64c699c59beba0b', 'admin', 'Modifier le rôle ', '/system/role/doEdit', '{\"roledesc\":[\"Super Administrateur\"],\"roleState\":[\"1\"],\"rolename\":[\"Super Admin\"],\"id\":[\"b1f9ce5543a049be9f169a3f5e6b72a8\"]}', '2018-12-20 10:55:15');
INSERT INTO `sys_log` VALUES ('dba2bf237fb541349d02263af8f38eee', 'admin', 'Modifier le rôle ', '/system/role/doEdit', '{\"roledesc\":[\"Super Administrateur\"],\"roleState\":[\"1\"],\"rolename\":[\"Super Admin\"],\"id\":[\"b1f9ce5543a049be9f169a3f5e6b72a8\"]}', '2018-12-20 10:54:58');
INSERT INTO `sys_log` VALUES ('dfb055ba5fdf4ebb82725c17be3c6603', 'admin', 'Nouveau fonctionnel menu', '/system/menu/doAddAction', '{\"code\":[\"080101\"],\"menuname\":[\"Liste de l\\u0027actualite\"],\"resource\":[\"listNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"sort\":[\"1\"]}', '2018-12-20 11:01:42');
INSERT INTO `sys_log` VALUES ('e0ad823f94cf44da821d8e9e500314d6', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-09 14:19:06');
INSERT INTO `sys_log` VALUES ('e1d5a598527b4ceea3110a3ef27ffaa8', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-10 17:38:20');
INSERT INTO `sys_log` VALUES ('e210578efb604c3aa9f6bf5eee6152a2', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 10:18:41');
INSERT INTO `sys_log` VALUES ('e21df06321db4e0b9b985cd9ae65ef1c', 'admin', '编辑部门', '/system/dept/doEdit', '{\"id\":[\"9a329b597d754c4180c6b40cdfb0f565\"],\"deptdesc\":[\"都是公司股份等十多个\"],\"deptname\":[\"产品部\"]}', '2018-12-04 14:33:41');
INSERT INTO `sys_log` VALUES ('e45df899ef4b45058c821f341c478246', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 10:09:55');
INSERT INTO `sys_log` VALUES ('e600466d9dfd4c579c826088b45c40cb', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-11-30 10:16:01');
INSERT INTO `sys_log` VALUES ('e6c0c1e81cbe49bca105722731096e94', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 10:29:38');
INSERT INTO `sys_log` VALUES ('e822bbf6925c4808ac1b6dafc2e91f57', 'admin', 'Nouveau fonctionnel menu', '/system/menu/doAddAction', '{\"code\":[\"080101\"],\"menuname\":[\"Liste de l\\u0027actualite\"],\"resource\":[\"addNews\"],\"pid\":[\"3128f549a7d848f091d8bf732140a709\"],\"sort\":[\"2\"]}', '2018-12-20 11:05:02');
INSERT INTO `sys_log` VALUES ('ece4bff3367849cd924b353cef52dc58', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-03 11:00:59');
INSERT INTO `sys_log` VALUES ('eebbc0a4b4d044e5bd241301023db9fb', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-05-28 16:33:14');
INSERT INTO `sys_log` VALUES ('eefcc0a41fbd42caa8e3cd53a0da8989', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-04 18:06:55');
INSERT INTO `sys_log` VALUES ('ef020189b8964305bdff6456a3d2d6b0', 'admin', '用户登录成功', '/login/doLogin', '', '2018-12-04 11:46:52');
INSERT INTO `sys_log` VALUES ('efa6588827d745a9b31328d1995fcf7a', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-20 11:34:05');
INSERT INTO `sys_log` VALUES ('f124225bdc864d19a43cd04e495792d7', 'admin', 'Création du menu', '/system/menu/doAddMenu', '{\"pid\":[\"cc8d1a5f520e44c294c65f41ac4a37c3\"],\"code\":[\"0901\"],\"menuname\":[\"ADD\"],\"url\":[\"/ueditor/index\"],\"sort\":[\"1\"],\"icon\":[\"fa-file\"]}', '2019-01-04 10:55:58');
INSERT INTO `sys_log` VALUES ('f2e6a02aefd8471c8746a7066d7282d6', 'admin', 'Supprimer le News', '/system/app-news/delete', '{\"id\":[\"b21cda5dd42e464e987b712ae9a392b3\"]}', '2019-01-09 09:57:19');
INSERT INTO `sys_log` VALUES ('f4f9f0c04b5441848bdc225ce1013433', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-06-04 15:08:01');
INSERT INTO `sys_log` VALUES ('f6d4c03b106347bca55da40ea2690cba', 'admin', 'Création du nouveau News ', '/system/app-news/doAdd', '{\"title\":[\"dafsfdsfds\"],\"subtitle\":[\"等我的请问请问\"],\"authorId\":[\"2\"],\"classifyId\":[\"2\"],\"typeId\":[\"2\"],\"sammary\":[\"dsafdsfdsgdfhgfhjgfjghkjgjkjhkhjkhjkhjkhjkhjk\"],\"deptdesc\":[\"\"],\"content\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190109/1547017291952039162.jpg\\\" title\\u003d\\\"1547017291952039162.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"],\"link\":[\"www.google.com\"],\"coverImage\":[\"img.www.google.com\"],\"editorValue\":[\"\\u003cp\\u003e\\u003cimg src\\u003d\\\"/file/ueditor/jsp/upload/image/20190109/1547017291952039162.jpg\\\" title\\u003d\\\"1547017291952039162.jpg\\\" alt\\u003d\\\"WeChat Image_20190108104045.jpg\\\"/\\u003e\\u003c/p\\u003e\"]}', '2019-01-09 15:01:39');
INSERT INTO `sys_log` VALUES ('f7df44c8575c4bda8311aff701e07123', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-15 10:27:35');
INSERT INTO `sys_log` VALUES ('f85b732fce214949ac28daf1490d71f5', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 10:50:56');
INSERT INTO `sys_log` VALUES ('f90f699b62cc4c0c8e12ac89403cb0aa', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-04 10:49:31');
INSERT INTO `sys_log` VALUES ('fd98f7dd11704c2587784c4661956376', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-11 09:31:33');
INSERT INTO `sys_log` VALUES ('fe96e7998cd843189f18a07818373c94', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2018-12-06 16:29:47');
INSERT INTO `sys_log` VALUES ('ff458a38d2844997b5b4d36634b2ed58', 'admin', 'Le succès de connexion', '/login/doLogin', '', '2019-01-08 17:01:50');
INSERT INTO `sys_log` VALUES ('ffbe58fb038d4e99b1bc8abac5ff4f44', 'admin', '用户登录成功', '/login/doLogin', '', '2018-04-15 11:38:37');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `menuName` varchar(50) NOT NULL COMMENT '菜单名称',
  `pid` varchar(50) NOT NULL COMMENT '父级菜单ID',
  `url` varchar(255) DEFAULT NULL COMMENT '连接地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `deep` int(11) DEFAULT NULL COMMENT '深度',
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `resource` varchar(50) DEFAULT NULL COMMENT '资源名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('02730069f29645548c718eff972546dd', 'Nouvel Actiualite', '3128f549a7d848f091d8bf732140a709', null, null, '2', '3', '080102', 'addNews');
INSERT INTO `sys_menu` VALUES ('0818e1c76bbd44eba3a698547ec4e637', 'Régles recherche système', '10', null, null, '0', '3', '010600', 'listSetting');
INSERT INTO `sys_menu` VALUES ('08bc9ae261454d43a3d7c59c7e38507c', 'Gestion de la classification des activités', '6bdc1683d3ad44128f1f80bdbf0580e7', 'act/class/1', 'fa-file', '1', '2', '0601', null);
INSERT INTO `sys_menu` VALUES ('0c9b5fc8b44b41d1871a8fc8300247ec', 'Suppression du Menu', '4', null, null, '4', '3', '010303', 'deleteMenu');
INSERT INTO `sys_menu` VALUES ('1', 'Gestion Système', '0', null, 'fa fa-cogs', '1', '1', '01', null);
INSERT INTO `sys_menu` VALUES ('10', 'Réglages', '1', '/system/setting/page', ' fa-cog', '6', '2', '0106', 'setting');
INSERT INTO `sys_menu` VALUES ('1db9105008404a3485b6fac30dba3c0e', 'Regarde la liste des rôles', '3', null, null, '0', '3', '010200', 'listRole');
INSERT INTO `sys_menu` VALUES ('2', 'Utilisateurs', '1', '/system/user/list/1', 'fa-user-circle-o', '1', '2', '0101', 'user');
INSERT INTO `sys_menu` VALUES ('22e38e885f9b40b9aae6a36deb78e89c', 'Département', '1', '/system/dept/list/1', 'fa-graduation-cap', '4', '2', '0104', 'dept');
INSERT INTO `sys_menu` VALUES ('2cf4fc34f42b40ed9325489629689f9a', 'Gestion des médecins', '60610d001b0f471da0b1ce1ed14eeec5', 'doctor/doctor_manager', 'fa-file', '1', '2', '0701', null);
INSERT INTO `sys_menu` VALUES ('3', 'Rôles', '1', '/system/role/list/1', 'fa-users', '2', '2', '0102', 'role');
INSERT INTO `sys_menu` VALUES ('3128f549a7d848f091d8bf732140a709', 'Actualites', 'f417a2a4ead048379a0c60c04ac42012', '/system/app-news/list/1', 'fa-file', '1', '2', '08-01', null);
INSERT INTO `sys_menu` VALUES ('363a778e78a346a68210b2590163a943', 'Département de rédaction', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '2', '3', '010402', 'editDept');
INSERT INTO `sys_menu` VALUES ('3da0154b4b4a4303bfc508f3d7e452db', 'Gestion de l’information des patients', '476dbef5152040668acffbdb5683d49d', 'news/patient/1', 'fa-file', '3', '2', '0503', null);
INSERT INTO `sys_menu` VALUES ('3f26102ef0e04c3c9328cb97067cc5fa', 'Nouveau menu', '4', null, null, '1', '3', '010301', 'addMenu');
INSERT INTO `sys_menu` VALUES ('3fb6a7a5935b4efabf3de82e7e1baeb6', 'Nouveaux secteurs', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '1', '3', '010401', 'addDept');
INSERT INTO `sys_menu` VALUES ('4', 'Menus', '1', '/system/menu/list/1', 'fa-list', '3', '2', '0103', 'menu');
INSERT INTO `sys_menu` VALUES ('4253190001c1480fb0d631d64d150535', 'Rédacteur en chef', '2', null, null, '2', '3', '010102', 'editUser');
INSERT INTO `sys_menu` VALUES ('42dd5ae31e3a43b3a197440e8ec19a94', 'Liste de contrôle', 'f5a20c82110b4a3ea9e30ca01a038680', null, null, '1', '3', '010701', 'monitorList');
INSERT INTO `sys_menu` VALUES ('4611d6d618f3439da7a4ceb459009be3', 'Suppression de l\'actualite', '3128f549a7d848f091d8bf732140a709', null, null, '3', '3', '080103', 'deleteNews');
INSERT INTO `sys_menu` VALUES ('476dbef5152040668acffbdb5683d49d', 'Gestion de l’information', '0', null, 'fa-folder', '5', '1', '05', null);
INSERT INTO `sys_menu` VALUES ('488ef1eff57b4827acade7c0744278ce', 'Regarde la liste des menus', '4', null, null, '0', '3', '010300', 'listMenu');
INSERT INTO `sys_menu` VALUES ('4b61631a329f42fe8ed6acca78f0ce8a', 'ADD', 'cc8d1a5f520e44c294c65f41ac4a37c3', '/ueditor/index', 'fa-file', '1', '2', '0901', null);
INSERT INTO `sys_menu` VALUES ('4e816a9854714d24b0413d929d637a2b', 'Regarde la liste des départements', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '0', '3', '010400', 'listDept');
INSERT INTO `sys_menu` VALUES ('5', 'Logs', '1', '/system/log/list/1', 'fa-info-circle', '5', '2', '0105', 'log');
INSERT INTO `sys_menu` VALUES ('56596b28d126495db2c49fa5cf127a07', 'Gestion de l’information des médecins', '1', 'news/doctor/2', 'fa-file', '2', '2', '0502', null);
INSERT INTO `sys_menu` VALUES ('5d3dd56c16ff4e32aecae1b3228159c7', 'Regarde la liste des logis', '5', null, null, '0', '3', '010500', 'listLog');
INSERT INTO `sys_menu` VALUES ('60610d001b0f471da0b1ce1ed14eeec5', 'Gestion des médecins', '0', null, 'fa-folder', '7', '1', '07', null);
INSERT INTO `sys_menu` VALUES ('60dda993d87647f5989c15f14f866df9', 'Nouveau rôle', '3', null, null, '1', '3', '010201', 'addRole');
INSERT INTO `sys_menu` VALUES ('6218886c12664b69bae31611865fc150', 'Modification de l\'actualite', '3128f549a7d848f091d8bf732140a709', null, null, '4', '3', '080104', 'editNews');
INSERT INTO `sys_menu` VALUES ('649b484b58414d91aefa5a26143e6557', 'Supprimer l\' utilisateur', '2', null, null, '3', '3', '010103', 'deleteUser');
INSERT INTO `sys_menu` VALUES ('686630c7cb624cc786dcdc9958971a6b', 'Changer le rôle', '3', null, null, '2', '3', '010202', 'editRole');
INSERT INTO `sys_menu` VALUES ('6bdc1683d3ad44128f1f80bdbf0580e7', 'Gestion des activités', '0', null, 'fa-folder', '6', '1', '06', null);
INSERT INTO `sys_menu` VALUES ('79d78b8357174cac8f44abd275dec597', 'Supprimer le secteur', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '3', '3', '010403', 'deleteDept');
INSERT INTO `sys_menu` VALUES ('915c309ebe5047b68645b3eb777dd8c9', 'Système opérationnel installé', '10', null, null, '1', '3', '010601', 'doSetting');
INSERT INTO `sys_menu` VALUES ('a5ebf29168234406939856bc6890c86b', 'Rôle Autorisation', '3', null, null, '4', '3', '010204', 'authRole');
INSERT INTO `sys_menu` VALUES ('a73802e513cc4465883530ec8074abbb', 'Nouveaux utilisateurs', '2', null, null, '1', '3', '010101', 'addUser');
INSERT INTO `sys_menu` VALUES ('b4e7232189b14cf3ba160cf7b0d3bf37', 'Supprimer le rôle', '3', null, null, '3', '3', '010203', 'deleteRole');
INSERT INTO `sys_menu` VALUES ('b71a4dc089754301a38783f126e48d3d', 'Liste de l\'actualite', '3128f549a7d848f091d8bf732140a709', null, null, '1', '3', '080101', 'listNews');
INSERT INTO `sys_menu` VALUES ('b9cd0a3916fb4c969ecb0157e46be1c0', 'Invite les médecins', '60610d001b0f471da0b1ce1ed14eeec5', 'doctor/doctor', 'fa-file', '2', '2', '0702', null);
INSERT INTO `sys_menu` VALUES ('c6bfb8c2d70b4b57a7da69b8b20538a4', 'Gestion de l’information des médecins', '476dbef5152040668acffbdb5683d49d', 'news/doctor/1', 'fa-file', '1', '2', '0501', null);
INSERT INTO `sys_menu` VALUES ('cc8d1a5f520e44c294c65f41ac4a37c3', 'UEditor', '0', null, 'fa-folder', '9', '1', '09', null);
INSERT INTO `sys_menu` VALUES ('d2bc30feb5474a1bb7e02d48d39a3f8a', 'Regarde la liste des utilisateurs', '2', null, null, '0', '3', '010100', 'listUser');
INSERT INTO `sys_menu` VALUES ('d9c96546f5c74f87a86c3febed252f4b', 'Gestion de l’information des patients', '476dbef5152040668acffbdb5683d49d', 'news/patient/2', 'fa-file', '4', '2', '0501', null);
INSERT INTO `sys_menu` VALUES ('dc5f478d98ed4297a8ae638fe90df050', 'Menu d’édition', '4', null, null, '3', '3', '010302', 'editMenu');
INSERT INTO `sys_menu` VALUES ('ee54fe93fd0b4255a22fefeb2b6de084', 'Gestion de l’activité banner', '6bdc1683d3ad44128f1f80bdbf0580e7', 'act/banner/1', 'fa-file', '3', '2', '0603', null);
INSERT INTO `sys_menu` VALUES ('f3e3b049dd9d4433a5a8dcaf78f38253', 'Gestion des contenus d’activité', '6bdc1683d3ad44128f1f80bdbf0580e7', 'act/content/1', 'fa-file', '2', '2', '0602', null);
INSERT INTO `sys_menu` VALUES ('f417a2a4ead048379a0c60c04ac42012', 'Actualites', '0', null, 'fa-folder', '5', '1', '08', null);
INSERT INTO `sys_menu` VALUES ('f5a20c82110b4a3ea9e30ca01a038680', 'Surveillance systématique', '1', '/system/monitor/list', 'fa-eye', '7', '2', '0107', null);
INSERT INTO `sys_menu` VALUES ('f899f3d3baec4571b1c786717f9906fd', 'Supprimer les rôles', '3', null, null, '5', '3', '010205', 'deleteBatchRole');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `roleName` varchar(50) NOT NULL COMMENT '角色名称',
  `roleDesc` varchar(300) DEFAULT NULL COMMENT '角色描述',
  `roleState` int(2) DEFAULT '1' COMMENT '状态,1-启用,-1禁用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('6a2994e4788a44f0973b5ca6ac4b6d73', '运营人员', '', '1', '2018-04-12 18:41:40');
INSERT INTO `sys_role` VALUES ('b1f9ce5543a049be9f169a3f5e6b72a8', 'Super Admin', 'Super Administrateur', '1', null);

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `roleId` varchar(50) NOT NULL COMMENT '角色主键',
  `menuId` varchar(50) NOT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('00358600c4464e859cdb6fcfcc9112b6', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'f899f3d3baec4571b1c786717f9906fd');
INSERT INTO `sys_role_menu` VALUES ('0374dcd2ce6a4ef2bb445abe9fa76fff', 'b1f9ce5543a049be9f169a3f5e6b72a8', '0c9b5fc8b44b41d1871a8fc8300247ec');
INSERT INTO `sys_role_menu` VALUES ('076da3ade5f2476e9d201cc59d6a4d91', 'b1f9ce5543a049be9f169a3f5e6b72a8', '3f26102ef0e04c3c9328cb97067cc5fa');
INSERT INTO `sys_role_menu` VALUES ('14ec0f80cd544d0388f298f37d124455', 'b1f9ce5543a049be9f169a3f5e6b72a8', '6218886c12664b69bae31611865fc150');
INSERT INTO `sys_role_menu` VALUES ('1cad186767af48ebab572d8ed70a4d8c', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'ee54fe93fd0b4255a22fefeb2b6de084');
INSERT INTO `sys_role_menu` VALUES ('1d63b783a8714a548f29bd394c9eabbb', 'b1f9ce5543a049be9f169a3f5e6b72a8', '3128f549a7d848f091d8bf732140a709');
INSERT INTO `sys_role_menu` VALUES ('1fdd4c401cec4f2095651797009175cb', 'b1f9ce5543a049be9f169a3f5e6b72a8', '1');
INSERT INTO `sys_role_menu` VALUES ('29467f5f4c9b4e96a993140cce4b5ab9', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'f3e3b049dd9d4433a5a8dcaf78f38253');
INSERT INTO `sys_role_menu` VALUES ('2cdf9a39113a4d35afb4a078f45ec0a8', 'b1f9ce5543a049be9f169a3f5e6b72a8', '10');
INSERT INTO `sys_role_menu` VALUES ('2e606df875f04124b841fa80ea7b5adf', 'b1f9ce5543a049be9f169a3f5e6b72a8', '02730069f29645548c718eff972546dd');
INSERT INTO `sys_role_menu` VALUES ('33bf05c78360491ea2adf01d6a167338', 'b1f9ce5543a049be9f169a3f5e6b72a8', '476dbef5152040668acffbdb5683d49d');
INSERT INTO `sys_role_menu` VALUES ('3afecc684344480db6fa3c4c009f1a3e', 'b1f9ce5543a049be9f169a3f5e6b72a8', '5d3dd56c16ff4e32aecae1b3228159c7');
INSERT INTO `sys_role_menu` VALUES ('3d139e1340ef44098d4a14640fddb8b9', 'b1f9ce5543a049be9f169a3f5e6b72a8', '3');
INSERT INTO `sys_role_menu` VALUES ('421fe4c5ec344906a70cdbfcab44a9a6', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'd2bc30feb5474a1bb7e02d48d39a3f8a');
INSERT INTO `sys_role_menu` VALUES ('4458e52ae623460f8afb8da5f85fab08', 'b1f9ce5543a049be9f169a3f5e6b72a8', '0818e1c76bbd44eba3a698547ec4e637');
INSERT INTO `sys_role_menu` VALUES ('528519731933415298e3cd81cfa082e4', 'b1f9ce5543a049be9f169a3f5e6b72a8', '3da0154b4b4a4303bfc508f3d7e452db');
INSERT INTO `sys_role_menu` VALUES ('5534fc87c9b44316b484ade8cdcbaac1', 'b1f9ce5543a049be9f169a3f5e6b72a8', '6bdc1683d3ad44128f1f80bdbf0580e7');
INSERT INTO `sys_role_menu` VALUES ('57779a5b40bd40b995c447f0a6e0a06b', '6a2994e4788a44f0973b5ca6ac4b6d73', '08bc9ae261454d43a3d7c59c7e38507c');
INSERT INTO `sys_role_menu` VALUES ('59d0c13464e540e4ae1cf1708fed8dd6', 'b1f9ce5543a049be9f169a3f5e6b72a8', '4253190001c1480fb0d631d64d150535');
INSERT INTO `sys_role_menu` VALUES ('5d9912a14581416c820610a15ea9b2cd', 'b1f9ce5543a049be9f169a3f5e6b72a8', '22e38e885f9b40b9aae6a36deb78e89c');
INSERT INTO `sys_role_menu` VALUES ('5dc5112fb7534884a72ba5ed3b7765c5', '6a2994e4788a44f0973b5ca6ac4b6d73', '3da0154b4b4a4303bfc508f3d7e452db');
INSERT INTO `sys_role_menu` VALUES ('617dfc6d53214ef6b065682b1bb97e96', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'b4e7232189b14cf3ba160cf7b0d3bf37');
INSERT INTO `sys_role_menu` VALUES ('74914c7a11ca4ef29847586f27b6c3ac', '6a2994e4788a44f0973b5ca6ac4b6d73', 'c6bfb8c2d70b4b57a7da69b8b20538a4');
INSERT INTO `sys_role_menu` VALUES ('788a4bb585ff4f5fb9047f148ecc9ec8', 'b1f9ce5543a049be9f169a3f5e6b72a8', '4611d6d618f3439da7a4ceb459009be3');
INSERT INTO `sys_role_menu` VALUES ('7b8373573d984e43b126dd0aad4c0586', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'cc8d1a5f520e44c294c65f41ac4a37c3');
INSERT INTO `sys_role_menu` VALUES ('7ef7a36080d2454a868996f4a8e1591f', 'b1f9ce5543a049be9f169a3f5e6b72a8', '60610d001b0f471da0b1ce1ed14eeec5');
INSERT INTO `sys_role_menu` VALUES ('81b251f73edb4cad9c19ad78c99c7a3e', 'b1f9ce5543a049be9f169a3f5e6b72a8', '60dda993d87647f5989c15f14f866df9');
INSERT INTO `sys_role_menu` VALUES ('83a60efd7bb94934beac39014efc0461', 'b1f9ce5543a049be9f169a3f5e6b72a8', '915c309ebe5047b68645b3eb777dd8c9');
INSERT INTO `sys_role_menu` VALUES ('8a5c9d18ef2d4b268e7b3029eff09ff2', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'a73802e513cc4465883530ec8074abbb');
INSERT INTO `sys_role_menu` VALUES ('8c6e917c832d4ec986bf04bcc9597ddc', '6a2994e4788a44f0973b5ca6ac4b6d73', 'ee54fe93fd0b4255a22fefeb2b6de084');
INSERT INTO `sys_role_menu` VALUES ('8dd6f171cde044cc9dc7d63f61d8460a', 'b1f9ce5543a049be9f169a3f5e6b72a8', '649b484b58414d91aefa5a26143e6557');
INSERT INTO `sys_role_menu` VALUES ('95811fac7a624cb9a1d49987dae93f2d', 'b1f9ce5543a049be9f169a3f5e6b72a8', '4e816a9854714d24b0413d929d637a2b');
INSERT INTO `sys_role_menu` VALUES ('9b71160d80c849e595db0ac686401fca', 'b1f9ce5543a049be9f169a3f5e6b72a8', '2cf4fc34f42b40ed9325489629689f9a');
INSERT INTO `sys_role_menu` VALUES ('9df9231526cd472daf57f0e96297efff', 'b1f9ce5543a049be9f169a3f5e6b72a8', '3fb6a7a5935b4efabf3de82e7e1baeb6');
INSERT INTO `sys_role_menu` VALUES ('9ef858f2d4ea4d59843fc7236e0ea324', 'b1f9ce5543a049be9f169a3f5e6b72a8', '488ef1eff57b4827acade7c0744278ce');
INSERT INTO `sys_role_menu` VALUES ('a2729d2b9e7e4d8abfd0b21a0ad8e02b', 'b1f9ce5543a049be9f169a3f5e6b72a8', '08bc9ae261454d43a3d7c59c7e38507c');
INSERT INTO `sys_role_menu` VALUES ('a2902ebf93864380afa099dc285e114e', '6a2994e4788a44f0973b5ca6ac4b6d73', '476dbef5152040668acffbdb5683d49d');
INSERT INTO `sys_role_menu` VALUES ('a56bc7836b494764b42ce87c3cc4ea52', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'f5a20c82110b4a3ea9e30ca01a038680');
INSERT INTO `sys_role_menu` VALUES ('a946e306e42f43a888d734b66208e61e', 'b1f9ce5543a049be9f169a3f5e6b72a8', '79d78b8357174cac8f44abd275dec597');
INSERT INTO `sys_role_menu` VALUES ('ac1e67c15ad6481aa85ebb9c00a9e777', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'b71a4dc089754301a38783f126e48d3d');
INSERT INTO `sys_role_menu` VALUES ('aed650feb4d244cfa08f6408e950ae27', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'f417a2a4ead048379a0c60c04ac42012');
INSERT INTO `sys_role_menu` VALUES ('af1ac01b32c745c78bd76be55320885c', '6a2994e4788a44f0973b5ca6ac4b6d73', '6bdc1683d3ad44128f1f80bdbf0580e7');
INSERT INTO `sys_role_menu` VALUES ('b23d5bc841a04c91bee4d296008b8326', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'dc5f478d98ed4297a8ae638fe90df050');
INSERT INTO `sys_role_menu` VALUES ('b428c376eb874f498d10d0fe5206594a', '6a2994e4788a44f0973b5ca6ac4b6d73', 'f3e3b049dd9d4433a5a8dcaf78f38253');
INSERT INTO `sys_role_menu` VALUES ('c2aeb23a10cf4ccfb34027ba3bf1e106', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'd9c96546f5c74f87a86c3febed252f4b');
INSERT INTO `sys_role_menu` VALUES ('c79f013dc76e4e50aab74706c1b0cd20', 'b1f9ce5543a049be9f169a3f5e6b72a8', '5');
INSERT INTO `sys_role_menu` VALUES ('d46e82e549674dd8ace014447cde2c4c', '6a2994e4788a44f0973b5ca6ac4b6d73', 'd9c96546f5c74f87a86c3febed252f4b');
INSERT INTO `sys_role_menu` VALUES ('d7bd2e027b7444308b555482c75a7e1a', 'b1f9ce5543a049be9f169a3f5e6b72a8', '686630c7cb624cc786dcdc9958971a6b');
INSERT INTO `sys_role_menu` VALUES ('d9b601d3e7594458974c7e7838a3cb00', 'b1f9ce5543a049be9f169a3f5e6b72a8', '42dd5ae31e3a43b3a197440e8ec19a94');
INSERT INTO `sys_role_menu` VALUES ('dad0474d106749de985a2841f3c41eca', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'b9cd0a3916fb4c969ecb0157e46be1c0');
INSERT INTO `sys_role_menu` VALUES ('dc63e0097e4a47128f2641b76b1841d5', 'b1f9ce5543a049be9f169a3f5e6b72a8', '1db9105008404a3485b6fac30dba3c0e');
INSERT INTO `sys_role_menu` VALUES ('e42a551255d04a27b1ab8863eea50089', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'c6bfb8c2d70b4b57a7da69b8b20538a4');
INSERT INTO `sys_role_menu` VALUES ('e576c95e602449749e30aa3f0dec5a69', 'b1f9ce5543a049be9f169a3f5e6b72a8', '4');
INSERT INTO `sys_role_menu` VALUES ('e850e5cb501141b89a9a2d8c761b975b', 'b1f9ce5543a049be9f169a3f5e6b72a8', '4b61631a329f42fe8ed6acca78f0ce8a');
INSERT INTO `sys_role_menu` VALUES ('f35f7506a5964f2d8b372b400e45d037', 'b1f9ce5543a049be9f169a3f5e6b72a8', 'a5ebf29168234406939856bc6890c86b');
INSERT INTO `sys_role_menu` VALUES ('f8bc603b50b5469fbb8f021dd6ab4424', 'b1f9ce5543a049be9f169a3f5e6b72a8', '363a778e78a346a68210b2590163a943');
INSERT INTO `sys_role_menu` VALUES ('fac9735e48674160ae40c20f6d5be3a9', 'b1f9ce5543a049be9f169a3f5e6b72a8', '2');

-- ----------------------------
-- Table structure for `sys_setting`
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting` (
  `Id` varchar(50) NOT NULL COMMENT '主键',
  `sysKey` varchar(50) NOT NULL COMMENT 'KEY',
  `sysName` varchar(50) NOT NULL COMMENT '名称',
  `sysValue` varchar(300) DEFAULT NULL COMMENT '值',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `sysDesc` varchar(300) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统设置表';

-- ----------------------------
-- Records of sys_setting
-- ----------------------------
INSERT INTO `sys_setting` VALUES ('1', 'systemName', '系统名称', 'Dieudo-admin', '0', null);
INSERT INTO `sys_setting` VALUES ('2', 'systemSubName', '系统简称', '后台管理系统V1.03', '1', null);
INSERT INTO `sys_setting` VALUES ('3', 'bottomCopyright', '许可说明', 'Copyright © 2018 XXX管理有限公司. All rights reserved.', '2', null);

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `userState` int(2) NOT NULL DEFAULT '1' COMMENT '用户状态,1-启用,-1禁用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `userDesc` varchar(300) DEFAULT NULL COMMENT '描述',
  `userImg` varchar(300) DEFAULT 'http://news.mydrivers.com/Img/20110518/04481549.png' COMMENT '头像',
  `deptId` varchar(50) DEFAULT NULL COMMENT '部门主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('45300712cbc343d3998a065164b72067', 'zhangbaochun', '2512a468e49402cbf91e9b8ff422e855', '1', '2018-04-12 18:42:05', '', '/img/profile.jpg', '9a329b597d754c4180c6b40cdfb0f565');
INSERT INTO `sys_user` VALUES ('c4e78cdcfe454dea84f3e0594184be2d', 'dieudonne', 'd9f6114ee83e4e5e43d5e02be46992f7', '1', '2018-12-11 11:19:30', 'vhghghghgfhfghg', null, '9a329b597d754c4180c6b40cdfb0f565');
INSERT INTO `sys_user` VALUES ('c79ba431f9f74dfbae585b87b0cde933', 'admin', '038bdaf98f2037b31f1e75b5b4c9b26e', '1', '2017-09-14 15:02:17', '', null, '9a329b597d754c4180c6b40cdfb0f565');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `Id` varchar(50) NOT NULL COMMENT '主键',
  `userId` varchar(50) NOT NULL COMMENT '用户主键',
  `roleId` varchar(50) NOT NULL COMMENT '角色主键',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('b63941907fd046fab09ce0930489bbe2', 'c79ba431f9f74dfbae585b87b0cde933', 'b1f9ce5543a049be9f169a3f5e6b72a8');
INSERT INTO `sys_user_role` VALUES ('cc57a825df4f4a15a417be1e58cc4ae7', '45300712cbc343d3998a065164b72067', '6a2994e4788a44f0973b5ca6ac4b6d73');
