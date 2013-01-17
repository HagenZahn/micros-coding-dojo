import groovyx.gpars.ParallelEnhancer

class FizzBuzz {

    def rules = []

    FizzBuzz() {
        addRule( [{it % 3 == 0 && it % 5 == 0}, "FizzBuzz"] )
        addRule( [{it % 3 == 0}, "Fizz"] )
        addRule( [{it % 5 == 0}, "Buzz"] )
    }

    def addRule(Closure rule, def result) {
        rules.add( [rule, result] )
    }

    def getNumbers() {
        def numbers = 1..500000

        ParallelEnhancer.enhanceInstance numbers
        numbers.makeConcurrent()

        numbers.collect {
            def findResult = rules.find{rule -> rule[0](it)}
            findResult == null ? it : findResult[1]
        }

    }

}
