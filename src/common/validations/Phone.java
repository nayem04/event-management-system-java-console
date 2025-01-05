package common.validations;

public final class Phone {
    private static final String PHONE_REGEX = "^(\\+8801|01)[3-9][0-9]{8}$";

    public static boolean validate(final String phone) {
        return Validator.validate(phone, PHONE_REGEX);
    }
}
