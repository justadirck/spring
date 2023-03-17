package boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityDaoTest {

  private static final String CITY_ID = "sim";
  private CityDao cityDao;
  private City simCity;

  @BeforeEach
  void setup() {
    cityDao = new CityDao();
    simCity = new City(CITY_ID, "Sim City", 2016, 123_456);
    cityDao.add(simCity);
  }

  @Test
  void should_return_empty_optional_for_unknown_id() {
    Optional<City> city = cityDao.find("unknown");

    assertThat(city).isNotPresent();
  }

  @Test
  void should_add_city() {
    Optional<City> city = cityDao.find(CITY_ID);

    assertThat(city)
        .isPresent()
        .hasValue(simCity);
  }

  @Test
  void should_update_city() {
    simCity.setFoundedIn(2015);
    cityDao.update(simCity);

    Optional<City> city = cityDao.find(CITY_ID);

    assertThat(city)
        .isPresent()
        .hasValueSatisfying(s -> assertThat(s.getFoundedIn()).isEqualTo(2015));
  }

  @Test
  void should_remove_city() {
    cityDao.remove(CITY_ID);

    Optional<City> city = cityDao.find(CITY_ID);

    assertThat(city).isNotPresent();
  }

  @Test
  void should_find_all_cities() {
    List<City> cities = cityDao.getAll();

    assertThat(cities)
        .hasSize(1)
        .containsExactly(simCity);
  }
}