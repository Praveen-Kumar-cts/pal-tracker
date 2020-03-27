package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mysql.cj.jdbc.MysqlDataSource;

@SpringBootApplication
public class PalTrackerApplication {
	
	
	@Bean
	public TimeEntryRepository getTimeEntryRepository() {
		 MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
		
		return new JdbcTimeEntryRepository(dataSource);
	}
	public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
}
