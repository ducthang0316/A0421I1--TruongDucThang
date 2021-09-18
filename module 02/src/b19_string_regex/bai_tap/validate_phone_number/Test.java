package b19_string_regex.bai_tap.validate_phone_number;


public class Test {
    private static ValidatePhoneNumber validatePhoneNumber;

    public static final String[] valid = new String[] {"(84)-(0978489648)"};
    public static final String[] inValid = new String[] {"(a8)-(22222222)"};

    public static void main(String[] args) {
        validatePhoneNumber = new ValidatePhoneNumber();
        for (String phone : valid){
            boolean validPhoneNum = validatePhoneNumber.validate(phone);
            System.out.println("Phone number: " + phone + " is valid: " + validPhoneNum);
        }

        for (String phone : inValid){
            boolean validPhoneNum = validatePhoneNumber.validate(phone);
            System.out.println("Phone number: " + phone + " is valid: " + validPhoneNum);
        }
    }
}
