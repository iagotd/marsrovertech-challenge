package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoverTest {
    @Test
    void shouldThrowErrorWhenEmptyInput(){
        String input = "";
        Assertions.assertThrows(IncorrectArgument.class, ()->new Rover(input));
    }
}
