package domain;

public class Coordinate {
  private final int i;

  public Coordinate(int i) {
    this.i = i;
  }

  @Override
  public String toString() {
    return String.valueOf(i);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Coordinate that = (Coordinate) o;

    return i == that.i;
  }

  @Override
  public int hashCode() {
    return i;
  }
}
