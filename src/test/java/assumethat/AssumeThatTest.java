package assumethat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

@Slf4j
class AssumeThatTest {

    static Stream<Arguments> parametersForTestBeforeOracleFree() {
        // Provide different combinations of parameters here
        return Stream.of(
                Arguments.arguments(true, "BOOLEAN"),
                Arguments.arguments(false, "BOOLEAN"),
                Arguments.arguments(true, "OTHER_TYPE"),
                Arguments.arguments(false, "OTHER_TYPE")
        );
    }

    @ParameterizedTest
    @MethodSource("parametersForTestBeforeOracleFree")
    void testBeforeOracleFree(boolean isOracleFree, String type) {
        // If Oracle Free the test will always run regardless of the type
        // If isOracleFree is false, the test will be ignored when the type is "BOOLEAN"
        assumeThat(isOracleFree || !type.equals("BOOLEAN"))
                .as("Conditions for test execution are met")
                .isTrue();

        log.info("Executing test");
    }

}
