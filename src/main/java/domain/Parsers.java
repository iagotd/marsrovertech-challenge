package domain;

import java.util.ArrayList;
import java.util.List;

public class Parsers {

  private static final String SPACE = " ";
  private static final String NEW_LINE = "\n";

  private Parsers(){
    // Nothing to do here
  }

  public static RoverCool parseRover(String input) {
    final String[] split = input.split(NEW_LINE);
    return new RoverCool(parserPosition(split[0]), parseOrientation(split[0]), parseInstructions(split[1]));
  }

  private static List<Instructions> parseInstructions(String s) {
    final ArrayList<Instructions> instructions = new ArrayList<>();
    for (char c : s.toCharArray()) {
      instructions.add(Instructions.valueOf(String.valueOf(c)));
    }
    return instructions;
  }

  private static Orientation parseOrientation(String s) {
    return Orientation.valueOf(s.split(SPACE)[2]);
  }

  private static Position parserPosition(String s) {
    return new Position(new Coordinate(Integer.parseInt(s.split(SPACE)[0])),
        new Coordinate(Integer.parseInt(s.split(SPACE)[1])));
  }
}
