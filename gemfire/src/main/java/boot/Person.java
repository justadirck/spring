package boot.model;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Data
@Region("People")
public class Person {

  private static AtomicLong counter = new AtomicLong(0L);

  @Id
  private Long id;

  private String firstName;
  private String lastName;

  @PersistenceCreator
  public Person() {
    this.id = counter.incrementAndGet();
  }
  
}