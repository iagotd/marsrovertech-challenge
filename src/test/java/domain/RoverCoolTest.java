package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.Instructions.M;
import static domain.Orientation.N;

class RoverCoolTest {

  @Test
  void shouldReturnFinalPosition() {
    final RoverCool roverCool = new RoverCool(new Position(new Coordinate(1), new Coordinate(2)), N, List.of(M));

    Assertions.assertEquals(new PositionReport("1 3 N"), roverCool.move());
  }
}