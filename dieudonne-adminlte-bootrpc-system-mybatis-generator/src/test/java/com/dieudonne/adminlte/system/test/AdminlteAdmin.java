package com.dieudonne.adminlte.system.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 
 * @ClassName:  RxmallSpringBoot   
 * @Description:MyBatis 实体类生成器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年4月19日 上午10:15:49   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class AdminlteAdmin {
	private static Logger logger = Logger.getLogger(AdminlteAdmin.class);
	public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		logger.info("Start generator ...");
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true; // 是否覆盖原来的文件
		File configFile = new File("E:/eclipse-workspace/dieudonne-adminlte-bootrpc/dieudonne-adminlte-bootrpc-parent/dieudonne-adminlte-bootrpc-system-mybatis-generator/src/test/resources/rxmall-spring-boot.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		logger.info("Finish generator");
	}
}
