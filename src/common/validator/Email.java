package common.validator;

import java.util.regex.Pattern;

public final class Email {
    private static final String EMAIL_REGEX = "^[\\w.+_-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean validate(String email) {
        return email != null && !email.isBlank() && EMAIL_PATTERN.matcher(email).matches();
    }
}
