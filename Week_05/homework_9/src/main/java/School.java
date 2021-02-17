
import lombok.Data;


import java.util.List;

@Data
public class School {

    List<Klass> class1;

    public void show() {
        class1.forEach(System.out::println);
    }

}
