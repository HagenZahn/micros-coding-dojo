public class StringCalculator {

    private static final String SEPARATORS = "(\\.|\\n)";
    private int sum = 0;

    public int add(String value) throws Exception {
        if (value.isEmpty()){
            return sum;
        }

        String separators = SEPARATORS;
        String delimiter = null;

        if (value.startsWith("//")) {
            if ( !value.substring(3,4).equals("\n")) {
                throw new Exception();
            }
            delimiter = value.substring(2,3);
            value = value.substring(4);
            separators = "(\\" + delimiter + "|\\n)";
        }



        for (String token : value.split(separators)) {
            Integer number = Integer.valueOf(token);
            checkForNegativeValue(number);
            sum += number;
        }

        return sum;
    }

    private void checkForNegativeValue(int number) throws Exception {
        if (number < 0) {
            throw new Exception();
        }
    }
}
