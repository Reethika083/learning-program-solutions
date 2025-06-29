public class ExceptionThrower {

    public void throwException(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        // Otherwise, do something meaningful (we're simulating)
        System.out.println("Input: " + input);
    }
}
