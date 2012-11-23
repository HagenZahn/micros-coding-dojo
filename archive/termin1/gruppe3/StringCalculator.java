public class StringCalculator {

    private int result = 0;

    public int add(String inputString){
        if (!inputString.isEmpty()) {
            char separator = '.';
            String separatedNumberString = inputString;
            if(inputString.startsWith("//")){
                separator = inputString.charAt(2);
                separatedNumberString = inputString.substring(4);
            }
            for(String number : separatedNumberString.split("["+separator+"\\n]")){
                Integer value = Integer.valueOf(number);
                checkNegativeNumber(value);
                result += value;
            }
        }
        return result;
    }

    private void checkNegativeNumber(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }
}
