package b19_string_regex.bai_tap.validate_class_name;

public class ValidateClassTest {
    private static ValidateClass validateClass= new ValidateClass();

    public static final String[] validClassName = new String[] {"C0318G"};
    public static final String[] inValidClassName = new String[] {"M0318G" , "P0323A"};

    public static void main(String[] args) {

        for (String name : validClassName){
            boolean validName = validateClass.validate(name);
            System.out.println("Class name: " + name + " is valid: " + validName);
        }

        for (String name : inValidClassName){
            boolean invalidName = validateClass.validate(name);
            System.out.println("Class name: " + name + " is valid: " + invalidName);
        }
    }
}
