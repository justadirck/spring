package boot;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		RepositoryRestConfiguration repositoryRestConfiguration = ctx.getBean(RepositoryRestConfiguration.class);

        repositoryRestConfiguration.setReturnBodyForPutAndPost(true);
		
	}

}
