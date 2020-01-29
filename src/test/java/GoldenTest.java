import domain.IncorrectArgument;
import domain.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GoldenTest {
    @Test
    void shouldReturnExpected () throws IncorrectArgument {
        String input = "5 5\n" +
                "\n" +
                "1 2 N\n" +
                "\n" +
                "LMLMLMLMM\n" +
                "\n" +
                "3 3 E\n" +
                "\n" +
                "MMRMMRMRRM";

        String expected = "1 3 N\n" +
                "\n" +
                "5 1 E";

        String actual = new Rover(input).execute();

        Assertions.assertEquals(expected, actual);
    }

}
