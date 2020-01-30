package domain;

public class Mars {
    private int plateauHeight;
    private int plateauWidth;
    private int[][] plateauGrid;
    private int numberOfRovers;

    public Mars(String input) throws IncorrectArgument, IncorrectCommand {
        if (("").equals(input) || input.split("\n").length <= 2) {
            throw new IncorrectArgument();
        }

        if (input.split("\n").length % 2 == 0)
            throw new IncorrectArgument();

        setNumberOfRovers(input.split("\n").length / 2);

        checkPlateauSizeParameters(input);
        checkCoordinatesParameters(input);
        checkOrdersParameters(input);

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
                setPlateauHeight(Integer.parseInt(input.split("\n")[0].trim().split(" ")[0]));
                setPlateauWidth(Integer.parseInt(input.split("\n")[0].trim().split(" ")[1]));
            } catch (NumberFormatException e) {
                throw new IncorrectArgument();
            }
        } else {
            throw new IncorrectArgument();
        }
    }

    private void checkCoordinatesParameters(String input) throws IncorrectArgument {
        if (input.split("\n")[1].trim().split(" ").length == 3) {
            try {
                int x = Integer.parseInt(input.split("\n")[1].trim().split(" ")[0]);
                int y = Integer.parseInt(input.split("\n")[1].trim().split(" ")[1]);

                switch (input.split("\n")[1].trim().split(" ")[2].trim()) {
                    case "N":
                    case "S":
                    case "W":
                    case "E":
                        break;
                    default:
                        throw new IncorrectArgument();
                }

            } catch (NumberFormatException e) {
                throw new IncorrectArgument();
            }
        } else {
            throw new IncorrectArgument();
        }
    }

    public String execute() {
        return "";
    }

    public int getPlateauHeight() {
        return this.plateauHeight;
    }

    public int getPlateauWidth() {
        return this.plateauWidth;
    }

    public int[][] getPlateauGrid() {
        return this.plateauGrid;
    }

    public int getNumberOfRovers() {
        return this.numberOfRovers;
    }

    private void setPlateauHeight(int parseInt) {
        this.plateauHeight = parseInt;
    }

    private void setPlateauWidth(int parseInt) {
        this.plateauWidth = parseInt;
    }

    private void setPlateauGrid(int[][] plateauGrid) {
        this.plateauGrid = plateauGrid;
    }

    private void setNumberOfRovers(int numberOfRovers) {
        this.numberOfRovers = numberOfRovers;
    }

}
