package boot;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
@WebAppConfiguration
class CitiesInitializerTest {

    @Resource
    private CityDao cityDao;

    @Test
    void should_have_inserted_cities() {
        List<City> cities = cityDao.getAll();

        assertThat(cities).isNotEmpty();
    }
}