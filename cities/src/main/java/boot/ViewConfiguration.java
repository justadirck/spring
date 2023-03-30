package boot;

import ch.mfrey.thymeleaf.extras.with.WithDialect;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ViewConfiguration {

    @Bean
    LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Bean
    WithDialect withDialect() {
        return new WithDialect();
    }

}