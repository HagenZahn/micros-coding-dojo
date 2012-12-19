import org.junit.Assert
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: hagen.zahn
 * Date: 19.12.12
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
class FizzBuzzTest {

    private def fizzBuzz = new FizzBuzz()

    @Test
    public void doFizzBuzzShouldGetHundredEntries() {
      def result = fizzBuzz.doFizzBuzz()
      assert result.size() == 100
    }

    @Test
    public void testDefaultNumber() {
        def result = fizzBuzz.doFizzBuzz()
        assert result.get(25) == 26
    }

    @Test
    public void testThreeDivisionReturnsFizz() {
        assert fizzBuzz.doFizzBuzz()[26] == "Fizz"
    }

    @Test
    void testFiveDivisionReturnBuzz() {
        assert fizzBuzz.doFizzBuzz()[4] == "Buzz"
    }

    @Test
    void testFiveAndThreeDivisionReturnFizzBuzz() {
        assert fizzBuzz.doFizzBuzz()[14] == "FizzBuzz"
    }

    @Test
    void testAddRule() {
        fizzBuzz.addRule({it == 1}, "One")
        assert fizzBuzz.doFizzBuzz()[0] == "One"
    }
}
