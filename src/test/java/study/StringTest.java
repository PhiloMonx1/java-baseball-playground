package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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


    //요구사항 3
    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    void getCharAtPosition(){
        String input = "abc";
        char actual = input.charAt(1);

        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기 (예외 발생 : IndexOutOfBounds)")
    void getCharAtPositionIndexOutOfBoundsException() {
        String input = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                char actual = input.charAt(55);
            }).withMessageMatching("String index out of range: 55");
    }
}
