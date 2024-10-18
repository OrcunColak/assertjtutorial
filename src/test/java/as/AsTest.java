package as;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class AsTest {


    // This example shows how to use as() with parameters like String.format()
    @Test
    void testParameterizedMessage(TestInfo testInfo) {
        String actual = "Hello, World!";
        String expected = "Hello";

        Assertions.assertThat(actual)
                .as("%s failed. Expected is different", testInfo.getDisplayName())
                .isEqualTo(expected);
    }
}
