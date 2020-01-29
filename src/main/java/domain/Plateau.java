package domain;

public class Plateau {
    public Plateau(String input) throws IncorrectArgument {
        if(("").equals(input) || input.split("\n").length <= 2){
            throw new IncorrectArgument();
        }
    }

    public String execute() {
        return "";
    }
}
