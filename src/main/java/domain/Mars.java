package domain;

import java.util.ArrayList;

public class Mars {
    private int[][] plateauGrid;
    private ArrayList<Rover> roverList = new ArrayList<>();

    public Mars(String input) throws IncorrectArgument, IncorrectCommand {

        checkNumberOfInputLines(input);
        checkPlateauSizeParameters(input);
        checkCoordinatesParameters(input);
        checkOrdersParameters(input);
    }

    private void checkNumberOfInputLines(String input) throws IncorrectArgument {
        if (("").equals(input) || input.split("\n").length <= 2 || input.split("\n").length % 2 == 0) {
            throw new IncorrectArgument();
        }
    }

    private void checkOrdersParameters(String input) throws IncorrectArgument {

        for (int i = 2; i < input.split("\n").length; i += 2) {
            String order = input.split("\n")[i].trim();
            System.out.println(order + "----" + order.length());
            for (int j = 0; j < order.length(); j++) {
                switch (order.charAt(j)) {
                    case 'L':
                    case 'M':
                    case 'R':
                        break;
                    default:
                        throw new IncorrectArgument();
                }
            }
        }
    }

    private void checkPlateauSizeParameters(String input) throws IncorrectArgument {
        if (input.split("\n")[0].trim().split(" ").length == 2) {
            try {
                plateauGrid = new int[Integer.parseInt(input.split("\n")[0].trim().split(" ")[0])]
                        [Integer.parseInt(input.split("\n")[0].trim().split(" ")[1])];
            } catch (NumberFormatException e) {
                throw new IncorrectArgument();
            }
        } else {
            throw new IncorrectArgument();
        }
    }

    private void checkCoordinatesParameters(String input) throws IncorrectArgument {
        for (int i = 1; i < input.split("\n").length; i += 2) {
            if (input.split("\n")[i].trim().split(" ").length == 3) {
                try {
                    int x = Integer.parseInt(input.split("\n")[i].trim().split(" ")[0]);
                    int y = Integer.parseInt(input.split("\n")[i].trim().split(" ")[1]);
                    String d = "";

                    switch (input.split("\n")[i].trim().split(" ")[2].trim()) {
                        case "N":
                        case "S":
                        case "W":
                        case "E":
                            d = input.split("\n")[i].trim().split(" ")[2].trim();
                            break;
                        default:
                            throw new IncorrectArgument();
                    }

                    for (int j = i + 2; j < input.split("\n").length; j += 2) {
                        if (x == Integer.parseInt(input.split("\n")[j].trim().split(" ")[0]) &&
                                y == Integer.parseInt(input.split("\n")[j].trim().split(" ")[1])) {
                            throw new IncorrectArgument();
                        }
                    }

                    if (i == 1) {
                        roverList.add(new Rover(x, y, d));
                    } else {
                        int x0 = roverList.get((i - 3) / 2).getX();
                        int y0 = roverList.get((i - 3) / 2).getY();

                        if (x == x0 && y == y0) {
                            throw new IncorrectArgument();
                        }

                    }

                } catch (NumberFormatException e) {
                    throw new IncorrectArgument();
                }
            } else {
                throw new IncorrectArgument();
            }
        }
    }

    public String execute() {
        return "";
    }

    public int[][] getPlateauGrid() {
        return this.plateauGrid;
    }

    private void setPlateauGrid(int[][] plateauGrid) {
        this.plateauGrid = plateauGrid;
    }

}
