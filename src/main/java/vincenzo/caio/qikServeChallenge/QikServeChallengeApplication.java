package vincenzo.caio.qikServeChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QikServeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QikServeChallengeApplication.class, args);
	}

}
