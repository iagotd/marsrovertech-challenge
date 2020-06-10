package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.Instructions.L;
import static domain.Instructions.M;
import static domain.Orientation.N;

class ParsersTest {

  @Test
  void shouldReturnRoverWhenInputIsCorrect() {
    String input = "1 2 N\n" +
        "LMLMLMLMM\n";

    RoverCool actual = Parsers.parseRover(input);

    List<Instructions> l = List.of(L, M, L, M, L, M, L, M, M);
    Position position = new Position(new Coordinate(1), new Coordinate(2));
    Assertions.assertEquals(new RoverCool(position, N, l), actual);
  }
}