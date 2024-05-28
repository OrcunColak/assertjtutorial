package customassert;

import org.assertj.core.api.AbstractAssert;

public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

    // Constructor
    private PersonAssert(Person actual) {
        super(actual, PersonAssert.class);
    }

    // Custom assertion method to check name
    public PersonAssert hasName(String name) {
        isNotNull();

        if (!actual.getName().equals(name)) {
            failWithMessage("Expected person's name to be <%s> but was <%s>", name, actual.getName());
        }

        return this;
    }

    // Custom assertion method to check age
    public PersonAssert hasAge(int age) {
        isNotNull();

        if (actual.getAge() != age) {
            failWithMessage("Expected person's age to be <%s> but was <%s>", age, actual.getAge());
        }

        return this;
    }

    // Factory method for creating the assertion instance
    public static PersonAssert assertThat(Person actual) {
        return new PersonAssert(actual);
    }
}

