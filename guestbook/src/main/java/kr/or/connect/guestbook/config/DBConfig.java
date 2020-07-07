package kr.or.connect.guestbook.config;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {
	private String driverClassName = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

	private String username = "connectuser";

	private String password = "connectuser";
	
	/*Properties prop = new Properties();
	public DBConfig() {
		ClassLoader cl;
		cl = Thread.currentThread().getContextClassLoader();
		URL url = cl.getResource("application.properties");
		try {
				prop.load(url.openStream());
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	private String driverClassName = prop.getProperty("spring.datasource.driver-class-name");
	private String url = prop.getProperty("spring.datasource.url");
	private String username = prop.getProperty("spring.datasource.username");
	private String password = prop.getProperty("spring.datasource.password");*/

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManger();
	}

	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(dataSource());
	}
}