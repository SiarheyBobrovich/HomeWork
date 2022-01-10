package calculator.string_calculator3.test;

import calculator.string_calculator3.dto.DecoratorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorFactoryTest {


    DecoratorFactory factory = new DecoratorFactory();

    @Test
    void reverse() {
        Assertions.assertEquals("5 + 3 + 12", factory.reverse("12 + 3 + 5"));
    }

}