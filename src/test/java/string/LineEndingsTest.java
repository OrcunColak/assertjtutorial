package string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineEndingsTest {

    @Test
    void testEOL() {
        String str1 = "Line1\nLine2\nLine3";
        String str2 = "Line1\r\nLine2\r\nLine3";


        // Use AssertJ to assert that the normalized strings are equal
        assertThat(str1).isEqualToNormalizingNewlines(str2);
    }
}
