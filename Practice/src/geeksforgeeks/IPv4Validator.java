package geeksforgeeks;

class IPv4Validator {

    // Method to validate IPv4 address
    public boolean isValid(String s) {
        String[] ip = s.split("\\.");
        if (ip.length != 4)
            return false;
        boolean flag = true;
        for (String k : ip) {
            flag = flag && validate(k);
        }
        return flag;
    }

    private boolean validate(String k) {
        if (k.startsWith("0") && k.length() > 1)
            return false;
        return Integer.parseInt(k) >= 0 && Integer.parseInt(k) <= 255;
    }

    public static void main(String[] args) {
        // Example test cases
        IPv4Validator validator = new IPv4Validator();

        System.out.println(validator.isValid("222.111.111.111")); // Expected Output: true after implementation
        System.out.println(validator.isValid("5555..555")); // Expected Output: false after implementation
        System.out.println(validator.isValid("0.0.0.255")); // Expected Output: false after implementation
        System.out.println(validator.isValid("255.025.255.255")); // Expected Output: false after implementation

    }
}
