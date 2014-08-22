public class Calculator {
    public static void main(String[] arguments) {
        float sum = 0;
        for (int i = 0; i < arguments.length; i++) {
            sum = sum + Float.parseFloat(arguments[i]);
        }
        System.out.println("Those numbers add up to " + sum);
    }
}