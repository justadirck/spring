package boot;

import static eu.jasha.demo.sbtfragments.HomeController.VIEW_INDEX;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeControllerTest {

  private HomeController controller;

  @BeforeEach
  void setup() {
    controller = new HomeController();
  }

  @Test
  void should_show_index() {
    String home = controller.getHome();

    assertThat(home).isEqualTo(VIEW_INDEX);
  }
}