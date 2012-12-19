import groovyx.gpars.GParsPool

/**
 * Created with IntelliJ IDEA.
 * User: hagen.zahn
 * Date: 19.12.12
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
class FizzBuzz {

    FizzBuzz() {
        addRule({ (it % 3 == 0 && it % 5 == 0) }, "FizzBuzz")
        addRule({ it % 3 == 0 }, "Fizz")
        addRule({ it % 5 == 0 }, "Buzz")
    }


    def rules = new HashMap()


    def doFizzBuzz() {

        (1..100).collect  ({ element ->

            def ruleResult = rules.find({ rule ->
                rule.key(element)
            })
            ruleResult == null ? element : ruleResult.value
        })

    }

    def addRule(Closure condition, def replacement) {
        rules.put(condition, replacement)
    }
}
