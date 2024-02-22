package exceptionmessage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
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
    void when_noTimestamps_then_error() {
        assertThatThrownBy(this::process)
                .hasMessageContaining("is missing a timestamp definition");
    }

    void process() {
        throw new RuntimeException("prefix is missing a timestamp definition suffix");
    }
}
