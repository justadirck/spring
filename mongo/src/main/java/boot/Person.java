package boot;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;

}