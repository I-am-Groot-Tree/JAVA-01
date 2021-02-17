
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;


@Configuration
public class StudentConfig {

    @Bean(name = "student01")
    public Student build() {
        return new Student(2, 20, "test");
    }
}
