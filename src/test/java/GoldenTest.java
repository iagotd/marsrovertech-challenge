import domain.IncorrectArgument;
import domain.IncorrectCommand;
import domain.Mars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GoldenTest {
    @Test
    void shouldReturnExpected () throws IncorrectArgument, IncorrectCommand {
        String input = "6 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";

        String expected = "1 3 N\n" +
                "5 1 E";

        String actual = new Mars(input).execute();

        Assertions.assertEquals(expected, actual);
    }

}
