package optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {

    @Test
    void hasValueSatisfying() {
        record Student(String name) {
        }

        Student student = new Student("student1");
        Optional<Student> optional = Optional.of(student);

        // then - verify the output
        assertThat(optional).isPresent()
                .hasValueSatisfying(optionalStudent -> {
                    assertThat(optionalStudent.name()).isEqualTo("student1");
                });
    }
}
