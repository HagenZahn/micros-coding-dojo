import org.junit.Test
import org.junit.Before

class FizzBuzzTest {

  def fizzBuzz

    @Before void setUp() {
        fizzBuzz = new FizzBuzz()
    }
  @Test
  void fizzBuzzReturnsArray() {
    assert fizzBuzz.process().size() == 100
  }

  @Test
  void thirdElementIsFizz() {
      assert fizzBuzz.process()[2] == "Fizz"
  }

  @Test
  void multipleOfThreeIsFizz() {
      def matcher = {number -> number % 3 == 0 && number % 5 != 0 }
      assertCorrectModification(matcher,"Fizz")
  }

    private void assertCorrectModification(def matcher, def modifier) {
        def numbers = 1..100
        def result = fizzBuzz.process()
        numbers.each({
            assert  matcher(it)  ? result[it - 1] == modifier : result[it - 1] != modifier
        })
    }

    @Test void multipleOfFiveIsBuzz() {
        def matcher = {number -> number % 5 == 0  && number % 3 != 0 }
        assertCorrectModification(matcher,"Buzz")
    }

    @Test void multipleOfFiveAndOfThreeIsFizzBuzz() {
        def matcher = {number -> number % 5 == 0  && number % 3 == 0 }
        assertCorrectModification(matcher,"FizzBuzz")
    }

}
