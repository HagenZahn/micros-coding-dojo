
class FizzBuzz {
    def process(){
        def result = (1..100).collect( { it } )
        result = result.collect {
            if (it % 3 == 0 && it % 5 == 0) {
                "FizzBuzz"
            } else if (it % 3 == 0) {
                "Fizz"
            } else if (it % 5 == 0) {
                "Buzz"
            } else {
                it
            }
        }
        return result
    }

    def replace(def condition, def replacement) {
        if (condition) {
            replacement
        }
    }
}
