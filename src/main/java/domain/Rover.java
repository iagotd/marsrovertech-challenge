package domain;

public class Rover {
    public Rover(String input) throws IncorrectArgument {
        if(("").equals(input)){
            throw new IncorrectArgument();
        }
    }

    public String execute() {
        return "";
    }
}
