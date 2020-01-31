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
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenSizeIsNotNumber() {
        String input = "5 N\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldNotThrowErrorWhenHeightIsOk() throws IncorrectArgument, IncorrectCommand {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MRMMRMRRM\n";

        Mars mars = new Mars(input);
        Assertions.assertEquals(6, mars.getPlateauGrid().length);
    }

    @Test
    void shouldNotThrowErrorWhenWidthIsOk() throws IncorrectArgument, IncorrectCommand {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MRMMRMRRM\n";

        Mars mars = new Mars(input);
        Assertions.assertEquals(5, mars.getPlateauGrid()[0].length);
    }

    @Test
    void shouldThrowErrorWhenCoordinatesNotCorrect() {
        String input = "5 6\n" +
                "1 2 \n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenCoordinatesNotNumber() {
        String input = "5 6\n" +
                "1 A N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenCoordinatesNotWindRose() {
        String input = "5 6\n" +
                "1 2 X\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenOrderNotLMR() {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMMX\n" +
                "3 3 E\n" +
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenRoverStartsOnTop(){
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMMX\n" +
                "1 2 E\n" +
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenRoverStartsBeforeLimits() {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMMM\n" +
                "-3 3 E\n" +
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenRoverStartsOutOfLimits() {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LMLMLMLMMM\n" +
                "3 6 E\n" +
                "MRMMRMRRM\n";

        Assertions.assertThrows(IncorrectArgument.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenRoverWalksOutOfLimits() {
        String input = "5 6\n" +
                "1 2 N\n" +
                "MMMLMLMMM\n" +
                "3 3 E\n" +
                "MMMM\n";

        Assertions.assertThrows(IncorrectCommand.class, () -> new Mars(input));
    }

    @Test
    void shouldThrowErrorWhenRoverWalksOnTopOfOtherRover() {
        String input = "5 6\n" +
                "1 2 N\n" +
                "LLLL\n" +
                "3 3 W\n" +
                "MMLM\n";

        Assertions.assertThrows(IncorrectCommand.class, () -> new Mars(input));
    }


}
