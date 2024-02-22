package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    //요구사항 1
    @Test
    void splitString() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void splitStringOnlyOne() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void splitStringToInt() {
        String[] input = "1,2".split(",");
        int[] actual = new int[input.length];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = Integer.parseInt(input[i]);
        }
        assertThat(actual).containsExactly(1,2);
    }


    //요구사항 2
    @Test
    void removeParenthesesFromString() {
        String input = "(1,2)";
        String actual= input.substring(1,input.length()-1);
        assertThat(actual).isEqualTo("1,2");
    }

}
