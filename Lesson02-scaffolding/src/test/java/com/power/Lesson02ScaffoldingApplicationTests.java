package com.power;

import com.power.conf.EnvironmentConfig;
import com.power.conf.PropertiesConfig;
import com.power.conf.YamlConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson02ScaffoldingApplicationTests {

	@Autowired
	private PropertiesConfig propertiesConfig;

	@Test
	void testPropertiesConfig() {
		propertiesConfig.printValue();
	}

//默认加载的是application.properties文件
	//如果需要application.yml文件起作用,给application.properties文件换个名字
	@Autowired
	private YamlConfig yamlConfig;

	@Test
	void testYamlConfig(){
		yamlConfig.printValue();
	}

	@Autowired
	private EnvironmentConfig envConfig;

	@Test
	public void testEnvironment(){
		envConfig.printEnv();
	}
}
