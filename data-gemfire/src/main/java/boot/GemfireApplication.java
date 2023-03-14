package boot;

import boot.model.Person;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@ClientCacheApplication(name = "AccessingGemFireDataRestApplication")
@EnableEntityDefinedRegions(
  basePackageClasses = Person.class,
  clientRegionShortcut = ClientRegionShortcut.LOCAL
)
@EnableGemfireRepositories
public class GemfireApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemfireApplication.class, args);
	}

}
