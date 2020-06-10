package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static domain.Instructions.*;
import static domain.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class ParsersTest {

  private static final List<Instructions> INSTRUCTIONS_LIST = List.of(L, M, L, R, L, M, L, M, M);
  private static final String INSTRUCTIONS_INPUT = "LMLRLMLMM\n";

  @ParameterizedTest
  @MethodSource("getInput")
  void shouldReturnRoverWhenInputIsCorrect(String input, RoverCool expected) {
    assertEquals(expected, Parsers.parseRover(input));
  }

  private static Stream<Arguments> getInput() {
    return Stream.of(
        of("1 2 N\n" + INSTRUCTIONS_INPUT, new RoverCool(new Position(new Coordinate(1), new Coordinate(2)), N,
            INSTRUCTIONS_LIST)),
        of("1 3 S\n" + INSTRUCTIONS_INPUT, new RoverCool(new Position(new Coordinate(1), new Coordinate(3)), S,
            INSTRUCTIONS_LIST)),
        of("3 2 W\n" + INSTRUCTIONS_INPUT, new RoverCool(new Position(new Coordinate(3), new Coordinate(2)), W,
            INSTRUCTIONS_LIST)),
        of("1 4 E\n" + INSTRUCTIONS_INPUT, new RoverCool(new Position(new Coordinate(1), new Coordinate(4)), E,
            INSTRUCTIONS_LIST))
    );
  }
}