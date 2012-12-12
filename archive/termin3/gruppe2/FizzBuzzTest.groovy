import org.junit.Before
import org.junit.Test

public class FizzBuzzTest {
    FizzBuzz fizzBuzz

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz()
    }

    @Test
    public void areThereHundredNumbers() {
        assert fizzBuzz.getNumbers().size() == 100
    }

    @Test
    public void divideByThreeIsFizz() {
        assert fizzBuzz.getNumbers()[2] == "Fizz"
    }

    @Test
    public void divideByThreeAndFiveIsFizzBuzz() {
        assert fizzBuzz.getNumbers()[14] == "FizzBuzz"
    }

    @Test
    public void othersAreNumbers() {
        assert fizzBuzz.numbers[0] == 1
    }

    @Test
    public void divideByFiveIsBuzz() {
        assert fizzBuzz.getNumbers()[4] == "Buzz"
    }

    @Test
    public void moreRulesCanBeAddedModular() {
        fizzBuzz.addRule({it == 1}, "???")
        assert fizzBuzz.getNumbers()[0] == "???"
    }
}