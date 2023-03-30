package boot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

@Configuration
@EnableConfigurationProperties(ProjectProperties.class)
public class CitiesInitializer implements InitializingBean {

  @Resource
  private CityDao cityDao;

  @Resource
  private ObjectMapper objectMapper;

  @Resource
  private ProjectProperties projectProperties;

  @Override
  public void afterPropertiesSet() throws Exception {
    org.springframework.core.io.Resource resource = new ClassPathResource(projectProperties.getCitiesFile());

    List<City> cities;
    try (InputStream inputStream = resource.getInputStream()) {
      cities = objectMapper.readValue(inputStream, new TypeReference<List<City>>() {
      });
    }
    cities.forEach(cityDao::add);
  }
}