package exceptionmessage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * See https://jsparrow.github.io/rules/replace-j-unit-expected-exception.html#tags
 * Easily replace the following JUnit code:
 * <pre>
 * {@code
 * @Rule
 * public ExpectedException thrown = ExpectedException.none();
 *
 * @Test
 * public void exampleTest() {
 *   thrown.expect(SomeException.class);
 *   thrown.expectMessage("Expected exception message");
 * }
 * </pre>
 */
class ExceptionMessageTest {

    @Test
    void assertThatThrownBy1() {
        // It can also be
        // assertThrows(IOException.class, () -> ...);

        assertThatThrownBy(this::process)
                .hasMessageContaining("is missing a timestamp definition");
    }

    @Test
    void assertThatThrownBy2() {
        assertThatThrownBy(this::process)
                .hasMessageContaining("is missing a timestamp definition");

        // assertThatThrownBy does not stop the test. The statement below will fail the test
        int result = 4;
        assertEquals(5, result);
    }

    void process() {
        throw new RuntimeException("prefix is missing a timestamp definition suffix");
    }
}
