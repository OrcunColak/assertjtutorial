package customassert;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void testPerson() {
        Person john = new Person("John", 25);

        // Use custom assertions
        PersonAssert.assertThat(john)
                .hasName("John")
                .hasAge(25);
    }

    @Test
    void testPersonWithStandardAssertions() {
        Person jane = new Person("Jane", 30);

        // Use standard AssertJ assertions
        assertThat(jane.getName()).isEqualTo("Jane");
        assertThat(jane.getAge()).isEqualTo(30);
    }
}

