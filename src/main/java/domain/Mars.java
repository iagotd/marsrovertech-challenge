package domain;

public class Mars {
    private int plateauHeight;
    private int plateauWidth;

    public Mars(String input) throws IncorrectArgument {
        if (("").equals(input) || input.split("\n").length <= 2) {
            throw new IncorrectArgument();
        }

        if(input.split("\n").length % 2 == 0)
            throw new IncorrectArgument();

        checkPlateauSizeParameters(input);
        checkCoordinatesParameters(input);

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

    private void setPlateauHeight(int parseInt) {
        this.plateauHeight = parseInt;
    }

    private void setPlateauWidth(int parseInt) {
        this.plateauWidth = parseInt;
    }
}
