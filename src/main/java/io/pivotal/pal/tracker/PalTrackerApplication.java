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
		dataSource.setUrl("jdbc:mysql://localhost:3306/tracker_dev?user=tracker&useSSL=false&useTimezone=true&serverTimezone=UTC&useLegacyDatetimeCode=false");
		
		return new JdbcTimeEntryRepository(dataSource);
	}
	public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
}
