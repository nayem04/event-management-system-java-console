package common.validations;

import java.util.regex.Pattern;

public class Validator {
    public static boolean validate(String regx, String input) {
        Pattern pattern = Pattern.compile(regx);
        return pattern.matcher(input).matches();
    }
}
