package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MarsTest {
    @Test
    void shouldThrowErrorWhenEmptyInput() {
        String input = "";
        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenInputLessThanThreeLines() {
        String input = "5 5\n" +
                "1 2 N\n";
        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenInputNotOddNumberOfLines() {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n";
        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenSizeIsNotCorrect() {
        String input = "5 \n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenSizeIsNotNumber() {
        String input = "5 N\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldNotThrowErrorWhenHeightIsOk() throws IncorrectArgument, IncorrectCommand {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Mars mars = new Mars(input);
        Assertions.assertEquals(5, mars.getPlateauHeight());
    }

    @Test
    void shouldNotThrowErrorWhenWidthIsOk() throws IncorrectArgument, IncorrectCommand {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Mars mars = new Mars(input);
        Assertions.assertEquals(6, mars.getPlateauWidth());
    }

    @Test
    void shouldThrowErrorWhenCoordinatesNotCorrect() {
        String input = "5 6\n" +
                "1 2 \n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenCoordinatesNotNumber() {
        String input = "5 6\n" +
                "1 A N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenCoordinatesNotWindRose() {
        String input = "5 6\n" +
                "1 2 X\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenOrderNotLMR() {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMMX\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenRoverOutOfLimits() {
        String input = "5 6\n" +
                "1 2 N\n" +
                "MMMMMMMMMMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        Assertions.assertThrows(IncorrectCommand.class, () -> new Mars(input));
    }


}
