package common.validations;

import java.util.regex.Pattern;

public final class Phone {
    private static final String PHONE_REGEX = "^(\\+8801|01)[3-9][0-9]{8}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    public static boolean validate(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }
}
