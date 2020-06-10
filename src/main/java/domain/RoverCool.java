package domain;

import java.util.List;

public class RoverCool {
  private final Position position;
  private final Orientation orientation;
  private final List<Instructions> instructions;

  public RoverCool(Position position, Orientation orientation, List<Instructions> instructions) {
    this.position = position;
    this.orientation = orientation;
    this.instructions = instructions;
  }

  @Override
  public String toString() {
    return "RoverCool{" +
        "position=" + position +
        ", orientation=" + orientation +
        ", instructions=" + instructions +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    RoverCool roverCool = (RoverCool) o;

    if (!position.equals(roverCool.position)) {
      return false;
    }
    if (orientation != roverCool.orientation) {
      return false;
    }
    return instructions.equals(roverCool.instructions);
  }

  @Override
  public int hashCode() {
    int result = position.hashCode();
    result = 31 * result + orientation.hashCode();
    result = 31 * result + instructions.hashCode();
    return result;
  }
}
