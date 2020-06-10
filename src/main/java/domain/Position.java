package domain;

public class Position {
  private final Coordinate x;
  private final Coordinate y;

  public Position(Coordinate x, Coordinate y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "{x=" + x +
        ", y=" + y +
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

    Position position = (Position) o;

    if (!x.equals(position.x)) {
      return false;
    }
    return y.equals(position.y);
  }

  @Override
  public int hashCode() {
    int result = x.hashCode();
    result = 31 * result + y.hashCode();
    return result;
  }
}
