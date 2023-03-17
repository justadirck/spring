package boot;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {

  private static final long serialVersionUID = 5276571601486161777L;

  private String id;
  private String name;
  private int foundedIn;
  private int population;
}