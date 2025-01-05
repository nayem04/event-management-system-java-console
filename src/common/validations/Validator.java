package common.validations;

import java.util.regex.Pattern;

public final class Validator {
    public static boolean validate(final String regx, final String input) {
        Pattern pattern = Pattern.compile(regx);
        return input != null && !input.isEmpty() && pattern.matcher(input).matches();
    }
}
