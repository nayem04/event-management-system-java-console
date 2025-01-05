package common.validations;

public final class Email {
    private static final String EMAIL_REGEX = "^[\\w.+_-]+@[\\w.-]+\\.[A-Za-z]{2,}$";

    public static boolean validate(final String email) {
        return Validator.validate(EMAIL_REGEX, email);
    }
}
