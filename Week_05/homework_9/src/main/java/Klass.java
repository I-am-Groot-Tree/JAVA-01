import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class Klass {

    List<Student> students;

    public void show() {
        System.out.println("This is my class students:");
        students.forEach(System.out::println);
    }

}
