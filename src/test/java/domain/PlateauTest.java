package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlateauTest {
    @Test
    void shouldThrowErrorWhenEmptyInput() {
        String input = "";
        Assertions.assertThrows(IncorrectArgument.class, () -> new Plateau(input));
    }

    @Test
    void shouldThrowErrorWhenInputLessThanThreeLines() {
        String input = "5 5\n" +
                "1 2 N\n";
        Assertions.assertThrows(IncorrectArgument.class, () -> new Plateau(input));
    }


}
